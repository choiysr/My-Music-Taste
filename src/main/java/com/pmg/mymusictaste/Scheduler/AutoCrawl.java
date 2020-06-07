package com.pmg.mymusictaste.Scheduler;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.util.MelonCrawler;
import com.pmg.mymusictaste.util.MelonTarget;
import com.pmg.mymusictaste.util.YoutubeCrawler;

/**
 * AutoCrawl
 */


public class AutoCrawl {

    private MelonCrawler melonCrawler;
    private YoutubeCrawler youtubeCrawler;

    public List<Song> startCrawling(MelonTarget target) {

        this.melonCrawler = new MelonCrawler();
        this.youtubeCrawler = YoutubeCrawler.getChrome();
        
        List<SongInfo> targetList = youtubeCrawler.crawl(melonCrawler.getMelonCrawlingList(target));
        return SongInfo.toSongList(targetList);

    }

}