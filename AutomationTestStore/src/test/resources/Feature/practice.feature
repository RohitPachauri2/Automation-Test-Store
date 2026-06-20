Feature: Feature for checking adding men product and books

  Background: for login
    Given user is on automaation test store site
    When user clicks on login button
    And user enters username as "rohitpachauri2" and password as "rmv123*#R"
    Then user is successfully logged in

  Scenario:
    Given user is logged into the site
    When user clicks on menssss section
    Then user is able to see mensss products

  Scenario Outline:
    Given user is logged into the site
    When user enters "<value>" on search section
    Then user is able to appropraite products

    Examples:
      | value |
      | Books |
      | women |
