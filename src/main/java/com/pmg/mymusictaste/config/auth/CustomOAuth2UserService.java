package com.pmg.mymusictaste.config.auth;

import java.util.Collections;

import javax.servlet.http.HttpSession;

import com.pmg.mymusictaste.config.auth.dto.OAuthAttributes;
import com.pmg.mymusictaste.config.auth.dto.SessionMember;
import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.repository.MemberRepository;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


/* 구글 로그인 이후 가져온 사용자의 정보(email,name,picture etc.)들을 기반으로 가입 및 정보수정,
세션 저장 등의 기능을 지원하는 클래스  */
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final MemberRepository memberRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 현재 로그인 진행중인 서비스를 구분하는 코드. 추후 다른 소셜 로그인을 연동시 어떤 사이트인지(구글or네이버..)구분하기위해 사용
        String registrationId = userRequest.getClientRegistration().getRegistrationId();

        // OAuth2 로그인 진행 시 키가 되는 필드값. PK같은 의미
        // 구글이 기본적으로 지원하는 코드는 'sub'
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint()
                                                  .getUserNameAttributeName();

        // OAuth2UserSerivce를 통해 가져온 OAuth2User의 OAuth2User의 attribute를 담을 클래스 
        OAuthAttributes attributes = OAuthAttributes
                                    .of(registrationId, userNameAttributeName,oAuth2User.getAttributes());

        Member member = saveOrUpdate(attributes);

        // 세션에 사용자 정보를 저장하기 위한 SessionMmeber클래스.  
        httpSession.setAttribute("user", new SessionMember(member));

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(member.getRoleKey())),
                attributes.getAttributes(), attributes.getNameAttributeKey());
    }

    // 가입시 DB에 사용자 정보가 넣어짐. 
    // 구글에 사용자 정보가 업데이트 되었을 때를 대비하여 update 기능도 구현 
    private Member saveOrUpdate(OAuthAttributes attributes) {
        Member member = memberRepository.findByEmail(attributes.getEmail())
                .map(entity -> entity.update(attributes.getName(), attributes.getPicture()))
                .orElse(attributes.toEntity());
        return memberRepository.save(member);

    }
}