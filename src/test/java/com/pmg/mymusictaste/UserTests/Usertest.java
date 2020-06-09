package com.pmg.mymusictaste.UserTests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.pmg.mymusictaste.domain.Playing;
import com.pmg.mymusictaste.domain.User;
import com.pmg.mymusictaste.repository.PlayingRepository;
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

    @Autowired
    private PlayingRepository prepo;

    @Test
    public void userTest() {
        User user = User.builder().userid("userid").password("password").nickname("nickname").build();
        urepo.save(user);
    }

    @Test
    public void playlistInsertTest(){

        
    }

    @Test
    public void savePlayList(){
    List<Playing> playlist = new ArrayList<>();
    

    }
    
}