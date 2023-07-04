@update
Feature:US001 User Registration

  Scenario: TC001 User creates an account
    Given go to home page
    When click Sign up button
    And provide a valid firstname
    And provide a valid lastname
    And provide a valid email address
    And provide a valid password at least seven characters long
    And click Submit button
    Then validate account created
    And Close driver



