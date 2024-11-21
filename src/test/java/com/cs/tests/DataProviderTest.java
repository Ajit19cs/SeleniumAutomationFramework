package com.cs.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cs.constants.FrameWorkConstatns;

public class DataProviderTest {
	
	@Test(dataProvider = "getTwoDimensionData")
	public void testdata(String ...name)
	{
		 System.out.println("data printed is :"+Arrays.toString(name));
		
	}
	
	@Test(dataProvider = "getExcelSheetData")
	public void testExceldata(String name,String email, String phNo ,String age)
	{
		 System.out.println("data printed is :"+ name+" "+ email +" "+phNo +" "+age );
		
	}
	@DataProvider
	public Object[][] getExcelSheetData() throws IOException
	{
		FileInputStream excelFile;
		
			 excelFile = new FileInputStream(FrameWorkConstatns.getExceltestdatapath());
			 XSSFWorkbook workBook= new XSSFWorkbook(excelFile);
			 XSSFSheet sheet = workBook.getSheetAt(0);
			 
			 int rowCount=sheet.getLastRowNum();
			 int colCount=sheet.getRow(rowCount).getLastCellNum();
			 Object[][] excelValues = new Object[rowCount][colCount];
			 
			 for(int row=1;row<=rowCount;row++)
			 {
				 for(int col=0;col<colCount;col++)
				 {
					 excelValues[row-1][col]= sheet.getRow(row).getCell(col).getStringCellValue();
				 }
			 }
			excelFile.close(); 
			workBook.close();
			 
		return excelValues;	 
			 
		
	}
	
	@DataProvider
	public String[] getdata()
	{
		String[] names = {"ajit","Manu","Yogita"};
		 return names;
	}

	@DataProvider
	public Object[][] getTwoDimensionData()
	{
		String[][] names = {{"ajit"},{"Manu"},{"Yogita"}};
		 return names;
	}
	

}
