package com.hrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import generics.Utility;

public abstract class HomePage extends BasePage{

	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcome;
	
	@FindBy(id="menu_pim_viewPimModule")
	private WebElement pim_Menu;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy(id="menu_pim_addEmployee")
	private WebElement addEmployee;

	@FindBy(id="menu_pim_viewEmployeeList")
	private WebElement empList_Menu;
	
	@FindBy(xpath="//b[text()='Admin']")
	private WebElement admin_Menu;
	
	@FindBy(id="menu_admin_Configuration")
	private WebElement configuration_Menu;
	
	@FindBy(id="menu_admin_localization")
	private WebElement local_Menu;
	
	@FindBy(id="menu_pim_Configuration")
	private WebElement pim_Configuration;
	
	@FindBy(id="menu_admin_pimCsvImport")
	private WebElement clickDataInput;
	
	@FindBy(id="menu_admin_UserManagement")
	private WebElement userManagement;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	private WebElement users;
	
	@FindBy(xpath="//b[text()='Leave']")
	private WebElement leaveMenu;
	
	@FindBy(id="menu_leave_assignLeave")
	private WebElement assignLeaveMenu;
	
	@FindBy(xpath="//b[text()='Recruitment']")
	private WebElement recruitmentMenu;
	
	@FindBy(id="menu_recruitment_viewJobVacancy")
	private WebElement vacanciesMenu;
	
	@FindBy(xpath="//b[text()='Time']")
	private WebElement time_Menu;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void click_Time_Menu(){
		time_Menu.click();
	}
	
	public void vacancies_Menu(){
		vacanciesMenu.click();
	}
	
	public void recruitment_Menu(){
		recruitmentMenu.click();
	}
	
	public void clickAssignLeaveMenu(){
		assignLeaveMenu.click();
	}
	
	public void clickUsers(){
		waitAndClick(users);
	}
	
	public void clickLeaveMenu(){
		leaveMenu.click();
	}
	
	public void userManagement_Menu(){
		mouseHoverAndClick(userManagement);
	}
	
	public void logout()
	{
		//code using selenium for clicking welcome
		waitAndClick(welcome);
		//code using javascript for clicking welcome
		//Utility.clickUsingJS(driver, welcome);
		waitAndClick(logout);
	}
		
	public void clickDataInput_Menu(){
		waitAndClick(clickDataInput);
	}
		
	public void admin_Config_Menu()
	{
		mouseHoverAndClick(configuration_Menu);
	}
	
	public void pim_Configuration(){
		mouseHoverAndClick(pim_Configuration);
	}
	
	public void local_Menu()
	{
		Reporter.log("Trying to click localization menu", true);
		local_Menu.click();
		Reporter.log("Localization menu clicked", true);
	}
	
	public void addEmployee_Menu()
	{
		addEmployee.click();
	}
	
	public void admin_Menu()
	{
		admin_Menu.click();
	}
	
	public void clickEmpList_Menu()
	{
		empList_Menu.click();
	}
	
	public void clickPIM_Menu()
	{
		pim_Menu.click();
	}
}
