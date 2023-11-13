package com.purna.stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.LoginPage;
import com.purna.pages.PurchaseDashboardPage;
import com.purna.pages.PurchseInvoicePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseOrder_Stepdefinition {
	private WebDriver  driver;
	private TestContext testContext;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	PurchaseDashboardPage purchaseDashboardPage;
	PurchseInvoicePage purchseInvoicePage;
	Utilities utils;
	 
	 public PurchaseOrder_Stepdefinition(TestContext context) {
		 testContext = context;
		 driver = testContext.getDriver();
		 loginPage = new LoginPage(driver);
		 dashboardPage = new DashboardPage(driver);
		 purchaseDashboardPage = new PurchaseDashboardPage(driver);
		 purchseInvoicePage = new PurchseInvoicePage(driver);
		 utils = new Utilities();
	 }
	
	@When("User clicks on purchase link")
	public void user_clicks_on_purchase_link() {
		utils.syncElement(driver, dashboardPage.link_purchase, "ToClickable");
		dashboardPage.link_purchase.click();
	}
	@When("User clicks on purchase order link")
	public void user_clicks_on_purchase_order_link() {
		dashboardPage.link_purchaseOrder.click();
	}
	@When("User clicks on New purchase order button")
	public void user_clicks_on_new_purchase_order_button() {
		purchaseDashboardPage.btn_newPuchaseInvoice.click();
	}
	@When("User enters purchase invoice details")
	public void user_enters_below_purchase_invoice_details() {
		utils.doDropDownUsingVisibleText(purchseInvoicePage.dropdown_suppName, "John");
		purchseInvoicePage.textbox_contactNo.sendKeys(testContext.getMapTestData().get("contactNo"));
		utils.doDropDownUsingValue(purchseInvoicePage.dropdown_creditPeriod, "15 DAYS");
		purchseInvoicePage.textbox_creditPeriodName.sendKeys(testContext.getMapTestData().get("CrditPeriodName"));
		purchseInvoicePage.textbox_totalAmount.sendKeys(testContext.getMapTestData().get("amount"));
		utils.doDropDownUsingVisibleText(purchseInvoicePage.dropdown_cgst, "6");
		
	}
	@When("User clicks on Calculate button")
	public void user_clicks_on_calculate_button() {
		purchseInvoicePage.btn_calculate.click();
	}
	
	@When("User clicks on Ok popup")
	public void user_clicks_on_ok_popup() {
		utils.acceptAlert(driver);
	}
	@When("User clicks on Purchase Invoice details button")
	public void user_clicks_on_purchase_invoice_details_button() {
		purchseInvoicePage.link_purchaseInvoiceDetails.click();
	}
	@Then("User verifies that the new Purchase order is created")
	public void user_verifies_that_the_new_purchase_order_is_created() {
	    Assert.assertEquals(driver.findElement(By.xpath("//td[text()='John']")).getText(), "John");
	}

	@When("User clicks on delete button")
	public void user_clicks_on_delete_button() {
		purchaseDashboardPage.link_delete.click();
	}
	@Then("User verifies that the purchase order is deleted")
	public void user_verifies_that_the_purchase_order_is_deleted() {
	    Assert.assertEquals(driver.findElements(By.xpath("//td[text()='John']")).size(), Integer.parseInt("0"));
	}
	
}
