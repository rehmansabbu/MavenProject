package com.test.stepdefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchTheProductOnAmazon {
	
	@Given("^I have search field on amazon page$")
	public void i_have_search_field_on_amazon_page() throws Throwable {
	    
	}
	
	

	@When("^I search a product with name \"([^\"]*)\" and price (\\d+)$")
	public void i_search_a_product_with_name_and_price(String laptopBrand, int price ) throws Throwable {
	    
	}

	
	@Then("^Product with name \"([^\"]*)\" should be displayed$")
	public void product_with_name_should_be_displayed(String arg1) throws Throwable {
	    
	}


}
