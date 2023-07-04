  @api
  Feature: Add New Contact by API
    Scenario: Add New Contact
      Given send the post request for creating new contact
      Then get the response and validate