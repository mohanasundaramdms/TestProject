//Using Excel to get FirstName and LastName and create employee

package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AddEmployeePage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

import generics.Utility;

public class CreateDeleteMultipleEmployee extends BaseTest
{
	@Test
	public void testEmpAddDelete()
	{
		DashboardPage dp = new DashboardPage(driver);
		dp.clickPIM_Menu();
		
		EmpInfoPage eiPage = new EmpInfoPage(driver);
		AddEmployeePage aePage = new AddEmployeePage(driver);
		
		int x = Utility.getExcelRowCount(INPUT_PATH, "AddEmp");
		for (int i=0; i<x; i++)
		{
			eiPage.addEmployee_Menu();
			
			
			String fn = Utility.getExcelCellValue(INPUT_PATH, "AddEmp", i+1, 0);
			String ln = Utility.getExcelCellValue(INPUT_PATH, "AddEmp", i+1, 1);
			aePage.enterFirstName(fn);
			aePage.enterLastName(ln);
			aePage.clickSaveButton();
			
		}
		
		aePage.clickEmpList_Menu();
		eiPage.selectAllCheckBox();
		eiPage.clickDelete();
		eiPage.clickOK();
		eiPage.allRecordDeleteConfirmation();
	}
}
