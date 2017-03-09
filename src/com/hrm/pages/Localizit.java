package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.BasePage;

public class Localizit extends BasePage 
{
	public Localizit(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id="languageList")
	private WebElement languageList;
	
	public void languageListSort()
	{
		verifyListBoxIsSorted(languageList, 1);
	}
}
