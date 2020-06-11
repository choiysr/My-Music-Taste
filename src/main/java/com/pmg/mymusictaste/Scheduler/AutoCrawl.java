package com.pmg.mymusictaste.Scheduler;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.service.SongService;
import com.pmg.mymusictaste.util.MelonCrawler;
import com.pmg.mymusictaste.util.MelonTarget;
import com.pmg.mymusictaste.util.YoutubeCrawler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * AutoCrawl
 */

@Component
@RequiredArgsConstructor
public class AutoCrawl {

    private static MelonCrawler melonCrawler;
    private static YoutubeCrawler youtubeCrawler;

    // private final SongService sServ;

    public static List<Song> startCrawling(MelonTarget target) {
        melonCrawler = new MelonCrawler();
        youtubeCrawler = YoutubeCrawler.getChrome();
        List<SongInfo> targetList = youtubeCrawler.crawl(melonCrawler.getMelonCrawlingList(target));
        return SongInfo.toSongList(targetList);
    }

    // // 1시간마다 실행
    // @Scheduled(cron="5 0 0-24 * * *")
    // public void crawlRealTime(){
    //     List<Song> list = startCrawling(MelonTarget.REALTIME);
    //     sServ.deleteByType(MelonTarget.REALTIME);
    //     sServ.saveSongList(list);
    // }

    // // 매일 자정(5초)에 실행 
    // @Scheduled(cron="5 0 0 * * ?")
    // public void crawlDaily(){
    //     List<Song> list = startCrawling(MelonTarget.DAILY);
    //     sServ.deleteByType(MelonTarget.DAILY);
    //     sServ.saveSongList(list);
    // }

    // // 매주 월요일 자정(5초)에 실행 
    // @Scheduled(cron="5 0 0 ? * 1")
    // public void crawlWeekly(){ 
    //     List<Song> list = startCrawling(MelonTarget.WEEKLY);
    //     sServ.deleteByType(MelonTarget.WEEKLY);
    //     sServ.saveSongList(list);
    // }

    // // 매달 1일 자정(5초)에 실행 
    // @Scheduled(cron = "5 0 0 1 * *")
    // public void crawlMonthly(){
    //     List<Song> list = startCrawling(MelonTarget.MONTHLY);
    //     sServ.deleteByType(MelonTarget.MONTHLY);
    //     sServ.saveSongList(list);
    // }


}