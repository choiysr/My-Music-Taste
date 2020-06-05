package com.pmg.mymusictaste.util;

import java.util.List;

import com.pmg.mymusictaste.DTO.SongInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Navigation;
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

    private YoutubeCrawler(String webDriverID, String webDriverPath) {
        System.setProperty(webDriverID, webDriverPath);
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        this.driver = new ChromeDriver();
    }

    public static YoutubeCrawler getChrome() {
        String webDriverID = "webdriver.chrome.driver";
        String webDriverPath = "C:\\Users\\choiy\\workspace\\selenium\\chromedriver.exe";
        return new YoutubeCrawler(webDriverID, webDriverPath);
    }

    private void closeWebDriver() {
        driver.close();
    }

    public List<SongInfo> crawl(List<SongInfo> songList) {
        String targetURL = BASE_URL+songList.get(0).getTitle()+" "+songList.get(0).getSinger()+" official";
        driver.get(targetURL);
        songList.get(0).setYoutubeId(getVideoId(driver.findElements(By.id("video-title"))));

        Navigation navigation = driver.navigate();

        for(int i=1;i<songList.size();i++) {
            targetURL = BASE_URL+songList.get(i).getTitle()+" "+songList.get(i).getSinger()+" official";
            navigation.to(targetURL);
            songList.get(i).setYoutubeId(getVideoId(driver.findElements(By.id("video-title"))));
        }
        closeWebDriver();
        return songList;
    }


    public String getVideoId(List<WebElement> elements) {
        String videoId = "";
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