package com.pmg.mymusictaste.Config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/")
        .permitAll()
        .anyRequest().authenticated()
        .and().oauth2Login();
    }

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository
    (@Value("${spring.security.oauth2.client.registration.kakao.client-id}") String kakaoClientId,
    @Value ("${spring.security.oauth2.client.registration.kakao.client-secret}") String kakaoClientSecret) {

        List<ClientRegistration> registrations = new ArrayList<>();
        registrations.add(CustomOAuth2Provider.KAKAO.getBuilder("kakao").clientId(kakaoClientId).clientSecret(kakaoClientSecret).jwkSetUri("temp").build());

        return new InMemoryClientRegistrationRepository(registrations);

        
    }

    
}