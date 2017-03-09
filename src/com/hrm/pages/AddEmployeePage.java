package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class AddEmployeePage extends HomePage
{
	@FindBy(id="firstName")
	private WebElement firstName;
	
	@FindBy(id="lastName")
	private WebElement lastName;
	
	@FindBy(id="btnSave")
	private WebElement btnSave;
	
	public AddEmployeePage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void enterFirstName(String name)
	{
		firstName.sendKeys(name);
	}
	
	public void enterLastName(String name)
	{
		lastName.sendKeys(name);
	}
	
	public void clickSaveButton()
	{
		btnSave.click();
	}
	
}
