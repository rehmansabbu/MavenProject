#This is my Gherkin language#
Feature: CRM Cutomer relationship management system we can login , we can create the Lead ,we can create Organization ,
         we can create contacts , and we can create opportunities & ducument

#With example keyword

Scenario Outline: login to vtiger crm and create the lead
Given user is on crm home page
When user enters "<username>" and "<password>"
Then click on login button
Then user click on leads page
Then user move and click on addlead
Then user fill leads detail "<firstname>" and "<lastname>" and "<company>" and "<mobile>" and  "<designation>" and "<email>" and "<city>" and "<country>" and "<state>" and "<description>"  
Then user click on save button
Then close the browser


Examples:
| username | password |firstname| lastname |company           | mobile    |designation       |email                  | city  |country |state     |description    |
| admin    | root@123 | sabbu   | rahman   |sbc exports lmt   | 8553609688|automation tester | rehmansabbu@gmail.com |Ranchi |India   |Jharkhand |selenium java  |    
| admin    | root@123 | zikra   | jabeen   |High court        |88409131808| advocate         | zikra198@gmail.com    |Dhanbad|India   |Jharkhand |LLM            |                     
                               
 
 
 