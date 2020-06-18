package com.pmg.mymusictaste.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pmg.mymusictaste.DTO.SongInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/* 쓸 일 없지만 반나절 고생한 수고가 아까워서 남겨두는 코드ㅠㅠ */
public class MelonCrawlerWithSelenium {

    private final WebDriver driver;
    private final String BASE_URL = "https://www.melon.com/chart/day/index.htm#params%5Bidx%5D=";
    public String WEB_DRIVER_ID;
    public String WEB_DRIVER_PATH;

    public MelonCrawlerWithSelenium() {
        final String webDriverID = "webdriver.chrome.driver";
        final String webDriverPath = PrivateProperties.getPrivateProperty("chromedriver.path");
        System.setProperty(webDriverID, webDriverPath);
        final ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        this.driver = new ChromeDriver();
    }

    private void closeWebDriver() {
        driver.close();
    }

    public void crawl() {
        driver.get(BASE_URL+51);
        List<SongInfo> songList = new ArrayList<>();
        List<WebElement> elist = driver.findElements(By.className("lst50"));
        for(WebElement element : elist) {
            songList.add(SongInfo.builder()
            .title(element.findElement(By.className("rank01")).findElement(By.tagName("a")).getText())
            .singer(element.findElement(By.className("rank02")).findElements(By.tagName("a")).stream().filter(artist -> artist.getText().length()>0).map(artist->new String(artist.getText())).collect(Collectors.joining(" ")))
            .thumbnail(element.findElement(By.className("image_typeAll")).findElement(By.tagName("img")).getAttribute("src"))
            .ranking(Integer.parseInt(element.findElement(By.className("rank")).getText()))
            .build()
            );
        }
        closeWebDriver();
        for(SongInfo song : songList) {
            System.out.println(song);
        }
    }



    
}