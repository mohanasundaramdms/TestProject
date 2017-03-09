package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class DefineTimesheetPeriod extends HomePage{

	public DefineTimesheetPeriod(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(id="time_startingDays")
	private WebElement firstDayOfWeek;
	
	public void firstDayOfWeekListBox(){
		verifyAddedListBoxIsSorted(firstDayOfWeek, 1);
	}

}
