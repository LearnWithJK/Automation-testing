package com.purna.stepdefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.purna.libraries.TestContext;
import com.purna.pages.DashboardPage;
import com.purna.pages.SupplierDashboardPage;
import com.purna.pages.SupplierPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Supplier_stepdefinition {
	WebDriver driver;
	private TestContext testContext;
	private DashboardPage onDashboardPage;
	private SupplierDashboardPage onSupplierDashboardPage;
	private SupplierPage onSupplierPage;
	
	
	public Supplier_stepdefinition(TestContext context)
    {
        testContext = context;
        driver = testContext.getDriver();
        onDashboardPage = new DashboardPage(driver);
        onSupplierDashboardPage = new SupplierDashboardPage(driver);
        onSupplierPage = new SupplierPage(driver);
    }

	@When("User clicks on Main Menu")
	public void user_clicks_on_main_menu() {
		onDashboardPage.link_main.click();
	}

	@When("User clicks on supplier link")
	public void user_clicks_on_supplier_link() {
		onDashboardPage.link_supplier.click();
	}

	@When("User clicks on New Supplier button")
	public void user_clicks_on_new_supplier_button() {
		onSupplierDashboardPage.btn_newSupplier.click();
	}

	@When("User enters below supplier details")
	public void user_enters_below_supplier_details() {
		
		
		onSupplierPage.txtBox_supplierName.sendKeys(testContext.getMapTestData().get("CustName"));
		onSupplierPage.txtBox_contactNoSupplier.sendKeys(testContext.getMapTestData().get("contactNumber"));
		
	}

	@When("User clicks on supplier Save button")
	public void user_clicks_on_save_button() {
		onSupplierPage.btn_save.click();
		driver.switchTo().alert().accept();
	}

	@When("User clicks on Supplier details button")
	public void user_clicks_on_supplier_details_button() {
		onSupplierPage.btn_supplierDetails.click();
	}

	@Then("Supplier should be created")
	public void supplier_should_be_created() {
		Assert.assertEquals(driver.findElement(By.xpath("//td[text()='John']")).getText(), "John");
	}
	
}
