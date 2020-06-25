package com.tyss.projectframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.projectframework.lib.GenericLib;

public class HomePage {
WebDriver driver;
	
	@FindBy(xpath="//a[text()='My Account']")
	private WebElement myAccountBtn;
	
	@FindBy(name = "product")
	private WebElement searchBox;
	
	@FindBy(xpath = "//button[@name='search']")
	private WebElement searchEnter;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void myAccountBtnClick()
	{
		GenericLib.clickElement(driver,myAccountBtn,"Account Button");
	}
	
	public void searchEnterTextandsearchClick(String searchKey) throws InterruptedException
	{
		GenericLib.enterText(driver, searchBox, searchKey, "SearchBox");
		Thread.sleep(5000);
		GenericLib.clickElement(driver, searchEnter, "search Btn");
	}

	public String getHomePage() 
	{
		return driver.getTitle();
	}
}