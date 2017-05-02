package webTests.promotionCreationTests.itemLevelDisscountTests;

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
import pageAction.promotionCreationMethods.ItemLevelDiscount.CreateDealMethods;
import pageAction.promotionCreationMethods.ItemLevelDiscount.CreatePromotionMethods;
import pageAction.promotionCreationMethods.ItemLevelDiscount.CreateTieredDiscountDealMethods;
import utills.SelectBrowser;

public class Buy3Get50PercentOffTest {
	LoginMethods lm;
	WebDriver driver;
	CreateTieredDiscountDealMethods cd;
	CreatePromotionMethods itm;
	String id;
	@BeforeClass
	public void beforeClass() throws Exception{
		Reporter.log("++++++++++++++++++++Before Class++++++++++++++++++++",true);
		Reporter.log("\n",true);
		driver= SelectBrowser.getBrowser();
		lm=PageFactory.initElements(driver, LoginMethods.class);
		itm= PageFactory.initElements(driver, CreatePromotionMethods.class);
		cd= PageFactory.initElements(driver, CreateTieredDiscountDealMethods.class);
		lm.login();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Reporter.log("\n",true);
		Reporter.log("******************Before Class Succesfull********************",true);
		
	}
	@Test(priority=1)
	public void dealCreationForItemLevelDiscount() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating Tiered Amount deal  and Flat Amount ++++++++++++++++++++",true);
		Reporter.log("\n",true);
		id=cd.creatingTieredDiscountDeal("ItemLevelDiscount" , "TieredDiscountDealWithPercentAmount");
		Reporter.log("\n",true);
		Reporter.log("******************Creating  Tiered Amount  Deal Succesfull********************",true);

	}

	@Test(priority=2)
	public void createPromotion() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating promotion for Tiered Amount deal and Flat Amount ++++++++++++++++++++",true);
		Reporter.log("\n",true);
		itm.createPromotions("ItemLevelDiscount","TiredDiscountPromotionWithPercentAmount",id);
		Reporter.log("\n",true);
		Reporter.log("******************Creating Promotion for  Tiered Amount deal Succesfull********************",true);

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
