package com.ylogo.testcases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ylogo.pages.Login_Page_ylogo;
import com.ylogo.utilities.ReadConfig_ylogo;

public class TC01_Login_ylogo extends BaseClass_ylogo
{
    @Test
	public void Login_ylogo_test() throws Exception 
	{
		Login_Page_ylogo ly = new Login_Page_ylogo(driver);
		
		logger.info("URL OPENED");
		
		ly.setUsername(username);
		logger.info("USERID ENTERED");
		
		ly.setpwd(password);
		logger.info("PWD ENTERED");
		
		ly.submit();
		logger.info("CLICKED ON SUBMIT");
		
		Thread.sleep(2000);
		if(driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders."))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		ly.logout();
		logger.info("CLICKED ON LOGOUT");
		
	}
	
	
	
}
