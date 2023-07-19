$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("featureFile/AmazonLogin.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 18,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 21,
  "name": "Login Page",
  "description": "       Inorder to test the login page for registered user",
  "id": "login-page",
  "keyword": "Feature"
});
formatter.before({
  "duration": 147000,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "Amazon login page",
  "description": "",
  "id": "login-page;amazon-login-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 26,
  "name": "User is on Amazon landing page",
  "keyword": "Given "
});
formatter.step({
  "line": 27,
  "name": "Sign in button is present on the screen",
  "keyword": "And "
});
formatter.step({
  "line": 28,
  "name": "User click on the sign in button",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "User can see the login screen",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "User enters username \"8553609688\" in username field",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "User enters password \"Sabb28uz@9\" in password field",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User click on sign In button",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "User is on home page",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Title of the home page is \"Amazon\"",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "Sign in button is not present",
  "keyword": "But "
});
formatter.match({
  "location": "LoginAmazon.user_is_on_Amazon_landing_page()"
});
formatter.result({
  "duration": 207643300,
  "status": "passed"
});
formatter.match({
  "location": "LoginAmazon.sign_in_button_is_present_on_the_screen()"
});
formatter.result({
  "duration": 40400,
  "status": "passed"
});
formatter.match({
  "location": "LoginAmazon.user_click_on_the_sign_in_button()"
});
formatter.result({
  "duration": 24200,
  "status": "passed"
});
formatter.match({
  "location": "LoginAmazon.user_can_see_the_login_screen()"
});
formatter.result({
  "duration": 24600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "8553609688",
      "offset": 22
    }
  ],
  "location": "LoginAmazon.user_enters_username_in_username_field(String)"
});
formatter.result({
  "duration": 2817000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sabb28uz@9",
      "offset": 22
    }
  ],
  "location": "LoginAmazon.user_enters_password_in_password_field(String)"
});
formatter.result({
  "duration": 57900,
  "status": "passed"
});
formatter.match({
  "location": "LoginAmazon.user_click_on_sign_In_button()"
});
formatter.result({
  "duration": 22100,
  "status": "passed"
});
formatter.match({
  "location": "LoginAmazon.user_is_on_home_page()"
});
formatter.result({
  "duration": 26200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Amazon",
      "offset": 27
    }
  ],
  "location": "LoginAmazon.title_of_the_home_page_is(String)"
});
formatter.result({
  "duration": 68200,
  "status": "passed"
});
formatter.match({
  "location": "LoginAmazon.sign_in_button_is_not_present()"
});
formatter.result({
  "duration": 21500,
  "status": "passed"
});
formatter.after({
  "duration": 44700,
  "status": "passed"
});
});