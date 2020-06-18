package com.pmg.mymusictaste.CrawlingTests;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;
import com.pmg.mymusictaste.domain.Song;
import com.pmg.mymusictaste.service.SongService;
import com.pmg.mymusictaste.util.MelonCrawler;
import com.pmg.mymusictaste.util.MelonTarget;
import com.pmg.mymusictaste.util.YoutubeCrawler;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class insertTest {

  private MelonCrawler melonCrawler;
  private YoutubeCrawler youtubeCrawler;
  @Autowired
  private SongService sServ;

  public List<Song> startCrawling(MelonTarget target) {
    melonCrawler = new MelonCrawler();
    youtubeCrawler = YoutubeCrawler.getChrome();
    List<SongInfo> targetList = youtubeCrawler.crawl(melonCrawler.crawl(target));
    return SongInfo.toSongList(targetList);
  }


  @Test
  public void crawlRealTimeTest() {
    List<Song> list = startCrawling(MelonTarget.REALTIME);
    sServ.deleteByType(MelonTarget.REALTIME);
    sServ.saveSongList(list);

  }

  @Test
  public void crawlDailyTest() {
    List<Song> list = startCrawling(MelonTarget.DAILY);
    sServ.deleteByType(MelonTarget.DAILY);
    sServ.saveSongList(list);
  }

  @Test
  public void crawlWeeklyTest() {
    List<Song> list = startCrawling(MelonTarget.WEEKLY);
    sServ.deleteByType(MelonTarget.WEEKLY);
    sServ.saveSongList(list);
  }

  @Test
  public void crawlMonthlyTest() {
    List<Song> list = startCrawling(MelonTarget.MONTHLY);
    sServ.deleteByType(MelonTarget.MONTHLY);
    sServ.saveSongList(list);
  }


}