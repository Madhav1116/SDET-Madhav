package com.vtiger.tc;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
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
import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;
public class CreateCOntact_Org {

	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	WebDriverUtility wdu= new WebDriverUtility();
	@Test
	public void createcontact() throws IOException, InterruptedException {

		String UN=fu.readDatafromPropFile(IConstants.propfilepath, "username");
		String PWD=fu.readDatafromPropFile(IConstants.propfilepath, "password");
		String URL=fu.readDatafromPropFile(IConstants.propfilepath, "url");


		WebDriver driver = new ChromeDriver();
		wdu.maximizeWindow(driver);
		driver.get(URL);
		wdu.implicitwait(driver);

		LoginPage lg=new LoginPage(driver);
		lg.getUsername(UN);
		lg.getPassword(PWD);
		lg.getLogbtn();
		
		HomePage hp=new HomePage(driver);
		hp.getContactlnk();
		
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("C P");

		driver.findElement(By.xpath("//input[@name='account_name']//following-sibling::img")).click();

		String parent = driver.getWindowHandle();
		Set<String> child = driver.getWindowHandles();
		Iterator<String> childWin = child.iterator();

		while(childWin.hasNext())
		{
			String childWindow = childWin.next();
			if(!parent.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
				driver.findElement(By.id("search_txt")).sendKeys("TCS");
				driver.findElement(By.xpath("//input[@name='search']")).click();
				Thread.sleep(3000);
				driver.findElement(By.xpath("//a[@id='1']")).click();
			}
		}

		driver.switchTo().window(parent) ;
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();


	}

}


