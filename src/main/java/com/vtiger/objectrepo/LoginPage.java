package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath="//input[@name='user_name']")
	private WebElement username;

	@FindBy(xpath="//input[@name='user_password']")
	private WebElement password;

	@FindBy(id="submitButton")
	private WebElement logbtn;

	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void getUsername(String un)
	{
		 username.sendKeys(un);
		
	}
	public void getPassword(String pwd)
	{
	   password.sendKeys(pwd);
	}
	public void getLogbtn() 
	{
		 logbtn.click();
	}



}
