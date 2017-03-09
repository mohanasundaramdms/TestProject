package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.BasePage;

public class CSVDataImportPage extends BasePage{

	@FindBy(id="pimCsvImport_csvFile")
	private WebElement clickFileToBrowse;
	
	@FindBy(id="btnSave")
	private WebElement clickUploadButton;
	
		
	public CSVDataImportPage(WebDriver driver) {
		super(driver);
		}

	public void clickToBrowse(){
		clickFileToBrowse.click();
	}
	
	public void clickToUploadFile(String FilePath)
	{
		uploadFile(FilePath);
	}
	
	public void clickToUpload()
	{
		clickUploadButton.click();
	}
}
