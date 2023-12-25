package com.example.model;
import com.example.util.ExcelParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FinanceStockRowCrawler implements FinanceDataFetcher{

    private final ExcelParser excelParser;

    @Autowired
    public FinanceStockRowCrawler(ExcelParser excelParser)
    {
        this.excelParser = excelParser;
    }

    private String getIncomeUrl(String company)
    {
        return "https://stockrow.com/api/companies/"+company+"/financials.xlsx?dimension=Q&section=Income%20Statement&sort=desc";
    }
    private String getGrowthUrl(String company)
    {
        return "https://stockrow.com/api/companies/"+company+"/financials.xlsx?dimension=Q&section=Growth&sort=desc";
    }

    private String getCashFlowUrl(String company)
    {
        return "https://stockrow.com/api/companies/"+company+"/financials.xlsx?dimension=Q&section=Cash%20Flow&sort=desc";
    }

    private String getBalanceUrl(String company)
    {
        return "https://stockrow.com/api/companies/"+company+"/financials.xlsx?dimension=Q&section=Balance%20Sheet&sort=desc";
    }

    private String getMetricsUrl(String company)
    {
        return "https://stockrow.com/api/companies/"+company+"/financials.xlsx?dimension=Q&section=Metrics&sort=desc";
    }

    @Override
    public List<Double> getRevenueGrowth(String company) {
        return excelParser.getStockRowData(getIncomeUrl(company),2);
    }

    @Override
    public List<Double> getGrossProfit(String company) {
        return excelParser.getStockRowData(getIncomeUrl(company),4);
    }

    @Override
    public List<Double> getPER(String company) {
        return excelParser.getStockRowData(getMetricsUrl(company),1);
    }

    @Override
    public List<Double> getTotalCurrentAsset(String company) {
        return excelParser.getStockRowData(getBalanceUrl(company),5);
    }

    @Override
    public List<Double> getDebtGrowth(String company) {
        return excelParser.getStockRowData(getGrowthUrl(company),14);
    }

    @Override
    public List<Double> getDPE(String company) {
        return excelParser.getStockRowData(getMetricsUrl(company),15);
    }

    @Override
    public List<Double> getCashflowPerShare(String company) {
        return excelParser.getStockRowData(getGrowthUrl(company),8);
    }

    @Override
    public List<Double> getOperatingCashFlow(String company) {
        return excelParser.getStockRowData(getCashFlowUrl(company),9);
    }

    @Override
    public List<Double> getRnDExpensesGrowth(String company) {
        return excelParser.getStockRowData(getGrowthUrl(company),16);
    }

    @Override
    public List<Double> getInventoryGrowth(String company) {
        return excelParser.getStockRowData(getGrowthUrl(company),14);
    }
}
