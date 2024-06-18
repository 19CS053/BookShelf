package com.urbanladder.actions;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.urbanladder.locators.BookshelvesPageLocators;
import com.urbanladder.utils.BaseClass;

public class BookshelvesPageActions {
	

	Actions handler = BaseClass.getHandler();
	BookshelvesPageLocators bookshelvespagelocator_Obj = null;
	Logger logger;

	//Constructor
	public BookshelvesPageActions() {

		BaseClass baseclass=new BaseClass();
		logger=baseclass.logElement();
		this.bookshelvespagelocator_Obj = new BookshelvesPageLocators();
		PageFactory.initElements(BaseClass.getDriver(),bookshelvespagelocator_Obj);
	
	}
	
	//Check for BookShelves Page
	public boolean checkBookShelfUrl() {

		return BaseClass.getWait(10).until(ExpectedConditions.urlContains("bookshelf"));

	}
	
	//Check for Popup 
	public boolean checkPopupBanner(){
		return bookshelvespagelocator_Obj.Popup.isDisplayed();
	}
	
	//Close Popup
	public void closePopup() {
		logger.info("PopUp is closed");
		bookshelvespagelocator_Obj.closePopup.click();
		BaseClass.highlightElement(bookshelvespagelocator_Obj.closePopup);
		
	}
	
	//Checks for Prize 
	public boolean CheckPrizeFilter() {
		logger.info("Prize Filter Slider is displayed");
		return bookshelvespagelocator_Obj.price_Filter.isDisplayed();
	}
	
	//MouseHover to Prize Filter 
	public void MovetoPrizeFilter() {
		
		BaseClass.highlightElement(bookshelvespagelocator_Obj.price_Filter);
		BaseClass.getWait(20).until(ExpectedConditions.visibilityOf(bookshelvespagelocator_Obj.price_Filter));
		handler.moveToElement(bookshelvespagelocator_Obj.price_Filter).build().perform();

	}

	//Check for Right Dragger 
	public boolean CheckRightDragger() {
		return bookshelvespagelocator_Obj.Right_Dragger.isDisplayed();
	}
	
	//Drag And Set the Price to 15000
	public void DragAndSet() {
		handler.dragAndDropBy(bookshelvespagelocator_Obj.Right_Dragger, -280, 0).build().perform();

	}
	
	//Select storage type as open
	public void selectStorageOpen() {
		
		logger.info("Open Storage option is displayed");
		BaseClass.highlightElement(bookshelvespagelocator_Obj.storage_Type);
		BaseClass.sleep(2000);
		bookshelvespagelocator_Obj.storage_Type.click();
		BaseClass.highlightElement(bookshelvespagelocator_Obj.open_Type);

		bookshelvespagelocator_Obj.open_Type.click();
		
	}

	//Check for Out Of Stock 
	public boolean CheckOutOfStock() {
		logger.info("Exclude Out of Stock option is displayed");
		return bookshelvespagelocator_Obj.outOfStock_CheckBox.isDisplayed();
	}
	
	//Click Out Of Stock 
	public void ExcludeOutOfStock() {
		
		logger.info("Exclude Out of Stock option is clicked");
		BaseClass.getWait(10).until(ExpectedConditions.elementToBeClickable(bookshelvespagelocator_Obj.outOfStock_CheckBox));
		
		bookshelvespagelocator_Obj.outOfStock_CheckBox.click();

	}
	
	//Check For SortBy DropDown
	public boolean CheckDropDown() {
		logger.info("Sort By drop down is displayed");
		return bookshelvespagelocator_Obj.SortBy_DropDown.isDisplayed();
	}
	
	//House Hover to DropDown
	public void MovetoDropDown() {
		handler.moveToElement(bookshelvespagelocator_Obj.SortBy_DropDown).build().perform();;
	}
	
	//Check For High To Low Option
	public boolean CheckHightoLow() {
		return bookshelvespagelocator_Obj.HighToLow_Option.isDisplayed();
	}
	
	//Click on  High To Low Option
	public void ClickHighToLow() {
		logger.info("High to Low option in Sort By drop down is displayed");
		bookshelvespagelocator_Obj.HighToLow_Option.click();
		BaseClass.highlightElement(bookshelvespagelocator_Obj.HighToLow_Option);
	}


	//Check and return the Results Displayed
	public List<WebElement> ProductName() {

		if(!(bookshelvespagelocator_Obj.HighToLow_Option.isSelected())) {
			BaseClass.sleep(3000);			
		}
		
		try{
			return bookshelvespagelocator_Obj.ProductName;
		}catch(Exception e) {
			logger.info("No Results Found to Display");
			System.out.println("No Results Found to Display");
			return null;
		}
	}
	
	public List<WebElement> PublishedBy() {
		try{
			return bookshelvespagelocator_Obj.PublishedBy;
		}catch(Exception e) {
			logger.info("No Results Found to Display");
			System.out.println("No Results Found to Display");
			return null;
		}
	}
	
	public List<WebElement> DiscountPrice() {
		try{
			return bookshelvespagelocator_Obj.DiscountPrice;
		}catch(Exception e) {
			logger.info("No Results Found to Display");
			System.out.println("No Results Found to Display");
			return null;
		}
	}
	
	public List<WebElement> OriginalPrice() {
		try{
			return bookshelvespagelocator_Obj.OriginalPrice;
		}catch(Exception e) {
			logger.info("No Results Found to Display");
			System.out.println("No Results Found to Display");
			return null;
		}
	}
	
	public List<WebElement> EMI() {
		try{
			return bookshelvespagelocator_Obj.EMiFrom;
		}catch(Exception e) {
			logger.info("No Results Found to Display");
			System.out.println("No Results Found to Display");
			return null;
		}
	}



}






