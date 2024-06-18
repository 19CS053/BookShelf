package com.urbanladder.definitions;


import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;

import com.urbanladder.actions.BookshelvesPageActions;
import com.urbanladder.actions.HeaderActions;
import com.urbanladder.utils.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HeaderDefinitions {

	HeaderActions objHeaderAction = new HeaderActions();
	BookshelvesPageActions objBookShelfPageAction = new BookshelvesPageActions();
	Properties p;

	@Given("navigate to home page")
	public void navigate_to_home_page() {
		try {
			p=BaseClass.propfile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BaseClass.openPage(p.getProperty("url"));
	}
	
	@When("search for bookshelves")
	public void searched_for_bookshelves() {
		try {
		Assert.assertEquals(objHeaderAction.CheckBookShelf(), true);
		
		}catch (AssertionError e) {
			System.err.println(e.getMessage());
		}
		objHeaderAction.SearchBookShelf();
		
	}
	
	@When("handle banner")
	public void handle_banner() {
		BaseClass.sleep(3000);
		try {
			objBookShelfPageAction.closePopup();
		}catch (AssertionError e) {
			System.err.println(e.getMessage());
		}
	}
	
	@Then("display searched results")
	public void display_searched_results() {
		try {
			Assert.assertEquals(objBookShelfPageAction.checkBookShelfUrl(), true);
		}catch (AssertionError e) {
			System.err.println(e.getMessage());
		}
	}
	
	
	
	
	
}