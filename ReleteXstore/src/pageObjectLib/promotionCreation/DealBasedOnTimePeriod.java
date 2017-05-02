package pageObjectLib.promotionCreation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.WebCommonMethods;

public class DealBasedOnTimePeriod {


	WebDriver driver;
	WebCommonMethods wcm;

	public DealBasedOnTimePeriod(WebDriver driver){
		this.driver = driver;
		wcm = PageFactory.initElements(driver, WebCommonMethods.class);	

	}

	@FindBy(xpath=".//*[@id='main']//div/div[2]/div/div/div/div/div[3]/div[2]/a")
	public WebElement clickHere;
	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/div[1]/table/tbody/tr[1]/td[2]/input")
	public WebElement nameField;

	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[2]/span")
	public WebElement monday;
	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[3]/span")
	public WebElement Tuesday;
	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[4]/span")
	public WebElement Wednsday;
	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[5]/span")
	public WebElement Thrusday;
	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[6]/span")
	public WebElement friday;
	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[7]/span")
	public WebElement saturday;
	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/table/tbody/tr[2]/td[8]/span")
	public WebElement sunday;
	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td[1]/div/div[2]/button")
	public WebElement saveButton;

	public void clickOnSaveButton(){
		saveButton.click();
	}
	public void clickOnDay1(){
		monday.click();
	}
	public void clickOnDay2(){
		Tuesday.click();
	}
	public void clickOnDay3(){
		Wednsday.click();
	}
	public void clickOnDay4(){
		Thrusday.click();
	}
	public void clickOnDay5(){
		friday.click();
	}public void clickOnDay6(){
		saturday.click();
	}public void clickOnDay7(){
		sunday.click();
	}

	public void enterDataToName(String key){
		nameField.sendKeys(key);
	}
	public void clickOnClickHere(){
		clickHere.click();
	}

}
