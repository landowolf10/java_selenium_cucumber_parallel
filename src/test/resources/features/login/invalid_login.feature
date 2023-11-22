Feature: Invalid user login
  Scenario Outline: Invalid user
    Given I navigate to SauceLab demo page
    When type the username <user> with password <password>
    And press the login button
    Then verify user login was not successful

    Examples:
      | user            | password      |
      | standard_use    | secret_sauce  |
      | standard_user    | secretsauce  |

