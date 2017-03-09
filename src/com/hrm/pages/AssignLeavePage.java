package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.BasePage;

import generics.Utility;

public class AssignLeavePage extends BasePage{

	public AssignLeavePage(WebDriver driver) {
		super(driver);
		}

	@FindBy(xpath="(//img[@class='ui-datepicker-trigger'])[1]")
	private WebElement fromDate;
	
	@FindBy(id="//*[@id='ui-datepicker-div']/div/div/select[1]")
	private WebElement monthListBox;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a")
	private WebElement currentDate;
	
	@FindBy(id="assignleave_txtFromDate")
	private WebElement fromDateTextBox;
	
	public void getDate(){
		String actualDate = fromDateTextBox.getAttribute("value");
		log.error(actualDate);
		String expectedDate=Utility.getCurrentDate();
		log.error(expectedDate);
		if(expectedDate.equals(actualDate)){
			log.info("**** The Date is matches with current Date ****");
		}
		else{
			log.error("**** The Date is NOT matches with current Date ****");
		}
		
	}
	
	
	public void clickCurrentDate(){
		currentDate.click();;
		
	}
	public void clickFromDate(){
		fromDate.click();
		}
	
	}
