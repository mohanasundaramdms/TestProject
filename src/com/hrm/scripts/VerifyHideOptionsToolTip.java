package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.VacanciesPage;

public class VerifyHideOptionsToolTip extends BaseTest {

	@Test
	public void testVerifyHideOptionsToolTip() throws InterruptedException{
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.recruitment_Menu();
		dbPage.vacancies_Menu();
		
		VacanciesPage vPage=new VacanciesPage(driver);
		vPage.vacanciesToggleTip();
		vPage.hideOption();
		vPage.clickVacancies();
		vPage.candidates();
		Thread.sleep(2000);
		vPage.vacanciesToggleTipActive();
		vPage.expandOption();
		
		vPage.clickvacanciesToggleTipActive();
		vPage.candidates();
		Thread.sleep(2000);
		vPage.vacanciesToggleTip();
		vPage.hideOption();
		
		
	}
}
