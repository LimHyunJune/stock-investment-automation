package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockData {
    String name;
    List<Double> revenueGrowth;
    List<Double> grossProfitGrowth;
    List<Double> per;
    List<Double> totalCurrentAsset;
    List<Double> debtGrowth;
    List<Double> dpe;
    List<Double> cashflowPerShare;
    List<Double> operatingCashFlow;
    List<Double> rndExpensesGrowth;
    List<Double> inventoryGrowth;
}
