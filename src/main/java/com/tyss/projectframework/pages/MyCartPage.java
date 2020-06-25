package com.tyss.projectframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage {

	WebDriver driver;
	
 	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
     private WebElement welcomeName;
 	
 	
 	public MyCartPage(WebDriver driver) {
 		this.driver = driver;
 		PageFactory.initElements(driver, this);
 	}

 	
 	public String getWelcomeName() {
 		return welcomeName.getText();
 	}


}
