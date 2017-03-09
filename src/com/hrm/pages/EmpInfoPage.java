package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class EmpInfoPage extends HomePage
{

	public EmpInfoPage(WebDriver driver) 
	{
		super(driver);
	}

	@FindBy(id="searchBtn")
	private WebElement searchBtn;
	
	@FindBy(id="ohrmList_chkSelectAll")
	private WebElement selectAllCheckBox;
	
	@FindBy(id="empsearch_job_title")
	private WebElement jobTitle;
	
	@FindBy(id="empsearch_termination")
	private WebElement empSearch;
	
	@FindBy(id="btnDelete")
	private WebElement delete;
	
	@FindBy(id="dialogDeleteBtn")
	private WebElement btnOK;
	
	@FindBy(xpath="//td[text()='No Records Found']")
	private WebElement noRecordFound;
	
	@FindBy(id="empsearch_id")
	private WebElement enterEmpID;
	
	@FindBy(xpath="//a[text()='emp001']")
	private WebElement empID;
	
	public void verifyEmpID(){
		verifyElementIsPresent(empID);
	}
	
	public void setEmpID(String empID){
		enterEmpID.sendKeys(empID);
	}
	
	public void verifySearchBtnPresent()
	{
		waitAndClick(searchBtn);
	}
	
	public void verifyJobTitleIsSorted()
	{
		log.info("Verify that the job title is sorted");
		verifyListBoxIsSorted(jobTitle, 1);
		log.info("Job Title is sorted");
	}
	
	public void verifyJobTitleHasNoDuplicate()
	{
		log.info("Verify the contents of Job Title List box has no duplicates");
		verifyListBoxHasNoDuplicate(jobTitle, 1);
		log.info("Job Title does not have any duplicate");
	}
	
	public void verifyEmployeeTerminationIsSorted()
	{
		log.info("Verify that the Employee Termination list is sorted");
		verifyListBoxIsSorted(empSearch, 0);
		log.info("Employee Termination list is sorted");
	}
	
	public void verifyEmployeeTerminationHasNoDuplicate()
	{
		log.info("Verify the contents of Employee Termination List box has no duplicates");
		verifyListBoxHasNoDuplicate(empSearch,0);
		log.info("Employee Termination list does not have any duplicate");
	}
	
	public void deleteEmployee(String empId)
	{
		String xpath = "//a[text()='"+empId+"']/../..//input[@type='checkbox']"; 
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickDelete()
	{
		delete.click();
	}
	
	public void clickOK()
	{
		btnOK.click();
	}
	public void verifyEmpNotPresent(String empID)
	{
		By loc = By.xpath("//a[text()='"+empID+"']");
		verifyElementIsNotPresent(loc);
	}
	
	
	
	public void selectAllCheckBox()
	{
		log.info("Selecting all Employees from checkbox");
		selectAllCheckBox.click();
		log.info("All Employees are selected");
	}
	
	public void allRecordDeleteConfirmation()
	{
		verifyElementIsPresent(noRecordFound);
	}	
	
}
