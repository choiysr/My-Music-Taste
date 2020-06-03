package com.pmg.mymusictaste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

<<<<<<< HEAD
<<<<<<< HEAD

  @GetMapping("/")
  public String mappedUrl() {

    MelonCrawler melon = new MelonCrawler();
    melon.getMelonCrawlingList("");
    return "index";
  }
  
=======
    @GetMapping("/")
=======
    @GetMapping("/index")
>>>>>>> 777eb71b98aaf1b58b3661d02da9eb1b25e23f68
    public String mappedUrl() {
        // MelonCrawler melon = new MelonCrawler();
        // melon.getMelonCrawlingList("");
        return "index";
    }
<<<<<<< HEAD
>>>>>>> bef1875d02d1dfc287335ea54aa1a0cb4332f246
=======

    @GetMapping("/musicTest")
    public String mappedUrl2() {
        // MelonCrawler melon = new MelonCrawler();
        // melon.getMelonCrawlingList("");
        return "musicTest";
    }
>>>>>>> 777eb71b98aaf1b58b3661d02da9eb1b25e23f68
}