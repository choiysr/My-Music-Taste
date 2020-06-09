package com.pmg.mymusictaste.controller;

import com.pmg.mymusictaste.service.KakaoLoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

  @Autowired
  KakaoLoginService kakao;


  @GetMapping("/")
  public String mappedUrl() {
    return "login";
  }

  @GetMapping("/musicTest")
  public String mmapedUrl2(){
    return "musicTest";
  } 
  @GetMapping("/indexTest")
  public String mmapedUrl3(){
    return "indexTest";
  }

  @GetMapping("/oauth")
  public String mmapedUrl4(@RequestParam String code){
    System.out.println("code > " + code);
    String access_Token = kakao.getAccessToken(code);
    System.out.println("accesS_Token :" +access_Token);
    return "redirect:/indexTest";
  }


  
}