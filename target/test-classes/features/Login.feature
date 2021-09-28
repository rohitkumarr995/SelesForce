Feature: Application Login

Scenario Outline: Successfully user login
Given initialize the driver with chrome and navigate to https://login.salesforce.com/?locale=eu
When user input username <username> and password<password>
And click on Login button
Then Error message shown
And close the browser

Examples:
|username			|	password	|
|test99@gmail.com	|	12345		|