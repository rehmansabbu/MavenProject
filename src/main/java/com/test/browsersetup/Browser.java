package com.test.browsersetup;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import com.test.dataread.GetDataFromExcel;
import com.test.customlistner.CustomListnerForScreenshort;
import com.test.utility.CommonUtil;


@Listeners(CustomListnerForScreenshort.class)
public class Browser {

	public static CommonUtil commonUtil = new CommonUtil();
	public static GetDataFromExcel getData=new GetDataFromExcel();



	//log4j log file
	public static Logger log = Logger.getLogger("");


	public static WebDriver driver;
	
	public static String URL = "http://localhost:8888/index.php";
	public static String CHROME_EXE_FILE_PATH = "sourceFile\\chromeDriver\\chromedriver.exe";
	public static String FIREFOX_EXE_FILE_PATH = "sourceFile\\firefoxDriver\\geckodriver.exe";
	public static String IE_EXE_FILE_PATH =   "sourceFile\\ieDriver\\IEDriverServer.exe";
	public static String login_To_Vtiger_CRM ="//h3[contains(text(),'Login to Vtiger CRM')]";
	public static String browser = "chrome";


	@BeforeClass 
	public static void launchBrowser() throws  IOException
	{

		log.info("Browser >> Launch >> CHROME>> FIREFOX >> IE");

		if(browser.equalsIgnoreCase("chrome"))
		{

			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver", CHROME_EXE_FILE_PATH);
			driver = new ChromeDriver();
			

		}

		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.silent  Output", "true");
			System.setProperty("webdriver.gecko.driver", FIREFOX_EXE_FILE_PATH);
			driver=new FirefoxDriver();

		}

		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.silentOutput", "true");
			System.setProperty("webdriver.ie.driver", IE_EXE_FILE_PATH);
			driver=new InternetExplorerDriver();

		}


		log.info("Vtiger CRM >> http://localhost:8888/index.php");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//verify Login to Vtiger CRM
		commonUtil.getText(driver, login_To_Vtiger_CRM, "Verify Login to Vtiger CRM");
		
		
	}




	@AfterClass
	public static void closeBrowser() throws IOException {

		log.info("Sucessfully Completed");
		System.out.println("Successfully closed browser !!!");
		driver.close();

	}

}





