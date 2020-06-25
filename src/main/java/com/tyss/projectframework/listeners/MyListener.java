package com.tyss.projectframework.listeners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.tyss.projectframework.lib.GenericLib;

public class MyListener implements ITestListener {
	public void onTestStart(ITestResult result) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String startTime = LocalDateTime.now().format(dtf);
		Reporter.log("The test case started at : "+result.getName()+startTime);		
	}

	public void onTestSuccess(ITestResult result) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String endTime = LocalDateTime.now().format(dtf);
		Reporter.log("The test case   "+result.getName() + "Completed At :"+endTime);		
	}

	public void onTestFailure(ITestResult result) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String endTime = LocalDateTime.now().format(dtf);
		Reporter.log("The test case   "+result.getName() + "Completed At :"+endTime);

		WebDriver driver = (WebDriver)result.getTestContext().getAttribute("driver");
		GenericLib.saveScreenShot(driver,result.getName());
		
	}

	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub	
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub	
	}

	public void onStart(ITestContext context) 
	{
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String startTime = LocalDateTime.now().format(dtf);
		Reporter.log("the test suite started at : "+startTime);
	}

	public void onFinish(ITestContext context) 
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String onFinishTime = LocalDateTime.now().format(dtf);
		Reporter.log("the test suite started at : "+onFinishTime);		
	}
}