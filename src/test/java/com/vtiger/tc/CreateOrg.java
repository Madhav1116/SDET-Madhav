package com.vtiger.tc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.generic.WebDriverUtility;
import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;
import com.vtiger.objectrepo.OrgPage;

public class CreateOrg extends BaseClass
{
	
	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	WebDriverUtility wdu= new WebDriverUtility();
	@Test
	public void createOrg() throws IOException, InterruptedException {
		int randomnumber=	jv.createRandomNumber();


		//Read data from property file
		String UN=fu.readDatafromPropFile(IConstants.propfilepath, "username");
		String PWD=fu.readDatafromPropFile(IConstants.propfilepath, "password");
		String URL=fu.readDatafromPropFile(IConstants.propfilepath, "url");

		//Read Test Script Data from Excel
		String name=eu.readDatafromExcel("Sheet1", 0, 0);
		String orgname=name+randomnumber;
		String phonenumber=eu.readDatafromExcel("Sheet1", 1, 0);
		String indDD=eu.readDatafromExcel("Sheet1", 2, 0);
		String ratingDD=eu.readDatafromExcel("Sheet1", 3, 0);
		String typeDD=eu.readDatafromExcel("Sheet1", 4, 0);

		//Name of org
		System.out.println(name+" "+orgname+" "+phonenumber+" "+indDD+" "+ratingDD+" "+typeDD);

		WebDriver driver = new ChromeDriver();
		wdu.maximizeWindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);
       
		LoginPage lg=new LoginPage(driver);
		lg.getUsername(UN);
		lg.getPassword(PWD);
		lg.getLogbtn();
		
		HomePage hp=new HomePage(driver);
		hp.getOrglnk();
		
		OrgPage op=new OrgPage(driver);
        op.getCreateorgbtn();
        
        CreateOrg co=new CreateOrg();
        co.get
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.id("phone")).sendKeys(phonenumber);

		WebElement industry=	driver.findElement(By.xpath("//select[@name='industry']"));
		wdu.selectDropDown(industry, indDD);

		WebElement rating= driver.findElement(By.xpath("//select[@name='rating']"));
		wdu.selectDropDown(rating, ratingDD);


		WebElement type=driver.findElement(By.xpath("//select[@name='accounttype']"));
		wdu.selectDropDown(type, typeDD);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		wdu.refresh(driver);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/Home.PNG']")).click();

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();

		WebElement searchbox=driver.findElement(By.xpath("//input[@name='search_text']"));

		wdu.elementisclickable(driver, searchbox);

		searchbox.sendKeys(orgname);

		WebElement orgnamedd=driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']"));
		wdu.selectDropDown(orgnamedd, "Organization Name");
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		WebElement actualorgname=driver.findElement(By.xpath(""
				+ "+));

		wdu.waitforElement(actualorgname);

		System.out.println(actualorgname.getText());

		boolean result=actualorgname.getText().contains(orgname);
 
		System.out.println(result);

	}

}
