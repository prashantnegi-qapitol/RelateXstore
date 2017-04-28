package webTests;

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
import utills.SelectBrowser;

public class LoginTest {

	LoginMethods lm;
	WebDriver driver;

	@BeforeClass
	public void beforeClass() throws Exception{
		driver= SelectBrowser.getBrowser();
		lm=PageFactory.initElements(driver, LoginMethods.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test
	public void loginpage() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++Login Method started++++++++++++++++++++++++++",true);
		Reporter.log("\n",true);
		lm.login();
		Reporter.log("******************Login method succesfull*********************",true);
		Reporter.log("\n",true);
	}	
	@AfterClass
	public void quitBrowser(){
		driver.quit();
	}


}
