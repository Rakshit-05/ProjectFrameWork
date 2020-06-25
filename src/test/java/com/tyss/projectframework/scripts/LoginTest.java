package com.tyss.projectframework.scripts;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tyss.projectframework.init.IConstants;
import com.tyss.projectframework.lib.BaseLib;
import com.tyss.projectframework.lib.ExcelLib;
import com.tyss.projectframework.pages.HomePage;
import com.tyss.projectframework.pages.MyCartPage;
import com.tyss.projectframework.pages.SignInPage;

@Listeners(com.tyss.projectframework.listeners.MyListener.class)

public class LoginTest extends BaseLib{
	
	@Test 
	public void tc_01() throws InterruptedException {
	HomePage hp = new HomePage(driver);
	Assert.assertEquals(hp.getHomePage(), ExcelLib.getData("Sheet1", 1, 1, IConstants.expectedExcelData));
	hp.myAccountBtnClick();
	SignInPage sip = new SignInPage(driver);
	Assert.assertEquals(hp.getHomePage(), ExcelLib.getData("Sheet1", 1, 2, IConstants.expectedExcelData));
	String un = ExcelLib.getData("Sheet1", 1, 1, IConstants.excelPath);
	String pw = ExcelLib.getData("Sheet1", 1, 2, IConstants.excelPath);
	sip.doLogin(un, pw);
	MyCartPage mcp = new MyCartPage(driver);
	Assert.assertTrue(mcp.getWelcomeName().contains(ExcelLib.getData("Sheet1", 1, 3, IConstants.expectedExcelData)));
	Thread.sleep(5000); 
}
	
}