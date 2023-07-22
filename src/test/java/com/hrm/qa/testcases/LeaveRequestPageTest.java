package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.AssignLeavePage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LeaveRequestPage;
import com.hrm.qa.pages.LoginPage;

public class LeaveRequestPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	LeaveRequestPage lpr;
	AssignLeavePage alp;
	public LeaveRequestPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialize();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		homepage = new HomePage();
		lpr = homepage.approveLeave();
		}
	
	@Test
	public void leaveRequest()
	{
		alp = lpr.click_assignLeave();
	}
	
	@AfterMethod
	public void tear()
	{
		driver.quit();
	}
	
}
