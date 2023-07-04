@contactList  @update
  Feature: US004 Add New Contact
    Scenario: TC001 User adds a new contact
      When go to home page
      And enter your email address
      And enter your password
      And click Submit button
      And click Add a New Contact button
      And enter firstname, lastname and other user informations
      And click Submit button
      And Close driver
