package com.pmg.mymusictaste.CrawlingTests;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.repository.SongRepository;
import com.pmg.mymusictaste.util.MelonCrawler;
import com.pmg.mymusictaste.util.YoutubeCrawler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.Setter;

@SpringBootTest
public class CombineTests {


    @Setter(onMethod_ = {@Autowired})
    private SongRepository sRepo;


    @Test
    public void getYoutubeVideoIdByMelonTest(){

        MelonCrawler melon = new MelonCrawler();
        List<SongInfo> list = melon.getMelonCrawlingList("https://www.melon.com/chart/index.htm");
        YoutubeCrawler youtube = new YoutubeCrawler(list);
        
        for(Song song : list) {
            sRepo.save(song);
        }

        

        

    }

}