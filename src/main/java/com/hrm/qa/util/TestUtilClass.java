package com.hrm.qa.util;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class TestUtilClass {

	public static int pageloadtimeout = 40;
	public static int implicitwait = 50;
	public static int explicitwait = 50;
	 public static Workbook book;
	 public static Sheet sheet;
	public static ExtentReports e;
	 public static String Test_Data_Path="C:\\Users\\hp\\Selecworkspace\\orangehrmwork\\src\\test\\java\\com\\hrm\\qa\\testcases\\Orange HRM data.xlsx";
	public static int convertto(String value)
	{
		int i_value = Integer.parseInt(value);
		return i_value;
	}
	public static String convertToString(int value)
	{
		String s_value = String.valueOf(value);
		return s_value;
	}
	
	public static LocalDate Calender(String date_user)
	{
		String leave_date = date_user;
        String[] dateParts = leave_date.split("-");
        
        int year = Integer.parseInt(dateParts[0]);
        int month = Integer.parseInt(dateParts[1]);
        int day = Integer.parseInt(dateParts[2]);
        LocalDate localDate = LocalDate.of(year, month, day);
    //    int leave_day = localDate.getDayOfYear();
        return localDate;
	}
	
	public static ExtentReports getReports()

	{
		String path = System.getProperty("C:\\Users\\hp\\Selecworkspace\\orangehrmwork")+ "\\reports\\index.html";
		ExtentSparkReporter r = new ExtentSparkReporter(path);
		r.config().setReportName("Automation Results");
		r.config().setDocumentTitle("TestNG Results");
		
		 e = new ExtentReports();
		e.attachReporter(r);
		e.setSystemInfo("Saumya", "OrangeHRM");
		return e;
	}
/*	public static Object[][] getData(String sheetname)
		{
			FileInputStream file = null;
			try
			{
				file = new FileInputStream(Test_Data_Path);
			}catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			try
			{
				book =WorkbookFactory.create(file);
			}catch(InvalidFormatException e)
		{e.printStackTrace();
		} 
			sheet = book.getSheet(sheetname);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			for (int i=0; i<sheet.getLastRowNum();i++)
			{
				for(int j = 0; j<sheet.getRow(0).getLastCellNum(); j++)
				{
					data[i][j] = sheet.getRow(i+1).getCell(j).toString();
				}
			}
			return data;
				
			
	} */
}
