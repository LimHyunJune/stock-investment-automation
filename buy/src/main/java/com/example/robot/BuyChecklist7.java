package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist7 implements BuyChecklist {
    public String context = "주당 현금 흐름이 증가하는가?";
    @Override
    public boolean run(StockData stockData) {
        return false;
    }
}
