package com.purna.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.PurchaseItemDashPage;
import com.purna.pages.PurchaseItemPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Inventory_stepdefinition extends Utilities{
	
	private WebDriver driver;
    private TestContext testContext;
    DashboardPage onDashboardPage;
    PurchaseItemDashPage onPurchaseItemDashPage;
    PurchaseItemPage onPurchaseItemPage;
    
    public Inventory_stepdefinition(TestContext context) {
		testContext = context;
		driver = testContext.getDriver();	
		onDashboardPage = new DashboardPage(driver);
		onPurchaseItemDashPage = new PurchaseItemDashPage(driver);
		onPurchaseItemPage = new PurchaseItemPage(driver);
	}
     
    @When("User clicks on inventory link")
    public void user_clicks_on_inventory_link() {
    	onDashboardPage.link_inventory.click();
        
    }
    @When("User clicks on Add New Item button")
    public void user_clicks_on_add_new_item_button() {
    	onPurchaseItemDashPage.btn_addNewItem.click();
    }
    @When("User enters inventory details")
    public void user_enters_inventory_details() {
    	syncElement(driver, onPurchaseItemPage.textbox_itemcode, "ToVisible");
    	onPurchaseItemPage.textbox_itemcode.sendKeys(testContext.getMapTestData().get("itemcodes"));
		onPurchaseItemPage.textbox_itemname.sendKeys(testContext.getMapTestData().get("itemname"));
		doDropDownUsingVisibleText(onPurchaseItemPage.dropdown_units, "KG");		
		onPurchaseItemPage.textbox_suppCode.sendKeys(testContext.getMapTestData().get("supCode"));
		onPurchaseItemPage.textbox_weight.sendKeys(testContext.getMapTestData().get("weight"));
		onPurchaseItemPage.textbox_rate.sendKeys(testContext.getMapTestData().get("rate"));
		onPurchaseItemPage.textbox_discount.sendKeys(testContext.getMapTestData().get("discount"));
		onPurchaseItemPage.textbox_quantity.sendKeys(testContext.getMapTestData().get("quantity"));
		onPurchaseItemPage.textbox_amount.click();	
    }
    @When("User submits inventory")
    public void user_submits_inventory() {
    	onPurchaseItemPage.btn_addItem.click();
    }
    @When("User clicks on Item details button")
    public void user_clicks_on_item_details_button() {
    	onPurchaseItemPage.link_itemDetails.click();
    }
    @Then("User verifies that inventory is created")
    public void user_verifies_that_inventory_is_created() {
        Assert.assertTrue(onPurchaseItemPage.textbox_itemcode.getText().contains(testContext.getMapTestData().get("itemCode")));
		Assert.assertTrue(onPurchaseItemPage.textbox_itemname.getText().contains(testContext.getMapTestData().get("itemname")));
    }
}
