package com.pmg.mymusictaste.controller;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.service.SongService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController  
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
  }

    

