package generics;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class Utility{
	
	public static String getFormatedDateTime(){
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return simpleDate.format(new Date());
	}
	
	public static String getCurrentDate(){
		//String s=" ";
		SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");
		return simpleDate.format(new Date());
	}
	
	//This is coment line

	public static void getFileToUpload(String FilePath){
		Robot robot;
		try {
			robot = new Robot();
		
		robot.setAutoDelay(5000);
		StringSelection stringSlection=new StringSelection(FilePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSlection, null);
		
		robot.setAutoDelay(1000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.setAutoDelay(1000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			
			e.printStackTrace();
		}
	}
	
	public static String getScreenShot(WebDriver driver, String imageFolderPath){
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		TakesScreenshot page=(TakesScreenshot) driver;
		try{
			FileUtils.copyFile(page.getScreenshotAs(OutputType.FILE), new File(imagePath));
		}catch(Exception e){
			
		}
		return imagePath;
		
	}
	
	public static void mouseHoverAction(WebDriver driver, WebElement toElement){
		Actions action=new Actions(driver);
		action.moveToElement(toElement).click().perform();
	}
	
	public static void mouseHover(WebDriver driver, WebElement toElement){
		Actions action=new Actions(driver);
		action.moveToElement(toElement).perform();
	}
	
	public static String getScreenShot(String imageFolderPath){
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		
		try{
			Dimension desktopSize=Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(desktopSize));
			ImageIO.write(image, "png", new File(imagePath));
		}
		catch(Exception e){
		}

		return imagePath;
		
	}
	public static String getPropertyValue(String filePath,String key)
	{
		String value="";
		Properties ppt=new Properties();
		try{
			ppt.load(new FileInputStream(filePath));
			value=ppt.getProperty(key);
		}
		catch(Exception e){
		}
		return value;
	}
	public static int getExcelRowCount(String path,String sheet)
	{
		int r=0;
		try{
			
			r=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	
	public static String getExcelCellValue(String path,String sheet,int r,int c)
	{
		String v="";
		try{
			
			v=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
	
	public static boolean checkArrayListIsSorted(ArrayList<String> al)
	{
		ArrayList<String> clone = new ArrayList<String>(al);
		Collections.sort(clone,String.CASE_INSENSITIVE_ORDER);
		System.out.println("-------------------------------------");
		for(int i=0; i<clone.size(); i++)
		{
			System.out.println(al.get(i)+"==="+clone.get(i));
		}
		System.out.println("-------------------------------------");
		return (al.equals(clone));
	}
	
	public static ArrayList<String> getAllTextFromListBox(WebElement listBox, int index)
	{
		Select select = new Select(listBox);
		List<WebElement> allOptions = select.getOptions();
		ArrayList<String> al = new ArrayList<>();
		for (int i =index; i< allOptions.size(); i++)
		{
			String element = allOptions.get(i).getText();
			al.add(element);
		}
		return al;
	}
	
	public static boolean checkArrayListHasDuplicateInDay(ArrayList<String> al){
		ArrayList<String> addDays=new ArrayList<String>(al);
		
		addDays.add("Monday");
		addDays.add("Tuesday");
		addDays.add("Wednesday");
		addDays.add("Thursday");
		addDays.add("Friday");
		addDays.add("Saturday");
		addDays.add("Sunday");
		
		
		for(int i=0; i<=addDays.size(); i++)
		{
			System.out.println(al.get(i)+"==="+addDays.get(i));
		}
		System.out.println("-------------------------------------");
		return (al.equals(addDays));
		
		
	}
	//The below method returns true if duplicate is present else if no duplicate is not available it returns false
	public static boolean checkArrayListHasDuplicate(ArrayList<String> al)
	{
		HashSet<String> clone = new HashSet<String>(al);
		System.out.println(clone.size());
		System.out.println(al.size());
		
		HashSet<String> clone1 = new HashSet<String>();
		for (String s : al)
		{
			boolean v = clone1.add(s);
			if (v == false)
			{
				System.out.println("Duplicate Value: "+ s);
				return true;
			}
			else
			{
				System.out.println("Not Duplicate: "+ s);
			}
		}
		return false;
	}
	
	public static void clickUsingJS(WebDriver driver, WebElement e)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click()", e);
	}
	
	public static void enterkUsingJS(WebDriver driver, WebElement e, String s)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].value=arguments[1]", e, s);
	}
	
	public static boolean switchBrowser(WebDriver driver, String eTitle)
	{
		
		String currentWH = "";
		try
		{
			currentWH = driver.getWindowHandle();
		}
		catch (Exception e)
		{
			Reporter.log("Current Window not found", true);
		}
		Set<String> allWH = driver.getWindowHandles();
		for (String wh : allWH)
		{
			String title = driver.switchTo().window(wh).getTitle();
			if(title.equals(eTitle))
			{
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentWH);
		return false;
	}
	
	public static boolean switchBrowser(String eURL, WebDriver driver)
	{
		
		String currentURL = "";
		try{
		currentURL = driver.getWindowHandle();
		}
		catch(Exception e){
			currentURL=driver.getWindowHandles().iterator().next();
			Reporter.log("Current URL not found or window closed", true);
		}
		Set<String> allWH = driver.getWindowHandles();
		for (String wh : allWH)
		{
			String url = driver.switchTo().window(wh).getCurrentUrl();
			if(url.contains(eURL))
			{
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentURL);
		return false;
	}
	
	public static boolean verifyElementIsPresent(WebDriver driver, WebElement element)
	  {
		  try
		  {
			  WebDriverWait wait = new WebDriverWait(driver, 5);
			  wait.until(ExpectedConditions.visibilityOf(element));
			  return true;
		  }
		  catch (Exception e)
		  {
			  Assert.fail();
			  return false;
		  }
		  
	  }
	
	public static boolean switchBrowser(WebElement element, WebDriver driver)
	{
		String currentURL = "";
		try
		{
			currentURL=driver.getWindowHandle();
		}
		catch (Exception e)
		{
			Reporter.log("Current URL not found or current browser is closed", true);
		}
		Set<String> allWH = driver.getWindowHandles();
		for (String wh : allWH)
		{
			driver.switchTo().window(wh);
			if(verifyElementIsPresent(driver, element))
			{
				System.out.println("Browser Found");
				return true;
			}
		}
		driver.switchTo().window(currentURL);
		return false;
	}
}