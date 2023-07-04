@update
  Feature: US006 Delete Contact
    Scenario: TC001 Delete updated contact
      When go to home page
      And enter your email address
      And enter your password
      And click Submit button
      And click on the person to be updated or deleted
      And click Delete Contact button
      And accept alert
      And validate contact is deleted
      And Close driver