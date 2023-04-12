Feature: simple feature

  Scenario Outline: login scenario
    Given open the browser
    When launch the "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    Then check the login scenario working correctly or not "<USERNAME>" and "<PASSWORD>"
    And close the site

    Examples: 
      | USERNAME | PASSWORD |
      | Admin    | admin123 |
      | admin    | Admin123 |
