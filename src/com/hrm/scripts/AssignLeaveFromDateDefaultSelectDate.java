package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AssignLeavePage;
import com.hrm.pages.DashboardPage;

public class AssignLeaveFromDateDefaultSelectDate extends BaseTest{

	@Test
	public void testAssignLeaveFromDateDefaultSelectDate(){
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickLeaveMenu();
		dbPage.clickAssignLeaveMenu();
		
		AssignLeavePage alPage=new AssignLeavePage(driver);
		alPage.clickFromDate();
		alPage.clickCurrentDate();
		alPage.getDate();
		
		
	}
}
