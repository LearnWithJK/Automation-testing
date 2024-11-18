Feature: Validation of Inventory functionality

  @RegressionTest17 @smoke
  Scenario Outline: Verify create inventory - success
    Given User is logged into Purna application "<TestCase_ID>" "Inventory"
    When User clicks on Main menu
		When User clicks on inventory link
		When User clicks on Add New Item button
		When User enters inventory details
		When User submits inventory
		When User clicks on Item details button
		Then User verifies that inventory is created
		
		Examples:
			| TestCase_ID  |
			| Purna_TC_017 |
    
    
   
