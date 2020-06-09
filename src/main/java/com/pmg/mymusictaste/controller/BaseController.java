package com.pmg.mymusictaste.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
  public String loginTest(@RequestParam("code") String code, HttpServletRequest request) {
    HttpSession httpSession = request.getSession(true);
    
    String access_Token = kakao.getAccessToken(code);
    System.out.println("controller access_token : " + access_Token);
    HashMap<String, Object> userInfo = kakao.getUserInfo(access_Token);
    System.out.println("===========================USER INFO");
    System.out.println("login Controller : " + userInfo);
    httpSession.setAttribute("userInfo", userInfo);
    return "indexTest";
  }

  @GetMapping("/musicTest")
  public String mmapedUrl2() {
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