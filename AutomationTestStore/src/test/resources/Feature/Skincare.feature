Feature: Checking the Skincare Functionality
 Background: Checking positive login functionality
    Given user is navigated to home page
    When user enters "rohitpachauri2" and "rmv123*#R" and clicks login
    Then user is logged in

#    Examples:
#      | username         | password    |
#      | "rohitpachauri2" | "rmv123*#R" |
#      |"rohitpachauri"|"rmv123*#R"|

  Scenario:
    Given User is on the home page
    When user hovers over the skincare button and clicks eyes
    Then user is navigated to eyes page
    And user clicks on cart button
    And user selects multiple dropdowns and clicks checkout
    And user logsout
 
