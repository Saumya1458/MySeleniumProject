package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.AssignLeavePage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LeaveRequestPage;
import com.hrm.qa.pages.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	AssignLeavePage alp;
	ExtentReports e;
	public HomePageTest()
	{
		super();
	 }
	@BeforeTest
	public void reports()
	{
		String path = System.getProperty("C:\\Users\\hp\\Selecworkspace\\orangehrmwork")+ "\\reports\\index.html";
		ExtentSparkReporter r = new ExtentSparkReporter(path);
		r.config().setReportName("Automation Results");
		r.config().setDocumentTitle("TestNG Results");
		
		ExtentReports e = new ExtentReports();
		e.attachReporter(r);
		e.setSystemInfo("Saumya", "OrangeHRM");
	}
	
@BeforeMethod
public void SetUp()
{
	initialize();
	loginpage = new LoginPage();
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
}

@Test(priority = 1)
public void UserValidation()
{
	String user = homepage.validateUser();
	String expecteduser = prop.getProperty("loggedInUser");
	Assert.assertEquals(user, expecteduser, "String Match");
}

@Test(priority = 2)
public void ValidateTime()
{
	String time = homepage.validateTimeSection();
	System.out.println("Name of time section is :" + time);
}
 
@Test(priority = 3)
public void LeaveApproval()
{
	alp = homepage.approveLeave();
}

@AfterMethod
public void teardown()
{
	driver.quit();
}
}
