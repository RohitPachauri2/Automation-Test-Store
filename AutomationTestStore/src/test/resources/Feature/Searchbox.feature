Feature: To Test searchbox with dynamic searches

  Background: Checking positive login functionality
    Given user is navigated to home page
    When user enters "rohitpachauri2" and "rmv123*#R" and clicks login
    Then user is logged in

  Scenario Outline:
    Given user is logged in
    When user enters "<search>"
    And user is able to add all the elements to cart
    Then user is able to see all elements in cart

    Examples:
      | search |
      | men    |
      | women  |
