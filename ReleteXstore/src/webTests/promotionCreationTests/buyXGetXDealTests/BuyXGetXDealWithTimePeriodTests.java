package webTests.promotionCreationTests.buyXGetXDealTests;

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
import pageAction.promotionCreationMethods.CreatePromotionMethods;
import pageAction.promotionCreationMethods.buyXGetXDealMethods.BuyXGetXDealWithTimePeriodMethods;
import utills.SelectBrowser;

public class BuyXGetXDealWithTimePeriodTests {
	
	LoginMethods lm;
	WebDriver driver;
	BuyXGetXDealWithTimePeriodMethods kdp;
	CreatePromotionMethods cpm;
	String id;
	@BeforeClass
	public void beforeClass() throws Exception{
		Reporter.log("++++++++++++++++++++++Before Class started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		driver= SelectBrowser.getBrowser();
		lm=PageFactory.initElements(driver, LoginMethods.class);
		cpm= PageFactory.initElements(driver, CreatePromotionMethods.class);
		kdp= PageFactory.initElements(driver, BuyXGetXDealWithTimePeriodMethods.class);
		lm.login();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Reporter.log("\n",true);
		Reporter.log("++++++++++++++++++++Before Class started++++++++++++++++++++",true);
		
	}
	@Test(priority=1)
	public void dealCreationForTransactionLevelDiscount() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating deal started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		id=kdp.creatingDeal("BuyXGetX","BuyXGetXDealWithTimePeriod");
		Reporter.log("******************Creating Deal Succesfull********************",true);
		Reporter.log("\n",true);
	}

	@Test(priority=2)
	public void createPromotionForTransactionLevel() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating promotion started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		cpm.createPromotions("BuyXGetX","BuyXGetXPromotionWithTimePeriod",id);
		Reporter.log("******************Creating Promotion Succesfull********************",true);
		Reporter.log("\n",true);
	}
	@AfterClass
	public void afterclass(){
		Reporter.log("++++++++++++++++++++After Class started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		driver.quit();
		Reporter.log("******************After Class Succesfull********************",true);
		Reporter.log("\n",true);
	}


}
