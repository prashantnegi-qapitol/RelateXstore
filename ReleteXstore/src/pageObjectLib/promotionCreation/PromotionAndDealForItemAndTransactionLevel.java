package pageObjectLib.promotionCreation;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.WebCommonMethods;

import com.sun.glass.events.KeyEvent;

public class PromotionAndDealForItemAndTransactionLevel {

	WebDriver driver;
	WebCommonMethods wcm;

	public PromotionAndDealForItemAndTransactionLevel(WebDriver driver){
		this.driver = driver;
		wcm = PageFactory.initElements(driver, WebCommonMethods.class);	

	}
	//*********************************************************************************************

	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div/div[2]/table/tbody/tr[2]/td[4]/select")
	public WebElement select;

	@FindBy(xpath=".//*[@id='main']//td[5]/select")
	public WebElement selectNoOfElement;

	@FindBy(xpath=".//a[contains(text(),'Actions')]")
	public WebElement actionButton;

	@FindBy(xpath=".//a[contains(text(),'Create')]")
	public WebElement createButton;

	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[1]/td[2]/input")
	public WebElement nameField;

	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[2]/td[2]/input")
	public WebElement posNameField;

	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/div/div[2]/table/tbody/tr[3]/td[2]/select")
	public WebElement dealTypeSelect;
	@FindBy(xpath=".//*[@id='main']//tr[4]/td[2]/select")
	public WebElement intentedPromotionTypeField;
	@FindBy(xpath=".//*[@id='main']//textarea")
	public WebElement commentsField;
	@FindBy(xpath=".//a[contains(text(),'next')]")
	public WebElement nextButton;
	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/div/div[2]/div/table/tbody/tr/td[2]/input")
	public WebElement subTotalMinimumfield;
	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/div/div[2]/div/table/tbody/tr/td[4]/input")
	public WebElement subTotalMaximumfield;
	@FindBy(xpath=".//*[@id='main']//td[2]/select")
	public WebElement thrusholdStylefield;
	@FindBy(xpath=".//*[@id='main']//td[4]/select")
	public WebElement thrusholdTypefield;
	@FindBy(xpath=".//*[@id='main']//tr/td[6]/input")
	public WebElement thrusholdfield;
	@FindBy(xpath=".//*[@id='main']//label[contains(text(),'Untargeted')]")
	public WebElement label;
	@FindBy(xpath=".//*[@id='main']//a[contains(text(),'New Set')]")
	public WebElement newSet;
	@FindBy(xpath=".//*[@id='main']//div[2]/div/table/tbody/tr/td[2]/select")
	public WebElement priorityField;

	@FindBy(xpath=".//*[@id='main']//div[2]/div/table/tbody/tr/td[4]/input")
	public WebElement maximumAwardPointfield;

	@FindBy(xpath=".//*[@id='main']//div[2]/div/table/tbody/tr/td[6]/input")
	public WebElement dealCountLimitField;

	@FindBy(xpath=".//div[6]/div[1]/div/div[1]/table/tbody/tr/td[2]/select")
	public WebElement discountTypeField;

	@FindBy(xpath=".//div[6]/div[1]/div/div[1]/table/tbody/tr/td[4]/select")
	public WebElement discountTypeField2;

	@FindBy(xpath=".//*[@id='main']//div[6]/div[1]/div/div[1]/table/tbody/tr/td[4]/input")
	public WebElement discountValueField;

	@FindBy(xpath=".//*[@id='main']//div[6]/div[1]/div/div[1]/table/tbody/tr/td[6]/input")
	public WebElement discountValueField2;

	@FindBy(xpath=".//*[@id='main']//div/div[6]/div[1]/div/div[1]/table/tbody/tr/td[6]/input")
	public WebElement maxQuantityfield;

	@FindBy(xpath=".//*[@id='main']//div/div[6]/div[1]/div/div[1]/table/tbody/tr/td[8]/input")
	public WebElement maxQuantityfield2;

	@FindBy(xpath=".//*[@id='gwt-uid-70']")
	public WebElement includReadLineCheckBox;

	@FindBy(xpath=".//*[@id='gwt-uid-71']")
	public WebElement includeNonMerchandiseChargesCheckBox;

	@FindBy(xpath=".//*[@id='gwt-uid-72']")
	public WebElement allowZeroPriceCheckBox;

	@FindBy(xpath=".//*[@id='gwt-uid-73']")
	public WebElement allowItemsUsedInOtherDealsCheckBox;

	@FindBy(xpath=".//a[contains(text(),'save')]")
	public WebElement saveButton;

	@FindBy(xpath=".//a[contains(text(),'cancel')]")
	public WebElement cancelButton;

	@FindBy(xpath=".//*[@id='main']//div[3]/div/div/div[2]/div/div/table/tbody/tr/td[1]")
	public List<WebElement> dealno;

	@FindBy(xpath=".//*[@id='main']//div/div/div/div/div[8]/div/div/div[2]/a[1]")
	public WebElement clickHere;
	
	@FindBy(xpath=".//*[@id='main']//div/div[2]/div/div/div/div/div[6]/div[3]/div/div[2]/a[1]")
	public WebElement clickHere2;
	@FindBy(xpath=".//*[@id='main']//div[3]/div/div[2]/div/div/div/div/div[7]/div[2]/a[1]")
	public WebElement clickHere3;
	
	//	************************Promotion creation***********************************************************************
	@FindBy(xpath=".//*[@id='main']//label[contains(text(),'Product')]")
	public WebElement productRadioButton;

	@FindBy(xpath=".//*[@id='main']//div/table/tbody/tr[1]/td[2]/input")
	public WebElement promotionNameField;

	@FindBy(xpath=".//*[@id='main']//div/table/tbody/tr[2]/td[2]/textarea")
	public WebElement descreptionField;

	@FindBy(xpath=".//*[@id='main']//div/div/table/tbody/tr[3]/td[2]/input")
	public WebElement endDateButton;

	@FindBy(xpath="html/body/div[4]/div/table/tbody/tr[2]/td/table/tbody/tr[7]/td[4]/div")
	public WebElement dateFromCalender;

	@FindBy(xpath=".//button[contains(text(),'Add')]")
	public WebElement addButton;

	@FindBy(xpath="*//div[2]/table/tbody/tr[1]/td[2]/input")
	public WebElement maxDealId;

	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div/div[2]/table/tbody/tr[1]/td[6]/select")
	public WebElement intendedUse;

	@FindBy(xpath="//table/tbody/tr/td/div/div[4]/button[contains(text(),'Add')]")
	public WebElement addButtonPopUp;

	@FindBy(xpath=".//a[contains(text(),'Add')]")
	public WebElement addhyperLink;

	@FindBy(xpath=".//div/div/div/div[3]/table/tbody/tr[2]/td[1]/input")
	public WebElement descriptionBudget;

	@FindBy(xpath=".//div/div/div[3]/table/tbody/tr[2]/td[2]/input")
	public WebElement budgetAmmount;

	@FindBy(xpath=".//div/div[3]/table/tbody/tr[2]/td[3]/input")
	public WebElement actualAmmount;

	@FindBy(xpath=".//label[contains(text(),'Approve')]")
	public WebElement approveCheckBox;

	@FindBy(xpath=".//label[contains(text(),'Export')]")
	public WebElement exportCheckbox;

	@FindBy(xpath=".//*[@id='main']//div[3]/div/div[2]/div/div/table/tbody/tr/td[2]")
	public List<WebElement> pomotionId;

	@FindBy(xpath=".//*[@id='main']//tbody/tr[2]/td[2]/div/table/tbody/tr[2]/td[2]")
	public WebElement dealName;

	@FindBy(xpath=".//*[@id='main']//div[3]/div/div[2]/div/div/table/tbody/tr[2]/td[2]")
	public WebElement promotionName;

	@FindBy(xpath=".//div[2]/table/tbody/tr[2]/td[4]/select")
	public WebElement dealType;


	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div/div[2]/table/tbody/tr[1]/td[6]/select/option[2]")
	public WebElement option;

	@FindBy(xpath="//table/tbody/tr[2]/td[2]/div/div/div[2]/div/table/tbody/tr/td[2]/select")
	public WebElement hierchyLevel;

	@FindBy(xpath="//div[5]//button[contains(text(),'Add')]")
	public WebElement add;

	@FindBy(xpath="//div[5]//button[contains(text(),'Close')]")
	public WebElement close;

	@FindBy(xpath="html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/div[2]/div/table/tbody/tr/td[1]")
	public WebElement level;

	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[3]/div/div[2]/div/div[2]/div/div[3]/div/div[3]/div/div/div[2]/div/div/table/tbody/tr[2]/td[1]")
	public WebElement id;

	@FindBy(xpath=".//*[@id='main']/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div[1]/div/div/div[3]/table/tbody/tr/td[2]")
	public WebElement closeTab;

	@FindBy(xpath=".//*[@id='main']//div/div[1]/table/tbody/tr/td[2]/input")
	public WebElement awardquantityField;


	public void enterDataToAwardQantity(String key){
		awardquantityField.sendKeys(key);
	}
	public void closetab(){
		closeTab.click();
	}

	
	
	public String getId(){
		return id.getText();
	}


	public void enterDataToDealType(String key) throws AWTException, InterruptedException{
		dealType.sendKeys(key);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}


	public void clickOnNewSet(){
		newSet.click();
	}
	public void clickLevel() throws InterruptedException{
		level.click();

		wcm.waitForElementToBeClickable(level);	
	}

	public void clickOnAdd(){
		add.click();
	}
	public void clickOnClose(){
		close.click();
	}
	public void enterdataToHierchyLevel(String key) throws InterruptedException, AWTException{
		hierchyLevel.sendKeys(key);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}



	public void clickOnclickHere(){
		clickHere.click();
		wcm.waitForVisibilityOfWebElement(add);
	}
	public void clickOnclickHere2(){
		clickHere2.click();
		wcm.waitForVisibilityOfWebElement(add);
	}
	public void clickOnclickHere3(){
		clickHere3.click();
		wcm.waitForVisibilityOfWebElement(add);
	}
	public void enterDealID(String id) throws InterruptedException{
		Thread.sleep(500);
		driver.findElement(By.xpath("html/body/div[5]/div/table/tbody/tr[2]/td[2]/div/div/table/tbody/tr/td/div/div[3]/div/table/tbody/tr[2]/td[contains(text(),'"+id+"')]")).click();
	}

	public void clickOnProductRadioButton() throws InterruptedException{
		wcm.waitForVisibilityOfWebElement(productRadioButton);

		productRadioButton.click();

	}

	public void enterNameTextField(String key){

		promotionNameField.sendKeys(key);


	}
	public String getPromotionName(){
		return promotionName.getText();
	}

	public void enterDescriptionField(String key){
		descreptionField.sendKeys(key);
	}
	public void clickOnLabel(){
		label.click();
	}
	public void clickOnCalender(){
		endDateButton.click();
		wcm.waitForVisibilityOfWebElement(dateFromCalender);
		dateFromCalender.click();
	}
	public void clickOnAddButton(){
		addButton.click();
		wcm.waitForVisibilityOfWebElement(maxDealId);
	}
	public void enterMaxDealId(String key) throws InterruptedException{
		maxDealId.clear();
		maxDealId.sendKeys(key);
	}
	public void enterIntendedUseField() throws InterruptedException{
		for(int i=0;i<4;i++){
			try{
				intendedUse.click();
				Thread.sleep(500);		Robot robot= new Robot();
				robot.keyPress(KeyEvent.VK_A);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_A);
				Thread.sleep(500);
				//		break;
			}catch(Exception e){
			}}

		select.click();
	}

	public void clickOnAddButtoninPopUp()
	{
		addButtonPopUp.click();
	}
	public void clickOnAddHyperLink(){
		wcm.waitForVisibilityOfWebElement(addhyperLink);
		addhyperLink.click();
	}
	public void enterDataToDiscriptionField(String key){
		descriptionBudget.sendKeys(key);

	}
	public void enterDataToBudgetValue(String key){
		budgetAmmount.sendKeys(key);
	}
	public void enterDataToActualAmount(String key){
		actualAmmount.sendKeys(key);
	}
	public void clickOnApprove(){
		wcm.waitForVisibilityOfWebElement(approveCheckBox);
		approveCheckBox.click();
	}
	public List<String> getListOfPromotions(){
		List<String> listOfPromotions= new ArrayList<String>();
		for(WebElement a: pomotionId){
			listOfPromotions.add(a.getText());
		}


		return listOfPromotions;

	}


	public List<String> getListOfDeal(){
		List<String> dealList= new ArrayList<String>();

		for(WebElement a : dealno){
			dealList.add(a.getText());
		}
		return dealList;

	}


	public void enterDataToPagination(String key){
		wcm.waitForVisibilityOfWebElement(selectNoOfElement);
		selectNoOfElement.sendKeys(key);
	}
	public void clickOnActionButtom(){
		actionButton.click();
		wcm.waitForVisibilityOfWebElement(createButton);
	}
	public void clickOnCreateButton(){
		createButton.click();

	}
	public void enterDataToNameField(String key){
		wcm.waitForVisibilityOfWebElement(nameField);
		nameField.sendKeys(key);	
	}
	public void enterDataToPosNameField(String key){
		posNameField.sendKeys(key);	
	}
	public void enterDataToDealTypeField(String key){
		dealTypeSelect.sendKeys(key);	
	}

	public void enterDataToIntendPromotionTypeField(String key){
		intentedPromotionTypeField.sendKeys(key);	
	}
	public void enterDataToCommentField(String key){
		commentsField.sendKeys(key);	
	}

	public void clickOnNext() throws InterruptedException{
		Thread.sleep(500);
		nextButton.click();

	}
	public void enterDataToSubTotalMinimumField(String key){
		subTotalMinimumfield.sendKeys(key);	
	}
	public void enterDataToSubToatalMaximumField(String key){
		subTotalMaximumfield.sendKeys(key);	
	}
	public void enterDataToThrusholdStyleField(String key){
		thrusholdStylefield.sendKeys(key);	
	}
	public void enterDataToThrusholdTypeField(String key){
		thrusholdTypefield.sendKeys(key);	
	}
	public void enterDataToThrushold(String key){
		thrusholdfield.clear();
		thrusholdfield.sendKeys(key);	
	}

	public void enterDataToPriorityField(String key){

		priorityField.sendKeys(key);	
	}

	public void enterDataToMaximumAwardPointField(String key){
		maximumAwardPointfield.sendKeys(key);	
	}

	public void enterDataToDealCountField(String key) throws InterruptedException{
		dealCountLimitField.sendKeys(key);	
		Thread.sleep(500);
	}
	public String getdealName(){
		return dealName.getText();
	}

	public void enterDataToDiscountTypeField(String key){

		discountTypeField.sendKeys(key);	
	}
	public void enterDataToDiscountTypeField2(String key){

		discountTypeField2.sendKeys(key);	
	}
	public void enterDataToMaxQuantityField(String key){
		maxQuantityfield.sendKeys(key);	
	}

	public void enterDataToMaxQuantityField2(String key){
		maxQuantityfield2.sendKeys(key);	
	}

	public void enterDataToDiscountValueField(String key){
		discountValueField.sendKeys(key);	
	}
	public void enterDataToDiscountValueField2(String key){
		discountValueField2.sendKeys(key);	
	}
	public void clickonIncludeReadLine(){
		includReadLineCheckBox.click();
	}
	public void clickonIncludeNonMerchandiseCharges(){
		includeNonMerchandiseChargesCheckBox.click();
	}
	public void clickonAllowZeroPrices(){
		allowZeroPriceCheckBox.click();
	}
	public void clickonAllowItemsToBeUsed(){
		allowItemsUsedInOtherDealsCheckBox.click();
	}
	public void clickonSaveButton() throws InterruptedException{
		saveButton.click();	
		wcm.waitForVisibilityOfWebElement(selectNoOfElement);
	}

	//********************Tiered Discount***********************************************************************
	
	
	@FindBy(xpath=".//*[@id='main']//div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/table/tbody/tr[2]/td[3]/input")
	public WebElement buy1;
	@FindBy(xpath=".//*[@id='main']//div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/table/tbody/tr[3]/td[5]/input")
	public WebElement buy2;

	@FindBy(xpath=".//*[@id='main']//div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/table/tbody/tr[2]/td[3]/input")
	public WebElement discountAmmount;
	@FindBy(xpath=".//*[@id='main']//div[2]/div/div[2]/div/div[3]/div/div[3]/div/div[2]/div/div/div/table/tbody/tr[3]/td[5]/input")
	public WebElement discountAmmount2;
	@FindBy(xpath="	.//*[@id='main']//div/div[5]/table/tbody/tr/td[6]/select")
	public WebElement discountTypeField1;
	public void enterDataToDiscountAmmount(String key){
		discountAmmount.sendKeys(key);
	}
	public void enterDataToDiscountAmmount1(String key){
		discountAmmount2.sendKeys(key);
	}
	public void enterDataToBuy1(String key){
		buy1.sendKeys(key);
	}
	public void enterDataToBuy2(String key){
		buy2.sendKeys(key);
	}
	
	public void enterDataToDiscountType(String key){
		discountTypeField1.sendKeys(key);
	}
}
