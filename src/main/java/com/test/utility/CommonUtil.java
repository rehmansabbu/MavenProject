package com.test.utility;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.test.browsersetup.Browser;


public class CommonUtil extends Browser{


	static
	{

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));
	}

	public static void uploadDucument(WebDriver driver , String locatorUploadDocument , String locations , String locatorTermNconditions , String buttonLocator , String fieldName)
	{

		try {


			log.info("!!Uplaod Documnet!!");
			WebElement uploadElement = driver.findElement(By.xpath(locatorUploadDocument));
			uploadElement.sendKeys(locations);

			// I Accept the Term & Conditions
			driver.findElement(By.xpath(locatorTermNconditions)).click();

			// click the "UploadFile" button
			driver.findElement(By.xpath(buttonLocator));
			log.info("!!Sucessfully Upload!!");


		}

		catch (Exception e)
		{

			System.out.println("Error While Uploading a File!!!" + e.getMessage());
			log.error("Error While Uploading a File!!!" + e.getMessage());

		}

	}


	public static void clickAndHold(WebDriver driver  , String locator , String fieldName)
	{
		//Actions action = new Actions(driver);

	}

	//Double click
	public static void doubleClick(WebDriver driver  , String locatorForDoubleClick , String fieldName)
	{

		try {

			log.info("Double Click");

			Actions actions = new Actions(driver);
			WebElement btnElement=driver.findElement(By.xpath(locatorForDoubleClick));
			actions.doubleClick(btnElement).perform();


			log.info("Double click Menu");
			System.out.println("Double click Menu");

			// Accept the Alert 
			driver.switchTo().alert().accept();


			log.info("Double click Alert Accepted");
			System.out.println("Double click Alert Accepted");
		} 

		catch (Exception e)
		{
			log.info("Error while Double Click -->" +e.getMessage());
			System.out.println("Error while Double Click -->" +e.getMessage());
		}



	}

	//Right click on mouse Action
	public static void contextClick(WebDriver driver  , String locatorForRightClick , String locatorForRightClickPopup, String fieldName)
	{
		try 
		{
			log.info("Right click Context Menu");

			Actions actions = new Actions(driver);
			WebElement btnElement=driver.findElement(By.xpath(locatorForRightClick));
			actions.contextClick(btnElement).perform();


			log.info("Right click Context Menu displayed");
			System.out.println("Right click Context Menu displayed");

			WebElement rightClickPopup=driver.findElement(By.xpath(locatorForRightClickPopup));
			rightClickPopup.click();

			// Accept the Alert 
			driver.switchTo().alert().accept();


			log.info("Right click Alert Accepted");
			System.out.println("Right click Alert Accepted");



		}

		catch (Exception e)
		{
			System.out.println("Error while Right click Context Menu !!!"+e.getMessage());
			log.error("Error while Right click Context Menu !!!"+e.getMessage());
		}

	}

	public static void dragNdrop(WebDriver driver  , String locatorFrom , String locatorTo , String fieldName)
	{
		try 
		{
			log.info("Drag-N-Drop");
			Actions builder = new Actions(driver);

			WebElement from = driver.findElement(By.xpath(locatorFrom));
			WebElement to = driver.findElement(By.xpath(locatorTo));

			builder.dragAndDrop(from , to).perform();

			String textTo = to.getText();

			log.info(textTo);
		}

		catch (Exception e) 
		{

			System.out.println("Error while Drag-N-Drop !!! " +e.getMessage());
			log.error("Error while Drag-N-Drop !!! " +e.getMessage());
		}

	}





	public static void moveToElement(WebDriver driver  ,  String locator  ,  String fieldName)
	{
		try
		{

			Actions actions = new Actions(driver);
			actions.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
			System.out.println("Sucessfully Mouse Over & Move The Element " +fieldName);
			log.info("Sucessfully Mouse Over & Move The Element" +fieldName);

		}

		catch (Exception e)

		{

			System.out.println("Error While MoveToElement" +e.getMessage());
			log.error("Error While MoveToElement" +e.getMessage());
		}

	}


	public static String getCurrentDateTime() throws IOException
	{   
		//log.info("Date and Time");
		DateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy h-m-s");
		Date currentDate = new Date();
		//log.pass("Pass date and Time::" +getCurrentDateTime());
		return DateFormat.format(currentDate);

	}

	public static String failedTakeScreenshort(String testMethodName ) throws IOException
	{
		log.info("Failed Take ScreenShort");
		log.info("Failed Take ScreenShort");
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshortPath=System.getProperty("user.dir") + "/Reports/screenshort/"  +"_"+ testMethodName + " " + getCurrentDateTime() + ".jpg";

		try 
		{
			//FileHandler.copy(srcFile, new File("reports\\screenshort\\" +""+ testMethodName + "  " + getCurrentDateTime() +".jpg"));
			FileHandler.copy(srcFile, new File(screenshortPath));			
			log.info("PASS failedTakeScreenshort"+screenshortPath);

		}

		catch(IOException e)
		{
			e.printStackTrace();	
			System.out.println("While not capturing the ScreenShort::"+e.getMessage());
			log.info("While not capturing the ScreenShort::"+e.getMessage());

		}
		return screenshortPath;

	}

	public static void enterData(WebDriver driver, String locator, String inputData, String fieldName) throws IOException
	{
		try {
			log.info("Entering The Data In TextField");
			log.info("Entering The Data In TextField");
			driver.findElement(By.xpath(locator)).sendKeys(inputData);
			System.out.println(locator +" : Entered : "+inputData);

			log.info("Entered Data in Text Field::"+inputData);
		} 

		catch (Exception e) {

			System.out.println("Error while intering the text !!! " +e.getMessage());


			log.error("Error while intering the text !!!" + "::"

					+ MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("enterData")).build());

		}
	}


	public static void click(WebDriver driver,String locator, String fieldName) throws IOException
	{
		try {
			log.info("Clicked");
			driver.findElement(By.xpath(locator)).click();

			System.out.println(locator +"  Clicked : "+fieldName);
			log.info(locator +"Pass Clicked : "+fieldName);
		} 

		catch (Exception e)
		{
			System.out.println("Error While Clicked!!!"+e.getMessage());
			log.error("Error While Clicked!!!"+e.getMessage() +" ::::" 
					+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("click")).build());



		}
	}
	
	public static void click(WebDriver driver,String locator) throws IOException
	{
		try {
			log.info("Clicked");
			driver.findElement(By.xpath(locator)).click();

			System.out.println(locator +"  Clicked : ");
			log.info(locator +"Pass Clicked : ");
		} 

		catch (Exception e)
		{
			System.out.println("Error While Clicked!!!"+e.getMessage());
			log.error("Error While Clicked!!!"+e.getMessage() +" ::::" 
					+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("click")).build());



		}
	}


	public static void pageLoad(WebDriver driver) throws IOException
	{
		try 
		{
			log.info("pageLoad");
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

		}

		catch (Exception e) 
		{
			System.out.println("Error while pageLoadTimeout!!!"+e.getMessage());
			log.error("Error while pageLoadTimeout!!!"+e.getMessage() + " :: "+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("pageLoad")).build());

		}
	}

	public static String getText(WebDriver driver, String locator, String fieldName) throws IOException
	{
		String actualValue = "";
		try {

			log.info("GET TEXT");
			WebElement text = driver.findElement(By.xpath(locator));
			actualValue = text.getText();
			System.out.println("The Text file and value is:::"+actualValue);
			log.info("Locator : " +locator+ "actual value : " +actualValue);


		} catch (Exception e) {

			System.out.println("Error while getText"+e.getMessage());
			log.error("Error while getText"+e.getMessage() + "::" +MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("getText")).build());

		}
		return actualValue;

	}

	public static void textValidation(WebDriver driver, String locator, String expectedValue , String fieldName) throws IOException
	{

		try {
			log.info("Text Validation");
			log.info("Text Validation");
			String actualValue = driver.findElement(By.xpath(locator)).getText();
			System.out.println(actualValue);

			if(actualValue.equalsIgnoreCase(expectedValue)) 
			{
				Assert.assertEquals(actualValue, expectedValue, "Doesn't match value fomr application ");
				System.out.println(locator+ " : " +actualValue+ " : " +expectedValue);
				log.info(locator+ " : " +actualValue+ " : " +expectedValue);
			}

		}
		catch (Exception e) {
			System.out.println("Error while textValidation!!!"+e.getMessage());
			log.error("Error while textValidation::"+e.getMessage() +"::"+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("textValidation")).build());
		}

	}

	public static void labelTextValidation(String actualValue, String expectedValue , String fieldName) throws IOException
	{

		try {
			log.info("Label Text Validation");
			log.info("Label Text Validation");
			if(actualValue.equalsIgnoreCase(expectedValue)) 
			{
				Assert.assertEquals(actualValue, expectedValue, "Doesn't match value fomr application ");
				log.info(actualValue+ " : " +expectedValue);
			}

		}
		catch (Exception e) 
		{
			System.out.println("Error while textValidation!!!"+e.getMessage());
			log.error("Error while textValidation!!!"+e.getMessage() +"::"+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("labelTextValidation")).build());

		}

	}

	public static void urlValidation(WebDriver driver, String expectedURL) throws IOException
	{

		try {
			log.info("URL Validation");
			log.info("URL Validation");
			String actualURL = driver.getCurrentUrl();
			if(actualURL.equalsIgnoreCase(expectedURL))
			{
				Assert.assertEquals(actualURL, expectedURL, "Doesn't match the url");
				System.out.println(actualURL+ " : " +expectedURL);
				log.info(actualURL+ " : " +expectedURL);

			}

		}
		catch (Exception e) {

			System.out.println("Error while URL Validation!!!"+e.getMessage());
			log.error("Error while URL Validation!!!" +e.getMessage() +"::" +MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("urlValidation")).build());

		}

	}

	public static String getAttribute(WebDriver driver , String locator ,  String attributeValue , String fieldName) throws IOException
	{   

		String attribute = "";

		try {
			log.info("Get Attribute");
			log.info("Get Attribute");
			WebElement elementLocator = driver.findElement(By.xpath(locator));
			attribute = elementLocator.getAttribute(attributeValue);
			System.out.println("The Attribute value is!!!" + attribute);
			log.info("The Attribute value is!!!" + attribute);

		} 
		catch (Exception e) 
		{

			System.out.println("Error while getAttribute!!!"+e.getMessage());
			log.error("Error while getAttribute!!!"+e.getMessage() +"::" +MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("getAttribute")).build());
		}
		return attribute;

	}

	public static Boolean isDisplayed(WebDriver driver , String locator , String fieldName ) throws IOException
	{

		Boolean actualValue = null;
		try {
			log.info("Is Displayed");
			log.info("Is Displayed");

			WebElement valueIs=driver.findElement(By.xpath(locator));
			actualValue=valueIs.isDisplayed();
			System.out.println("Element is displayed for : " +locator+ " "+ fieldName);
			Assert.assertTrue(actualValue);

			log.info("Element is displayed for : " +locator+ " "+ fieldName);

		}
		catch (Exception e)
		{

			Assert.fail("Elements not available !!!"+e.getMessage());
			log.error("Elements not available !!!" +e.getMessage() +"::"+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("isDisplayed")).build());

		}
		return actualValue;
	}

	public static Boolean isEnabled(WebDriver driver , String locator, String fieldName) throws IOException
	{
		Boolean checkButtonIsEnabled=null;

		try 
		{
			log.info("Is Enabled");
			log.info("Is Enabled");
			WebElement button=driver.findElement(By.xpath(locator));
			checkButtonIsEnabled = button.isEnabled();
			System.out.println("The button is :: " +checkButtonIsEnabled);
			log.info("The button is :: " +checkButtonIsEnabled);


			if (checkButtonIsEnabled == true) 
			{
				System.out.println("Button is enabled");
				log.info("Button is enabled");
			}

			// Check if Save button is not enabled on the WebPage

			else if (checkButtonIsEnabled == false)
			{

				System.out.println("Button is Not enabled");
				log.info("Button is Not enabled");
			}
		}

		catch (Exception e)
		{
			System.out.println("Error while isEnabled !!!"+e.getMessage());
			log.error("Error while isEnabled !!!"+e.getMessage() +"::"+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("isDisplayed")).build());

		}
		return checkButtonIsEnabled;
	}


	public static void selectValueUsingIndex(WebDriver driver,String locator,int indexNo,String fieldName) throws IOException
	{
		try 
		{
			log.info("Select Value Using Index");
			WebElement dropDownSelect=driver.findElement(By.xpath(locator));
			Select dropdown= new Select(dropDownSelect);
			dropdown.selectByIndex(indexNo);
			log.info("Selected By Index");
		} 

		catch (Exception e) 
		{

			System.out.println("Error While Selected By Index"+e.getMessage());
			log.error("Error While Selected By Index" +e.getMessage() +" "+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("selectValueUsingIndex")).build());
		}

	}

	public static  void selectValueFromVisibleText(WebDriver driver,String locator,String visibleText,String fieldName) throws IOException
	{

		try {
			log.info("Select Value From visible Text");
			WebElement dropDownSelect=driver.findElement(By.xpath(locator));
			Select dropdown= new Select(dropDownSelect);
			dropdown.selectByVisibleText(visibleText);
			log.info("Select Value From visible Text");
		}
		catch (Exception e) 
		{

			System.out.println("Error While Select Value From visible Text!!!"+e.getMessage());
			log.error("Error While Select Value From visible Text!!!"+e.getMessage() + "::" +MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("selectValueFromVisibleText")).build());

		}

	}

	public static void selectRandomValue(WebDriver driver,String locator,String fieldName) throws IOException
	{
		try {
			log.info("Select Random Value");
			log.info("Select Random Value");
			WebElement dropDown=driver.findElement(By.xpath(locator));
			Select selectRandomValue=new Select(dropDown);
			selectRandomValue.selectByIndex(new Random().nextInt(selectRandomValue.getOptions().size()));
			log.info("Selected Random Value");

		}
		catch (Exception e) 
		{

			System.out.println("Error while Select Random Value!!!"+e.getMessage());
			log.error("Error while Select Random Value!!!"+e.getMessage() +"::"+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("selectValueFromVisibleText")).build());

		}
	}


	public static List<String> getElements(WebDriver driver, String locator, String fieldName)
	{

		String theListIs = "";
		List<String> list = new ArrayList<String>();


		List<WebElement>yourList=driver.findElements(By.xpath(locator));
		int size=yourList.size();
		list.add("one");
		
		System.out.println("The Size is::"+size);
		log.info("The Size is::"+size);
		if(size > 0)
		{
			System.out.println("Elements are available in the application : ");

			for(int i = 0; i < size; i++)
			{
				theListIs = yourList.get(i).getText();
				list.add(theListIs);
				list.add(yourList.get(i).getText());
				System.out.println("' " +i+ " ' position value is available for  ::Locator::" + locator +"::Field Name is::"+fieldName +"::The List is::" +theListIs);	

			}  

		}

		else
		{

			System.out.println("Data is NOT Available in side the LIST");
			log.info("Data is NOT Available in side the LIST");
		}

		return list;

	}


	public static void scrollDown(WebDriver driver)
	{

		try {

			JavascriptExecutor js = (JavascriptExecutor)driver;

			js.executeScript("window.scrollBy(0,500)");
			System.out.println("SucessFully ScrollDown");

		}

		catch(Exception e)
		{
			e.printStackTrace();

		}
	}
	
	
	
	
	public static void clickedByJavaScript(WebDriver driver , String locator)
	{

		try {

			JavascriptExecutor js = (JavascriptExecutor)driver;
            WebElement click=driver.findElement(By.xpath(locator));
			js.executeScript("arguments[0].click();" , click );
			System.out.println("Clicked SucessFully");

		}

		catch(Exception e)
		{
			e.printStackTrace();

		}
	}

	
	
	public static void close(WebDriver driver) throws IOException
	{
		try
		{
			log.info("Close Browser");
			driver.close();

		}
		catch (Exception e) 
		{

			System.out.println("Error While Close Browser!!!"+e.getMessage()); 
			log.error("Error While Close Browser!!!"+e.getMessage() +"::"+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("close")).build());

		}
	}

	public static void quit(WebDriver driver) throws IOException
	{
		try
		{ 

			log.info("Quit Browser");
			driver.quit();

		} 
		catch (Exception e)
		{

			System.out.println("Error While Quit Browser!!!"+e.getMessage());
			log.error("Error While Quit Browser!!!"+e.getMessage() +"::"+MediaEntityBuilder.createScreenCaptureFromPath(failedTakeScreenshort("Quit")).build());
		}

	}

}





