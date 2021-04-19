package com.vtiger.tc;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;
public class Create_Contact {

		JavaUtility jv = new JavaUtility();
		FileUtility fu=  new FileUtility();
		ExcelUtility eu= new ExcelUtility();
		WebDriverUtility wdu= new WebDriverUtility();
		@Test
		public void createCon() throws IOException, InterruptedException
		{
			//Read data from property file
			String UN=fu.readDatafromPropFile(IConstants.propfilepath, "username");
			String PWD=fu.readDatafromPropFile(IConstants.propfilepath, "password");
			String URL=fu.readDatafromPropFile(IConstants.propfilepath, "url");
			
			WebDriver driver = new ChromeDriver();
			wdu.maximizeWindow(driver);
			driver.get(URL);
			wdu.implicitwait(driver);

			Select title = new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
			title.selectByVisibleText("Mr.");

			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Lee");

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		}


		
	}

