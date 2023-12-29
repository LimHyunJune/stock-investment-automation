package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

import java.util.OptionalDouble;

@Data
public class BuyChecklist1 implements BuyChecklist {
    public String context = "매년 매출이 증가하는가?";
    @Override
    public boolean run(StockData stockData) {
        double average = stockData.getRevenueGrowth().stream()
                .mapToDouble(a->a).average().orElse(0);
        return average > 0;
    }
}
