package com.ylogo.testcases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.utils.FileUtil;
import com.ylogo.utilities.ReadConfig_ylogo;


public class BaseClass_ylogo 
{

	ReadConfig_ylogo rc = new ReadConfig_ylogo();
	
	public String baseUrl = rc.getYlogoUrl();
	public String username = rc.getYlogoUserID();
	public String password = rc.getYlogopwd();
	public static WebDriver driver;
	public static Logger logger;


@Parameters ("browser")
@BeforeClass
public void Setup(String br)

{
	if(br.equals("firefox"))
	{
		System.setProperty("webdriver.gecko.driver", rc.getFirefoxPath());
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("marionette", false); 
        FirefoxOptions options = new FirefoxOptions(); 
        options.merge(capabilities);
		driver =  new FirefoxDriver(options);
	}
	else if (br.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver =new ChromeDriver();	
			
	}
	else if (br.equals("ie"))
	{
		System.setProperty("webdriver.ie.driver", rc.getIEPath());
		driver =new InternetExplorerDriver();
	}
	else
	{
		System.out.println("Please check your browser name");
	}
	
	
/*  System.setProperty("webdriver.chrome.driver", rc.getChromePath());
	driver =new ChromeDriver();   */
	
	
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get(baseUrl);
	driver.manage().window().maximize();
	
	// For Logs:
	
	logger = Logger.getLogger("YourLogo_Framework");
	PropertyConfigurator.configure("./" + "/log4j.properties");
	
}

     public void captureScreen(WebDriver driver, String tcname) throws Exception
   
     {
    	TakesScreenshot ts = (TakesScreenshot) driver;
    	File source = ts.getScreenshotAs(OutputType.FILE);
    	File target = new File("./"+ "/Screenshots/"+ tcname+ ".png");
    	FileUtils.copyFile(source, target);
    	System.out.println("Screenshot taken");
	
     }

}
