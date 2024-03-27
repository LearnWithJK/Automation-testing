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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Inventory_stepdefinition extends Utilities{
	
	private WebDriver driver;
    private TestContext testContext;
	LoginPage onLoginPage;
	DashboardPage onDashboardPage;
	PurchaseItemDashPage onPurchaseItemDashPage;
	PurchaseItemPage onPurchaseItemPage;
	
	public Inventory_stepdefinition(TestContext context) {
		testContext = context;
		driver = testContext.getDriver();
		onLoginPage = new LoginPage(driver);
		onDashboardPage = new DashboardPage(driver);
		onPurchaseItemDashPage = new PurchaseItemDashPage(driver);
		onPurchaseItemPage = new PurchaseItemPage(driver);
	}
		
	@Given("user is logged into purna application with {string} and {string}")
	public void user_is_logged_into_purna_application(String username, String password) {		
		onLoginPage.txtbox_username.sendKeys(username);
		onLoginPage.txtbox_password.sendKeys(password);
		onLoginPage.btn_login.click();
		}
	
	@When("user clicks on Main menu")
	public void user_clicks_on_main_menu() {
		onDashboardPage.link_main.click();
	}
	
	@When("user clicks on inventory link")
	public void user_clicks_on_inventory_link() {		
		clickElement(driver, onDashboardPage.link_inventory);
	}
	
	@When("user clicks on Add New Item button")
	public void user_clicks_on_add_new_item_button() {
		clickElement(driver, onPurchaseItemDashPage.btn_addNewItem);
	}
	
	@When("user enters inventory details")
	public void user_enters_inventory_details() {
		onPurchaseItemPage.textbox_srNo.clear();
		onPurchaseItemPage.textbox_srNo.sendKeys(testContext.getMapTestData().get("srNumber"));
		onPurchaseItemPage.textbox_itemcode.sendKeys(testContext.getMapTestData().get("itemCode"));
		onPurchaseItemPage.textbox_itemname.sendKeys(testContext.getMapTestData().get("itemname"));
		
		doDropDownUsingVisibleText(onPurchaseItemPage.dropdown_units, "KG");
		
		onPurchaseItemPage.textbox_suppCode.sendKeys(testContext.getMapTestData().get("supCode"));
		onPurchaseItemPage.textbox_weight.sendKeys(testContext.getMapTestData().get("weight"));
		onPurchaseItemPage.textbox_rate.sendKeys(testContext.getMapTestData().get("rate"));
		onPurchaseItemPage.textbox_discount.sendKeys(testContext.getMapTestData().get("discount"));
		onPurchaseItemPage.textbox_quantity.sendKeys(testContext.getMapTestData().get("quantity"));
		onPurchaseItemPage.textbox_amount.click();
	}
	
	@When("user submits inventory")
	public void user_submits_inventory() {
		onPurchaseItemPage.btn_addItem.click();
	}
	
	@When("user clicks on Item details button")
	public void user_clicks_on_item_details_button() {
		onPurchaseItemPage.link_itemDetails.click();
	}
	@Then("user verifies that inventory is created")
	public void user_verifies_that_inventory_is_created() {
	    Assert.assertEquals("Grocery123", driver.findElement(By.xpath("//td[text()='Grocery123']")).getText());	    
	}
	
}
