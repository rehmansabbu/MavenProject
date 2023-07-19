package com.test.stepdefinations;
import java.util.Map;
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

//Data table with Maps : for parametrization.  

public class CreateTheContacts {

	static WebDriver driver;
	static JavascriptExecutor js = (JavascriptExecutor)driver;

 
	@Given("^user is on contacts page$")
	public static void user_is_on_contacts_page()  {
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

	@When("^user give username and password$")
	public static void user_give_username_and_password(DataTable table)  {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		//List<List<String>> data=table.raw();

		//WebElement organizationName= driver.findElement(By.xpath("//input[@id='Accounts_editView_fieldName_accountname']"));
		//organizationName.sendKeys(data.get(0).get(0));


		for( Map<String,String> data : table.asMaps(String.class, String.class)){

			WebElement uN = driver.findElement(By.xpath("//input[@id='username']"));
			uN.sendKeys(data.get("username"));
			WebElement pW = driver.findElement(By.xpath("//input[@id='password']"));
			pW.sendKeys(data.get("password"));
		}

	}


	@Then("^user click on login$")
	public static void user_click_on_login() throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		WebElement clicked_Signin= driver.findElement(By.xpath("//button[@class='btn btn-primary sbutton']"));
		System.out.println("SignIn button Is Enabled------------>"+clicked_Signin.isEnabled());
		//js.executeScript("arguments[0].click();", clicked_Signin);
		clicked_Signin.click();
	}

	@Then("^user click on contacts$")
	public static void user_click_on_contacts()  {
		// Write code here that turns the phrase above into concrete actions
		WebElement contacts=driver.findElement(By.xpath("//a[@id='menubar_item_Contacts']//strong"));
		contacts.click();
	}

	@Then("^user click on add contacts$")
	public static void user_click_on_add_contacts()  {
		// Write code here that turns the phrase above into concrete actions
		WebElement addContacts=driver.findElement(By.xpath("//strong[contains(text(),'Add Contact')]"));
		addContacts.click();
	}

	@Then("^user fill the detail of contacts$")
	public static void user_fill_the_detail_of_contacts(DataTable table)  {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)

		for( Map<String,String> data : table.asMaps(String.class, String.class))
		{

			WebElement firstname=driver.findElement(By.xpath("//input[@id='Contacts_editView_fieldName_firstname']"));
			firstname.sendKeys(data.get("firstname"));

			WebElement lastname=driver.findElement(By.xpath("//input[@id='Contacts_editView_fieldName_lastname']"));
			lastname.sendKeys(data.get("lastname"));

			WebElement mobileno=driver.findElement(By.xpath("//input[@id='Contacts_editView_fieldName_mobile']"));
			mobileno.sendKeys(data.get("mobileno"));

			WebElement emailid =driver.findElement(By.xpath("//input[@id='Contacts_editView_fieldName_email']"));
			emailid.sendKeys(data.get("emailid"));

			WebElement mailingcity=driver.findElement(By.xpath("//input[@id='Contacts_editView_fieldName_mailingcity']"));
			mailingcity.sendKeys(data.get("mailingcity"));

			WebElement mailingstate=driver.findElement(By.xpath("//input[@id='Contacts_editView_fieldName_mailingstate']"));
			mailingstate.sendKeys(data.get("mailingstate"));

			WebElement mailingcountry=driver.findElement(By.xpath("//input[@id='Contacts_editView_fieldName_mailingcountry']"));
			mailingcountry.sendKeys(data.get("mailingcountry"));

			WebElement description=driver.findElement(By.xpath("//textarea[@name='description']"));
			description.sendKeys(data.get("description"));

		}
	}

	@Then("^click on save$")
	public static void click_on_save()  {
		// Write code here that turns the phrase above into concrete actions
		//WebElement clicked_Save= driver.findElement(By.xpath("//button[@class='btn btn-primary sbutton']"));
	}

}
