package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class JobTitleSortDuplicateTest extends BaseTest
{
	@Test
	public void jobTitleSort()
	{
		DashboardPage dp = new DashboardPage(driver);
		dp.clickPIM_Menu();
		EmpInfoPage eip = new EmpInfoPage(driver);
		eip.verifyJobTitleIsSorted();
		eip.verifyJobTitleHasNoDuplicate();
	}
}
