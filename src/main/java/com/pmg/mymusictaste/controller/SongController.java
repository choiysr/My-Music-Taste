package com.pmg.mymusictaste.controller;

import java.util.List;

import com.pmg.mymusictaste.config.auth.dto.SessionMember;
import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.MemberRepository;
import com.pmg.mymusictaste.service.MemberService;
import com.pmg.mymusictaste.service.PlayingService;
import com.pmg.mymusictaste.service.SongService;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import lombok.RequiredArgsConstructor;

@RestController  
@RequestMapping("/*")
@RequiredArgsConstructor
public class SongController {

    private final SongService songServ;
    private final PlayingService playServ;
    private final MemberService memServ;


    // 실시간/일간/주간/월간 별로 리스트 데이터를 반환
    @GetMapping("/musicChartList/{type}/{page}")
    public ResponseEntity<Page<Song>> getSongList(@PathVariable String type, @PathVariable Integer page) {
        Page<Song> songList = songServ.getSongListByType(page,50,type); 
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }

    @PostMapping("/playList")
    public void addMusic(@RequestBody List<Integer> sids){


    }

    @GetMapping("/playList")
    public ResponseEntity<List<Playing>> getPlayList(@SessionAttribute("user") SessionMember member){
        return new ResponseEntity<>(playServ.getMemberPlayList(memServ.findByEmail(member.getEmail())),HttpStatus.OK);
    }
    
  }

    

