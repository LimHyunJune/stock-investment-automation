package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist4 implements BuyChecklist {
    public String context = "현금성 자산이 증가하였는가?";
    @Override
    public boolean run(StockData stockData) {
        return false;
    }
}
