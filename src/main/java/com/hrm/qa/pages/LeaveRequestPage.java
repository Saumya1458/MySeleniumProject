package com.hrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;

import com.hrm.qa.base.TestBase;

public class LeaveRequestPage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Assign')]")
	WebElement assignLeave;

	public LeaveRequestPage()
    {
    	PageFactory.initElements(driver, this);
    }
	public AssignLeavePage click_assignLeave()
	{
		assignLeave.click();
		return new AssignLeavePage();
	}
	
	
}
