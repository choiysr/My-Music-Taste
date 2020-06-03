package com.pmg.mymusictaste.CrawlingTests;

import java.util.List;

import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.util.MelonCrawler;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MelonChartTest {

    @Test
    public void crawlTest() {

        MelonCrawler melon = new MelonCrawler();
        List<Song> list = melon.getMelonCrawlingList("https://www.melon.com/chart/index.htm");
        

        
    }

}
