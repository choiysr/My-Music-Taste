package com.pmg.mymusictaste.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping("/index")
    public String mappedUrl() {
        // MelonCrawler melon = new MelonCrawler();
        // melon.getMelonCrawlingList("");
        return "index";
    }

    @GetMapping("/musicTest")
    public String mappedUrl2() {
        // MelonCrawler melon = new MelonCrawler();
        // melon.getMelonCrawlingList("");
        return "musicTest";
    }
}