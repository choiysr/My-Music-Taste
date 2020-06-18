package com.pmg.mymusictaste.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class Crawler {

    private WebDriver driver;
    private final String BASE_URL = "https://www.youtube.com/results?search_query=";
    public String WEB_DRIVER_ID;
    public String WEB_DRIVER_PATH;
    
    public final void crawlTheWeb(){

    }

    private void readyForCrawling(){
        System.setProperty("webdriver.chrome.driver", PrivateProperties.getPrivateProperty("chromedriver.path"));
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        this.driver = new ChromeDriver();
    }

    private void closeWebDriver() {
        driver.close();
    }


    
}