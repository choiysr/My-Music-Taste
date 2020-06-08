package com.pmg.mymusictaste.ServiceTests;

import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.User;
import com.pmg.mymusictaste.repository.UserRepository;
import com.pmg.mymusictaste.service.PlayingService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import lombok.Setter;

@SpringBootTest
public class PlayingServiceTest {

  @Setter(onMethod_ = {@Autowired})
  private PlayingService pServ;

  @Autowired
  private UserRepository urepo;

  @Test
  public void insertPlayListTest(){
    
    System.out.println("####[playList Service Test]");
    User user = new User();
    Playing playList = new Playing();

    user = User.builder().userid("hb").nickname("hyunbin").password("1111").build();
    playList = Playing.builder().title("에잇").singer("아이유").user(user).youtubeid("!@#SDFASF11").build();
    pServ.addMusic(playList);

  }

  @Test
  public void getPlayList(){
    User user = urepo.findById("userid").orElse(null);
    Page<Playing> playList = pServ.getPlayingByUser(1, 5, user);
    for(Playing pl : playList){
      System.out.println("playList> " + pl);
    }
  }
  
}