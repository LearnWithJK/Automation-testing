Feature: Purna Inventory functionality verification

@RegressionTest
Scenario Outline: Verify that user is able to create inventory successfully
Given User is logged into Purna application "<TestCase_ID>" "Inventory"
When user clicks on main menu
When user clicks on Inventory link
When user clicks on Add new Item button
When user enters inventory details
When user clicks on Add Item button
When user clicks on Item details button
Then Inventory should be created

Examples:
      | TestCase_ID |
      | Purna_TC_010|
