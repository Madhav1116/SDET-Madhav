package com.vtiger.generic;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectrepo.HomePage;
import com.vtiger.objectrepo.LoginPage;

public class BaseClass
{
	protected WebDriver driver;
	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	WebDriverUtility wdu= new WebDriverUtility();
	/**
	 * Create DB Connection
	 * and extent report
	 */
	@BeforeSuite
	public void beforeSuite()
	{
		Reporter.log("==DB connection==",true);
		Reporter.log("==Extent report==",true);
	}
	@AfterSuite
	public void afterSuite()
	{
		Reporter.log("==DB closed==",true);
		Reporter.log("==close Extent report==",true);
	}
	/**
	 * Launch the browser
	 * throws IO exception
	 */
	@BeforeClass
	public void launchBrowser() throws IOException {

		String BROWSER=fu.readDatafromPropFile(IConstants.propfilepath, "browser");

		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("ie")) {
			driver= new InternetExplorerDriver();
		}
		wdu.maximizeWindow(driver);
		wdu.implicitwait(driver);
		driver.get(fu.readDatafromPropFile(IConstants.propfilepath, "url"));
	}
	//@AfterClass
	//public void closeBrowser()
	//{
	//	driver.quit();
	//}
	@BeforeMethod
	public void logInApp() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.getUsername(fu.readDatafromPropFile(IConstants.propfilepath, "username"));
		lp.getPassword(fu.readDatafromPropFile(IConstants.propfilepath, "password"));
		lp.getLogbtn();
	}
	@AfterMethod
	public void logOutApp()
	{
		HomePage hp=new HomePage(driver);
		hp.getSignOutLnk();
	}
}
