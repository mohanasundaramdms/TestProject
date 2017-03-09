package com.hrm.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hrm.base.HomePage;

public class AddUserPage extends HomePage{

	public AddUserPage(WebDriver driver) {
		super(driver);
		}
	
	@FindBy(id="systemUser_employeeName_empName")
	private WebElement empNameTextBox;
	
	@FindBy(xpath="//div[@class='ac_results']")
	private List<WebElement> autoSuggestion;
	
	@FindBy(id="systemUser_userName")
	private WebElement userNameTextBox;
	
	@FindBy(id="systemUser_password")
	private WebElement passwordTextBox;
	
	@FindBy(id="systemUser_confirmPassword")
	private WebElement cPassword;
	
	@FindBy(id="btnSave")
	private WebElement btnSave;
	
	
	public void clickSave(){
		btnSave.click();
	}
	
	public void confirmPassword(String pw){
		
		cPassword.sendKeys(pw);
		//cPassword.sendKeys(Keys.CONTROL+"v");
		
	}
	
	public void password(String pw){
		passwordTextBox.clear();
		passwordTextBox.sendKeys(pw);
	}
	
	public void setUserName(String un){
		userNameTextBox.clear();
		userNameTextBox.sendKeys(un);
//		userNameTextBox.sendKeys(Keys.CONTROL+"a"+Keys.CONTROL+"c");
//		userNameTextBox.clear();
//		userNameTextBox.sendKeys("User");
	}
	
	public void autoSuggestion(){
		int count=autoSuggestion.size();
		log.info("The auto suggestion list count:"+count);
		for(int i=0; i<count; i++){
			String text=autoSuggestion.get(i).getText();
			log.info(text);
		}
		autoSuggestion.get(count-1).click();
		
	}
	
	public void setEmpName(String en){
		empNameTextBox.sendKeys(en);
	}

}
