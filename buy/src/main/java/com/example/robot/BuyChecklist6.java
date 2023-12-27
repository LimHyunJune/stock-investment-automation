package com.example.robot;

import com.example.dto.StockData;
import lombok.Data;

@Data
public class BuyChecklist6 implements BuyChecklist {
    public String context = "부채비가 적절한가? (정상적인 기업은 주주지분 75% 부채 25%)";
    @Override
    public boolean run(StockData stockData) {
        return false;
    }
}
