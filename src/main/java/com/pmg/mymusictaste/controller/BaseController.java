package com.pmg.mymusictaste.controller;

import com.pmg.mymusictaste.util.MelonCrawler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {


  @GetMapping("/")
  public String mappedUrl() {

    MelonCrawler melon = new MelonCrawler();
    //melon.getMelonCrawlingList("");
    return "index";
  }

  @GetMapping("/musicTest")
  public String mmapedUrl2(){

    return "musicTest";
  }
  
}