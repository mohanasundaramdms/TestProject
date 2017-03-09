package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.AddUserPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.SystemUsersPage;

public class AddEmpInSystemUserAndVerify extends BaseTest{

	@Test
	public void testAddEmpInSystemUserAndVerify() throws InterruptedException{
		
		DashboardPage dbPage=new DashboardPage(driver);
		
		dbPage.admin_Menu();
		
		dbPage.userManagement_Menu();
		
		dbPage.clickUsers();
		
		SystemUsersPage suPage=new SystemUsersPage(driver);
		
		suPage.clickAddButton();
		
		AddUserPage auPage=new AddUserPage(driver);
		auPage.setEmpName("m");
		auPage.autoSuggestion();
		auPage.setUserName("admin121");
		auPage.password("admin");
		auPage.confirmPassword("admin");
		auPage.clickSave();
		Thread.sleep(2000);
		
		
		
		
		
	}
}
