package com.hrm.scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.LocalizationPage;
import com.hrm.pages.Localizit;

import generics.Utility;

public class LanguageAndFontHelpTest extends BaseTest
{
	@Test
	public void languageAndFontHelpTest() throws InterruptedException
	{
		DashboardPage dp = new DashboardPage(driver);
		dp.admin_Menu();
		dp.admin_Config_Menu();
		dp.local_Menu();
		
		LocalizationPage lp = new LocalizationPage(driver);
		lp.languageLinkClick();
		
		Utility.switchBrowser("http://localizit.orangehrm.com/index.php", driver);
		
		Localizit local = new Localizit(driver);
		local.languageListSort();
		Reporter.log("Closing child browser", true);
		driver.close();
		Reporter.log("Child browser closed", true);
		Utility.switchBrowser("orangehrm", driver);
	}
}
