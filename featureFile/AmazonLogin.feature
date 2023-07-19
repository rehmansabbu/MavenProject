#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


Feature: Login Page 
         Inorder to test the login page for registered user
        
Scenario: Amazon login page 

Given  User is on Amazon landing page
And    Sign in button is present on the screen
When   User click on the sign in button
Then   User can see the login screen
When   User enters username "8553609688" in username field
And    User enters password "Sabb28uz@9" in password field
And    User click on sign In button
Then   User is on home page
And    Title of the home page is "Amazon"
But    Sign in button is not present






















