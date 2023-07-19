Feature: CRM Cutomer relationship management system testing


@SmokeTest @RegressionTest
Scenario: login with correct username and password
Given this is valid login test

@RegressionTest
Scenario: login with incorrect username and password
Given this is invalid login test

@SmokeTest
Scenario: create a leads
Given this is a leads test

@EndToEnd
Scenario: create a organizations
Given this is a organizations test

Scenario: create a contacts
Given this is a leads test

@SmokeTest @RegressionTest
Scenario: create a opportunities
Given this is a opportunities test

@SmokeTest @RegressionTest
Scenario: create a products
Given this is a products test

@SmokeTest @EndToEnd
Scenario: create a documents
Given this is a documents test

@RegressionTest
Scenario: create a tickets
Given this is a  tickets test


