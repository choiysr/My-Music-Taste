package com.pmg.mymusictaste.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.pmg.mymusictaste.domain.Member;
import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.MemberRepository;
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

import lombok.RequiredArgsConstructor;

@RestController  
@RequestMapping("/*")
@RequiredArgsConstructor
public class SongController {

    private final SongService songServ;
    private final PlayingService playServ;
    private final MemberRepository memberRepo;


    // 실시간/일간/주간/월간 별로 리스트 데이터를 반환
    @GetMapping("/musicChartList/{type}/{page}")
    public ResponseEntity<Page<Song>> getSongList(@PathVariable String type, @PathVariable Integer page) {
        Page<Song> songList = songServ.getSongListByType(page,50,type); 
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }


    //member가 저장한 플레이리스트 목록 가져오기 
    @GetMapping("/getPlayList")
    public ResponseEntity<List<Playing>> getPlayList(){
        //Member member = (Member) session.getAttribute("memberInfo");
        Member member = memberRepo.findById("memberid").orElse(null);

        List<Playing> playList = playServ.getMemberPlayList(member);
        return new ResponseEntity<>(playList, HttpStatus.OK);
    }


    @PostMapping("/addMusic")
    public void addMusic(@RequestBody List<Playing> playList, HttpSession session){
        //로그인 정보를 가져옴
        //Member member = (Member) session.getAttribute("memberInfo");

        Member member = memberRepo.findById("userid").orElse(null);
        playServ.addMusic(playList);
        //playList.setUser(user);
        //playServ.addMusic(Playing.builder().singer("김연우").title("사랑과우정사이").user(user).youtubeid("oCkAUDJKa10").build());
    }
    
  }

    

