package com.hrm.qa.pages;

import com.hrm.qa.base.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	//Page Factory
	@FindBy(xpath="//input[@placeholder='Username']")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	
	@FindBy(xpath = "//div[@class='oxd-form-actions orangehrm-login-action']//button[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	WebElement forgotpwd;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	

	
	//Actions
	public String validatePageTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		submit.click();
		//forgotpwd.click();
		 return new HomePage();
	}
}
