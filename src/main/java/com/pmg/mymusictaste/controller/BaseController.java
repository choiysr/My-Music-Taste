package com.pmg.mymusictaste.controller;

import java.util.HashMap;

import com.pmg.mymusictaste.service.KakaoAPIService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BaseController {

  private final KakaoAPIService kakao;

  @GetMapping("/")
  public String mappedUrl() {
    return "indexTest";
  }

  @RequestMapping("/login")
  public String loginTest(@RequestParam("code") String code) {
    String access_Token = kakao.getAccessToken(code);
    System.out.println("controller access_token : " + access_Token);
    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
    System.out.println("===========================USER INFO");
    System.out.println("login Controller : " + userInfo);

    return "indexTest";
  }

  @GetMapping("/musicTest")
  public String mmapedUrl2() {
    return "musicTest";
  }

}