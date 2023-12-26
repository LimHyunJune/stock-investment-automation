package com.example.controller;

import com.example.dto.StockData;
import com.example.kafka.KafkaProducer;
import com.example.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/data")
public class DataFetcherController {

    private final KafkaProducer kafkaProducer;
    private final FinanceDataFetcher financeDataFetcher;
    private SectorDataFetcher sectorDataFetcher;
    private CandidateDataFetcher candidateDataFetcher;

    @Autowired
    DataFetcherController(KafkaProducer kafkaProducer, FinanceDataFetcher financeDataFetcher)
    {
        this.kafkaProducer = kafkaProducer;
        this.financeDataFetcher = financeDataFetcher;
        this.sectorDataFetcher = new SectorTradingViewCrawler();
        this.candidateDataFetcher = new CandidateTradingViewDataFetcher();
    }
    @GetMapping("welcome")
    public String test() {
        return "test";
    }

    @GetMapping("run")
    public List<StockData> run() throws InterruptedException, JsonProcessingException {
        String sector = sectorDataFetcher.getSector();
        List<String> candidates = candidateDataFetcher.getCandidates(sector);
        List<StockData> stockDataResult = new ArrayList<>();
        for(String candidate : candidates)
        {
            StockData stockData = StockData.builder().name(candidate)
                    .revenueGrowth(financeDataFetcher.getRevenueGrowth(candidate))
                    .grossProfitGrowth(financeDataFetcher.getGrossProfitGrowth(candidate))
                    .per(financeDataFetcher.getPER(candidate))
                    .totalCurrentAsset(financeDataFetcher.getTotalCurrentAsset(candidate))
                    .debtGrowth(financeDataFetcher.getDebtGrowth(candidate))
                    .dpe(financeDataFetcher.getDPE(candidate))
                    .cashflowPerShare(financeDataFetcher.getCashflowPerShare(candidate))
                    .operatingCashFlow(financeDataFetcher.getOperatingCashFlow(candidate))
                    .rndExpensesGrowth(financeDataFetcher.getRnDExpensesGrowth(candidate))
                    .inventoryGrowth(financeDataFetcher.getInventoryGrowth(candidate)).build();
            stockDataResult.add(stockData);
        }
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(stockDataResult);
        log.info("Result : {}", result);
        kafkaProducer.send("data", result);
        return stockDataResult;
    }
}


