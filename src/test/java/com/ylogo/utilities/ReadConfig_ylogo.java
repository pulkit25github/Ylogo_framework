package com.ylogo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig_ylogo 
{
	Properties ylpro;
	
	//Creating constructor
	
	public ReadConfig_ylogo()
	{
		File src = new File("./" +"\\Configurations\\config.properties");
		
		// Automatically suggest you to add try catch 
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			ylpro = new Properties();
			ylpro.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Error messgage is : "+ e.getMessage());
		}
	}	
	
	// Adding Web elements
		
	   public String getYlogoUrl()
	   {
		   String url = ylpro.getProperty("baseUrl");
		   return url;
	   }
	   
	   public String getYlogoUserID()
	   {
		   String uid= ylpro.getProperty("username");
		   return uid;
	   }
	   
	   public String getYlogopwd()
	   {
		   String pwd= ylpro.getProperty("password");
		   return pwd;
	   }
	   
		public String getChromePath()
		{
			String chromepath = ylpro.getProperty("ChromePath");
			return chromepath;
		}
		
		public String getFirefoxPath()
		{
			String ffpath = ylpro.getProperty("FirefoxPath");
			return ffpath;
		}
	
		public String getIEPath()
		{
			String iepath = ylpro.getProperty("IEPath");
			return iepath;
		}
	
}
// 