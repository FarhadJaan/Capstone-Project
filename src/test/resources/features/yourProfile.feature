@AccountPage
Feature: Retail Account Page

  Background: 
    Given User is on retail website
    When User click on Sign in option
    And User enter email 'Farhad@Gmail.com' and password 'Farhad@1234'
    And User click on login button
    Then User should be logged in into Account

  @personalInformation
  Scenario: Verify User can update Profile Information
    When User click on Account option
    And User update Name 'Farhad Jan' and Phone '818-749-7154'
    And User click on Update button
    Then user profile information should be updated

  
  @AddCard
  Scenario: Verify User can add a payment method
    When User click on Account option
    And User click on Add a payment method link
    And User fill Debit or credit card information
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 0031561120123410 | Hakimuui   |              11 |           2029 |          513 |
    And User click on Add your card button
    Then a message should be displayed Payment Method added successfully

  @Edit
  Scenario: Verify User can edit Debit or Credit card
    When User click on Account option
    When User click on added card
    And User click on Edit option of card section
    And user edit information with below data
      | cardNumber       | nameOnCard | expirationMonth | expirationYear | securityCode |
      | 0122333404000788 | zai      |              09 |           2029 |          444 |
    And user click on Update Your Card button
    Then a message should be displayed Payment Method updated Successfully

  @removedCard
  Scenario: Verify User can remove Debit or Credit card
    When User click on Account option
    When User click on added card
    And User click on remove option of card section
    Then payment details should be removed

  @AddAddress
  Scenario: Verify User can add an Address
    When User click on Account option
    And User click on Add address option
    And user fill new address form with below information
      | country       | fullName | phoneNumber | streetAddress | apt  | city   | state    | zipCode |
      | United States | Farhad Jaan    | 8187497154 | 1131 uni w    | 1212 | silver | land |   20021 |
    And User click Add Your Address button
    Then a message should be displayed Address Added Successfully

  @EditAddress
  Scenario: Verify User can edit an Address added on account
    When User click on Account option
    And User click on edit address option
    And user fill new address form with below information there
      | country       | fullName | phoneNumber | streetAddress       | apt  | city    | state    | zipCode |
      | United States | Hameed     | 23232323445 | 1121 university bld | 112 | rocvile | land |   20202 |
    And User click update Your Address button
    Then a message should be displayed Address Updated Successfully

  @RemoveAddress
  Scenario: Verify User can remove Address from Account
    When User click on Account option
    And User click on remove option of Address section
    Then Address details should be removed
