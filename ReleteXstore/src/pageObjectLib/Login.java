package pageObjectLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.WebCommonMethods;

public class Login {

	WebDriver driver;
	WebCommonMethods wcm;
	
	public Login(WebDriver driver){
		this.driver = driver;
		wcm = PageFactory.initElements(driver, WebCommonMethods.class);
		
		
	}
	
	@FindBy(xpath = ".//*[@id='main']/div/div[2]/div/div[2]/div[2]/table/tbody/tr[1]/td[2]/input")
	private  WebElement emailIdField;
	
	@FindBy(xpath = ".//*[@id='main']/div/div[2]/div/div[2]/div[2]/table/tbody/tr[2]/td[2]/input")
	private  WebElement passwordField;

	@FindBy(xpath = ".//*[@id='main']/div/div[2]/div/div[2]/div[3]/button")
	private WebElement loginButtonLoginPage;
	
	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/table/tbody/tr/td[2]/div/a")
	private WebElement userName;
	
	
	public String getUserName(){
		String name= userName.getText();
		return name;
	}

	
	public void enterEmailId(String email){
		wcm.waitForVisibilityOfWebElement(emailIdField);
		emailIdField.sendKeys(email);
	}
	
	

	public void enterPassword(String password){
		passwordField.sendKeys(password);

	}
	
	
	public void clickLoginButton(){
		wcm.waitForElementToBeClickable(loginButtonLoginPage);
		loginButtonLoginPage.click();
		wcm.waitForVisibilityOfWebElement(userName);
	}
}
