package com.tyss.projectframework.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;
import com.tyss.projectframework.init.IConstants;


public class GenericLib {
	public static String getPropData(String key) 
	{
		String data = "";
		try 
		{
			FileInputStream fin = new FileInputStream(IConstants.propFilePath);
			Properties prop = new Properties();
			prop.load(fin);
		data = prop.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	public static void clickElement(WebDriver driver, WebElement ele, String eleName)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele)).click();
			Reporter.log("clicked on"+eleName);
		}
		catch(TimeoutException e)
		{
			Reporter.log(eleName+"is not displayed");
			Assert.fail();
		}
	}
	
	public static void enterText(WebDriver driver, WebElement ele,String text, String eleName)
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys(text);
			Reporter.log("entered text"+text+"in the"+eleName);
		}
		catch(TimeoutException e)
		{
			Reporter.log(eleName+"is not displayed");
			Assert.fail();
		}
	}
	public static void saveScreenShot(WebDriver driver,String fileName)
	{
		TakesScreenshot ss = (TakesScreenshot) driver;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy hh-mm-ss");
		String time = LocalDateTime.now().format(dtf);
		
		File src = ss.getScreenshotAs(OutputType.FILE);
		File des = new File(IConstants.ScreenShotPath +fileName +" "+time+"_Failed.png");
		try 
		{
			Files.copy(src, des);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
