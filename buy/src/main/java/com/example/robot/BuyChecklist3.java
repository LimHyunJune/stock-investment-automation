package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist3 implements BuyChecklist {
    public String context = "PER이 이익 성장률의 절반인가?";
    @Override
    public boolean run(StockData stockData) {
        return false;
    }
}
