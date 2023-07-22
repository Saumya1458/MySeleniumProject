package com.hrm.qa.util;

import org.testng.ITestContext ;		
import org.testng.ITestListener ;		
import org.testng.ITestResult ;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.hrm.qa.base.TestBase;	



public class WebEventListener extends TestBase implements ITestListener
{
	ExtentReports extent = TestUtilClass.getReports();
	ExtentTest test;
	@Override  
	public void onTestStart(ITestResult result) {  
	// TODO Auto-generated method stub  
		//control will come here before any test starts
		test = extent.createTest(result.getMethod().getMethodName());
	}  
	  
	@Override  
	public void onTestSuccess(ITestResult result) {  
	// TODO Auto-generated method stub  
		test.log(Status.PASS, "Test Pass");
	System.out.println("Success of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());
	test.fail(result.getThrowable());
	String filepath = null;
	try {
		filepath = TestBase.getscreenshot(result.getMethod().getMethodName());
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Skip of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	// TODO Auto-generated method stub  
	System.out.println("Failure of test cases and its details are : "+result.getName());  
	}  
	  
	@Override  
	public void onStart(ITestContext context) {  
	// TODO Auto-generated method stub  
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
	// TODO Auto-generated method stub  
		extent.flush();
	}  
}
	