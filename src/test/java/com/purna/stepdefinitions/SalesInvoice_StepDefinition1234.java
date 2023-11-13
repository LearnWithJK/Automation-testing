package com.purna.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.SalesInvoicePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesInvoice_StepDefinition1234 extends Utilities{
	
	private WebDriver driver;
    private TestContext testContext;
    private DashboardPage onDashboardPage;
    private SalesInvoicePage onSalesInvoicePage;
    
    public SalesInvoice_StepDefinition1234(TestContext context) {
    	testContext = context;
    	driver = testContext.getDriver();
    	onDashboardPage = new DashboardPage(driver);
    	onSalesInvoicePage = new SalesInvoicePage(driver);
    }
	
	@When("user clicks on New Sales Invoice button")
	public void user_clicks_on_new_sales_invoice_button() {
		onDashboardPage.btn_newSaleInvoice.click();
	}
	
//	@When("user enters sales invoice details")
//	public void user_enters_sales_invoice_details() {
//		onSalesInvoicePage.txtbox_invoiceNo.clear();
//		onSalesInvoicePage.txtbox_invoiceNo.sendKeys(testContext.getMapTestData().get("invoiceNo"));
//		onSalesInvoicePage.txtbox_powo.sendKeys(testContext.getMapTestData().get("powo"));
//		onSalesInvoicePage.txtbox_powoDate.sendKeys(testContext.getMapTestData().get("powoDate"));
//		onSalesInvoicePage.txtbox_contactNo.sendKeys(testContext.getMapTestData().get("contactNumber"));
//	}
	
	@When("User clicks on Ok button on popup")
	public void user_clicks_on_ok_button_on_popup() {
	    acceptAlert(driver);
	}
	@When("User clicks on Sale Invoice details button")
	public void user_clicks_on_sale_invoice_details_button() {
		onSalesInvoicePage.link_saveInvoiceDetail.click();
	}
	@Then("user verifies that the Sales Invoice is created")
	public void user_verifies_that_the_sales_invoice_is_created() {
	    Assert.assertEquals(driver.findElement(By.xpath("//td[text()='909090']")).getText(), "909090");
	    onDashboardPage.link_delete.click();
	}
	

}
