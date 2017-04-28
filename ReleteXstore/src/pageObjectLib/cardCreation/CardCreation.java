package pageObjectLib.cardCreation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.WebCommonMethods;

public class CardCreation {

	WebDriver driver;
	
	WebCommonMethods wcm;
	
	public CardCreation(WebDriver driver) {
this.driver= driver;
wcm= PageFactory.initElements(driver, WebCommonMethods.class);
	}
	
	@FindBy(xpath=".//a[contains(text(),'Actions')]")
	public WebElement actionButton;
	
	@FindBy(xpath="//a[contains(text(),'Create New Card Definition')]")
	public WebElement createNewCard;
	
	@FindBy(xpath=".//*[@id='main']//div/div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[3]/preceding-sibling:: td/input")
	public WebElement cardType;
	
	@FindBy(xpath=".//*[@id='main']//div[2]/div/div/div/div[2]/table/tbody/tr[1]/td[4]/input")
	public WebElement cardNUmberPrefix;
	
	@FindBy(xpath=".//*[@id='main']//div[2]/div/div/div/div[2]/table/tbody/tr[2]/td[2]/input")
	public WebElement description;
	
	@FindBy(xpath=".//*[@id='main']//div/div/div[2]/table/tbody/tr[2]/td[4]/input")
	public WebElement cardNumberLength;
	
	@FindBy(xpath=".//*[@id='main']//div/div/div/div[2]/table/tbody/tr[3]/td[2]/input")
	public WebElement cardSerialNumberPrefix;
	
//	@FindBy(id="gwt-uid-154")
	@FindBy(xpath=".//*[@id='main']//div/div[2]/table/tbody/tr[4]/td[2]/span")
	public WebElement genratePin;
	
	@FindBy(xpath=".//*[@id='main']//div/div[2]/table/tbody/tr[5]/td[2]/input")
	public WebElement pinLength;
	
	@FindBy(xpath=".//*[@id='main']//div/div/div[2]/table/tbody/tr[6]/td[2]/span")
	public WebElement alwaysPinRequired;
	
	@FindBy(xpath=".//*[@id='main']//div/div[2]/table/tbody/tr[8]/td[2]/span")
	public WebElement activeCheckbox;
	
	@FindBy(xpath=".//a[contains(text(),'next')]")
	public WebElement nextButton;
	
	@FindBy(xpath=".//a[contains(text(),'save')]")
	public WebElement saveButton;
	
	@FindBy(xpath=".//*[@id='main']//td[contains(text(),'Vendor Name')]/following-sibling:: td/input")
	public WebElement vendorName;
	
	@FindBy(xpath=".//*[@id='main']//div/div/div[2]/table/tbody/tr[5]/td[2]/input")
	public  WebElement vendorCity;
	
	@FindBy(xpath=".//*[@id='main']//div/div/div/div[2]/table/tbody/tr[6]/td[2]/input")
	public WebElement vendorState;
	
	@FindBy(xpath=".//*[@id='main']//div/div[2]/table/tbody/tr[8]/td[2]/input")
	public WebElement vendorCountry;
	
	@FindBy(xpath=".//*[@id='main']//div/div[2]/table/tbody/tr[7]/td[2]/input")
	public WebElement vendorPostal;
	
	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[3]/div/div[2]/div/div[3]/div/div[2]/div/div[3]/div/table/tbody/tr/td[1]/div/div[1]")
	public WebElement expectedCardName;
	
	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[3]/div/div[2]/div/div[3]/div/div/div/div/div/div/div/table/tbody/tr/td[1]/div/div[1]")
	public List<WebElement> cardInfo;
	
	@FindBy(xpath=".//*[@id='main']//div/div/div/div/table/tbody/tr/td[3]/div/div[2]/table/tbody/tr[1]/td[4]")
	public List<WebElement> cardPrefixList;
	

	public List<String> getCardPrefix() throws InterruptedException{
		List<String> cardList= new ArrayList<String>();
		for(WebElement i: cardPrefixList){
			cardList.add(i.getText());
		}
		Thread.sleep(500);	
		return cardList;
	
	}
	
	
	public List<String> getCardInfo(){
		List<String> cardList= new ArrayList<String>();
		for(WebElement i: cardInfo){
			cardList.add(i.getText());
		}
		
		return cardList;
	}
	
	public String getCardName(){
		return expectedCardName.getText();
	}
	
	public void enterDataToVendorPostal(String key){
		vendorPostal.sendKeys(key);
	}
	
	public void enterDataToVendorstate(String key){
		vendorState.sendKeys(key);
	}
	
	public void enterDataToVendorCountry(String key){
		vendorCountry.sendKeys(key);
	}
	
	public void enterDAtaToVendorCity(String key) throws InterruptedException{
		Thread.sleep(500);
		vendorCity.sendKeys(key);
	}
	
	public void enterDataToVendorName(String key) throws InterruptedException{
		Thread.sleep(500);
		vendorName.sendKeys(key);
	}
	
	
	public void clickOnsave(){
		saveButton.click();
		wcm.waitForVisibilityOfWebElement(expectedCardName);
	}
	
	public void clickOnNext(){
		nextButton.click();
	}
	
	public void clickOnActive(){
		activeCheckbox.click();
	}
	
	public void clickOnAlways(){
		alwaysPinRequired.click();
	}
	
	public void enterDatatoPinLength(String key){
		pinLength.clear();
		pinLength.sendKeys(key);
	}
	
	public void clickOnGenratePin(){
//		Actions act= new Actions(driver);
//		act.moveToElement(genratePin).click().build().perform();
//		
		genratePin.click();
		wcm.waitForVisibilityOfWebElement(pinLength);
	}
	
	public void enterDataToCardSerialNumber(String key){
	cardSerialNumberPrefix.sendKeys(key);
	}
	
	public void enterDataToCardNumberLength(String key){
		cardNumberLength.sendKeys(key);
	}
	
	public void enterDataToDescription(String key){
		description.sendKeys(key);
	}
	
	
	public void enterDataToCardNumberPrefix(String key){
		cardNUmberPrefix.sendKeys(key);
	}
	
	public void enterDataTocardType(String key){
		cardType.sendKeys(key);
	}
	
	public void clickOnAction(){
		actionButton.click();
		wcm.waitForVisibilityOfWebElement(createNewCard);
	}
	
	public void clickOnCreateNewCard(){
		createNewCard.click();
		wcm.waitForVisibilityOfWebElement(cardType);
	}
	
	
}
