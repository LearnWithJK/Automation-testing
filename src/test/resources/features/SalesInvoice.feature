Feature: Purna Sales invoice functionality
  I want to validate the Sales invoice functionality
 
 @RegressionTest
Scenario Outline: Verify that sales invoice is created successfully
Given User is logged into Purna application "<TestCase_ID>" "SalesInvoice"
When user clicks on New sale invoice button
When user enters sales invoice details
When user save the sales invoice details
When user clicks on sales invoice details button
Then new sales invoice should be created
 
 Examples:
 | TestCase_ID |
 | Purna_TC_011|
 
 