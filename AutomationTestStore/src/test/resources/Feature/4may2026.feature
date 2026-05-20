Feature: to practice for wings 1 
Scenario Outline: testing login functionality
Given user is on web site xyz
When user enter "<username>" and <password>
Then user is successfully logged in xyz

Examples:
|username|password|
|rohitpachauri2|"rmv123*#R"|

Scenario: testing the cart functionality
Given user is already logged in and is on home page
When user clicks on the cart button
Then user can see previously saved options


