package com.purna.stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.LoginPage;
import com.purna.pages.ProjectDashboardPage;
import com.purna.pages.ProjectPage;
import com.purna.pages.PurchaseItemDashPage;
import com.purna.pages.PurchaseItemPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Project_stepdefinition extends Utilities{
	
	private WebDriver driver;
    private TestContext testContext;
    private DashboardPage onDashboardPage;
    private ProjectDashboardPage onProjectDashboardPage;
	private ProjectPage onProjectPage;
	
	public Project_stepdefinition(TestContext context) {
		testContext = context;
		driver = testContext.getDriver();
		onDashboardPage = new DashboardPage(driver);
		onProjectDashboardPage = new ProjectDashboardPage(driver);
		onProjectPage = new ProjectPage(driver);	
	}
	
		
	@When("user clicks on project link")
	public void user_clicks_on_project_link() {
		onDashboardPage.link_project.click();
	}
	
	@When("user clicks on add new project button")
	public void user_clicks_on_add_new_project_button() {
		onProjectDashboardPage.btn_addNewProject.click();
	}
	
	@When("user enters project details")
	public void user_enters_project_details() {
		onProjectPage.txtBox_projectCode.sendKeys(testContext.getMapTestData().get("projectCode"));
		onProjectPage.txtBox_projectName.sendKeys(testContext.getMapTestData().get("projectName"));
		onProjectPage.textbox_remark.sendKeys(testContext.getMapTestData().get("Remark"));
		onProjectPage.txtBox_budgetAmount.sendKeys(testContext.getMapTestData().get("budgetAmout"));
		
		doDropdownUsingIndex(onProjectPage.dropdown_custName, 1);
	}
	
	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		onProjectPage.btn_save.click();
	}
	
	@When("user clicks on project details button")
	public void user_clicks_on_project_details_button() {
		onProjectPage.link_projectDetails.click();
	}
	
	@Then("user verifies that the new project is created")
	public void user_verifies_that_the_new_project_is_created() {
	    Assert.assertEquals("Purna App", driver.findElement(By.xpath("//td[text()='Purna App']")).getText());
	    driver.findElement(By.xpath("//td[text()='Purna App']//following::a[text()='Delete']")).click();
	    driver.switchTo().alert().accept();
	}

}
