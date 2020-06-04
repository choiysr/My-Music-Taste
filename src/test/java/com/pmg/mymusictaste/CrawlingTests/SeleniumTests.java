package com.pmg.mymusictaste.CrawlingTests;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.util.YoutubeCrawler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeleniumTests {

    private static YoutubeCrawler crawler = YoutubeCrawler.getChrome();

    @Test
    public void utilTest(){

        SongInfo test = SongInfo.builder().singer("아이유").title("밤편지").build();

        String videoId = crawler.crawl(test.getTitle(),test.getSinger());
        System.out.println(videoId);   

    }
    
}