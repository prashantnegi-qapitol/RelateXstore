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
import pageAction.promotionCreationMethods.itemLevelDiscountMethods.CreateDealMethods;
import pageAction.promotionCreationMethods.itemLevelDiscountMethods.CreatePromotionMethods;
import utills.SelectBrowser;

public class BuyLeviJeanAndShirtsGet30PercentOffTest {
	LoginMethods lm;
	WebDriver driver;
	CreateDealMethods cd;
	CreatePromotionMethods itm;
	@BeforeClass
	public void beforeClass() throws Exception{
		driver= SelectBrowser.getBrowser();
		lm=PageFactory.initElements(driver, LoginMethods.class);
		itm= PageFactory.initElements(driver, CreatePromotionMethods.class);
		cd= PageFactory.initElements(driver, CreateDealMethods.class);
		lm.login();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	//	@Test
	public void dealCreationForItemLevelDiscount() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating deal started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		cd.creatingDeal("ItemLevelDiscount","creatingNewDeal");
		Reporter.log("******************Creating Deal Succesfull********************",true);
		Reporter.log("\n",true);
	}

	@Test(priority=1)
	public void createpromotion() throws BiffException, IOException, Exception{
		Reporter.log("++++++++++++++++++++Creating promotion started++++++++++++++++++++",true);
		Reporter.log("\n",true);
		itm.createPromotions("ItemLevelDiscount","creatingNewPromotion");
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
