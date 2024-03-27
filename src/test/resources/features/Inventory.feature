Feature: Validation of Inventory functionality

  @RegressionTest @smoke
  Scenario Outline: Verify create inventory - success
    Given User is logged into Purna application "<TestCase_ID>" "Inventory"
    When user clicks on main menu
    When user clicks on inventory link
    When user clicks on Add New Item button
    When user enters inventory details
    When user submits inventory
    When user clicks on Item details button
    Then user verifies that inventory is created

    Examples: 
      | TestCase_ID  |
      | Purna_TC_014 |
