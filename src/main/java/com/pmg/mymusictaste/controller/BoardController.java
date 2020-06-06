package com.pmg.mymusictaste.controller;

import java.util.ArrayList;
import java.util.List;

import com.pmg.mymusictaste.util.MelonCrawler;
import com.pmg.mymusictaste.util.MelonTarget;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/*")
public class BoardController {

  @GetMapping("test")
  public ResponseEntity<List<String>> test(){

    MelonCrawler melon = new MelonCrawler();
    melon.getMelonCrawlingList(MelonTarget.DAILY);

    List<String> list = new ArrayList<>();
    
    return new ResponseEntity<>(list,HttpStatus.OK);
  }

}