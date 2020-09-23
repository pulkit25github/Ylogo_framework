package com.ylogo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_ylogo 
{
	WebDriver driver;
	
    public Login_Page_ylogo (WebDriver rdriver)
    {
	driver= rdriver;
	PageFactory.initElements(rdriver, this);
    }

// 
	
	@FindBy (name = "email")
	WebElement usrname;
	
	@FindBy (how= How.NAME, using = "passwd")
	WebElement pwd;
	
	@FindBy (name = "SubmitLogin")
	WebElement sigin;
	
	@FindBy (how = How.LINK_TEXT, using = "Sign out")
	WebElement logout;
	
	
	
	public void setUsername(String user)
	{
		usrname.sendKeys(user);
	}
	
	public void setpwd(String paswd)
	{
		pwd.sendKeys(paswd);
	}
	
	public void submit()
	{
		sigin.click();
	}
	
	public void logout()
	{
		logout.click();
	}
	
}
