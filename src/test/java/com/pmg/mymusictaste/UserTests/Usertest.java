package com.pmg.mymusictaste.UserTests;

import com.pmg.mymusictaste.domain.User;
import com.pmg.mymusictaste.domain.Playlist;
import com.pmg.mymusictaste.repository.PlaylistRepository;
import com.pmg.mymusictaste.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Usertest {

    @Autowired
    private UserRepository urepo;

    @Autowired
    private PlaylistRepository prepo;

    @Test
    public void userTest() {
        User user = User.builder().userid("userid").password("password").nickname("nickname").build();
        urepo.save(user);
    }

    @Test
    public void playlistInsertTest(){

        User user = urepo.findById("userid").orElse(null);
        Playlist list = Playlist.builder().singer("songsinger").title("songtitle").user(user).youtubeid("oCkAUDJKa10").build();
        prepo.save(list);
        Playlist list2 = Playlist.builder().singer("songsinger11").title("songtitle11").user(user).youtubeid("oCkAUasdfKa10").build();
        prepo.save(list2);


    }
    
}