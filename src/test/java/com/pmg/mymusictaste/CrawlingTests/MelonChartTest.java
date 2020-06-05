package com.pmg.mymusictaste.CrawlingTests;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.util.MelonCrawler;
import com.pmg.mymusictaste.util.MelonTarget;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MelonChartTest {

    @Test
    public void crawlTest() {

        MelonCrawler melon = new MelonCrawler();
        List<SongInfo> songList = melon.getMelonCrawlingList(MelonTarget.DAILY);

        for (int k = 1; k <= songList.size(); k++) {
            System.out.println("[" + songList.get(k-1).getRanking() + "]" + songList.get(k - 1).getSinger() + " - " + songList.get(k - 1).getTitle()
                    + " - " + songList.get(k - 1).getThumbnail());
        }

    }

}
