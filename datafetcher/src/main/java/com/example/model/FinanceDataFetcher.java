package com.example.model;

import java.util.List;

public interface FinanceDataFetcher {

    List<Double> getRevenueGrowth(String company); //매출 성장률
    List<Double> getGrossProfit(String company); // 이익 성장률
    List<Double> getPER(String company); // PER
    List<Double> getTotalCurrentAsset(String company); // 현금성 자산
    List<Double> getDebtGrowth(String company); // 부채 상승율
    List<Double> getDPE(String company); // Debt/Equity 부채비
    List<Double> getCashflowPerShare(String company); // 주당 현금
    List<Double> getOperatingCashFlow(String company); // 영업 현금 흐름
    List<Double> getRnDExpensesGrowth(String company); // 연구 개발 비 성장률
    List<Double> getInventoryGrowth(String company); // 재고 증가율

}
