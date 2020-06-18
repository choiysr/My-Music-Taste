package com.pmg.mymusictaste.CrawlingTests;

import com.pmg.mymusictaste.util.MelonCrawlerWithSelenium;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MelonSeleniumTests {


    @Test
    public void getElementsTest(){

        MelonCrawlerWithSelenium crawler = new MelonCrawlerWithSelenium();
        crawler.crawl();

    }
    
}