package com.pmg.mymusictaste.controller;

import java.net.URI;

import com.pmg.mymusictaste.util.PrivateProperties;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

    private String serverDomain = "http://localhost:8080/login";


    @GetMapping("/tryLogin")
    public ResponseEntity<String> sendRequestToKakaoForLogin(){

       String apiKey = PrivateProperties.getPrivateProperty("kakao.apikey");
       RestTemplate restTemplate = new RestTemplate(); 
       URI uri = UriComponentsBuilder.fromHttpUrl("https://kauth.kakao.com/oauth/authorize")
       .queryParam("client_id", apiKey)
       .queryParam("redirect_uri", serverDomain)
       .queryParam("response_type", "code")
       .build().toUri();

       ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

       return responseEntity;

    } 


    

}