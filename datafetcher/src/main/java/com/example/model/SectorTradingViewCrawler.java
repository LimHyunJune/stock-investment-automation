package com.example.model;

import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class SectorTradingViewCrawler implements SectorDataFetcher{
    WebDriver driver;
    @PostConstruct
    public void init()
    {
        WebDriverManager.chromedriver().setup();
    }
    @Override
    public String getSector() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        String url = "https://www.tradingview.com/markets/stocks-usa/market-movers-ath/";
        driver.get(url);
        List<WebElement> el = driver.findElements(By.className("listRow"));

        List<String> sectors = new ArrayList<>();
        log.info("52주 신고가 sector 수집 중");
        for(WebElement e : el)
        {
            log.info(e.findElement(By.xpath(".//td[11]/a")).getText());
            sectors.add(e.findElement(By.xpath(".//td[11]/a")).getText());
        }
        driver.quit();
        return calculateSector(sectors);
    }

    private String calculateSector(List<String> sectors)
    {
        HashMap<String,Integer> count = new HashMap<>();
        String mostSector = null;
        int mostCount = 0;
        for(String sector: sectors)
        {
            int x = 1;
            if(count.containsKey(sector))
            {
                x = count.get(sector) + 1;
            }
            count.put(sector, x);

            if(mostCount < x)
            {
                mostSector = sector;
                mostCount = x;
            }
        }
        return mostSector;
    }
}
