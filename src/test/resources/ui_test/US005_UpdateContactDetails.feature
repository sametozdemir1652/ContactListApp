@contactList  @update
  Feature: US005 Update Contact Details
    Scenario: TC001 Update created contact details
      When go to home page
      And enter your email address
      And enter your password
      And click Submit button
      And click on the person to be updated or deleted
      And click Edit Contact button
      And update last name
      And click Submit button
      Then validate contact details updated
      And Close driver

