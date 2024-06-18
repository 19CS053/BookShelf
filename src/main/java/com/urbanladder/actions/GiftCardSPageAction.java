package com.urbanladder.actions;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.urbanladder.locators.GiftCardSPageLocators;
import com.urbanladder.utils.BaseClass;

public class GiftCardSPageAction {
	

	GiftCardSPageLocators giftcardspageLocators_Obj = null;
	Select monthDate;
	Logger logger;
	
	//Constructor
	public GiftCardSPageAction() {
		
		this.giftcardspageLocators_Obj=new GiftCardSPageLocators();
		BaseClass baseclass=new BaseClass();
		logger=baseclass.logElement();
		PageFactory.initElements(BaseClass.getDriver(), giftcardspageLocators_Obj);
		
	}
	
	//Check for GiftCard Label Link
	public boolean CheckGiftCardLabel() {
		
		logger.info("Gift Card Label is displayed");
		return giftcardspageLocators_Obj.giftCards_Label.isDisplayed();
		
	}
	
	//Click on GiftCard Link 
	public void ClickOngiftCard() {
		
		logger.info("Gift Card Label is clicked");
		BaseClass.getWait(10).until(ExpectedConditions.elementToBeClickable(giftcardspageLocators_Obj.giftCards_Label));
		BaseClass.highlightElement(giftcardspageLocators_Obj.giftCards_Label);
		giftcardspageLocators_Obj.giftCards_Label.click();
	
	}
	
	//Check  "Birthday/Anniversary"
	public boolean CheckForBirthdaORAnniversary() {
		
		logger.info("Birthday Card is displayed");
		return giftcardspageLocators_Obj.Birthday_AnniversaryGift.isDisplayed();
		
	}
	
	//choose "Birthday/Anniversary"
	public void ClickOnBirthdaORAnniversary(){
		
		logger.info("Birthday Card is clicked");
		giftcardspageLocators_Obj.Birthday_AnniversaryGift.click();
		
	}
	
	//Check for Price Input
	public boolean CheckAmountInnputBox() {
		
		logger.info("Amount Input Box is displayed");
		return giftcardspageLocators_Obj.Amount_Input.isDisplayed();
		
	}
	
	//Enter the Amount in Input Box
	public void EnterAmount(String Amount){
		
		logger.info("Amount is Entered");
		giftcardspageLocators_Obj.Amount_Input.sendKeys(Amount);
		BaseClass.highlightElement(giftcardspageLocators_Obj.Amount_Input);

	}
	
	//Check For Date and Month DropDown
	public boolean CheckForDateandMonth() {
		
		logger.info("Date and Month are displayed");
		return (giftcardspageLocators_Obj.month_DropDown.isDisplayed() && giftcardspageLocators_Obj.date_DropDown.isDisplayed());
		
	}
	
	//Select Date and Month on Drop Down 
	public void SelectMonthandDate(){
		
		logger.info("Date and Month are selected");
		monthDate = new Select(giftcardspageLocators_Obj.month_DropDown);
		monthDate.selectByIndex(1);
		monthDate = new Select(giftcardspageLocators_Obj.date_DropDown);
		monthDate.selectByIndex(1);
		
	}
	
	//Check For next Button 
	public boolean CheckForNextButtton() {
		
		logger.info("Next button is displayed");
		return giftcardspageLocators_Obj.next_button.isDisplayed();
		
	}
	
	//Click on Next Button
	public void ClickOnNextButton(){
		
		logger.info("Next button is clicked");
		giftcardspageLocators_Obj.next_button.click();

		BaseClass.highlightElement(giftcardspageLocators_Obj.next_button);
	}
	
	
	//To 
	//Check For Recipient's Name 
	public boolean CheckForRecipientName() {
		logger.info("Recipient Name is displayed");
		return giftcardspageLocators_Obj.recipientsName_Input.isDisplayed();
	}
	//Enter the Recipient's Name 
	public void EnterRecipientName(String name) {
		giftcardspageLocators_Obj.recipientsName_Input.sendKeys(name);
		BaseClass.highlightElement(giftcardspageLocators_Obj.recipientsName_Input);
	}
	//Check For Recipient's Email
	public boolean CheckForRecipientEmail(){
		logger.info("Recipient Email is displayed");
		return giftcardspageLocators_Obj.recipientsEmail_Input.isDisplayed();
	}
	//Enter the Recipient's Email
	public void EnterRecipientEmail(String Email) {
		giftcardspageLocators_Obj.recipientsEmail_Input.sendKeys(Email);
		BaseClass.highlightElement(giftcardspageLocators_Obj.recipientsEmail_Input);
	}
	//Check For Recipient's Mobile
	public boolean CheckForRecipientMobile() {
		logger.info("Recipient Mobile Number is displayed");
		return giftcardspageLocators_Obj.recipientsMobile_Input.isDisplayed();
	}
	//Enter the Recipient's Mobile 
	public void EnterRecipientMobile(String mobile) {
		giftcardspageLocators_Obj.recipientsMobile_Input.sendKeys(mobile);
		BaseClass.highlightElement(giftcardspageLocators_Obj.recipientsMobile_Input);
	}

	
	//From
	//1)Check for Your Name
	public boolean CheckForYourName() {
		logger.info("From Name is displayed");
		return giftcardspageLocators_Obj.yourName_Input.isDisplayed();
	}
	//Enter Your Name 
	public void EnterYourName(String name) {
		giftcardspageLocators_Obj.yourName_Input.sendKeys(name);
		BaseClass.highlightElement(giftcardspageLocators_Obj.yourName_Input);
	}
	//2)Check for Your Email
	public boolean CheckForYourEmail(){
		logger.info("From EMail is displayed");
		return giftcardspageLocators_Obj.yourEmail_Input.isDisplayed();
	}
	//Enter Your Email
	public void EnterYourEmail(String Email) {
		giftcardspageLocators_Obj.yourEmail_Input.sendKeys(Email);
		BaseClass.highlightElement(giftcardspageLocators_Obj.yourEmail_Input);
	}
	//3)Check for Your Mobile
	public boolean CheckForYourMobile() {
		logger.info("From Mobile Number is displayed");
		return giftcardspageLocators_Obj.yourEmail_Input.isDisplayed();
	}
	//Enter Your Mobile 
	public void EnterYourMobile(String mobile) {
		giftcardspageLocators_Obj.yourMobile_Input.sendKeys(mobile);
		BaseClass.highlightElement(giftcardspageLocators_Obj.yourMobile_Input);
	}
	//4)Check for Your Address
	public boolean CheckForYourAddress() {
		logger.info("From Address is displayed");
		return giftcardspageLocators_Obj.Address_Input.isDisplayed();
	}
	//Enter Your Address
	public void EnterYourAddress(String address) {
		giftcardspageLocators_Obj.Address_Input.sendKeys(address);
		BaseClass.highlightElement(giftcardspageLocators_Obj.Address_Input);
	}
	//5)Check for Your pincode
	public boolean CheckForYourPincode() {
		logger.info("From Pincode is displayed");
		return giftcardspageLocators_Obj.pincode_Input.isDisplayed();
	}
	//Enter Your Pincode 
	public void EnterYourPincode(String pincode) {
		giftcardspageLocators_Obj.pincode_Input.sendKeys(pincode);
		BaseClass.highlightElement(giftcardspageLocators_Obj.pincode_Input);
	}
	//Check for Messge Input box 
	public boolean CheckForMsgBox() {
		return giftcardspageLocators_Obj.Message_Input.isDisplayed();
	}
	//Enter Message 
	public void EnterMsg(String msg) {
		giftcardspageLocators_Obj.Message_Input.sendKeys(msg);
		BaseClass.highlightElement(giftcardspageLocators_Obj.Message_Input);
	}
	//Check For Confirm Button
	public boolean CheckForConfirm() {
		logger.info("Confirm Message is displayed");
		return giftcardspageLocators_Obj.Confirm_button.isDisplayed();
	}
	//Click On Confirm Button
	public void ClickOnConfirm() {
		logger.info("Confirm Message is clicked");
		BaseClass.getHandler().scrollToElement(giftcardspageLocators_Obj.Confirm_button);
		BaseClass.sleep(2000);
		giftcardspageLocators_Obj.Confirm_button.click();
		BaseClass.highlightElement(giftcardspageLocators_Obj.Confirm_button);
		BaseClass.sleep(2000);
	}
}
