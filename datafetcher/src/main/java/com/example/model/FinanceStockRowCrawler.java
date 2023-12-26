package com.example.model;
import com.example.util.ExcelParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
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
        log.info("getRevenueGrowth : Company[{}]", company);
        return excelParser.getStockRowData(getIncomeUrl(company),"Revenue Growth");
    }

    @Override
    public List<Double> getGrossProfitGrowth(String company) {
        log.info("getGrossProfit : Company[{}]", company);
        return excelParser.getStockRowData(getIncomeUrl(company),"Gross Profit Growth");
    }

    @Override
    public List<Double> getPER(String company) {
        log.info("getPER : Company[{}]", company);
        return excelParser.getStockRowData(getMetricsUrl(company),"P/E ratio");
    }

    @Override
    public List<Double> getTotalCurrentAsset(String company) {
        log.info("getTotalCurrentAsset : Company[{}]", company);
        return excelParser.getStockRowData(getBalanceUrl(company),"Total current assets");
    }

    @Override
    public List<Double> getDebtGrowth(String company) {
        log.info("getDebtGrowth : Company[{}]", company);
        return excelParser.getStockRowData(getGrowthUrl(company),"Debt Growth");
    }

    @Override
    public List<Double> getDPE(String company) {
        log.info("getDPE : Company[{}]", company);
        return excelParser.getStockRowData(getMetricsUrl(company),"Debt/Equity");
    }

    @Override
    public List<Double> getCashflowPerShare(String company) {
        log.info("getCashflowPerShare : Company[{}]", company);
        return excelParser.getStockRowData(getGrowthUrl(company),"Free Cash Flow per Share");
    }

    @Override
    public List<Double> getOperatingCashFlow(String company) {
        log.info("getOperatingCashFlow : Company[{}]", company);
        return excelParser.getStockRowData(getCashFlowUrl(company),"Operating Cash Flow");
    }

    @Override
    public List<Double> getRnDExpensesGrowth(String company) {
        log.info("getRnDExpensesGrowth : Company[{}]", company);
        return excelParser.getStockRowData(getGrowthUrl(company),"Research and Development (R&D) Expenses Growth");
    }

    @Override
    public List<Double> getInventoryGrowth(String company) {
        log.info("getInventoryGrowth : Company[{}]", company);
        return excelParser.getStockRowData(getGrowthUrl(company),"Inventory Growth");
    }
}
