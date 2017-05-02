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
import pageAction.promotionCreationMethods.CreatePromotionMethods;
import pageAction.promotionCreationMethods.itemLevelDiscountMethods.CreateDealMethods;
import utills.SelectBrowser;

public class LimitedQantityDiscountsTest {
	LoginMethods lm;
	WebDriver driver;
	CreateDealMethods cd;
	CreatePromotionMethods itm;
	String id;
	@BeforeClass
	public void beforeClass() throws Exception{
		Reporter.log("++++++++++++++++++++Before Class++++++++++++++++++++",true);
		Reporter.log("\n",true);
		driver= SelectBrowser.getBrowser();
		lm=PageFactory.initElements(driver, LoginMethods.class);
		itm= PageFactory.initElements(driver, CreatePromotionMethods.class);
		cd= PageFactory.initElements(driver, CreateDealMethods.class);
		lm.login();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		Reporter.log("\n",true);
		Reporter.log("******************Before Class Succesfull********************",true);
		
	}
	@Test(priority=1)
	public void dealCreationForItemLevelDiscount() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating deal for Percent Amount++++++++++++++++++++",true);
		Reporter.log("\n",true);
		id=cd.creatingDeal("ItemLevelDiscount" , "DealWithPercentAmount");
		Reporter.log("\n",true);
		Reporter.log("******************Creating Deal Succesfull********************",true);

	}

	@Test(priority=2)
	public void createPromotion() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating promotion for Percent Amount++++++++++++++++++++",true);
		Reporter.log("\n",true);
		itm.createPromotions("ItemLevelDiscount","PromotionWithPercentAmount");
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
