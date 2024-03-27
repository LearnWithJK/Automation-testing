package com.purna.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.LoginPage;
import com.purna.pages.SalesInvoicePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SalesInvoice_stepdefinition extends Utilities{
	private WebDriver driver;
    private TestContext testContext;
	LoginPage onLoginPage;
	DashboardPage onDashboardPage;
	SalesInvoicePage onSalesInvoicePage;
	
	public SalesInvoice_stepdefinition(TestContext context) {
		testContext = context;
    	driver = testContext.getDriver();
		onLoginPage = new LoginPage(driver);
		onDashboardPage = new DashboardPage(driver);
		onSalesInvoicePage = new SalesInvoicePage(driver);
	}
	
	@When("user clicks on New sale invoice button")
	public void user_clicks_on_new_sale_invoice_button() {
		onDashboardPage.btn_newSaleInvoice.click();
	}
	
	@When("user enters sales invoice details")
	public void user_enters_sales_invoice_details() {
		onSalesInvoicePage.txtbox_powo.sendKeys(testContext.getMapTestData().get("powoNo"));
		onSalesInvoicePage.txtbox_powoDate.sendKeys(testContext.getMapTestData().get("powo_date"));
		
		doDropDownUsingValue(onSalesInvoicePage.dropdown_billTo, "Sakshi");
		
		
	}
	@When("user save the sales invoice details")
	public void user_save_the_sales_invoice_details() {
		onSalesInvoicePage.btn_save.click();
		acceptAlert(driver);
	    
	}
	@When("user clicks on sales invoice details button")
	public void use_clisk_on_sales_invoice_details_button() {
		onSalesInvoicePage.link_saveInvoiceDetail.click();
	}
	@Then("new sales invoice should be created")
	public void new_sales_invoice_should_be_created() {
	    Assert.assertEquals("Sakshi", driver.findElement(By.xpath("//td[text()='Sakshi']")).getText());
	}

}
