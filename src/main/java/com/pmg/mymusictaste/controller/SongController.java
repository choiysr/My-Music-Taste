package com.pmg.mymusictaste.controller;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.SongRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SongController {


  private final SongRepository srepo;

  @GetMapping("/getSongList")
  public ResponseEntity<Page<Song>> test(){
    Pageable pageinfo = PageRequest.of(0,10,Sort.Direction.DESC);
    Page<Song> list = srepo.findAll(pageinfo);
    return new ResponseEntity<>(list,HttpStatus.OK);
  }

  
}