package com.purna.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.LoginPage;
import com.purna.pages.PurchaseItemDashPage;
import com.purna.pages.PurchaseItemPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Inventory_stepdefinition extends Utilities{
	private WebDriver driver;
    private TestContext testContext;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PurchaseItemDashPage purchaseItemDashPage;
	PurchaseItemPage purchaseItemPage;
	
	public Inventory_stepdefinition(TestContext context) {
		testContext = context;
    	driver = testContext.getDriver();
		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		purchaseItemDashPage = new PurchaseItemDashPage(driver);
		purchaseItemPage = new PurchaseItemPage(driver);
	}
	
	@When("user clicks on Inventory link")
	public void user_clicks_on_inventory_link() {				
		clickElement(driver, dashboardPage.link_inventory);
	}
	
	@When("user clicks on Add new Item button")
	public void user_clicks_on_add_new_item_button() {	
		clickElement(driver, purchaseItemDashPage.btn_addNewItem);
	}
	
	@When("user enters inventory details")
	public void user_enters_inventory_details() {
		purchaseItemPage.textbox_srNo.clear();
		purchaseItemPage.textbox_srNo.sendKeys(testContext.getMapTestData().get("srNumber"));
		purchaseItemPage.textbox_itemcode.sendKeys(testContext.getMapTestData().get("itemCode"));
		purchaseItemPage.textbox_itemname.sendKeys(testContext.getMapTestData().get("itemname"));
		
		doDropDownUsingVisibleText(purchaseItemPage.dropdown_units, "Numbers");
		
		purchaseItemPage.textbox_suppCode.sendKeys(testContext.getMapTestData().get("supCode"));
		purchaseItemPage.textbox_weight.sendKeys(testContext.getMapTestData().get("weight"));
		purchaseItemPage.textbox_rate.sendKeys(testContext.getMapTestData().get("rate"));
		purchaseItemPage.textbox_quantity.sendKeys(testContext.getMapTestData().get("quantity"));
		clickElement(driver, purchaseItemPage.textbox_amount);
	}
	
	@When("user clicks on Add Item button")
	public void user_clicks_on_add_item_button() {
		clickElement(driver, purchaseItemPage.btn_addItem);
	}
	
	@When("user clicks on Item details button")
	public void user_clicks_on_item_details_button() {
		clickElement(driver, purchaseItemPage.link_itemDetails);
	}
	
	@Then("Inventory should be created")
	public void inventory_should_be_created() {
	    Assert.assertEquals(testContext.getMapTestData().get("itemCode"), driver.findElement(By.xpath("//td[text()='Dairy_1234']")).getText());
	    clickElement(driver, purchaseItemDashPage.link_delete);
	    acceptAlert(driver);
	}

}
