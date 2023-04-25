package com.qa.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;

public class CodeReader {
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\divya\\eclipse-workspace\\Projects\\DS_ALGO_BDD\\src\\test\\resources\\TestData\\code.xlsx";
	//public static String="# This program prints Hello, world!"
		         			//+ "print('Hello, world!')";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	/*public static List<String> getPythonCodeFromSheet1(String sheetName, int startRow) {
	    List<String> codeList = new ArrayList<>();
	    try {
	        // Open the workbook and get the specified sheet
	        FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        // Loop through all rows in the sheet and retrieve the code from the first cell
	        int lastRow = sheet.getLastRowNum();
	        for (int rowNumber = startRow; rowNumber <= lastRow; rowNumber++) {
	            Row row = sheet.getRow(rowNumber);
	            if (row != null) {
	                Cell cell = row.getCell(0);
	                if (cell != null) {
	                    codeList.add(cell.getStringCellValue());
	                }
	            }
	        }
	        // Close the workbook and return the code list
	        workbook.close();
	        return codeList;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return null;
	    }
	}*/
	
	
	public static List<String> getPythonCodeFromSheet(String sheetName, int startRow) {
	    List<String> codeList = new ArrayList<>();
	    try {
	        FileInputStream file = new FileInputStream(TESTDATA_SHEET_PATH);
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(startRow);
	        if (row != null) {
	            Cell cell = row.getCell(0);
	            if (cell != null) {
	                codeList.add(cell.getStringCellValue());
	            }
	        }
	        workbook.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return codeList;
	}

}
