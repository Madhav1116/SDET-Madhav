package com.vtiger.objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateOrgPage 
{
  @FindBy(xpath="//input[@name='accountname']")
  private WebElement accountName;
  
  @FindBy(xpath="//select[@name='industry']")
  private WebElement industry;
  
  @FindBy(xpath="//select[@name='rating']")
  private WebElement rating;
  
  @FindBy(xpath="//select[@name='accounttype']")
  private WebElement accountType;
  
  @FindBy(xpath="//input[@title='Save [Alt+S]']")
  private WebElement save;
  @FindBy(xpath="//img[@src='themes/softed/images/Home.PNG']")
  private WebElement save_click;
  
  @FindBy(xpath="//a[text()='Organizations']")
  private WebElement organization;
  
  @FindBy(xpath="//input[@name='search_text']")
  private WebElement search;
  
  @FindBy(xpath="//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']")
  private WebElement OrgNo;
  
  @FindBy(xpath="//input[@name='submit']")
  private WebElement submit;
  
  @FindBy(xpath="//a[text()='"+orgname+"']/ancestor::table[@class='lvt small']")
  private WebElement actualOrgName;
  
  
  
}
