package com.purna.stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.PurchaseDashboardPage;
import com.purna.pages.PurchseInvoicePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_stepdefinition extends Utilities{
	
	private WebDriver driver;
	private TestContext testContext;
	private DashboardPage onDashboardPage;
	private PurchaseDashboardPage onPurchaseDashboardPage;
	private PurchseInvoicePage onPurchaseInvoicePage;
	
	public Purchase_stepdefinition(TestContext context) {
		testContext = context;
		driver = context.getDriver();
		onDashboardPage = new DashboardPage(driver);
		onPurchaseDashboardPage = new PurchaseDashboardPage(driver);
		onPurchaseInvoicePage = new PurchseInvoicePage(driver);
		
	}
	
	@When("User clicks on purchase link")
	public void user_clicks_on_purchase_link() {
		clickElement(driver, onDashboardPage.link_purchase);
	}
	
	@When("User clicks on purchase order link")
	public void user_clicks_on_purchase_order_link() {
	   clickElement(driver, onDashboardPage.link_purchaseOrder);
	}
	
	@When("User clicks on New purchase order button")
	public void user_clicks_on_new_purchase_order_button() {
	   clickElement(driver, onPurchaseDashboardPage.btn_newPuchaseInvoice);
	}
	
	@When("User enters purchase invoice details")
	public void user_enters_purchase_invoice_details() {
		
		Select suppSelect = new Select(onPurchaseInvoicePage.dropdown_suppName);
		suppSelect.selectByIndex(2);
		
		Select crSelect = new Select(onPurchaseInvoicePage.dropdown_creditPeriod);
		crSelect.selectByValue("15 DAYS");
		
		sleepInMilliSeconds(15000);
		
		onPurchaseInvoicePage.textbox_creditPeriodName.sendKeys(testContext.getMapTestData().get("CrditPeriodName"));
		onPurchaseInvoicePage.textbox_totalAmount.sendKeys(testContext.getMapTestData().get("amount"));
		
		Select cgstSelect = new Select(onPurchaseInvoicePage.dropdown_cgst);
		cgstSelect.selectByVisibleText("6");
		
		Select sgstSelect = new Select(onPurchaseInvoicePage.dropdown_sgst);
		cgstSelect.selectByVisibleText("9");
		
		Select igstSelect = new Select(onPurchaseInvoicePage.dropdown_igst);
		cgstSelect.selectByVisibleText("6");
		
		onPurchaseInvoicePage.textbox_packingAndForwarding.sendKeys("100");
		onPurchaseInvoicePage.textbox_deliveryCharges.sendKeys("50");	
	}
	
	@When("User clicks on Calculate button")
	public void user_clicks_on_calculate_button() {
	   clickElement(driver, onPurchaseInvoicePage.btn_calculate);
	}
	
	@When("User clicks on Purchase Invoice details button")
	public void user_clicks_on_purchase_invoice_details_button() {
		clickElement(driver, onPurchaseInvoicePage.link_purchaseInvoiceDetails);
	}
	
	@Then("User verifies that the new Purchase order is created")
	public void user_verifies_that_the_new_purchase_order_is_created() {
	   
	}

}
