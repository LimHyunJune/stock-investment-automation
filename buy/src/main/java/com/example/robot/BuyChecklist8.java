package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist8 implements BuyChecklist {
    public String context = "재고가 감소하고 있는가?";
    @Override
    public boolean run(StockData stockData) {
        return false;
    }
}
