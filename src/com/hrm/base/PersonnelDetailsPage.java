package com.hrm.base;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonnelDetailsPage extends HomePage 
{

	@FindBy(id="personal_txtEmpFirstName")
	private WebElement firstName;
	
	@FindBy(id="personal_txtEmployeeId")
	private WebElement empID;
	
	public PersonnelDetailsPage(WebDriver driver) 
	{
		super(driver);
	}
	
	public void verifyFirstName(String name)
	{
		String fname = firstName.getAttribute("value");
		Assert.assertEquals(name, fname);
		
		/*if(firstName.getText() == name)
		{
			return empID.getText();
		}
		else
		{
			Assert.fail("Employee is not created");
			return null;
		}*/
	}
	
	public String getEmpID()
	{
		return empID.getAttribute("value");
	}

}
