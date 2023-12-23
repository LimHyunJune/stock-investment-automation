package com.example.controller;

import com.example.kafka.KafkaProducer;
import com.example.model.FinanceDataFetcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataFetcherController {

    private final KafkaProducer kafkaProducer;
    private final FinanceDataFetcher financeDataFetcher;

    @Autowired
    DataFetcherController(KafkaProducer kafkaProducer, FinanceDataFetcher financeDataFetcher)
    {
        this.kafkaProducer = kafkaProducer;
        this.financeDataFetcher = financeDataFetcher;
    }
    @GetMapping("welcome")
    public String test()
    {
        log.info("List : {}", financeDataFetcher.getRevenueGrowth("AAPL"));
        return "test";
    }

}


