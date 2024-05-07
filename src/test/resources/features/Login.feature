@RegressionLogin
Feature: Login

 @Test1
 Scenario: Login with success
   Given User is on Login Page
   When User fill username and password
   And User click Login button
   Then User will redirect to Products page


  @Test2
  Scenario: Login without success (wrong username)
    Given User is on Login Page
    When User fill wrong username and password
    And User click Login button
    Then An error message will appear

  @Test3
  Scenario: Login without success (wrong password)
    Given User is on Login Page
    When User fill username and wrong password
    And User click Login button
    Then An error message will appear