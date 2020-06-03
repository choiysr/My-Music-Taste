package com.pmg.mymusictaste.controller;

<<<<<<< HEAD
import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.SongRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
=======
import com.pmg.mymusictaste.service.SongService;
import com.pmg.mymusictaste.domain.Song;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
>>>>>>> 777eb71b98aaf1b58b3661d02da9eb1b25e23f68
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestMapping;
>>>>>>> 777eb71b98aaf1b58b3661d02da9eb1b25e23f68
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
<<<<<<< HEAD
@RequiredArgsConstructor
public class SongController {


  private final SongRepository srepo;

  @GetMapping("/getSongList")
  public ResponseEntity<Page<Song>> test(){
    Pageable pageinfo = PageRequest.of(0,10,Sort.Direction.DESC);
    Page<Song> list = srepo.findAll(pageinfo);
    return new ResponseEntity<>(list,HttpStatus.OK);
  }

  
=======
@RequestMapping("/*")
@RequiredArgsConstructor
public class SongController {

    private final SongService songs;

    // 소라-플레이어 만들면서 테스트용으로 사용중 
    @GetMapping("/songlist")
    public ResponseEntity<Page<Song>> getSongListTest() {
        Page<Song> songList = songs.getSongList(PageRequest.of(0, 10, Sort.Direction.DESC, "sid"));
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }


    

>>>>>>> 777eb71b98aaf1b58b3661d02da9eb1b25e23f68
}