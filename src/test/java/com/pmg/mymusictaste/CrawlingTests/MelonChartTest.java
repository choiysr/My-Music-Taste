package com.pmg.mymusictaste.CrawlingTests;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
        
        Elements element = doc.select("div.rank01");

        String title = element.select("a[title]").text();
        System.out.println("============================================================");
        System.out.println(title);
        System.out.println("============================================================");

        // for (Element el : element.select("li")) { 
        //     System.out.println(el.text());
        // }
        System.out.println("============================================================");
    }

}
