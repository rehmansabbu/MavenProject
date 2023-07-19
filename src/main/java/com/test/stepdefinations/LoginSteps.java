package com.test.stepdefinations;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.test.dataread.GetDataFromExcel;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class LoginSteps {





	public static void disableWarning() {
		System.err.close();
		System.setErr(System.out);
	}


	GetDataFromExcel dataFromExcel;

	static WebDriver driver;
	String chrome_Path="sourceFile\\chromeDriver\\chromedriver.exe";



	@Given("^user is on login home page$")
	public void user_is_on_login_home_page() throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions

		System.setProperty("webdriver.chrome.driver", chrome_Path);
		driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}


	@When("^user click on login button$")
	public void user_click_on_login_button() throws InterruptedException  {

		// Write code here that turns the phrase above into concrete actions

		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click(); // Click on Cancel

		Thread.sleep(2000);



		driver.navigate().refresh();

		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click(); // Click on Login


	}

	@And("^user enter username , password$")
	public void user_enter_username_password()  {	

		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys("rehmansabbu@gmail.com");
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys("sabbu_78688");

		//JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("document.('elementID').setAttribute('value', 'new value for element'"))


	}

	@And("^user click on submit button$")
	public void user_click_on_submit_button() throws InterruptedException  {

		Thread.sleep(3000);

		JavascriptExecutor js= (JavascriptExecutor)driver; Thread.sleep(3000);
		WebElement button=driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']"));
		js.executeScript("arguments[0].click();", button);
	}

	@Then("^user should be on login home page$")
	public void user_should_be_on_login_home_page()  {
		// Write code here that turns the phrase above into concrete actions

		String homeUrl=driver.getCurrentUrl();

		System.out.println("user should be on login home page   ------------>"+homeUrl);
		Assert.assertEquals("Not matched", homeUrl, "https://www.flipkart.com/");


		WebElement verify_HomePageImage=driver.findElement(By.xpath("//a[@class='_33x-Wq']"));
		String homePage=verify_HomePageImage.getText();
		System.out.println("user should be on login home page   ------------>" +homePage);
		Assert.assertEquals("Not Matched",homePage,"Explore Plus");


	}

	@Given("^user can search and purchase the item$")
	public static void user_can_search_and_purchase_the_item() throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(4000);

		WebElement searchForProduct_Brand=driver.findElement(By.xpath("//input[@class='LM6RPg']"));
		searchForProduct_Brand.sendKeys("Mobiles");



		Thread.sleep(2000); searchForProduct_Brand.clear();
		searchForProduct_Brand.sendKeys("Mobiles"); Actions act= new Actions(driver);
		act.sendKeys(Keys.DOWN).perform(); Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();

		Thread.sleep(2000);




		List<WebElement>item_List=driver.findElements(By.xpath("//ul[@class='col-12-12 _1PBbw8']//li[@class='_1va75j']"));
		int item_List_Size=item_List.size();
		System.out.println("size of item -------->  "+item_List_Size);

		for(int i =1 ;i<item_List_Size;i++)
		{
			String the_List_Of_Item_Is =item_List.get(i).getText();
			System.out.println(the_List_Of_Item_Is);


			if(the_List_Of_Item_Is.equalsIgnoreCase("Mobiles")) {

				item_List.get(i).click(); 
				System.out.println("Item of Mobile is Available");
				break;
			}	 	  

		}
		Thread.sleep(2000);
		driver.navigate().back();

	}

	@When("^user keep the cursor on men tab item$")
	public static void user_keep_the_cursor_on_men_tab_item() throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		Actions mouse_Over=new Actions(driver);
		WebElement men_Xpath=driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		mouse_Over.moveToElement(men_Xpath).build().perform();

		String men_locator= men_Xpath.getText();
		System.out.println(men_locator);
		Assert.assertEquals("Not Matched",men_locator,"Men");   

	}

	@And("^user is select and click men item jeans$")
	public static void user_is_select_and_click_men_item_jeans() {
		// Write code here that turns the phrase above into concrete actions

		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement clickOnItem=driver.findElement(By.linkText("Jeans"));
		js.executeScript("arguments[0].click();", clickOnItem);

		//Verify jeans page

		String jeans_title = driver.getTitle();
		System.out.println(jeans_title);
		//Assert.assertEquals(jeans_title,"Buy Stylish Mens Jeans Online at Low prices | Low Waist Jeans, Skinny Jeans &amp; More | Flipkart.com" ,"Not matched");	
		if(jeans_title.contains("Buy Stylish Mens Jeans Online at Low prices"))
		{
			System.out.println("Matched");
		}

		else
			System.out.println("Not Matched");

	}

	@And("^user is on selected item mens jeans$")
	public static void user_is_on_selected_item_mens_jeans()  {
		// Write code here that turns the phrase above into concrete actions

		String url=driver.getCurrentUrl();
		System.out.println("current url is------------>"+url);
		//Assert.assertEquals(url, "https://www.flipkart.com/mens-jeans/pr?sid=clo%2Cvua%2Ck58%2Ci51&otracker=undefined_footer_footer\r\n" );

		//availabality of jeans
		WebElement mens_JeansXpath=driver.findElement(By.xpath("//h1[contains(text(),\"Men's Jeans\")]"));
		System.out.println("The Text value is------>  "+mens_JeansXpath.getText());

		boolean displayed = mens_JeansXpath.isDisplayed();
		System.out.println("The Text value IsDisplayed ------> " +displayed);

	}

	@SuppressWarnings("static-access")
	@Then("^user will check popularity,price low to high,price high to low and newest first$")
	public static void user_will_check_popularity_price_low_to_high_price_high_to_low_and_newest_first() throws InterruptedException  {
		// Write code here that turns the phrase above into concrete actions

		WebElement popularity_Xpath=driver.findElement(By.xpath("//div[contains(text(),'Popularity')]"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", popularity_Xpath);
		Thread.sleep(2000);

		WebElement priceLowToHigh_Xpath=driver.findElement(By.xpath("//div[contains(text(),'Price -- Low to High')]"));
		js.executeScript("arguments[0].click();", priceLowToHigh_Xpath);
		Thread.sleep(2000);


		WebElement priceHighToLow_Xpath=driver.findElement(By.xpath("//div[contains(text(),'Price -- High to Low')]"));
		js.executeScript("arguments[0].click();", priceHighToLow_Xpath);
		Thread.sleep(2000);




		WebElement newestFirst_Xpath=driver.findElement(By.xpath("//div[contains(text(),'Newest First')]"));
		@SuppressWarnings("deprecation")

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(newestFirst_Xpath));
		js.executeScript("arguments[0].click();", newestFirst_Xpath);

		Thread.sleep(2000);

		js.executeScript("arguments[0].click();", popularity_Xpath);



		//scroll
		//js.executeScript("window.scrollBy(0,1500)");


		//select the item for purchase

		Thread.sleep(2000);
		List<WebElement>lst=driver.findElements(By.xpath("//ul/li[@class='_3qdW4F']"));

		System.out.println("The size of item is ---------->"+lst.size());

		for(int i=0;i<=lst.size();i++)
		{
			String theListIs =lst.get(i).getText();
			System.out.println(theListIs);

			if(theListIs.equalsIgnoreCase("Fabric: Cotton Blend"))
			{
				lst.get(i).click();
				System.out.println("Selected element is --->"+i);
				break;
			}



		}


		Thread.sleep(2000);
		WebElement selected_Item = driver.findElement(By.xpath("//div[contains(text(),'2.')]"));
		js.executeScript("arguments[0].click();",selected_Item);


		// Switch to Other Window

		Set<String> windowId =driver.getWindowHandles();

		Iterator<String>itr= windowId.iterator();

		String parentWindow=itr.next();
		System.out.println("Parent Window url-------> " +driver.getCurrentUrl());

		String childWindow=itr.next();
		driver.switchTo().window(childWindow);
		System.out.println("Child Window url-------> " +driver.getCurrentUrl());

		//scroll
		JavascriptExecutor js1= (JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,500)", "");


		Thread.sleep(2000);
		WebElement clickOnDeliverTo_Xpath=driver.findElement(By.xpath("//div[@class='_2LG8B7']"));
		js.executeScript("arguments[0].click();",clickOnDeliverTo_Xpath );

		Thread.sleep(2000);
		WebElement enterDeliverPincode_Xpath=driver.findElement(By.xpath("//input[@class='_20PCkk']"));
		enterDeliverPincode_Xpath.sendKeys("829122");

		Thread.sleep(2000);
		WebElement checkDelivery_Xpath=driver.findElement(By.xpath("//span[contains(text(),'Check')]"));
		js.executeScript("arguments[0].click();",checkDelivery_Xpath );


		selectSize();




	} 

	public static void selectSize()
	{
		//----------size of item Availablity is --------
		List<WebElement> sizeOfItemList=driver.findElements(By.xpath("//div[@class='_2a2WU_']//ul[@class='fUBI-_']//li[@class='_3hSwtk _2UBURg']"));
		//ul[@class='fUBI-_']//li[@class='_3hSwtk _2UBURg']

		System.out.println("size is--->"+sizeOfItemList.size());


		for(int i=0;i<=sizeOfItemList.size(); i++)
		{

			String sizeOfItem=sizeOfItemList.get(i).getText();
			System.out.println("Size of item Availablity is-------> "+sizeOfItem);
			// int size=Integer.parseInt(sizeOfItem);
			//System.out.println("size------>"+size);

			try {
				if( sizeOfItemList.get(i).isEnabled()) {


					Thread.sleep(8000);
					//WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(4));
					// boolean invisible =wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath( "//div[@class='_1g90e7'")));
					// if (invisible) {

					sizeOfItemList.get(i).click();
					break;

				}
			}


			catch(Exception e){


				System.out.println("Not clicked by" +e.getMessage());



			}
		}

	}
}




