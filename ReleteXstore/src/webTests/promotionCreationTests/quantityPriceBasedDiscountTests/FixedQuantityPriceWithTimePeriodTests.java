package webTests.promotionCreationTests.quantityPriceBasedDiscountTests;

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
import pageAction.promotionCreationMethods.quantityPriceDiscountBasedOnTimePeriodMethods.FixedQuantityPriceDealCreationMethods;
import utills.SelectBrowser;

public class FixedQuantityPriceWithTimePeriodTests {
	LoginMethods lm;
	WebDriver driver;
	FixedQuantityPriceDealCreationMethods fq;
	CreatePromotionMethods cpm;
	String id;
	@BeforeClass
	public void beforeClass() throws Exception{
		Reporter.log("++++++++++++++++++++Before Class started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		driver= SelectBrowser.getBrowser();
		lm=PageFactory.initElements(driver, LoginMethods.class);
		cpm= PageFactory.initElements(driver, CreatePromotionMethods.class);
		fq= PageFactory.initElements(driver, FixedQuantityPriceDealCreationMethods.class);
		lm.login();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Reporter.log("\n",true);
		Reporter.log("******************Before Class Succesfull********************",true);
		
	}
	@Test(priority=1)
	public void dealCreationForTransactionLevelDiscount() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating deal started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		id=fq.creatingDeal("FixedQuantityPriceDiscount","DealCreationForPercentAmountTimeRule");
		Reporter.log("\n",true);
		Reporter.log("******************Creating Deal Succesfull********************",true);
		
	}

	@Test(priority=2)
	public void createPromotionForTransactionLevel() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating promotion started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		cpm.createPromotions("FixedQuantityPriceDiscount","creatingNewPromotionForPercentAmountTimeRule",id);
		Reporter.log("\n",true);
		Reporter.log("******************Creating Promotion Succesfull********************",true);
		
	}
	@AfterClass
	public void afterclass(){
		Reporter.log("++++++++++++++++++++After Class started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		driver.quit();
		Reporter.log("\n",true);
		Reporter.log("******************After Class Succesfull********************",true);
		
	}

}
