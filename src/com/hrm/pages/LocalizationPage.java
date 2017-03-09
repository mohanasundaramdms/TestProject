package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class LocalizationPage extends HomePage
{
	public LocalizationPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(xpath="//a[contains(text(),'Language and font')]")
	private WebElement languageLink;
	
	public void languageLinkClick()
	{
		languageLink.click();
	}
}
