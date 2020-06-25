package com.tyss.projectframework.lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseLib {
	static
	{
		System.setProperty(GenericLib.getPropData("browserKey"), GenericLib.getPropData("browserValue"));
		
	}
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp(ITestContext contex)
	{
    driver = new ChromeDriver();
    contex.setAttribute("driver",driver);	
	Reporter.log("Browser launched successfully ");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get(GenericLib.getPropData("url"));
	Reporter.log("Application loaded ");
	
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
}
