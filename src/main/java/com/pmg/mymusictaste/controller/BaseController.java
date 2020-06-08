package com.pmg.mymusictaste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {


  @GetMapping("/")
  public String mappedUrl() {
    return "indexTest";
  }

  @GetMapping("/musicTest")
  public String mmapedUrl2(){
    return "musicTest";
  }
  
}