package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class SearchButtonVisibleTest extends BaseTest
{
	@Test
	public void searchButtonVisible()
	{
		DashboardPage db = new DashboardPage(driver);
		db.clickPIM_Menu();
		EmpInfoPage eip = new EmpInfoPage(driver);
		eip.verifySearchBtnPresent();
	}
}
