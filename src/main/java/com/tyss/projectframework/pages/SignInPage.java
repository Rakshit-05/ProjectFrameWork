package com.tyss.projectframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tyss.projectframework.lib.GenericLib;

public class SignInPage {
	WebDriver driver;
	@FindBy(id = "exampleInputEmail1")
	private WebElement usrname;
	
	@FindBy(id = "exampleInputPassword1")
	private WebElement psw;
	
	@FindBy(name = "login")
	private WebElement loginBtn;
	
	public SignInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void doLogin(String username, String password)
	{
		GenericLib.enterText(driver, usrname, username, "Username TextBox");
		GenericLib.enterText(driver, psw, password, "password TextBox");
		GenericLib.clickElement(driver, loginBtn, "Login Btn");
	}
	
	public String getSignInPage()
	{
		return driver.getTitle();
	}

}
