package com.pmg.mymusictaste.config.auth;

import com.pmg.mymusictaste.domain.Role;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // csrf()~and()이전까지-> 책의예제에서는 h2웹콘솔을 사용하는데에 이 옵션을 disable하지 않으면 이용이 안됨.
        // 우리 프로젝트는 필요없긴 한데 일단 넣었음 
        http.csrf().disable()
        .headers().frameOptions().disable()
        .and()
        .authorizeRequests() // URL별 권한 관리를 설정하는 옵션의 시작점. 
                .antMatchers("/", "/resources/**", "/resources/static/public/**", "/resources/templates", "/templates/**", "/static/**", "/js/**", "/profile").permitAll() // 지정된 URL은 permitAll() - 전체열람 
                .antMatchers("/playList/**").hasRole(Role.MEMBER.name()) // 이건 수정필요할듯 일단은... 
                .anyRequest().permitAll() // 나머지 url들은 모두 인증된 사용자들에게만 허용하게 함.(이건 삭제해도 될라나?)
                .and().logout().logoutSuccessUrl("/") // 로그아웃 성공 시 이동하는 URL
                .and()
                .oauth2Login() // Oauth2로그인 기능에 대한 여러 설정의 진입점
                .userInfoEndpoint() // Oauth2 로그인 성공 이후 사용자 정보를 가져올 때 설정들을 담당
                .userService(customOAuth2UserService); // 소셜 로그인 성공시 후속조치를 진행할 UserService 인터페이스의 구현체 등록
                                                       // 리소스서버(소셜서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자
                                                       // 하는 기능을 명시할 수 있음. 
    }
}