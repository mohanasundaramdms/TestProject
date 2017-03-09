package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class VacanciesPage extends HomePage {

	public VacanciesPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//a[@class='toggle tiptip']")
	private WebElement vacanciesToggleTip;
	
	@FindBy(xpath="//a[@class='toggle tiptip activated']")
	private WebElement vacanciesToggleTipActive;
	
	@FindBy(xpath="//*[text()='Hide Options']")
	private WebElement hideOption;
	
	@FindBy(xpath="//*[text()='Expand for Options']")
	private WebElement expandOption;
	
	@FindBy(id="btnAdd")
	private WebElement btnAdd;
	
	@FindBy(id="menu_recruitment_viewCandidates")
	private WebElement candidates;
	
	public void candidates(){
		mouseHover(candidates);
	}
	
	public void addButton(){
		mouseHover(btnAdd);
	}
	
	public void expandOption(){
		waitAndClick(expandOption);
		verifyElementIsPresent(expandOption);
		log.info("Expand Option is Display");
	}
	public void clickVacancies(){
		vacanciesToggleTip.click();
	}
	
	public void hideOption(){
		verifyElementIsPresent(hideOption);
		log.info("Vacancies search filters are hidden");
		log.info("The Element search as Search are displayed");
	}
	
	public void vacanciesToggleTipActive(){
		mouseHover(vacanciesToggleTipActive);
	}
	
	public void clickvacanciesToggleTipActive(){
		vacanciesToggleTipActive.click();
	}
	
	public void vacanciesToggleTip(){
		mouseHover(vacanciesToggleTip);
	}

	
}
