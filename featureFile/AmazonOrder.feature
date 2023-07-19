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

Feature: In order to test the order details 
         as a registered user check previous order 
         Open order and cancelled order
         
Background:

Given  Registered user is on Amazon home page
And    User is on login page
When   User enter username
And    User enter password
And    User click on signin button
Then   User navigate to the amazon home page


Scenario: Check previous order details 
When    User click on the order details link
Then    user check the previous order details


Scenario: Check Open order details 
When    User click on the open order details link
Then    user check the open order details



Scenario: Check Cancelled order details 
When    User click on the cancelled order details link
Then    user check the cancelled order details



