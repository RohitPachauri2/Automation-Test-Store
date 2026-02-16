Feature: Checking login feature

  Scenario: Checking positive login functionality
    Given user is navigated to home page
    When user enters "rohitpachauri2" and "rmv123*#R" and clicks login
    Then user is logged in

#    Examples:
#      | username         | password    |
#      | "rohitpachauri2" | "rmv123*#R" |
#      |"rohitpachauri"|"rmv123*#R"|
