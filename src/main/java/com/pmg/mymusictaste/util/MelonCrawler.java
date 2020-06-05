package com.pmg.mymusictaste.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MelonCrawler {

  public List<SongInfo> getMelonCrawlingList(MelonTarget target) {

    Document doc = null;
    Elements elements = null;
    List<SongInfo> songList = null;
    SongInfo song = null;
    String songType = null;
    Integer rank = 1;

    // 프로세스부
    try {
      doc = Jsoup.connect(target.getUrl()).get();
      if (doc != null) {
        if(target.equals(MelonTarget.REALTIME)){
          songType = "REALTIME";
        } else if(target.equals(MelonTarget.DAILY)){
          songType = "DAILY";
        } else if(target.equals(MelonTarget.WEEKLY)){
          songType = "WEEKLY";
        } else{
          songType = "MONTHLY";
        }
        elements = doc.select("tr.lst50");
        songList = new ArrayList<SongInfo>();
        for (Element el : elements) {
          song = new SongInfo();
          song.setTitle(el.select("div.rank01").select("a").text());
          // 가수 여러명인지 체크
          Elements singers = el.select("div.rank02").select("a");
          String singersText = "";
          // a태그는 n(가수수) * 2. 가수가 1명일때는 a태그 2개
          if (singers.size() == 2) {
            singersText = singers.first().text(); 
          } else {
            singersText = singers.first().text();
            for (int j = 1; j < (singers.size() / 2); j++) {
              singersText += "," + singers.get(j).text();
            }
          }
          song.setRanking(rank++);
          song.setType(songType);
          song.setSinger(singersText);
          song.setThumbnail(el.select("div").select("img").attr("src"));
          songList.add(song);
        }
      }
      
    } catch (IOException e) {
      e.printStackTrace();
    }

    return songList;

  }

}
