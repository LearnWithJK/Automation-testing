Feature: Login Verification
  This feature will verify login validations for P

  @RegressionTest
  Scenario Outline: Login Scenario one
    Given User is on Purna login page "<TestCase_ID>" "Login"
    When User on Login Page enters valid username and password
    And User clicks on Login button
    Then User should navigates to sales dashboard page
    
    Examples:
      | TestCase_ID |
      | Purna_TC_001|
      
   @RegressionTest
  Scenario Outline: Login Scenario one
    Given User is on Purna login page "<TestCase_ID>" "Login"
    When User on Login Page enters invalid username and password
    And User clicks on Login button
    Then User should navigates to sales dashboard page
    
    Examples:
      | TestCase_ID |
      | Purna_TC_002|
      
  

 
