package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {  
	
	public String getDataFromExcel(String sheetName, int rowNum, int CelNum) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptdata.xlsx");
		Workbook wb	= WorkbookFactory.create(fis);
		String data= wb.getSheet(sheetName).getRow(rowNum).getCell(CelNum).getStringCellValue();
		wb.close();
		return data;
	}
	
	public int getRowcount(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./testData/testScriptdata.xlsx");
		Workbook wb	= WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./testData/testScriptdata.xlsx");
		Workbook wb	= WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		
		FileOutputStream fos= new FileOutputStream("./testData/testScriptdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
