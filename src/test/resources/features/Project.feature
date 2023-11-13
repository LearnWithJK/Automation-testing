Feature: Verify Project functionality
  I want to Verify Project functionality
  
  @RegressionTest
  Scenario Outline: Verify that user is able to create new project
  Given User is logged into Purna application "<TestCase_ID>" "Project"
  When user clicks on main menu
  When user clicks on project link
  When user clicks on add new project button
  When user enters project details
  When user clicks on save button
  When user clicks on ok button on popup
  When clicks on project details button
  Then user verifies that the new project is created
  
Examples:
      | TestCase_ID |
      | Purna_TC_007|
  
