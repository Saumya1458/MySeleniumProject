package com.hrm.qa.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.AssignLeavePage;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LeaveRequestPage;
import com.hrm.qa.pages.LoginPage;
import com.hrm.qa.util.WebEventListener;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(WebEventListener.class)

public class AssignLeavePageTest extends TestBase {
	
	
	LoginPage loginpage;
	HomePage homepage;
	//LeaveRequestPage lpr;
	AssignLeavePage alp;
	
	
	public AssignLeavePageTest()
	{
		super();
	}

	@BeforeMethod
	@BeforeMethod
	public void setUp()
	{
		
		initialize();
		
	    loginpage = new LoginPage();
	    alp = new AssignLeavePage();
	 
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	 
	    alp = homepage.approveLeave();
	  
	   	
	}
	
	
	/*public void validateHeaderText()
	{
		
		Assert.assertTrue(alp.checkAssignLeaveText(), "Correct Header Text is present");
	} */
	
	@DataProvider
	public void getData()
	{
		
	}
	
	
	@Test
	public void validate_Emp()
	{
		 
		alp.empName("Lisa  Andrews");
		//alp.empName(prop.getProperty("emp_name"));
	/*	String name = prop.getProperty("emp_name");
    if (name != null) {
        alp.empName(name);
    } else {
        // Handle the case when the comment is null
        // For example, you can log a message or skip the test
        System.out.println("The comment is null. Skipping the test.");
    } */
	}
	
/*	@Test(priority = 2)
	public void selectLeaveType()
	{
		alp.leaveType(prop.getProperty("leave_type"));
	}
	
//	@Test(priority = 3)
	public void selectFromMonth()
	{
		alp.leavedurationfrom_Month("from", "frommonth");
	}
	public void selectFromYear()
	{
		alp.leavedurationfrom_Year("from", "fromyear");
	}
	public void selectFromDay()
	{
		alp.leavedurationfrom_Day("from", "fromdate");
	}
	
//	@Test(priority = 4)
	public void selectToMonth()
	{
		alp.leavedurationTo_Month("frommonth", "to");
	}
	public void selectToYear()
	{
		alp.leavedurationTo_Year("to", "fromyear");
	}
	public void selectToDay()
	{
		alp.leavedurationTo_Day("to", "fromday");
	}
	
//	@Test(priority = 5)
	public void selectPartialBays()
	{
		alp.partialDaysPresent(prop.getProperty("partialdays"));
	}
	
//	@Test(priority = 6)
	public void selectDurationDays()
	{
		alp.duration_days(prop.getProperty("duration"));
	}	
	
//	@Test(priority = 7)*/

	public void giveComment()
	{
	 //alp.comments_section(prop.getProperty("comment"));
	 String comment = prop.getProperty("comment");
	    if (comment != null) {
	        alp.comments_section(comment);
	    } else {
	        // Handle the case when the comment is null
	        // For example, you can log a message or skip the test
	        System.out.println("The comment is null. Skipping the test.");
	    }
	}
	public void checkSubmitButton()
	{
		AssertJUnit.assertTrue(alp.assign(), "Submit button is not enabled");
	}
	public void checkAlertText()
	{
		String alert_text = alp.getAlertText();
		System.out.println("The alert Text is : " + alert_text);
	}
	public void performAlertAction()
	{
		alp.alertButton("yes");
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
