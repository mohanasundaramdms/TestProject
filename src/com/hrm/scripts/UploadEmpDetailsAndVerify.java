package com.hrm.scripts;

import org.testng.annotations.Test;

import com.hrm.base.BaseTest;
import com.hrm.pages.CSVDataImportPage;
import com.hrm.pages.DashboardPage;
import com.hrm.pages.EmpInfoPage;

public class UploadEmpDetailsAndVerify extends BaseTest{

	@Test
	public void testUploadEmpDetailsAndVerify(){
		DashboardPage dbPage=new DashboardPage(driver);
		dbPage.clickPIM_Menu();
		
		EmpInfoPage eiPage=new EmpInfoPage(driver);
		eiPage.pim_Configuration();
		eiPage.clickDataInput_Menu();
		
		CSVDataImportPage csvPage=new CSVDataImportPage(driver);
		log.info("Click Upload");
		csvPage.clickToBrowse();
		log.info("Send Path");
		csvPage.clickToUploadFile("D:\\importData.csv");
		csvPage.clickToUpload();
		
		eiPage.clickPIM_Menu();
		
		eiPage.setEmpID("emp001");
		eiPage.verifySearchBtnPresent();
		
		eiPage.verifyEmpID();
		
		
	}
}
