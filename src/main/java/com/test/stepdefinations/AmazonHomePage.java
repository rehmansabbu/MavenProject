package com.test.stepdefinations;

import java.util.List;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AmazonHomePage {
	@Given("^Amazon is on home page$")
	public void amazon_is_on_home_page() throws Throwable {

	}

	@Then("^User gets Amazon search fields$")
	public void user_gets_Amazon_search_fields() throws Throwable {

	}

	@Then("^Username is displayed side to the search field$")
	public void username_is_displayed_side_to_the_search_field() throws Throwable {

	}

	@Then("^Cart is displayed on home page$")
	public void cart_is_displayed_on_home_page() throws Throwable {

	}

	@Then("^Amazon link and logo is displayed$")
	public void amazon_link_and_logo_is_displayed() throws Throwable {

	}

	@When("^User scroll down for today delas section$")
	public void user_scroll_down_for_today_delas_section() throws Throwable {

	}

	@Then("^User gets the list of the multiple products$")
	public void user_gets_the_list_of_the_multiple_products() throws Throwable {

	}

	@Then("^User gets product image and price details$")
	public void user_gets_product_image_and_price_details() throws Throwable {

	}

	@Then("^User can see more product$")
	public void user_can_see_more_product() throws Throwable {

	}

	@When("^User scroll down to the footer page$")
	public void user_scroll_down_to_the_footer_page() throws Throwable {

	}

	@Then("^User gets all the country links$")
	public void user_gets_all_the_country_links(DataTable dataTable)  {
		List<List<String>> countryList=dataTable.asList(null); 

		System.out.println(countryList);
	}

	@Then("^User gets all the Amazon service link$")
	public void user_gets_all_the_Amazon_service_link(DataTable dataTable)  {

		List<List<String>>serviceLink=dataTable.asList(null); 

		System.out.println(serviceLink);

	}


}
