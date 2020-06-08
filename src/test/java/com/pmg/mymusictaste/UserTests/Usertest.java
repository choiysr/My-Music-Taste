package com.pmg.mymusictaste.UserTests;

import com.google.api.services.youtube.model.Playlist;
import com.pmg.mymusictaste.domain.User;
import com.pmg.mymusictaste.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class Usertest {

    @Autowired
    private UserRepository urepo;

    @Test
    public void userTest() {
        User user = User.builder().userid("userid").password("password").nickname("nickname").build();
        urepo.save(user);
    }

    @Test
    public void playlistInsertTest(){

        // User user = urepo.findById("userid").orElse(null);
        // System.out.println("user > "+ user);
        // Playlist list = Playlist.builder().singer("songsinger1").title("songtitle1").user(user).youtubeid("oCkAUDJKa10").build();
        // prepo.save(list);
        // Playlist list2 = Playlist.builder().singer("songsinger2").title("songtitle2").user(user).youtubeid("oCkAUasdfKa10").build();
        // prepo.save(list2);

    }
    
}