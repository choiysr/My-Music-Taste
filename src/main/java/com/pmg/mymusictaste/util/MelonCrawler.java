package com.pmg.mymusictaste.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

<<<<<<< HEAD
import com.pmg.mymusictaste.domain.Song;
=======
import com.pmg.mymusictaste.DTO.SongInfo;
>>>>>>> 777eb71b98aaf1b58b3661d02da9eb1b25e23f68

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MelonCrawler {

  public List<SongInfo> getMelonCrawlingList(String url){
    
    // https://www.melon.com/chart/index.htm 실시간 
    // https://www.melon.com/chart/rise/index.htm 급상승
    // https://www.melon.com/chart/day/index.htm 일간 
    // https://www.melon.com/chart/week/index.htm 주간
    // https://www.melon.com/chart/month/index.htm 월간
    
    // 선언부
    // url = "https://www.melon.com/chart/month/index.htm";
    Document doc = null;
    Elements elements = null;
    List<SongInfo> songList = null;
    SongInfo song = null;


    // 프로세스부
    try {doc = Jsoup.connect(url).get(); 
        
/*         if(doc != null && null != doc.select("div.rank01")){
          title = doc.select("div.rank01").select("a[title]").text(); 
        } */
        /* 
      if(doc != null && null != doc.select("div.rank01")){
        elements = doc.select("div.rank01");
        for(Element el : elements){
          System.out.println("elements index > " + el.select("a[title]").text());
        }
      } */

      if(doc != null){
        elements = doc.select("tr.lst50");
        songList = new ArrayList<SongInfo>();
        System.out.println("============================================================");
        for(Element el : elements){
          song = new SongInfo();
          song.setTitle(el.select("div.rank01").select("a").text());
          song.setSinger(el.select("div.rank02").select("a").first().text());
          song.setThumbnail(el.select("div").select("a").select("img[src]").text());
          // System.out.println("song data > " + song.toString());
          songList.add(song);
        }
        System.out.println("============================================================");
      }

    } catch (IOException e) {
        e.printStackTrace();
    }

    // for(Song s : songList){
    //   System.out.println("songList " + s);
    // }

    return songList;

  }

  
}
 