package com.pmg.mymusictaste.Scheduler;

import java.util.ArrayList;
import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.util.MelonCrawler;
import com.pmg.mymusictaste.util.MelonTarget;
import com.pmg.mymusictaste.util.YoutubeCrawler;

/**
 * AutoCrawl
 */
public class AutoCrawl {

    private MelonCrawler melonCrawler;
    private YoutubeCrawler youtubeCrawler;
    List<String> strList = new ArrayList<>();

    public AutoCrawl() {
        this.melonCrawler = new MelonCrawler();
    }

    public void startCrawling(MelonTarget target) {
        List<SongInfo> targetList = melonCrawler.getMelonCrawlingList(target);
        youtubeCrawler = YoutubeCrawler.getChrome();
        youtubeCrawler.crawl(targetList);
        for (SongInfo song : targetList) {
            System.out.println(song);
        }
    }

}