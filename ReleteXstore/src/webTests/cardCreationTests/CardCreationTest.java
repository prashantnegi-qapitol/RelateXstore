package webTests.cardCreationTests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageAction.LoginMethods;
import pageAction.cardCreationMethods.CardCreationMethods;
import utills.SelectBrowser;

public class CardCreationTest {
	LoginMethods lm;
	CardCreationMethods ccm;
	WebDriver driver;

	@BeforeClass
	public void beforeClass() throws Exception{
		Reporter.log("++++++++++++++++Before Class started++++++++++++++++++++++++++",true);
		Reporter.log("\n",true);
		driver= SelectBrowser.getBrowser();
		ccm=PageFactory.initElements(driver,CardCreationMethods.class);
		lm=PageFactory.initElements(driver, LoginMethods.class);
		lm.login();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Reporter.log("******************Before Class succesfull*********************",true);
		Reporter.log("\n",true);
	}
	@Test
	public void loginpage() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++Creating card started++++++++++++++++++++++++++",true);
		Reporter.log("\n",true);
		ccm.creatingCard("CreateCard","creatingNewCard");	
		Reporter.log("******************creating Card succesfull*********************",true);
		Reporter.log("\n",true);
	}	
	@AfterClass
	public void quitBrowser(){
		Reporter.log("++++++++++++++++After class started++++++++++++++++++++++++++",true);
		Reporter.log("\n",true);
		driver.quit();
		Reporter.log("******************After Class succesfull*********************",true);
		Reporter.log("\n",true);
	}
	



}
