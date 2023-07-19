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
@All
Feature: Booking the Sedan cab from ola application

@SmokeTest
Scenario: Booking Cab sedan

Given User want to select a "sedan" car from Ola Application 
When  User select a "Seden" car and destination from "Ranchi" to "Ramgarh"
Then  Driver start the journey
And   Driver end the journey
Then User pay 2000 rs  

@RegressionTest
Scenario: Booking XUB car

Given User want to select a "XUB" car from Ola Application 
When  User select a "XUB" car and destination from "Ranchi" to "Hazaribagh"
Then  Driver start the journey
And   Driver end the journey
Then User pay 4000 rs  

@prodServer
Scenario: Booking Mini Cab

Given User want to select a "Mini" car from Ola Application 
When  User select a "Mini" car and destination from "Ranchi" to "Kodarma"
Then  Driver start the journey
And   Driver end the journey
Then User pay 5000 rs   
