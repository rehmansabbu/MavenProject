Feature: CRM Cutomer relationship management system we can login ,we can create Organization 

Scenario: login to V tiger and move to create the organization 
	Given user is on home page 
	When user enters username and password 
		|admin  | root@123 |
	Then user click on submit 
	Then user click on organization 
	Then user click on add organization 
	Then user fill the detail of organization 
		|JEPC|www.jepc.com|8553609688|rehmansabbu@gmail.com|Ranchi|Ranchi|Jharkhand|India|Education|
	Then user click on save 
	
