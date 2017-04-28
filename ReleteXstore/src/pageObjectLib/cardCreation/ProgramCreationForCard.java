package pageObjectLib.cardCreation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.WebCommonMethods;

public class ProgramCreationForCard {

	WebDriver driver;
	WebCommonMethods wcm;
	public ProgramCreationForCard(WebDriver driver) {
		this.driver=driver;
		wcm=PageFactory.initElements(driver, WebCommonMethods.class);
	}

	@FindBy(xpath=".//*[@id='main']//a[contains(text(),'click here.')]")
	public WebElement clickHereLink;

	@FindBy(xpath=".//*[@id='main']//div/div[3]/div/div[3]/div/div[2]/div/table/tbody/tr[3]/td[1]/span")
	public WebElement loyalityCardRadioButton;

	@FindBy(xpath=".//a[contains(text(),'next')]")
	public WebElement nextButton;

	@FindBy(xpath=".//a[contains(text(),'save')]")
	public WebElement saveButton;

	@FindBy(xpath=".//*[@id='main']//div/div[3]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/input")
	public WebElement programNameField;

	@FindBy(xpath=".//*[@id='main']//div/div[3]/div/div[2]/div/div[2]/table/tbody/tr[1]/td[2]/input")
	public WebElement programDescriptionField;

	@FindBy(xpath=".//*[@id='main']//div[3]/div/div[2]/div/div[2]/table/tbody/tr[3]/td[2]/input")
	public WebElement startDate;

	@FindBy(xpath="html/body/div[4]/div/table/tbody/tr[2]/td/table/tbody/tr[6]/td[4]/div")
	public WebElement dateFromCaender;

	@FindBy(xpath=".//*[@id='main']//div/div[3]/div/div[3]/div/div[2]/div/div[2]/table/tbody/tr[4]/td[2]/span")
	public WebElement disableEndDate;

	@FindBy(xpath=".//*[@id='main']//div/div[3]/div/div[2]/div/div[2]/table/tbody/tr[5]/td[2]/input")
	public WebElement endDate;

	@FindBy(xpath=".//*[@id='main']//div[2]/div/div[2]/table/tbody/tr[6]/td[2]/select")
	public WebElement activeDropdown;

	public void clickOnActive(String key){

		activeDropdown.click();
		wcm.waitForVisibilityOfWebElement(driver.findElement(By.xpath(".//*[@id='main']//option[contains(text(),'"+key+"')]")));
		driver.findElement(By.xpath(".//*[@id='main']//option[contains(text(),'"+key+"')]")).click();
	}
	public void clickOnEndDate(){
		endDate.click();
		wcm.waitForVisibilityOfWebElement(dateFromCaender);
		dateFromCaender.click();
	}

	public void clickOnDisableEndDate(){
		disableEndDate.click();	
	}

	public void clickOnCalander(){
		startDate.click();
		wcm.waitForVisibilityOfWebElement(dateFromCaender);
		dateFromCaender.click();
	}

	public void enterDataToProgramDescription(String key){
		programDescriptionField.sendKeys(key);
	}

	public void enterDataToProgram(String key){
		programNameField.sendKeys(key);
	}
	public void clickOnSave(){
		saveButton.click();
	}

	public void clickOnNext(){
		nextButton.click();
	}


	public void clickOnRadioButton(){
		loyalityCardRadioButton.click();
	}

	public void clickOnClickHere(){
		clickHereLink.click();
	}


}
