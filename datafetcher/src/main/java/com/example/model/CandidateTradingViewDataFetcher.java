package com.example.model;

import io.github.bonigarcia.wdm.WebDriverManager;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CandidateTradingViewDataFetcher implements CandidateDataFetcher{
    WebDriver driver;
    @PostConstruct
    public void init()
    {
        WebDriverManager.chromedriver().setup();
    }
    @Override
    public List<String> getCandidates(String sector) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        String url = "https://www.tradingview.com/markets/stocks-usa/sectorandindustry-sector/" + mappingSector(sector);
        driver.get(url);
        // volume click
        WebElement volume = driver.findElement(By.xpath("//table[@class='table-Ngq2xrcG tableSticky-SfGgNYTG']/thead/tr/th[4]"));
        volume.click();
        Thread.sleep(1000);
        // sort descending click
        WebElement sort = driver.findElement(By.xpath("//div[@id='overlap-manager-root']/div/span/div[1]/div/div/div[3]"));
        sort.click();
        Thread.sleep(1000);
        // collect stocks
        List<WebElement> el = driver.findElements(By.className("listRow"));
        List<String> stocks = new ArrayList<>();
        int length = Math.min(el.size(), 2);
        for(int i = 0; i < length; i++)
        {
            log.info(el.get(i).findElement(By.xpath(".//td[1]/span/a")).getText());
            stocks.add(el.get(i).findElement(By.xpath(".//td[1]/span/a")).getText());
        }
        driver.quit();
        return stocks;
    }

    private String mappingSector(String sector)
    {
        String convert = null;
        switch (sector)
        {
            case "Commercial Services" :
                convert = "commercial-services";
                break;
            case "Communications":
                convert = "communications";
                break;
            case "Consumer Durables":
                convert = "consumer-durables";
                break;
            case "Consumer Non-Durables":
                convert = "consumer-non-durables";
                break;
            case "Consumer Services":
                convert = "consumer-services";
                break;
            case "Distribution Services":
                convert = "distribution-services";
                break;
            case "Electronic Technology":
                convert = "electronic-technology";
                break;
            case "Energy Minerals":
                convert = "energy-minerals";
                break;
            case "Finance":
                convert = "finance";
                break;
            case "Health Services":
                convert = "health-services";
                break;
            case "Health Technology":
                convert = "health-technology";
                break;
            case "Industrial Services":
                convert = "industrial-services";
                break;
            case "Miscellaneous":
                convert = "miscellaneous";
                break;
            case "Non-Energy Minerals":
                convert = "non-energy-minerals";
                break;
            case "Process Industries":
                convert = "process-industries";
                break;
            case "Retail Trade":
                convert = "retail-trade";
                break;
            case "Technology Services":
                convert = "technology-services";
                break;
            case "Transportation":
                convert = "transportation";
                break;
            case "Utilities":
                convert = "utilities";
                break;
        }
        return convert;
    }
}
