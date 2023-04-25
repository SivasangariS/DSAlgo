package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelReader {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\91638\\git\\DSAlgo\\DSAlgo\\src\\test\\resources\\TestData\\Login.xlsx";
	//public static String="# This program prints Hello, world!"
		         			//+ "print('Hello, world!')";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
			    
	    public static List<Map<String, String>> readTestData(String sheetName) {
	        List<Map<String, String>> testData = new ArrayList<>();
	        FileInputStream file = null;
	        Workbook workbook = null;
	        try {
	            file = new FileInputStream(TESTDATA_SHEET_PATH);
	            workbook = WorkbookFactory.create(file);
	            Sheet sheet = workbook.getSheet(sheetName);
	            Row headerRow = sheet.getRow(0);
	            int lastRowNum = sheet.getLastRowNum();
	            for (int i = 1; i <= lastRowNum; i++) {
	                Row row = sheet.getRow(i);
	                Map<String, String> rowData = new HashMap<>();
	                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
	                    Cell cell = row.getCell(j);
	                    String key = headerRow.getCell(j).getStringCellValue();
	                    String value = "";
	                    if (cell != null) {
	                        DataFormatter formatter = new DataFormatter();
	                        value = formatter.formatCellValue(cell);
	                    }
	                    rowData.put(key, value);
	                }
	                testData.add(rowData);
	            }
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (workbook != null) {
	                try {
	                    workbook.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (file != null) {
	                try {
	                    file.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return testData;
	    }
	
}
