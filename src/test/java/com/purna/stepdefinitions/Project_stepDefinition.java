package com.purna.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.ProjectDashboardPage;
import com.purna.pages.ProjectPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Project_stepdefinition extends Utilities{
	
	private WebDriver driver;
    private TestContext testContext;
    DashboardPage onDashboardPage;
	ProjectPage onProjectPage;
	ProjectDashboardPage onProjectDashboardPage;
	
	public Project_stepdefinition(TestContext context) {
		testContext = context;
    	driver = testContext.getDriver();
    	onDashboardPage = new DashboardPage(driver);
    	onProjectPage = new ProjectPage(driver);
    	onProjectDashboardPage = new ProjectDashboardPage(driver);
	}
	
	@When("user clicks on project link")
	public void user_clicks_on_project_link() {
//		syncElement(driver, onDashboardPage.link_project, "ToClickable");
//		onDashboardPage.link_project.click();
		clickElement(driver, onDashboardPage.link_project);
	}
	
	@When("user clicks on add new project button")
	public void user_clicks_on_add_new_project_button() {
		syncElement(driver, onProjectDashboardPage.btn_addNewProject, "ToClickable");
		onProjectDashboardPage.btn_addNewProject.click();
	}
	
	@When("user enters project details")
	public void user_enters_project_details() {
		onProjectPage.txtBox_srNo.clear();
		onProjectPage.txtBox_srNo.sendKeys(testContext.getMapTestData().get("srNumber"));
		onProjectPage.txtBox_projectCode.sendKeys(testContext.getMapTestData().get("projectCode"));
		onProjectPage.txtBox_projectName.sendKeys(testContext.getMapTestData().get("projectName"));
		onProjectPage.textbox_remark.sendKeys(testContext.getMapTestData().get("remark"));
		onProjectPage.txtBox_budgetAmount.sendKeys(testContext.getMapTestData().get("budgetAmout"));
		
		doDropdownUsingIndex(onProjectPage.dropdown_custName, 1);
	}
	
	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		syncElement(driver, onProjectPage.btn_save, "ToClickable");
		onProjectPage.btn_save.click();
	}
	
	@When("user clicks on project details button")
	public void user_clicks_on_project_details_button() {
		syncElement(driver, onProjectPage.link_projectDetails, "ToClickable");
		onProjectPage.link_projectDetails.click();
	}
	
	@Then("user verifies that the new project is created")
	public void user_verifies_that_the_new_project_is_created() {
	    Assert.assertEquals(driver.findElement(By.xpath("//td[text()='PR01234']")).getText(), "PR01234");
	}


}
