package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.DefineTimesheetPeriod;

public class FirstDayOfWeekListBox extends BaseTest{
	
	@Test
	public void testFirstDayOfWeekListBox(){
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.click_Time_Menu();
		
		DefineTimesheetPeriod dtpPage=new DefineTimesheetPeriod(driver);
		dtpPage.firstDayOfWeekListBox();
	}
}
