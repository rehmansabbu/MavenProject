Feature:  CRM Cutomer relationship management system we can login ,we can create Contacts by using MAP<K,V> 

Scenario: login to V tiger and move to create the contacts 
	Given user is on contacts page 
	When user give username and password 
		|username  | password |
		|admin  | root@123 |
	Then user click on login 
	Then user click on contacts 
	Then user click on add contacts 
	And then user enter the conatct details 
	
		|firstname|lastname|mobileno  |emailid              |mailingcity|mailingstate|mailingcountry|description           |
		|sabbu    |rehman  |8553609688|rehmansabbu@gmail.com|Ranchi     |Jharkhand   | India        | automation tester    |
		|sabbu    |rehman  |8553609688|rehmansabbu@gmail.com|Ranchi     |Jharkhand   | India        | automation tester    |
		|sabbu    |rehman  |8553609688|rehmansabbu@gmail.com|Ranchi     |Jharkhand   | India        | automation tester    |
		|sabbu    |rehman  |8553609688|rehmansabbu@gmail.com|Ranchi     |Jharkhand   | India        | automation tester    |
		|sabbu    |rehman  |8553609688|rehmansabbu@gmail.com|Ranchi     |Jharkhand   | India        | automation tester    |
		
	Then click on save 