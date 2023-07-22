
/*Author Name - Saumya Gupta 
 * 
 */


package com.hrm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.pages.HomePage;
import com.hrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
		initialize();
		loginpage = new LoginPage();//methods of loginpage class are not static. Hence, we need to create object to access methods
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String PageTitle = loginpage.validatePageTitle();
		Assert.assertEquals(PageTitle, "OrangeHRM");
	}
	
	
	@Test(priority=3)
	public void loginTest()
	{
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
