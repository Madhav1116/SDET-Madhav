package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage
{
	@FindBy(xpath="//img[@title='Create Lead...']")
	private WebElement createLeadbtn;
	
	@FindBy(xpath="//input[@name='firstname']")
	private WebElement firstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(xpath="//input[@name='company']")
	private WebElement company;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='secondaryemail']")
	private WebElement secondaryemail;
	
	public WebElement getEmail() {
		return email;
	}

	public WebElement getSecondaryemail() {
		return secondaryemail;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCompany() {
		return company;
	}

	@FindBy(xpath="//input[@name='annualrevenue']" )
	private WebElement annualIncome;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]" )
	private WebElement save;
	
	public WebElement getCreateLeadbtn() {
		return createLeadbtn;
	}

	public WebElement getAnnualIncome() {
		return annualIncome;
	}

	public WebElement getSave() {
		return save;
	}

	
	
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
