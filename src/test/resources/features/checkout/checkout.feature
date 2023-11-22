Feature: Validate checkout flow on SwagLabs page
  Scenario: Validate checkout flow
    Given I navigate to SauceLab demo page
    When type the username standard_user with password secret_sauce
    And press the login button
    And sort products from most expensive to cheapest
    And add product to the cart
    And add product to the cart
    And checkout information
    Then finish checkout