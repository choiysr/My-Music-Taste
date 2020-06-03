package com.pmg.mymusictaste.controller;

import com.pmg.mymusictaste.util.MelonCrawling;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {


  @GetMapping("/")
  public String mappedUrl() {

    MelonCrawling melon = new MelonCrawling();
    melon.getMelonCrawlingList("");
    return "index";
  }
  
}