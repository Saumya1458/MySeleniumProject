package com.hrm.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrm.qa.base.TestBase;
import com.hrm.qa.util.TestUtilClass;

public class AssignLeavePage extends TestBase {

	
 
	@FindBy(xpath = "//h6[text()='Assign Leave']")
	WebElement checkText;
	
	@FindBy(xpath= "//div[@class='oxd-autocomplete-text-input--before']")
	WebElement emp_label;
	
	@FindBy(className = "oxd-autocomplete-option")
	List<WebElement> autosuggest_name;
	
	@FindBy(xpath="//div[@role='listbox']")
	WebElement rolelist;
	
	@FindBy(xpath = "//div[@class='oxd-select-text--after']")
	WebElement leaveType;
	
	@FindBy(xpath = "//div[@role='listbox']//div//span")
	List<WebElement> type_leaves;
	
	@FindBy(xpath = "(//input[@placeholder='yyyy-mm-dd'])[1]")
	WebElement durationfrom;
	
	@FindBy(xpath = "//div[@class='oxd-calendar-selector-month-selected']//i")
	WebElement month_from;
	
	@FindBy(xpath = "//ul[@class='oxd-calendar-dropdown']//li")
    List<WebElement> month_yearcells;
	
	@FindBy(xpath = "//div[@class='oxd-calendar-selector-year-selected']")
	WebElement year_from;
	
	@FindBy(xpath = "//div[@class='oxd-calendar-dates-grid']//div//div")
	List<WebElement> date_cell;
	
	@FindBy(xpath = "(//input[@placeholder='yyyy-mm-dd'])[1]")
	WebElement durationto;
	
	@FindBy(xpath = "(//ul[@class='oxd-calendar-selector']//li)[1]")
	WebElement monthto;
	
	@FindBy(xpath = "(//ul[@class='oxd-calendar-selector']//li//ul//li)")
	List<WebElement> monthto_cells;
	
	@FindBy(xpath = "//div[@class='oxd-calendar-selector-year-selected']//p")
	WebElement year_to;
	
//	@FindBy(xpath = "(//ul[@role='menu']//li[@class='oxd-calendar-dropdown--option'])")
//	List<WebElement> yearto_cells;
	
//	@FindBy(xpath = "(//div[@class='oxd-calendar-dates-grid']//div//div)")
//	WebElement date_to;
	
	@FindBy(xpath = "(//div[@class='oxd-input-group__label-wrapper']//label[text() = 'Partial Days'])")
	WebElement partial_days;
	
	@FindBy(xpath = "((//div[@class='oxd-select-text--after'])[2])")
	WebElement partialdays_arrow;
	
	@FindBy(xpath = "(//div[@role='listbox']//div//span)")
	List<WebElement> partialdays_dropdown;
	
	@FindBy(xpath = "(//div[@class='oxd-input-group__label-wrapper']//label[text() = 'Duration'])")
	WebElement duration;
	
	@FindBy(xpath = "((//div[@class='oxd-select-text--after'])[3])")
	WebElement duration_arrow;
	
	@FindBy(xpath = "(//div[@role='listbox']//span)")
	List<WebElement> duration_dropdown;
	
	@FindBy(xpath = "(//div[@class='oxd-grid-item oxd-grid-item--gutters']//div//div//textarea)")
	WebElement comments;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit; 
	
	@FindBy(xpath = "((//div[@role='document']//div//p)[1])")
	WebElement alertElement;

	public AssignLeavePage()
    {
    	PageFactory.initElements(driver, this);
    }
	
	
//public boolean checkAssignLeaveText()
//{
//	boolean b = checkText.isDisplayed();
	

//	return b;
//}

public void empName(String empname_user)
{
	emp_label.click();
	emp_label.sendKeys("sa");
	emp_label.sendKeys(Keys.ENTER);
	   waitForVisibilityOfElement(rolelist);
	   for(WebElement a : autosuggest_name)
	   {
		   System.out.println("Name list :"+ a.getText());
		   if(a.getText().equalsIgnoreCase(empname_user))
		   {
			   a.click();
			   break;
	//	   return a.getText();
	   }
	   }
	  // return null;
}
	   
		   public void leaveType(String leavetype_user)
		   {
		   leaveType.click();
		    System.out.println("lenth of list " + type_leaves.size());
		    for (WebElement type : type_leaves)
		    {
		    	System.out.println("Leave type: " + type.getText());
		    	if(type.getText().equalsIgnoreCase(leavetype_user))
		    		{
		    		type.click();
		    	//	return type.getText();
		    		break;
		    		}
		    }
		    //	return null;
		   }
		    
public void leavedurationfrom_Month(String datecomponent, String duration)
{
	int from_month_name = TestBase.cal_Calender_from(datecomponent, duration);
	String month_name = String.valueOf(from_month_name);
	durationfrom.click();
	month_from.click();
	System.out.println("List of month : " + month_yearcells.size());
	   
    for(WebElement ml : month_yearcells)
    {
    	System.out.println("month :" + ml.getText());
    	if(ml.getText().equalsIgnoreCase(month_name))
    	{
    		ml.click();
    	//	return ml.getText();
    	break;	
    	}
    }
//return null;
}

public void leavedurationfrom_Year(String duration, String datecomponent)
{
	
   // durationfrom.click();
	
	int year_name = TestBase.cal_Calender_from(datecomponent, duration);
  year_from.click();
  System.out.println("List of the year : " + monthto_cells.size());

  for (WebElement y1 : month_yearcells)
  {
	  String getY1 = y1.getText();
	int convert_year = TestUtilClass.convertto(getY1);
	System.out.println("year : " + convert_year);
	  if(convert_year == year_name)
	  {
		  y1.click();
		 break;
	  }
  }
  
}

public void leavedurationfrom_Day(String duration, String datecomponent)
{
	int day_name = TestBase.cal_Calender_from(datecomponent, duration);
  System.out.println("Total Number of Days : " + date_cell.size());
  
  for(WebElement day : date_cell)
  {
    String getday = day.getText();
  	int convert_day = TestUtilClass.convertto(getday);
  	//System.out.println("Day : " + cal_date);
  	if(convert_day == day_name)
  	{
  		System.out.println("Day Number : " + convert_day);
  		day.click();
  		break;
  	}
  }
 
}

public void leavedurationTo_Month(String datecomponent, String duration)
{
	int monthValue = TestBase.cal_Calender_from(datecomponent, duration);
	String month_name = String.valueOf(monthValue);	
	durationto.click();
	monthto.click();
    System.out.println("List of month : " + monthto_cells.size());
   
    for(WebElement m2 : monthto_cells)
    {
    	System.out.println("month :" + m2.getText());
    	if(m2.getText().equalsIgnoreCase(month_name))
    	{
    		m2.click();
            break;
    		}
    }

}
public void leavedurationTo_Year(String duration, String datecomponent)
{
	
   // durationfrom.click();
	
	int year_name = TestBase.cal_Calender_from(datecomponent, duration);
	year_to.click();
  System.out.println("List of the year : " + monthto_cells.size());

  for (WebElement y2 : monthto_cells)
  {
	  String getY2 = y2.getText();
	int convert_year = TestUtilClass.convertto(getY2);
	System.out.println("year : " + convert_year);
	  if(convert_year == year_name)
	  {
		  y2.click();
		  break;
	  }
  }
  
}
public void leavedurationTo_Day(String duration, String datecomponent)
{
	int date_name = TestBase.cal_Calender_from(datecomponent, duration);
  System.out.println("Total Number of Days : " + date_cell.size());
  
  for(WebElement dayto : date_cell)
  {
    String getday2 = dayto.getText();
  	int convert_day = TestUtilClass.convertto(getday2);
  	//System.out.println("Day : " + cal_date);
  	if(convert_day == date_name)
  	{
  		System.out.println("Day Number : " + convert_day);
  		dayto.click();
  		break;
  	}
  }
 
}

public void partialDaysPresent(String partialdays)
{
	waitForVisibilityOfElement(partial_days);
	boolean pd = partial_days.isDisplayed();
	String str_pd = String.valueOf(pd);
	if(pd == true)
	{
		partialdays_arrow.click();
		for (WebElement p : partialdays_dropdown)
		{
			if(p.getText().equals(partialdays))
			{
				p.click();
				break;
			}
		}
	}
		
		}

public void duration_days(String durationdays)
{
	waitForVisibilityOfElement(duration);
	boolean d = duration.isDisplayed();
	String str_d = String.valueOf(d);
	if(str_d=="true")
	{
		duration_arrow.click();
		for(WebElement dd : duration_dropdown)
		{
			if(dd.getText().equals(durationdays))
			{
				dd.click();
				break;
			}
		}
	}
	 
}
 public void comments_section(String comment)
 {
	 comments.click();
	 comments.clear();
	 comments.sendKeys(comment);
	
	 
 }

public boolean assign()
{
	boolean a = submit.isEnabled();
	submit.click();
	return a;
}

public String getAlertText()
{
	String text = alertElement.getText();
	return text;
}

public void alertButton(String action)
{
	String a = action;
	if(a == "yes")
	driver.switchTo().alert().accept();
	else
		if(a=="no")
			driver.switchTo().alert().dismiss();
}
}
	
	








		   
		   
		   