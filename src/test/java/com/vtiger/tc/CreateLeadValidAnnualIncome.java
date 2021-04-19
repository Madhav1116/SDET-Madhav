package com.vtiger.tc;

import java.io.IOException;

import org.testng.annotations.Test;

import com.vtiger.generic.ExcelUtility;
import com.vtiger.generic.FileUtility;
import com.vtiger.generic.IConstants;
import com.vtiger.generic.JavaUtility;
import com.vtiger.objectrepo.CreateLeadPage;
import com.vtiger.objectrepo.HomePage;
import com.vtiger.generic.*;
public class CreateLeadValidAnnualIncome extends BaseClass
{
	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	@Test
	public void createLead()  throws IOException
	{
		
		//Read data from property file
				String UN=fu.readDatafromPropFile(IConstants.propfilepath, "username");
				String PWD=fu.readDatafromPropFile(IConstants.propfilepath, "password");
				String URL=fu.readDatafromPropFile(IConstants.propfilepath, "url");
				
				String fName=eu.readDatafromExcel("Create Lead", 1, 0);
				String lName=eu.readDatafromExcel("Create Lead", 1, 1);
				String company=eu.readDatafromExcel("Create Lead", 1, 2);
				//String annualIncome=(eu.readDatafromExcel("Create Lead", 1, 3));
				
				HomePage hp=new HomePage(driver);
				hp.getLeadsLnk().click();
				
				CreateLeadPage cl=new CreateLeadPage(driver);
				cl.getCreateLeadbtn().click();
				cl.getFirstName().sendKeys(fName);
				cl.getLastName().sendKeys(lName);
				cl.getCompany().sendKeys(company);
				cl.getAnnualIncome().sendKeys("2");
				cl.getSave().click();
				 
				
				
				
	}
	

}
