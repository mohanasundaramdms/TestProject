package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class EmployeeTerminationListTest extends BaseTest 
{
	@Test
	public void employeeTerminationList()
	{
		DashboardPage dp = new DashboardPage(driver);
		dp.clickPIM_Menu();
		EmpInfoPage eip = new EmpInfoPage(driver);
		eip.verifyEmployeeTerminationIsSorted();
		eip.verifyEmployeeTerminationHasNoDuplicate();
	}
}
