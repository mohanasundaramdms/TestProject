package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.base.PersonnelDetailsPage;
import com.hrm.pages.AddEmployeePage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class EmpAddDelete extends BaseTest 
{
	@Test
	public void testEmpAddDelete()
	{
		DashboardPage dp = new DashboardPage(driver);
		dp.clickPIM_Menu();
		
		EmpInfoPage eiPage = new EmpInfoPage(driver);
		eiPage.addEmployee_Menu();
		
		AddEmployeePage aePage = new AddEmployeePage(driver);
		aePage.enterFirstName("Mohan");
		aePage.enterLastName("Sundaram");
		aePage.clickSaveButton();
		
		PersonnelDetailsPage pdPage = new PersonnelDetailsPage(driver);
		pdPage.verifyFirstName("Mohan");
		String empId = pdPage.getEmpID();
		pdPage.clickEmpList_Menu();
		
		eiPage.deleteEmployee(empId);
		eiPage.clickDelete();
		eiPage.clickOK();
		eiPage.verifyEmpNotPresent(empId);
		
	}
}
