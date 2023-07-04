@update
  Feature: US003 Contact List
    Scenario: TC001 View Contact List
      When go to home page
      And enter your email address
      And enter your password
      And click Submit button
      When validate contact list is viewed
      And Close driver