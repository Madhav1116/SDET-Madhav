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
public class CreateLeadValidEmails extends BaseClass
{
	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	@Test
	public void createLead()  throws IOException
	{
				
				String fName=eu.readDatafromExcel("Create Lead", 5, 0);
				String lName=eu.readDatafromExcel("Create Lead", 5, 1);
				String company=eu.readDatafromExcel("Create Lead", 5, 2);
				String email=(eu.readDatafromExcel("Create Lead", 5, 5));
				String secondaryEmail=(eu.readDatafromExcel("Create Lead", 5, 6));
				HomePage hp=new HomePage(driver);
				hp.getLeadsLnk().click();
				
				CreateLeadPage cl=new CreateLeadPage(driver);
				cl.getCreateLeadbtn().click();
				cl.getFirstName().sendKeys(fName);
				cl.getLastName().sendKeys(lName);
				cl.getCompany().sendKeys(company);
				cl.getEmail().sendKeys(email);
				cl.getSecondaryemail().sendKeys(secondaryEmail);
				cl.getSave().click();
	}
}



