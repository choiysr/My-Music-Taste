package com.pmg.mymusictaste.controller;

import com.pmg.mymusictaste.util.MelonCrawler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

<<<<<<< HEAD

  @GetMapping("/")
  public String mappedUrl() {

    MelonCrawler melon = new MelonCrawler();
    melon.getMelonCrawlingList("");
    return "index";
  }
  
=======
    @GetMapping("/")
    public String mappedUrl() {
        MelonCrawler melon = new MelonCrawler();
        melon.getMelonCrawlingList("");
        return "index";
    }
>>>>>>> bef1875d02d1dfc287335ea54aa1a0cb4332f246
}