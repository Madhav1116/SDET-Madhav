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
			String UN=fu.readDatafrompropfile(IConstants.propfilepath, "username");
			String PWD=fu.readDatafrompropfile(IConstants.propfilepath, "password");
			String URL=fu.readDatafrompropfile(IConstants.propfilepath, "url");
			
			WebDriver driver = new ChromeDriver();
			wdu.maximizewindow(driver);
			driver.get(URL);
			wdu.implicitwait(driver);
			
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();

			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

			Select title = new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
			title.selectByVisibleText("Mr.");

			driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Smith");
			driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Tylor");

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		}


		
	}

