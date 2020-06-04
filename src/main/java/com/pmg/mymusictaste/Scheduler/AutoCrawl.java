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
    private YoutubeCrawler youtubeCrawler = YoutubeCrawler.getChrome();
    private final MelonTarget melonTarget;
    List<String> strList = new ArrayList<>();

    public AutoCrawl(MelonTarget target) {
        System.out.println("오토크롤객체생성------------");
        this.melonTarget = target;
    }

    public void startCrawling() {
        System.out.println("오토크롤 스타트 크롤링------------");
        List<SongInfo> targetList = melonCrawler.getMelonCrawlingList(this.melonTarget);
        System.out.println(targetList);
        for(SongInfo song : targetList) {
           String youtubeId =  youtubeCrawler.crawl(song.getTitle(), song.getSinger());
           System.out.println(youtubeId);
           strList.add(youtubeId);
        }

        System.out.println("========크롤링한 YOUTUBEID");

        for(String st : strList) {
            System.out.println(st);
        }
    } 


 



    
}