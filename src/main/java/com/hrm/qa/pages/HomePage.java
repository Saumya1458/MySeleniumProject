package com.hrm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	@CacheLookup
	WebElement loggedInUser;
	
	@FindBy(xpath = "//p[text()='Time at Work']")
	WebElement timeSection;

    @FindBy(xpath = "//div[@class='orangehrm-dashboard-widget-name']//p[text()='My Actions']")
    WebElement myActions;
    
    @FindBy(xpath = "//p[text()='Quick Launch']")
    WebElement quickLaunch;
    
    @FindBy(xpath = "//p[text()='Buzz Latest Posts']")
    WebElement posts;
    
    @FindBy(xpath = "//p[text()='Employees on Leave Today']")
    WebElement empOnLeave;
    
    @FindBy(xpath = "//p[text()='Employee Distribution by Location']")
    WebElement empLocation;
    
    @FindBy(xpath = "//button[@type='button' and @title='Assign Leave']")
    WebElement requestToApprove;
    
    public HomePage()
    {
    	PageFactory.initElements(driver, this);
    }
     
    
   
    public String validateUser()
    {
    	String user = loggedInUser.getText();
    	return user;
    }
    public String validateTimeSection()
    {
    	String time = timeSection.getText();
    	return time;
    }
    public String validateAction()
    {
    	String actions = myActions.getText();
    	return actions;
    }
    public String validateQuickLaunch()
    {
        String launch = quickLaunch.getText();
        return launch;
    }
    public String validatePosts()
    {
    	String post = posts.getText();
    	return post;
    }
    public String validateEmpOnLeave()
    {
    	String leave = empOnLeave.getText();
    	return leave;
    }
    public String validateEmpLocation()
    {
    	String location = empLocation.getText();
    	return location;
    }
    public AssignLeavePage approveLeave()
    {
    	requestToApprove.click();
    	return new AssignLeavePage();
    }
}
