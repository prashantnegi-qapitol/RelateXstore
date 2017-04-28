package pageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.WebCommonMethods;

public class HomePage {

	WebDriver driver;
	WebCommonMethods wcm;
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		wcm = PageFactory.initElements(driver, WebCommonMethods.class);	
	
	}
	
	@FindBy(xpath=".//*[@id='gwt-uid-11']")
	public WebElement compaignInHeader;
	
	@FindBy(xpath=".//*[@id='gwt-uid-10']")
	public WebElement productDealDefination;
	
	@FindBy(xpath=".//*[@id='gwt-uid-9']")
	public WebElement productdefination;
	
	
	//*********************************** card creation******************
	
	@FindBy(xpath=".//*[@id='gwt-uid-14']")
	public WebElement accountInHeader;
	
	@FindBy(xpath=".//*[@id='gwt-uid-12']")
	public WebElement cardDefination;
	
	
	
	
	public void clickOnProductDefination(){
		productdefination.click();
	}
	
	public void clickOnAccount(){
		accountInHeader.click();
		wcm.waitForVisibilityOfWebElement(cardDefination);
		
	}
	
	public void clickOnCardDefination(){
		
		cardDefination.click();
	}
	public void clickOnCompaign(){
		compaignInHeader.click();
		wcm.waitForVisibilityOfWebElement(productDealDefination);
	}
	public void clickOnProductDealDefination(){
		productDealDefination.click();
	}
}
