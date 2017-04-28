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

public class CreatePromotionMethods extends SelectBrowser {

	WebDriver driver;
	PromotionAndDealForItemAndTransactionLevel pad;
	FilesAndFolders faf;
	HomePage hp;

	public CreatePromotionMethods(WebDriver driver) {
		this.driver= driver;
		pad= PageFactory.initElements(driver, PromotionAndDealForItemAndTransactionLevel.class);
		faf= PageFactory.initElements(driver, FilesAndFolders.class);
		hp= PageFactory.initElements(driver, HomePage.class);
	}

	public void createPromotions(String sheetName, String uniqueName) throws BiffException, IOException, Exception{

		Cell record [] =FilesAndFolders.readExcel(sheetName, uniqueName);
		String name= record[1].getContents();
		String descreption = record[2].getContents();
		String maxDealId= record[3].getContents();
		String budgetDescription = record[5].getContents();
		String budgetAmount = record[6].getContents();
		String actualAmount = record[7].getContents();
		String key = record[9].getContents();
		hp.clickOnCompaign();
		hp.clickOnProductDefination();
		pad.enterDataToPagination(key);

		List<String> promotionList=pad.getListOfPromotions();
		int j=0;
		boolean flag1= true;
		do{
			if(promotionList.contains(name)){
				name=record[1].getContents()+j;
				j++;
			}else{
				flag1=false;
			}
		}while(flag1);
		pad.clickOnCreateButton();
		pad.clickOnProductRadioButton();
		pad.clickOnNext();
		pad.enterNameTextField(name);
		pad.enterDescriptionField(descreption);
		pad.clickOnNext();
		pad.clickOnNext();
		pad.clickOnCalender();
		pad.clickOnNext();
		pad.clickOnNext();
		pad.clickOnAddButton();
		pad.enterMaxDealId(maxDealId);
		pad.enterIntendedUseField();
		pad.enterDealID();
		pad.clickOnAddButtoninPopUp();
		Thread.sleep(1000);
		pad.clickOnNext();
		Thread.sleep(1000);
		pad.clickOnLabel();
		pad.clickOnNext();
		pad.clickOnAddHyperLink();
		pad.enterDataToDiscriptionField(budgetDescription);
		pad.enterDataToBudgetValue(budgetAmount);
		pad.enterDataToActualAmount(actualAmount);	
		pad.clickOnNext();
		pad.clickOnApprove();
		pad.clickOnNext();
		pad.clickonSaveButton();
		pad.enterDataToPagination(key);
		List<String> promotionList1=pad.getListOfPromotions();
		String actual=pad.getPromotionName();

		int i=0;
		boolean flag=false;
		do{

			if(promotionList.get(i).equalsIgnoreCase(promotionList1.get(i))){
				i++;
			}else{
				flag=true;
				break;
			}
		}while(i<promotionList1.size());


		Assert.assertTrue(flag, "New Promotion did not created");
		Assert.assertEquals(actual, name,"actual result and expected result did  not match");
		Reporter.log("New promotion created succesfully with name as "+actual+" ",true);

	}




}
