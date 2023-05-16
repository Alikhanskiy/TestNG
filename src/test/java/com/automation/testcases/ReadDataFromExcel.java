package com.automation.testcases;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

public class ReadDataFromExcel {
    public static void main(String[] args) throws Exception {
        //Open Excel file

        XSSFWorkbook workbook = new XSSFWorkbook("src/test/resources/data/Data.xlsx");
        // Open Excel Sheet
        XSSFSheet sheet = workbook.getSheetAt(0);

        for(int i =0;i<sheet.getPhysicalNumberOfRows();i++){
            XSSFRow row = sheet.getRow(i);
            //XSSFCell cell = row.getCell(0);
            XSSFCell column1 = row.getCell(0);
            XSSFCell column2 = row.getCell(1);
            System.out.println(column1.getStringCellValue()+"  "+ column2.getStringCellValue());


        }
        System.out.println("==============");
        //Excel Row
        XSSFRow row = sheet.getRow(0);
        //Excel Cell(data)
        XSSFCell cell = row.getCell(1);
        System.out.println(cell.getStringCellValue());

    }

}
