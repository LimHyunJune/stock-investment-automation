package com.example.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class ExcelParser {
    public List<Double> getStockRowData(String url, String key)
    {
        List<Double> result = new ArrayList<>();
        try {
            InputStream file = new URL(url).openStream();
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();
            for(int rowIndex = 0; rowIndex < rows; rowIndex++)
            {
                XSSFRow row = sheet.getRow(rowIndex);
                if (row != null) {
                    if(key.equals(row.getCell(0).getStringCellValue()))
                    {
                        int cells = row.getPhysicalNumberOfCells();
                        for (int columnindex = 1; columnindex <= cells; columnindex++) {
                            //셀값을 읽는다
                            XSSFCell cell = row.getCell(columnindex);
                            if (cell == null)
                                continue;
                            if(cell.getCellType()== CellType.NUMERIC)
                                result.add(cell.getNumericCellValue());
                        }
                    }
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
