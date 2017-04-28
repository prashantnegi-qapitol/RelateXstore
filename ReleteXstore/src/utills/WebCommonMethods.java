package utills;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class WebCommonMethods {
	public WebDriver driver;	
	public static WebDriverWait wait;
	
	//Constructor to initialize driver 
	public WebCommonMethods(WebDriver driver){
		this.driver=driver;
		wait = new WebDriverWait(driver, Integer.parseInt(FilesAndFolders.getPropValue("explicitWaitTime")));
	}
	
	//Take Screenshot on failure and save in "failure_screenshots" folder
	public  void screenshot(String methodName) throws Exception 
	{
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");                   
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String screenshotLocationWeb = FilesAndFolders.getPropValue("screenshotLocationWeb");
		try {
			FileUtils.copyFile(scrFile, new
					File((screenshotLocationWeb + methodName + "_" + formater.format(calendar.getTime())+".png")));
			Reporter.log("<a href='" +
					screenshotLocationWeb + methodName + "_" + formater.format(calendar.getTime()) + ".png'> <imgsrc='" + screenshotLocationWeb + methodName + "_" + formater.format(calendar.getTime()) + ".png' /> </a>");
			Reporter.setCurrentTestResult(null);
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	//Maximize window
	public void maximizeWindow(){
		driver.manage().window().maximize();
	}
	
	//Get Alert Text
	public  String getAlertText(){
		return driver.switchTo().alert().getText();
	}
	
	//Accept Alert
	public  void acceptAlert(){
		driver.switchTo().alert().accept();
	}

	//Dismiss Alert
	public  void dismissAlert(){
		driver.switchTo().alert().dismiss();
	}

	
	//Close all browser
	public  void quit(){
		driver.quit(); 
	}
	
	//Close current browser
	public  void close(){
		driver.close();
	}
	
	/*
	 * Wait Methods
	 */
	
	//Wait for page to load
	public void implicitWait(){
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(FilesAndFolders.getPropValue("implicitWaitTime")), TimeUnit.SECONDS);
	}

	//Wait for element to be clickable
	public void waitForElementToBeClickable(WebElement webElement){
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	public void waitForElementToBeClickable(By locator){
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	//Wait for element to be selected
	public void elementToBeSelected(WebElement webElement){
		wait.until(ExpectedConditions.elementToBeSelected(webElement));
	}
	
	public void elementToBeSelected(By locator){
		wait.until(ExpectedConditions.elementToBeSelected(locator));
	}
	
	//Wait for visibility of Web Element in the page
	public  void waitForVisibilityOfWebElement(WebElement webElement){
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	public  void waitForVisibilityOfWebElement(By locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Wait for invisibility of Web Element in the page
	public  void waitForInvisibilityOfWebElement(By locator){
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitForInvisibilityOfWebElement(By locator, String text){
		wait.until(ExpectedConditions.invisibilityOfElementWithText(locator, text));
	}
	
	//Wait for visibility of all Web Elements in the page
	public void waitForVisibilityOfAllWebElements(List<WebElement> webElement){
		wait.until(ExpectedConditions.visibilityOfAllElements(webElement));
	}
	
	public  void waitForVisibilityOfAllWebElements(By locator){
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	//Wait for text to be present in the Web Element
	public void waitForTextToBePresentInWebElement(WebElement webElement, String text){
		wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));
	}
	
	//Wait for number of windows to be
	public  void waitForNumberOfWindowsToBe(int numberOfWindows){
		wait.until(ExpectedConditions.numberOfWindowsToBe(numberOfWindows));
	}
	
	//Wait for element to be located
	public void waitForPresenceOfElementToBeLocated(By locator){
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
