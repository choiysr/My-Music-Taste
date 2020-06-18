package com.pmg.mymusictaste.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.pmg.mymusictaste.DTO.SongInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MelonCrawler {

  private Document doc;
  private MelonTarget target;
  private Elements elements;
  private List<SongInfo> songList = new ArrayList<>();
  private AtomicInteger counter = new AtomicInteger(1);

  public List<SongInfo> crawl(MelonTarget target) {
    this.target = target;
    try {
      this.doc = Jsoup.connect(target.getUrl()).get();
      if (doc != null) {
        getMelonChartList("tr.lst50");
        getMelonChartList("tr.lst100");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return songList;
  }

  private void getMelonChartList(String className) {
    this.elements = doc.select(className);
      for (Element el : elements) {
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
        songList.add(SongInfo.builder()
        .title(el.select("div.rank01").select("a").text())
        .singer(singersText)
        .type(target)
        .thumbnail(el.select("div").select("img").attr("src"))
        .ranking(counter.getAndIncrement()).build()
        );
      }
  }

}
