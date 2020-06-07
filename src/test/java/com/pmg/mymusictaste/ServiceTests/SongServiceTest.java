package com.pmg.mymusictaste.ServiceTests;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.SongRepository;
import com.pmg.mymusictaste.service.SongService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SongServiceTest {

    @Setter(onMethod_ = {@Autowired})
    private SongService sServ;

    @Test
    public void getSongListByTypeTest(){
        int page = 1;
        String type = "DAILY";
        Page<Song> songPage = sServ.getSongListByType(page,50,type); 
        for(Song song : songPage.getContent()) {
            log.info("song : " + song);
        }
    }

    
}