package com.pmg.mymusictaste.controller;

import java.util.ArrayList;
import java.util.List;

import com.pmg.mymusictaste.util.MelonCrawling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/*")
public class BoardController {



  @GetMapping("test")
  public ResponseEntity<List<String>> test(){

    MelonCrawling melon = new MelonCrawling();
    melon.getMelonCrawlingList("");

    List<String> list = new ArrayList<>();
    
    return new ResponseEntity<>(list,HttpStatus.OK);
  }


  
}