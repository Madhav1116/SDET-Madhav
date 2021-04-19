package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	@FindBy(xpath="//a[text()='Organizations']")
	private WebElement orglnk;
	
	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	private WebElement contactlnk;
	
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	@FindBy(xpath="(//a[text()='Leads'])[1]")
	private WebElement leadsLnk;

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
  
	public WebElement getLeadsLnk() {
		return leadsLnk;
	}

	public WebElement getOrglnk() {
		return orglnk;
	}
	public WebElement getContactlnk() {
		return contactlnk;
	}
	 
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
