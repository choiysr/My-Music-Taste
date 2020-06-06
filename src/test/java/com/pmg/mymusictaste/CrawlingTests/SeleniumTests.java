package com.pmg.mymusictaste.CrawlingTests;

import java.util.ArrayList;
import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.util.YoutubeCrawler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SeleniumTests {

    private YoutubeCrawler crawler = YoutubeCrawler.getChrome();

    @Test
    public void utilTest(){

        SongInfo s1 = SongInfo.builder().singer("아이유").title("밤편지").build();
        SongInfo s2 = SongInfo.builder().singer("쿨").title("아로하").build();
        SongInfo s3 = SongInfo.builder().singer("김광석").title("서른즈음에").build();
        SongInfo s4 = SongInfo.builder().singer("쿨").title("너의집 앞에서").build();
        List<SongInfo> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);

        crawler.crawl(list);

        for(SongInfo song : list ){
            System.out.println(song);
        }

    }

    }
    
