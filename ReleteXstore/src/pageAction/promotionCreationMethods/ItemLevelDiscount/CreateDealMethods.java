package pageAction.promotionCreationMethods.ItemLevelDiscount;

import java.io.IOException;
import java.util.List;

import jxl.Cell;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjectLib.HomePage;
import pageObjectLib.promotionCreation.PromotionAndDealForItemAndTransactionLevel;
import utills.FilesAndFolders;
import utills.SelectBrowser;

public class CreateDealMethods extends SelectBrowser {

	WebDriver driver;
	PromotionAndDealForItemAndTransactionLevel pad;
	FilesAndFolders faf;
	HomePage hp;

	public CreateDealMethods(WebDriver driver) {
		this.driver= driver;
		pad= PageFactory.initElements(driver, PromotionAndDealForItemAndTransactionLevel.class);
		faf= PageFactory.initElements(driver, FilesAndFolders.class);
		hp= PageFactory.initElements(driver, HomePage.class);
	}

	public String creatingDeal(String sheetName,String uniqueName) throws BiffException, IOException, Exception{
		Cell record [] =FilesAndFolders.readExcel(sheetName, uniqueName);
		String name= record[1].getContents();
		String posName= record[2].getContents();
		String dealType= record[3].getContents();
		String promotionType=record[4].getContents();
		String comments= record[5].getContents();
		String subtotalMin= record[6].getContents();
		String subtotalMax= record[7].getContents();
		String thresholdType=record[8].getContents();
		String thresholdStyle=record[9].getContents();
		String threshold=record[10].getContents();
		String priority=record[11].getContents();
		String maxAwardsPoint=record[12].getContents();
		String dealCountLimit=record[13].getContents();
		String discountType=record[14].getContents();
		String discountValue=record[15].getContents();
		String maxQuantity=record[16].getContents();
		String pagination = record[17].getContents();
		String hierchy= record[18].getContents();

		hp.clickOnCompaign();
		hp.clickOnProductDealDefination();
		pad.enterDataToPagination(pagination);
		List<String> dealList= pad.getListOfDeal();
		pad.clickOnActionButtom();
		pad.clickOnCreateButton();
		pad.enterDataToNameField(name);
		pad.enterDataToPosNameField(posName);
		Thread.sleep(500);
		pad.enterDataToDealTypeField(dealType);
		Thread.sleep(500);
		pad.enterDataToIntendPromotionTypeField(promotionType);
		pad.enterDataToCommentField(comments);
		pad.clickOnNext();
		pad.enterDataToSubTotalMinimumField(subtotalMin);
		pad.enterDataToSubToatalMaximumField(subtotalMax);

		if(pad.getdealName().equals("Buy X Get X"))
		{
			pad.clickOnNewSet();
			Thread.sleep(500);
			pad.enterDataToThrusholdTypeField(thresholdType);
			Thread.sleep(500);
			pad.enterDataToThrusholdStyleField(thresholdStyle);
			pad.enterDataToThrushold(threshold);
			pad.clickOnclickHere();
			Thread.sleep(500);
			pad.enterdataToHierchyLevel(hierchy);
			Thread.sleep(500);
			pad.clickLevel();
			pad.clickOnAdd();
			pad.clickOnClose();
			Thread.sleep(500);
			pad.clickOnNext();
			Thread.sleep(500);
			pad.enterDataToPriorityField(priority);
			pad.enterDataToMaximumAwardPointField(maxAwardsPoint);
			pad.enterDataToDealCountField(dealCountLimit);
			Thread.sleep(500);
			String awardQantity= record[19].getContents();
			pad.enterDataToAwardQantity(awardQantity);
			pad.enterDataToDiscountTypeField2(discountType);
			pad.enterDataToDiscountValueField2(discountValue);
			pad.enterDataToMaxQuantityField2(maxQuantity);
		}
		else if(pad.getdealName().equals("Buy X Get Y")){
			pad.clickOnNewSet();
			Thread.sleep(500);
			pad.enterDataToThrusholdTypeField(thresholdType);
			Thread.sleep(500);
			pad.enterDataToThrusholdStyleField(thresholdStyle);
			pad.enterDataToThrushold(threshold);
			Thread.sleep(500);
			pad.clickOnclickHere2();
			Thread.sleep(500);
			pad.enterdataToHierchyLevel(hierchy);
			Thread.sleep(500);
			pad.clickLevel();
			pad.clickOnAdd();
			pad.clickOnClose();
			Thread.sleep(500);
			pad.clickOnNext();
			Thread.sleep(500);
			pad.enterDataToPriorityField(priority);
			pad.enterDataToMaximumAwardPointField(maxAwardsPoint);
			pad.enterDataToDealCountField(dealCountLimit);
			Thread.sleep(500);
			pad.clickOnclickHere3();
			Thread.sleep(500);
			pad.enterdataToHierchyLevel(hierchy);
			Thread.sleep(500);
			pad.clickLevel();
			pad.clickOnAdd();
			pad.clickOnClose();
			Thread.sleep(500);
			String awardQantity= record[19].getContents();
			pad.enterDataToAwardQantity(awardQantity);
			pad.enterDataToDiscountTypeField2(discountType);
			pad.enterDataToDiscountValueField2(discountValue);
			pad.enterDataToMaxQuantityField2(maxQuantity);
		}
		else{
			Thread.sleep(500);
			pad.enterDataToThrusholdTypeField(thresholdType);
			Thread.sleep(500);
			pad.enterDataToThrusholdStyleField(thresholdStyle);
			pad.enterDataToThrushold(threshold);
			pad.clickOnclickHere();
			Thread.sleep(500);
			pad.enterdataToHierchyLevel(hierchy);
			Thread.sleep(500);
			pad.clickLevel();
			pad.clickOnAdd();
			pad.clickOnClose();
			Thread.sleep(500);
			pad.clickOnNext();
			Thread.sleep(500);
			pad.enterDataToPriorityField(priority);
			pad.enterDataToMaximumAwardPointField(maxAwardsPoint);
			pad.enterDataToDealCountField(dealCountLimit);
			Thread.sleep(500);
			pad.enterDataToDiscountTypeField(discountType);
			pad.enterDataToDiscountValueField(discountValue);
			pad.enterDataToMaxQuantityField(maxQuantity);
		}
		pad.clickOnNext();
		Thread.sleep(500);
		pad.clickonSaveButton();
		List<String> dealList1= pad.getListOfDeal();
		int i=0;
		String id=pad.getId();
		boolean flag= false;
		do{
			if(dealList1.get(i).equalsIgnoreCase(dealList.get(i))){
				i++;
			}else{
				flag=true;
				break;
			}
		}while(dealList.size()>i);

		Assert.assertTrue(flag, "deal did not created some error occurs while creating deal ");
		Reporter.log("************ Test pass :: Deal succesfully created ***********",true);
		pad.closetab();
		return id;
	}

}
