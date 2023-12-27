package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist5 implements BuyChecklist {
    public String context = "부채가 감소하고 있는가?";
    @Override
    public boolean run(StockData stockData) {
        return false;
    }
}
