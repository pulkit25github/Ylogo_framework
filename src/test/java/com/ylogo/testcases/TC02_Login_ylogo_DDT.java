package com.ylogo.testcases;

import java.rmi.NoSuchObjectException;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ylogo.pages.Login_Page_ylogo;
import com.ylogo.utilities.XLUtils_ylogo;

public class TC02_Login_ylogo_DDT extends BaseClass_ylogo

{
 
	@Test (dataProvider = "ylogo_DDT")
	public void login_ylogo_DDT(String user, String pwd) throws Exception
	{
		
	 Login_Page_ylogo yl = new Login_Page_ylogo(driver);
	 yl.setUsername(user);
	 yl.setpwd(pwd);
	 yl.submit();

	
//	if (IsErrorPresent()==true)
	 if (driver.getPageSource().contains("There is 1 error"))
	{
		
		logger.error("Login failed");
		Thread.sleep(5000);
		WebElement email = driver.findElement(By.name("email"));
		WebElement passwd= driver.findElement(By.name("passwd"));
		email.clear();
		passwd.clear();
		
	}
	else
	{
		
		logger.info("Login passed");
		Thread.sleep(3000);
		yl.logout();
		
	
	}
	
}
	


@DataProvider (name= "ylogo_DDT")
 String[][] getdata() throws Exception

{

      String path = "./"+ "\\src\\test\\java\\com\\ylogo\\testdata\\YLogo_DDT.xlsx";
      int rownum = XLUtils_ylogo.getrowcount(path, "Sheet1");
      int colnum =XLUtils_ylogo.getcellcount(path, "Sheet1", 1);
      String ylogo_DDT [][] = new String [rownum][colnum];
     
      for (int i=1; i<rownum; i++)
      {
      	for (int j=0; j<colnum; j++)
      	{
      		ylogo_DDT [i-1][j] = XLUtils_ylogo.getCellData(path, "Sheet1", i, j);
      		
      	}
      }
      	return ylogo_DDT;
      	
      }

}
         