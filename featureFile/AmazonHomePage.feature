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

Feature: Amazon home page
         To test the order of home page as a registered user
         I want to specify the features of the home page

Scenario: Amazon Header panel section

#Precondition
Given  Amazon is on home page
#Validation
Then User gets Amazon search fields
And  Username is displayed side to the search field
And  Cart is displayed on home page
And  Amazon link and logo is displayed

Scenario: Amazon Today deals

Given Amazon is on home page
When User scroll down for today delas section
Then User gets the list of the multiple products
And User gets product image and price details
And User can see more product


Scenario: Amazon Footer panel section

Given Amazon is on home page

When User scroll down to the footer page

Then User gets all the country links

|Australia| 
|Brazil|
|Canada|

And  User gets all the Amazon service link

|Amazon Web Services|









 
