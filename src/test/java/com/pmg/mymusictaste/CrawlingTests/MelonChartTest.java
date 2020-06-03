package com.pmg.mymusictaste.CrawlingTests;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.util.MelonCrawler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MelonChartTest {

    @Test
    public void crawlTest() {

        MelonCrawler melon = new MelonCrawler();
        List<SongInfo> list = melon.getMelonCrawlingList("https://www.melon.com/chart/index.htm");
        

        
    }

}
