package com.test.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class AmazonHooks {
	
	@Before
	public static void launchTheBrowser()
	{
		System.out.println("Launched the browser sucessfully....");
		
	}
	
	@After
	public static void closeTheBrowser()
	{
		System.out.println("Close the Browser....");
	}
	

}
