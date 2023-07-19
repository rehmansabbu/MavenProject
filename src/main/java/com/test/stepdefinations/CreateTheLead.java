package com.test.stepdefinations;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.test.browsersetup.Browser;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTheLead extends Browser {
    
	
	

	@Given("^user is on crm home page$")
	public static void user_is_on_crm_home_page() throws IOException  {
		
           launchBrowser();
	}
     
	
	@When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public static void user_enters_and(String username, String password) throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
        Thread.sleep(2000);
		WebElement uN = driver.findElement(By.xpath("//input[@id='username']"));
		uN.sendKeys(username);
		WebElement pW = driver.findElement(By.xpath("//input[@id='password']"));
		pW.sendKeys(password);
	}


	@Then("^click on login button$")
	public static void click_on_login_button() throws InterruptedException, IOException  {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		WebElement clicked_Signin= driver.findElement(By.xpath("//button[@class='btn btn-primary sbutton']"));
		System.out.println("SignIn button Is Enabled------------>"+clicked_Signin.isEnabled());
		//js.executeScript("arguments[0].click();", clicked_Signin);
		clicked_Signin.click();
		commonUtil.click(driver, "", "fieldName");
		commonUtil.click(driver, "");
	}

	@Then("^user click on leads page$")
	public static void user_click_on_leads_page() throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions

		WebElement clicked_Onleads = driver.findElement(By.xpath("//strong[contains(text(),'Leads')]"));
		//js.executeScript("arguments[0].click();", clicked_Onleads);
		clicked_Onleads.click();
		Thread.sleep(2000);
		//System.out.println("Leads IsEnabled::"+clicked_Onleads.isDisplayed());

	}

	@Then("^user move and click on addlead$")
	public static void user_move_and_click_on_addlead()  {
		// Write code here that turns the phrase above into concrete actions
		//Verify after click on leads should be on leads page
		WebElement add_Lead =driver.findElement(By.xpath("//button[@class='btn addButton']//strong"));
		System.out.println("Button IsEnabled::" +add_Lead.isDisplayed()+ "::Text field is::" +add_Lead.getText());	


		//Click on Add lead
		add_Lead.click();
		//js.executeScript("arguments[0].click();", add_Lead);
	}

	
	@Then("^user fill leads detail \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and  \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public static void user_fill_leads_detail(String firstname,String lastname,String company,String mobile,String designation,String email,String city,String country,String state ,String description)  
	{
		// Write code here that turns the phrase above into concrete actions
		WebElement fName=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_firstname']"));
	    fName.sendKeys(firstname);
	    
	    WebElement lName=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_lastname']"));
	    lName.sendKeys(lastname);
	    
	    WebElement fieldName_company=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_company']"));
	    fieldName_company.sendKeys(company);
	    
	    WebElement fieldName_mobile=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_mobile']"));
	    fieldName_mobile.sendKeys(mobile);
	    
	    WebElement fieldName_designation=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_designation']"));
	    fieldName_designation.sendKeys(designation);
	    
	    WebElement fieldName_email=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_email']"));
	    fieldName_email.sendKeys(email);
	    
	    WebElement fieldName_city=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_city']"));
	    fieldName_city.sendKeys(city);
	    
	    WebElement fieldName_country=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_country']"));
	    fieldName_country.sendKeys(country);
	    
	    WebElement fieldName_state=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_state']"));
	    fieldName_state.sendKeys(state);
	    
	    WebElement fieldName_description=driver.findElement(By.xpath("//textarea[@id='Leads_editView_fieldName_description']"));
	    fieldName_description.sendKeys(description);
	    
	    
	}

	@Then("^user click on save button$")
	public static void user_click_on_save_button()  {
		// Write code here that turns the phrase above into concrete actions
		WebElement save=driver.findElement(By.xpath("//button[@class='btn btn-success']"));
		//save.click();
	}

	@Then("^close the browser$")
	public static void close_the_browser() throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions

		Thread.sleep(5000);
		//driver.close();
		
	}





}
