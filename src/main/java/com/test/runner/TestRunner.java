package com.test.runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions
(	
		
//features = { "src\\main\\java\\features\\Login.feature" },
//features = { "src\\main\\java\\features\\CrmLogin.feature" }, // where exactly feature file is available (The path of the feature file)


features = {"featureFile/AmazonLogin.feature" },


glue = {"com/test/stepdefinations" , "com/test/hooks"}, // Where exactly stepdefination file is available , The path of the step defination

format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"}, 
//we can generate different types of Report ,we can generate Json format report ,and generate xml format report and Html report also.

plugin = { "pretty", "html:target/cucumber-reports",  "json:target.cucumber.json", "junit:target/cucumber.xml" },

dryRun = false , 
//when dryRun =true ,immediately It will check ,the mapping is perfectly or not , Between feature file and Step definition
// it will check which step definition missed , its very help full to find out the issue
//when dryRun =false ,Then it will execute your Test case ,Remember - if dryRun=false then only execute our testCase

monochrome = true ,// Display the output in Readable Format , The output we can make more readable.& Its Display the Console output in
                     // proper readable format
//tags = {"~@prodServer" , "@SmokeTest" },



strict = true // Strictly will follow the rule , will check mapping between feature and step defination , work like a assert


//tags= {"@SmokeTest , @RegressionTest"} // FOR OR
//tags={"@SmokeTest" , "@RegressionTest"} //For AND
//stags={"~@SmokeTest" , "~@EndToEnd"} // for ignore 

)
 

public class TestRunner {
	
	//OR is represented by (,) [comma] , ---> tags= {"@SmokeTest , @RegressionTest"} --- execute all tests Tagged as @SmokeTest or @RegressionTest
	//AND is represented by (,) [comma] , ---> tags={"@SmokeTest" , "@RegressionTest"} --- execute all tests Tagged as @SmokeTest AND @RegressionTest
	//IGNORE- tags={"~@SmokeTest" , "@EndToEnd"} - only will execute EndToEnd

   /* Background : Basically its a used for inside the feature file multiple scenario is available by using Given,When,Then
	             If some steps are repeating again and again in multiple scenario , its look confuse and not perfect readable
	             so we have to use Background keyword.In side the Background we can write repeated step (It is a more elegant 
	              more readable)
	             
	             */
	/*
	 Hooks in Cucumber - @Before @After ,@BeforeStep ,@AfterStep - I have create seperate class for hook and need to call in side
	                      the TestRunner file and call inside the [glue = {"com/test/stepdefinations" , "com/test/hooks"}]
	 
	 What are Generate Different Reports in Cucumber BDD - I have to use
	  plugin = { "pretty", "html:target/cucumber-reports",  "json:target.cucumber.json", "junit:target/cucumber.xml" }
	  
	  
	   Rerun Failure - For Rerun Failure I have to use plugin = "rerun:target/failedrerun.txt"
	   
	   If any feature file is getting failed for rerun i have to use plugin - Inside the plugin i have to use
	   plugin = "rerun:target/failedrerun.txt"
	   when i will execute the the testcase it will create the failed scenarion .txt file by the name of failedrerun.txt
	   After refresh we can se location and which scenarion its failing it will give inside the .txt file.
	   
	    How to #SKIP Scenarios - For Skip the Scenario I have to use tags = "not @skip" , This skip tags if i mention inside the any
	                              scenario, that skip scenario will not execute-It will ignore or skip
	                              - By the using of Hooks also we can skip.
	 
	 
	 */

}


