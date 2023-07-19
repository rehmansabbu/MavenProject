#This is my Gherkin language#
Feature: CRM Cutomer relationship management system we can login , we can create the Lead ,we can create Organization ,
         we can create contacts , and we can create opportunities & ducument

# Without example keyword
Scenario: login to vtiger crm
Given user is on crm login home page
When user enter "admin" and "root@123"
And user click on login signin button
Then user should be on crm home page

 Scenario: now user can check all the option one by one
 Given user is on already leads
 When user click on leads
 And user will create the leads , click on addlead
 And user should be on creating new lead page
 And user will fill the detail of lead
 And user will click on save button
 Then user will close the browser