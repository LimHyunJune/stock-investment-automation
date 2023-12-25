package com.example.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MostSectorTest {
    SectorDataFetcher sectorDataFetcher = new SectorTradingViewCrawler();

    @Test
    public void findMostSector()
    {
        String sector = sectorDataFetcher.getSector();
        Assertions.assertEquals(sector,"Finance");
    }

}