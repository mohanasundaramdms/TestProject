package com.hrm.base;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import generics.Utility;

public abstract class BasePage {
  public Logger log=Logger.getLogger(this.getClass());
  public long timeout=Long.parseLong(Utility.getPropertyValue(AutomationConstants.CONFIG_PATH, "EXPLICIT"));
  public WebDriver driver;
  public WebDriverWait wait;
 
  public BasePage(WebDriver driver){
	  this.driver=driver;
	  PageFactory.initElements(driver,this);
	  wait = new WebDriverWait(driver, timeout);
  }
  
  public void verifyElementIsPresent(WebElement element)
  {
	  log.info("Verify Element is present");
	  boolean status = Utility.verifyElementIsPresent(driver, element);
	  Assert.assertTrue(status,"Element is not present");
	  log.info("Element found in the page");
  }
  
  
  public void uploadFile(String FilePath){
	  Utility.getFileToUpload(FilePath);
  }
  
  public void mouseHoverAndClick(WebElement toElement){
	  Utility.mouseHoverAction(driver, toElement);
  }
  
  public void mouseHover(WebElement toElement)
  {
	  Utility.mouseHover(driver, toElement);
  }
  public void verifyURLhas(String expectedUrl)
  {
	  wait.until(ExpectedConditions.urlContains(expectedUrl));
  }
  
  public void waitAndClick(WebElement element)
  {
	  wait.until(ExpectedConditions.elementToBeClickable(element));
	  element.click();
  }
  
  public void verifyListBoxIsSorted(WebElement listbox, int i)
  {
	  listbox.click();
	  ArrayList<String> list = Utility.getAllTextFromListBox(listbox, i);
	  boolean sorted = Utility.checkArrayListIsSorted(list);
	  Assert.assertTrue(sorted, "ListBox is not sorted");
  }
  
  public void verifyAddedListBoxIsSorted(WebElement listbox, int i){
	  listbox.click();
	  ArrayList<String> list=Utility.getAllTextFromListBox(listbox, i);
	  boolean sorted = Utility.checkArrayListHasDuplicateInDay(list);
	  Assert.assertTrue(sorted, "ListBox is not Sorted");
  }
  
  public void verifyListBoxHasNoDuplicate(WebElement listbox, int i)
  {
	  listbox.click();
	  ArrayList<String> list = Utility.getAllTextFromListBox(listbox, i);
	  boolean duplicate = Utility.checkArrayListHasDuplicate(list);
	  Assert.assertFalse(duplicate,"ListBox has duplicate values");
  }
 
  public void verifyElementIsNotPresent(By locator)
  {
	  try
	  {
		  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		  Assert.fail();
	  }
	  catch (Exception e)
	  {
		  log.info("Element is Not Present");
	  }
  }
  
  public void verifyElementIsNotPresent(WebElement element)
  {
	  try
	  {
		  wait.until(ExpectedConditions.visibilityOf(element));
		  Assert.fail();
	  }
	  catch (Exception e)
	  {
		  log.info("Element is Not Present");
	  }
  }
}
