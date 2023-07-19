package com.test.stepdefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookingCab {
	
	@Given("^User want to select a \"([^\"]*)\" car from Ola Application$")
	public void user_want_to_select_a_car_from_Ola_Application(String arg1) throws Throwable {
	    
	}

	@When("^User select a \"([^\"]*)\" car and destination from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void user_select_a_car_and_destination_from_to(String arg1, String arg2, String arg3) throws Throwable {
	    
	}

	@Then("^Driver start the journey$")
	public void driver_start_the_journey() throws Throwable {
	    
	}

	@Then("^Driver end the journey$")
	public void driver_end_the_journey() throws Throwable {
	    
	}

	@Then("^User pay (\\d+) rs$")
	public void user_pay_rs(int arg1) throws Throwable {
	    
	}



}
