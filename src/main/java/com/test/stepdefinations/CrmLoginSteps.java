package com.test.stepdefinations;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CrmLoginSteps {

	static WebDriver driver;
	static JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@Given("^user is on crm login home page$")
	public static void user_is_on_crm_login_home_page()  {
	    // Write code here that turns the phrase above into concrete actions
	    System.setProperty("webdriver.chrome.driver", "sourceFile\\chromeDriver\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("http://localhost:8888/index.php");
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
		
	    //verify Login to Vtiger CRM
	    
	    WebElement login_To_Vtiger_CRM = driver.findElement(By.xpath("//h3[contains(text(),'Login to Vtiger CRM')]"));
	    String login_To_Vtiger_CRM_Text = login_To_Vtiger_CRM.getText();
	    System.out.println(login_To_Vtiger_CRM_Text);
	    Assert.assertEquals(login_To_Vtiger_CRM_Text, "Login to Vtiger CRM");    
	    
	}
     // regular expression
	// 1  \"(.*)\"
	// 2  \"([^\"]*)\"
	
	//@When("^user enter \"(.*)\" and \"(.*)\" $")
	@When("^user enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public static void user_enter_username_password(String username , String password)  {
	    // Write code here that turns the phrase above into concrete actions
	    // This is harcoded value so how i will achive Data driven value in cucumber--->
		
		
		WebElement uN = driver.findElement(By.xpath("//input[@id='username']"));
		uN.sendKeys(username);
		WebElement pW = driver.findElement(By.xpath("//input[@id='password']"));
		pW.sendKeys(password);
		
		// i have remove the harcoded value from here
		
		
	}
	
	@And("^user click on login signin button$")
	public static void user_click_on_login_signin_button() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	    
		Thread.sleep(3000);
		WebElement clicked_Signin= driver.findElement(By.xpath("//button[@class='btn btn-primary sbutton']"));
		System.out.println("SignIn button Is Enabled------------>"+clicked_Signin.isEnabled());
		//js.executeScript("arguments[0].click();", clicked_Signin);
		  clicked_Signin.click();
	}

	@Then("^user should be on crm home page$")
	public static void user_should_be_on_crm_home_page()  {
	    // Write code here that turns the phrase above into concrete actions
	    
		// verify login home page
	    String url=driver.getCurrentUrl();
	    System.out.println(url);
	    Assert.assertEquals("Not match", url, "http://localhost:8888/index.php");
		
		
		// Verify Home Page
	     WebElement leads = driver.findElement(By.xpath("//strong[contains(text(),'Leads')]"));
		 String leads_Text=leads.getText();
	     System.out.println("Text value is::"+leads_Text +"::Is displayed::"+ leads.isDisplayed());
		
	}
	
	
	@Given("^user is on already leads$")
	public static void user_is_on_already_leads()  {
	    // Write code here that turns the phrase above into concrete actions
		
		// Verify Lead Tab
		
				WebElement leads = driver.findElement(By.xpath("//strong[contains(text(),'Leads')]"));
				 String leads_Text=leads.getText();
			     System.out.println("Text value is::"+leads_Text +"::Is displayed::"+ leads.isDisplayed());
		
	}

	@When("^user click on leads$")
	public static void user_click_on_leads() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement clicked_Onleads = driver.findElement(By.xpath("//strong[contains(text(),'Leads')]"));
		//js.executeScript("arguments[0].click();", clicked_Onleads);
		clicked_Onleads.click();
		Thread.sleep(2000);
		//System.out.println("Leads IsEnabled::"+clicked_Onleads.isDisplayed());
		
	}

	@And("^user will create the leads , click on addlead$")
	public static void user_will_create_the_leads_click_on_addlead()  {
	    // Write code here that turns the phrase above into concrete actions
	   
		//Verify after click on leads should be on leads page
		WebElement add_Lead =driver.findElement(By.xpath("//button[@class='btn addButton']//strong"));
		System.out.println("Button IsEnabled::" +add_Lead.isDisplayed()+ "::Text field is::" +add_Lead.getText());	
		
		
		//Click on Add lead
		add_Lead.click();
		//js.executeScript("arguments[0].click();", add_Lead);
		
	}

	@And("^user should be on creating new lead page$")
	public static void user_should_be_on_creating_new_lead_page() {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement creating_NewLeads_Page=driver.findElement(By.xpath("//h3[contains(text(),'Creating New Lead')]"));
	    System.out.println("Is Displayed::" +creating_NewLeads_Page.isDisplayed() + "::Text Value is ::"+creating_NewLeads_Page.getText());
	    
	}

	@And("user will fill the detail of lead <\"([^\"]*)\">$")
	public static void user_will_fill_the_detail_of_lead(String firstName)  {
	    // Write code here that turns the phrase above into concrete actions
		
		WebElement fName=driver.findElement(By.xpath("//input[@id='Leads_editView_fieldName_firstname']"));
	    fName.sendKeys(firstName);
	}

	@And("^user will click on save button$")
	public static void user_will_click_on_save_button() {
		
		
		
	}
	
	
	@Then("^user will close the browser$")
	public static void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		//driver.close();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
