package com.cs.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cs.reports.ExtentLogger;

public final class ExcelUtils {

    private ExcelUtils() {}

    private static List<Map<String, String>> list;

    public static List<Map<String, String>> getExcelData() {
        if (Objects.isNull(list)) {
            list = new ArrayList<>();

            try (InputStream is = ResourceLoader.getResource("excel/testcaseData.xlsx")) {
                XSSFSheet sheet = getworksheet(is);
                if (sheet != null) {
                    int rowCount = sheet.getLastRowNum();
                    int columnCount = sheet.getRow(0).getLastCellNum();

                    for (int i = 1; i <= rowCount; i++) {
                        HashMap<String, String> map = new HashMap<>();
                        for (int j = 0; j < columnCount; j++) {
                            String key = sheet.getRow(0).getCell(j).getStringCellValue();
                            String value = sheet.getRow(i).getCell(j).getStringCellValue();
                            map.put(key, value);
                        }
                        list.add(map);
                    }
                } else {
                    ExtentLogger.logFail("Failed to get the worksheet.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    private static XSSFSheet getworksheet(InputStream is) {
        XSSFSheet worksheet = null;
        try (XSSFWorkbook workbook = new XSSFWorkbook(is)) {
            worksheet = workbook.getSheet("RUNNER");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return worksheet;
    }
}
