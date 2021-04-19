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
public class CreateLeadInvalidNoOfEmployees extends BaseClass
{
	JavaUtility jv = new JavaUtility();
	FileUtility fu=  new FileUtility();
	ExcelUtility eu= new ExcelUtility();
	@Test
	public void createLead()  throws IOException
	{
				
				String fName=eu.readDatafromExcel("Create Lead", 4, 0);
				String lName=eu.readDatafromExcel("Create Lead", 4, 1);
				String company=eu.readDatafromExcel("Create Lead", 4, 2);
				String noOfEmp=(eu.readDatafromExcel("Create Lead", 4, 4));
				
				HomePage hp=new HomePage(driver);
				hp.getLeadsLnk().click();
				
				CreateLeadPage cl=new CreateLeadPage(driver);
				cl.getCreateLeadbtn().click();
				cl.getFirstName().sendKeys(fName);
				cl.getLastName().sendKeys(lName);
				cl.getCompany().sendKeys(company);
				cl.getAnnualIncome().sendKeys(noOfEmp);
				cl.getSave().click();
	}
}


