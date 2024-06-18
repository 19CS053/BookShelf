package com.urbanladder.definitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.urbanladder.actions.BookshelvesPageActions;
import com.urbanladder.actions.HeaderActions;
import com.urbanladder.utils.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookShelvesDefinitions {

	List<WebElement>ProductName = null;
	List<WebElement>PublishedBy = null;
	List<WebElement>DiscountPrice = null;
	List<WebElement>OriginalPrice = null;
	List<WebElement>EMiFrom = null;
	
	HeaderActions objHeaderAction = new HeaderActions();
	BookshelvesPageActions bookshelvespageactionsObj= new BookshelvesPageActions();
	
	@Given("Filter  Bookshelves below Rs15000")
	public void filter_bookshelves_below_rs() {
		
			bookshelvespageactionsObj.MovetoPrizeFilter();
			bookshelvespageactionsObj.DragAndSet();
		
		
	}
	
	@Given("exclude out of stock")
	public void exclude_out_of_stock() {
		BaseClass.sleep(2000);
		bookshelvespageactionsObj.ExcludeOutOfStock();
		
	}

	@Given("Select storage type open")
	public void select_storage_type_open() {
		BaseClass.sleep(2000);
		bookshelvespageactionsObj.selectStorageOpen();
		
	}
	
	@Given("Sort by price High to Low")
	public void sort_by_price() {
		BaseClass.sleep(2000);
		bookshelvespageactionsObj.MovetoDropDown();
		bookshelvespageactionsObj.ClickHighToLow();
		
	}
	
	@When("fetched the items")
	public void fetched_the_top_items() {
		
		ProductName = bookshelvespageactionsObj.ProductName();
		PublishedBy =bookshelvespageactionsObj.PublishedBy();
		DiscountPrice =bookshelvespageactionsObj.DiscountPrice();
		OriginalPrice =bookshelvespageactionsObj.OriginalPrice();
		EMiFrom = bookshelvespageactionsObj.EMI();
	}
	
	@Then("print all details in console output")
	public void print_all_details_in_console_output() {
		
		for(int i=0,j=1;i<3;i++,j++) {
			System.out.println(j+")Product Name: "+ProductName.get(i).getText());
			System.out.println("Published By: "+PublishedBy.get(i).getText());
			System.out.println("DiscountPrice: "+DiscountPrice.get(i).getText());
			System.out.println("OriginalPrice: "+OriginalPrice.get(i).getText());
			System.out.println("EMi From "+EMiFrom.get(i).getText()+"\n");
			}
//		BaseClass.sleep(5000);
	}
	
	@When("retrieve any one SubMenu data from living menu")
	public void LivingSubMenu(){
//		BaseClass.sleep(3000);
		objHeaderAction.MoveToLivngLabel();
		List<WebElement> chairList = objHeaderAction.ChairList();
		for (int i=0;i<chairList.size();i++) {
			System.out.println(i+1+")Chair SubMenu: " + chairList.get(i).getText());
		}
	}
}
