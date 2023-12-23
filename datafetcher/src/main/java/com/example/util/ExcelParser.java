package com.example.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ExcelParser {
    public List<Double> getStockRowData(String url, int rowIndex)
    {
        List<Double> result = new ArrayList<>();
        try {
            InputStream file = new URL(url).openStream();
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = sheet.getRow(rowIndex);
            if (row != null) {
                int cells = row.getPhysicalNumberOfCells();
                for (int columnindex = 1; columnindex <= cells; columnindex++) {
                    //셀값을 읽는다
                    XSSFCell cell = row.getCell(columnindex);
                    if (cell == null)
                        continue;
                    result.add(cell.getNumericCellValue());
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
