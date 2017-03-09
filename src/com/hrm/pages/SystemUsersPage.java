package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class SystemUsersPage extends HomePage {

	public SystemUsersPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(id="btnAdd")
	private WebElement addButton;
	
	public void clickAddButton(){
		addButton.click();
	}

}
