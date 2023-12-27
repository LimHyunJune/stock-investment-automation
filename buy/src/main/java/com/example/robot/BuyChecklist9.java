package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist9 implements BuyChecklist {
    public String context = "연구 개발 비에 많은 돈을 투자하는가?";
    @Override
    public boolean run(StockData stockData) {
        return false;
    }
}
