package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist1 implements BuyChecklist {
    public String context = "매년 매출이 증가하는가?";
    @Override
    public boolean run(StockData stockData) {
        return false;
    }
}
