package com.pmg.mymusictaste.controller;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.service.SongService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController  
@RequestMapping("/*")
@RequiredArgsConstructor
public class SongController {

    private final SongService songServ;

    // 소라-플레이어 만들면서 테스트용으로 사용중 
    @GetMapping("/songlist")
    public ResponseEntity<Page<Song>> getSongListTest() {
        Page<Song> songList = songServ.getSongList(PageRequest.of(0, 10, Sort.Direction.DESC, "sid"));
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }

    // 실시간/일간/주간/월간 별로 리스트 데이터를 반환
    // @GetMapping("/songList/{type}/{page}")
    // public ResponseEntity<Page<Song>> getSongList(@PathVariable String type, @PathVariable Integer page) {
    //     Page<Song> songList = songServ.findByType(PageRequest.of(page-1, 50, Sort.Direction.ASC, "sid"), type); 
    //     return new ResponseEntity<>(songList, HttpStatus.OK);
    // }

    @GetMapping("/getPlayList")
    public ResponseEntity<Page<Song>> getPlayList(){
        Page<Song> songList = songServ.getSongList(PageRequest.of(0, 10, Sort.Direction.DESC, "sid"));
        
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }

    @PostMapping("/addMusic")
    public ResponseEntity<Page<Song>> addMusic(){

        //로그인 세션을 통과한 음악정보 playList 에 저장 
        Page<Song> songList = songServ.getSongList(PageRequest.of(0, 10, Sort.Direction.DESC, "sid"));
        
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }
  }

    

