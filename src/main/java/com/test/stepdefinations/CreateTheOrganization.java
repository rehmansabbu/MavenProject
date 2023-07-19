package com.test.stepdefinations;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateTheOrganization {

	static WebDriver driver;
	static JavascriptExecutor js = (JavascriptExecutor)driver;
	
	@Given("^user is on home page$")
	public static void user_is_on_home_page()  {
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

	@When("^user enters username and password$")
	public static void user_enters_username_and_password(DataTable table)  {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    List<List<String>> data=table.raw();
	    
	    WebElement uN = driver.findElement(By.xpath("//input[@id='username']"));
		uN.sendKeys(data.get(0).get(0));
		
		WebElement pW = driver.findElement(By.xpath("//input[@id='password']"));
		pW.sendKeys(data.get(0).get(1));
	}

	@Then("^user click on submit$")
	public static void user_click_on_submit() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		
		Thread.sleep(3000);
		WebElement clicked_Signin= driver.findElement(By.xpath("//button[@class='btn btn-primary sbutton']"));
		System.out.println("SignIn button Is Enabled------------>"+clicked_Signin.isEnabled());
		//js.executeScript("arguments[0].click();", clicked_Signin);
		clicked_Signin.click();
		
	    
	}

	@Then("^user click on organization$")
	public static void user_click_on_organization()  {
	    // Write code here that turns the phrase above into concrete actions
		WebElement clicked_Organization= driver.findElement(By.xpath("//a[@id='menubar_item_Accounts']//strong"));
		clicked_Organization.click();
	}

	@Then("^user click on add organization$")
	public static void user_click_on_add_organization()  {
	    // Write code here that turns the phrase above into concrete actions
		WebElement clicked_AddOrganization= driver.findElement(By.xpath("//button[@id='Accounts_listView_basicAction_LBL_ADD_RECORD']"));
		clicked_AddOrganization.click();
	}

	@Then("^user fill the detail of organization$")
	public static void user_fill_the_detail_of_organization(DataTable table)  {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
		List<List<String>> data=table.raw();
		
		WebElement organizationName= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_accountname']"));
		organizationName.sendKeys(data.get(0).get(0));
		
		WebElement website= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_website']"));
		website.sendKeys(data.get(0).get(1));
		
		WebElement mobileNumber= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_phone']"));
		mobileNumber.sendKeys(data.get(0).get(2));
		
		WebElement mailId= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_email1']"));
		mailId.sendKeys(data.get(0).get(3));
		
		WebElement billingCity= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_bill_city']"));
		billingCity.sendKeys(data.get(0).get(4));
		
		WebElement shipingCity= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_ship_city']"));
		shipingCity.sendKeys(data.get(0).get(5));
		
		WebElement shipingState= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_ship_state']"));
	    shipingState.sendKeys(data.get(0).get(6));
	    
		WebElement country= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_ship_country']"));
		country.sendKeys(data.get(0).get(7));
		
		WebElement description= driver.findElement(By.xpath("//textarea[@name='description']"));
		description.sendKeys(data.get(0).get(8));
		
	    
	}

	@Then("^user click on save$")
	public static void user_click_on_save()  {
	    // Write code here that turns the phrase above into concrete actions
		//WebElement clicked_Save= driver.findElement(By.xpath("//button[@class='btn btn-primary sbutton']"));
	}


	
	
	
}
