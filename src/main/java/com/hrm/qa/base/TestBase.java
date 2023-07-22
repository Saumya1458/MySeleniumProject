package com.hrm.qa.base;

import java.util.Properties;
import java.io.*;
import java.time.Duration;
import java.time.LocalDate;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.hrm.qa.util.TestUtilClass;
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static String datecomponent;
	public static String duration;
	public static LocalDate localDate_from;

	
	public TestBase()
	{
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("//C:\\Users\\hp\\Selecworkspace\\orangehrmwork\\src\\main\\java\\com\\hrm\\qa\\config\\config.properties");
			prop.load(ip);
		}catch(FileNotFoundException e) {
		e.printStackTrace();
		}
		catch(IOException e) {
		e.printStackTrace();
		}
		}
	

	
public void initialize()
{
	String browsername = prop.getProperty("browser");
	if(browsername.equalsIgnoreCase("Chrome"))
	{
		driver = new ChromeDriver();
	}else if(browsername.equals("FireFox"))
	{
		driver = new FirefoxDriver();
	}
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtilClass.pageloadtimeout));
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtilClass.implicitwait));
	driver.get(prop.getProperty("url"));
	
}
public TestBase(WebDriver driver) {
    TestBase.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtilClass.explicitwait ));
}

protected void waitForVisibilityOfElement(WebElement element) {
    wait.until(ExpectedConditions.visibilityOf(element));
}

protected void waitForElementToBeClickable(WebElement element) {
    wait.until(ExpectedConditions.elementToBeClickable(element));
}
public static String getscreenshot(String testcasename)
{
TakesScreenshot src = ((TakesScreenshot)driver);
File srcfile = src.getScreenshotAs(OutputType.FILE);
File dest=new File("C:\\Users\\hp\\Selecworkspace\\orangehrmwork\\src\\main\\java\\com\\hrm\\qa\\base\\demo.png");
try {
    FileUtils.copyFile(srcfile, dest);
} catch (IOException e) {
    e.printStackTrace();
}
return dest.getAbsolutePath();

}

public static int cal_Calender_from(String datecomponent, String duration)
{
	duration = duration;
	datecomponent = datecomponent;
	if (duration=="from")
	{
    localDate_from = TestUtilClass.Calender(prop.getProperty("datefrom"));
	}else 
		if(duration == "to")
		{
		localDate_from = TestUtilClass.Calender(prop.getProperty("dateto"));
		}
 int year = localDate_from.getYear();
 int month = localDate_from.getMonthValue();
 int day = localDate_from.getDayOfMonth();
 
 switch(datecomponent)
 {
 case "fromday": 
	 return day;
	 
 case "frommonth":
	 return month;
	 
 case "fromyear":
	 return year;
	 
	 default:
		 System.out.print("Please do the needful selection");
		 return -1;
 }
}

 {
 
 }
	
}



	
	

