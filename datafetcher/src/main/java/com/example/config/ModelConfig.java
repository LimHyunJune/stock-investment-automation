package com.example.config;

import com.example.model.FinanceDataFetcher;
import com.example.model.FinanceStockRowCrawler;
import com.example.util.ExcelParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    @Bean
    public ExcelParser excelParser()
    {
        return new ExcelParser();
    }
    @Bean
    public FinanceDataFetcher financeDataFetcher()
    {
        return new FinanceStockRowCrawler(excelParser());
    }
}
