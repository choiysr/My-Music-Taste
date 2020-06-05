package com.pmg.mymusictaste.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * YoutubeCrawler
 */
public class YoutubeCrawler {
    
    private final WebDriver driver;
    private final String BASE_URL = "https://www.youtube.com/results?search_query=";
    public String WEB_DRIVER_ID;
    public String WEB_DRIVER_PATH;

    public YoutubeCrawler(String webDriverID, String webDriverPath) {
        System.setProperty(webDriverID, webDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        this.driver = new ChromeDriver();
    }

    public static YoutubeCrawler getChrome() {
        String webDriverID = "webdriver.chrome.driver";
        String webDriverPath = "C:\\Users\\차동국\\workspace\\selenium\\chromedriver.exe";
        return new YoutubeCrawler(webDriverID, webDriverPath);
    }

    public void closeWebDriver() {
        driver.close();
    }

    public String crawl(String title, String singer) {
        String targetURL = BASE_URL+title+" "+singer+" official";
        String videoId ="";
        driver.get(targetURL);
        List<WebElement> elements = driver.findElements(By.id("video-title"));
        for(WebElement ele : elements) {
            String eleId = ele.getAttribute("href");
            if(eleId!=null) {
                videoId = eleId.substring(eleId.lastIndexOf("=")+1,eleId.length());
                break;
            } 
        }
        return videoId;
    }

    
}