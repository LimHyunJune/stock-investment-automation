package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist2 implements BuyChecklist {
    public String context = "매년 이익이 증가하는가?";
    private double threshold = 5;
    @Override
    public boolean run(StockData stockData) {
        double average = stockData.getGrossProfitGrowth().stream()
                .mapToDouble(a->a).average().orElse(0);
        return average > 0;
    }
}
