Feature: User can purchase and search the item in this application 

Scenario: test the login of application
Given user is on login home page
When user click on login button
And user enter username , password
And user click on submit button
Then user should be on login home page

Scenario: now user can search and purchase the item
Given user can search and purchase the item
When user keep the cursor on men tab item 
And user is select and click men item jeans
And user is on selected item mens jeans
Then user will check popularity,price low to high,price high to low and newest first

