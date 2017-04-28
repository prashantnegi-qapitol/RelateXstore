package pageAction.cardCreationMethods;

import java.io.IOException;
import java.util.List;

import jxl.Cell;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import pageObjectLib.HomePage;
import pageObjectLib.cardCreation.CardCreation;
import utills.FilesAndFolders;
import utills.SelectBrowser;

public class CardCreationMethods extends SelectBrowser {

	WebDriver driver;
	HomePage hp;
	FilesAndFolders faf;
	CardCreation cc;
	public CardCreationMethods(WebDriver driver) {
		this.driver=driver;
		hp= PageFactory.initElements(driver, HomePage.class);
		faf=  PageFactory.initElements(driver, FilesAndFolders.class);
		cc= PageFactory.initElements(driver, CardCreation.class);
	}

	public void creatingCard(String sheetName,String uniqueName) throws BiffException, IOException, Exception{
		Cell[] record= FilesAndFolders.readExcel(sheetName, uniqueName);
		String cardTypeName=record[1].getContents();		
		String description=record[2].getContents();		
		String CardNumberPrefix=record[3].getContents();		
		String cardSerialNumber=record[4].getContents();		
		String pinLength =record[5].getContents();		
		String cardNumberLength=record[6].getContents();		
		String vendorName =record[7].getContents();		
		String vendorCity=record[8].getContents();		
		String vendorState=record[9].getContents();		
		String vendorCountry=record[10].getContents();		
		String vendorPostalCode=record[11].getContents();		

		hp.clickOnAccount();
		hp.clickOnCardDefination();
		List<String> cardList=cc.getCardInfo();
		List<String> cardList1=cc.getCardPrefix();
		cc.clickOnAction();
		cc.clickOnCreateNewCard();
		int i=0;
		boolean flag=true;
		do{

			if(cardList.contains(cardTypeName)){
				cardTypeName= record[1].getContents()+i;
				i++;
			}else{
				flag=false;
			}
		}while(flag);

		cc.enterDataTocardType(cardTypeName);
		cc.enterDataToDescription(description);


		int j=0;
		boolean flag1=true;
		do{

			if(cardList1.contains(cardSerialNumber)){
				if(j<10){
					
					cardSerialNumber=((record[4].getContents().substring(0,4))+j); 
				}else if(j<100){
					cardSerialNumber=((record[4].getContents().substring(0,3))+j);
				}else{
					cardSerialNumber=((record[4].getContents().substring(0,2))+j);
				}j++;
			}else{
				flag1=false;
			}
		}while(flag1);		
		Thread.sleep(1000);
		
		cc.enterDataToCardNumberPrefix(CardNumberPrefix);
		cc.enterDataToCardSerialNumber(cardSerialNumber);
		cc.enterDataToCardNumberLength(cardNumberLength);
		cc.clickOnGenratePin();
		cc.enterDatatoPinLength(pinLength);
		cc.clickOnAlways();
		cc.clickOnActive();
		cc.clickOnNext();
		cc.enterDataToVendorName(vendorName);
		cc.enterDAtaToVendorCity(vendorCity);
		cc.enterDataToVendorstate(vendorState);
		cc.enterDataToVendorCountry(vendorCountry);
		cc.enterDataToVendorPostal(vendorPostalCode);
		cc.clickOnNext();
		Thread.sleep(500);
		cc.clickOnsave();
		String expectedCardType= cc.getCardName();

		Assert.assertEquals(cardTypeName, expectedCardType,"Actual card name and Expected Card Name did not match"); 
		Reporter.log("Actual name of the card is !"+cardTypeName+ "! and Expectd Card Name is "+expectedCardType, true);



	}


}
