package com.pmg.mymusictaste.CrawlingTests;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MelonChartTest {

    @Test
    public void crawlTest() {

        String url = "https://www.melon.com/chart/index.htm";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 주요 뉴스로 나오는 태그를 찾아서 가져오도록 한다.
        Elements element = doc.select("div.rank01");
        // 1. 헤더 부분의 제목을 가져온다.
        String title = element.select("a[title]").text();
        System.out.println("============================================================");
        System.out.println(title);
        System.out.println("============================================================");

        // for (Element el : element.select("li")) { // 하위 뉴스 기사들을 for문 돌면서 출력
        //     System.out.println(el.text());
        // }
        System.out.println("============================================================");
    }

}
