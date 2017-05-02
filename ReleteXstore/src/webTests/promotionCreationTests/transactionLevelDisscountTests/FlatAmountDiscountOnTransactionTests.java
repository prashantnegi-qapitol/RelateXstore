package webTests.promotionCreationTests.transactionLevelDisscountTests;

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
import pageAction.promotionCreationMethods.itemLevelDiscountMethods.CreateDealMethods;
import pageAction.promotionCreationMethods.itemLevelDiscountMethods.CreatePromotionMethods;
import utills.SelectBrowser;

public class FlatAmountDiscountOnTransactionTests {
	LoginMethods lm;
	WebDriver driver;
	CreateDealMethods cd;
	CreatePromotionMethods cpm;
	String id;
	@BeforeClass
	public void beforeClass() throws Exception{
		driver= SelectBrowser.getBrowser();
		lm=PageFactory.initElements(driver, LoginMethods.class);
		cpm= PageFactory.initElements(driver, CreatePromotionMethods.class);
		cd= PageFactory.initElements(driver, CreateDealMethods.class);
		lm.login();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void dealCreationForTransactionLevelDiscount() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating deal started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		id=cd.creatingDeal("TransactionLevelDiscount","DealCreationForTransaction");
		Reporter.log("******************Creating Deal Succesfull********************",true);
		Reporter.log("\n",true);
	}

	@Test(priority=2)
	public void createPromotionForTransactionLevel() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating promotion started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		cpm.createPromotions("TransactionLevelDiscount","creatingNewPromotion",id);
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

