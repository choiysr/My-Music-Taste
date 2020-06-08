package com.pmg.mymusictaste.controller;

import javax.servlet.http.HttpSession;

import com.google.api.services.youtube.model.Playlist;
import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.domain.User;
import com.pmg.mymusictaste.repository.UserRepository;
import com.pmg.mymusictaste.service.PlayingService;
import com.pmg.mymusictaste.service.SongService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController  
@RequestMapping("/*")
@RequiredArgsConstructor
public class SongController {

    private final SongService songServ;
    private final PlayingService playServ;
    private final UserRepository userreop;


    // 소라-플레이어 만들면서 테스트용으로 사용중 
    @GetMapping("/songlist")
    public ResponseEntity<Page<Song>> getSongListTest() {
        Page<Song> songList = songServ.getSongList(PageRequest.of(0, 10, Sort.Direction.DESC, "sid"));
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }

    // 실시간/일간/주간/월간 별로 리스트 데이터를 반환
    @GetMapping("/musicChartList/{type}/{page}")
    public ResponseEntity<Page<Song>> getSongList(@PathVariable String type, @PathVariable Integer page) {
        Page<Song> songList = songServ.getSongListByType(page,50,type); 
        return new ResponseEntity<>(songList, HttpStatus.OK);
    }


    //user가 저장한 플레이리스트 목록 가져오기 
    @GetMapping("/getPlayList")
    public ResponseEntity<Page<Playing>> getPlayList(){
        //User user = (User) session.getAttribute("userInfo");
        User user = userreop.findById("userid").orElse(null);
        Page<Playing> playList = playServ.getPlayingByUser(1, 10, user);
        return new ResponseEntity<>(playList, HttpStatus.OK);
    }



    @PostMapping("/addMusic")
    public void addMusic(Playing playing, HttpSession session){
        User user = (User) session.getAttribute("userInfo");
        user = userreop.findById("userid").orElse(null);
        playing.setUser(user);
        playServ.addMusic(Playing.builder().singer("김연우").title("사랑과우정사이").user(user).youtubeid("oCkAUDJKa10").build());
        
    }
    
  }

    

