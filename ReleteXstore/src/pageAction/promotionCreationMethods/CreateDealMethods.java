package pageAction.promotionCreationMethods;

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

	public void creatingDeal(String sheetName,String uniqueName) throws BiffException, IOException, Exception{
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
		hp.clickOnCompaign();
		hp.clickOnProductDealDefination();
		pad.enterDataToPagination(pagination);
		List<String> dealList= pad.getListOfDeal();
		pad.clickOnActionButtom();
		pad.clickOnCreateButton();
		pad.enterDataToNameField(name);
		pad.enterDataToPosNameField(posName);
		pad.enterDataToDealTypeField(dealType);
		pad.enterDataToIntendPromotionTypeField(promotionType);
		pad.enterDataToCommentField(comments);
		pad.clickOnNext();
		pad.enterDataToSubTotalMinimumField(subtotalMin);
		pad.enterDataToSubToatalMaximumField(subtotalMax);
		pad.enterDataToThrusholdTypeField(thresholdType);
		pad.enterDataToThrusholdStyleField(thresholdStyle);
		pad.enterDataToThrushold(threshold);
		pad.clickOnNext();
		pad.enterDataToPriorityField(priority);
		pad.enterDataToMaximumAwardPointField(maxAwardsPoint);
		pad.enterDataToDealCountField(dealCountLimit);
		pad.enterDataToDiscountTypeField(discountType);
		pad.enterDataToDiscountValueField(discountValue);
		pad.enterDataToMaxQuantityField(maxQuantity);
		pad.clickOnNext();
		pad.clickonSaveButton();
		List<String> dealList1= pad.getListOfDeal();
		int i=0;
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

	}

}
