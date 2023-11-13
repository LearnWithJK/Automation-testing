package com.purna.stepdefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.purna.libraries.TestContext;
import com.purna.libraries.Utilities;
import com.purna.pages.DashboardPage;
import com.purna.pages.ProjectDashboardPage;
import com.purna.pages.ProjectPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Project_stepDefinition extends Utilities{
	private WebDriver driver;
    private TestContext testContext;
    private DashboardPage onDashboardPage;
    private ProjectDashboardPage onProjectDashboardPage;
    private ProjectPage onProjectPage;
   
	
	public Project_stepDefinition(TestContext context) {
		testContext = context;
    	driver = testContext.getDriver();
    	onDashboardPage = new DashboardPage(driver);
    	onProjectDashboardPage = new ProjectDashboardPage(driver);
    	onProjectPage = new ProjectPage(driver);
	}
	
	@When("user clicks on project link")
	public void user_clicks_on_project_link() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(onDashboardPage.link_project));
		
		syncElement(driver, onDashboardPage.link_project, "ToClickable");
		onDashboardPage.link_project.click();
	}
	
	@When("user clicks on add new project button")
	public void user_clicks_on_add_new_project_button() {
		onProjectDashboardPage.btn_addNewProject.click();
	}
	
	@When("user enters project details")
	public void user_enters_below_project_details() {
		onProjectPage.txtBox_srNo.clear();
		onProjectPage.txtBox_srNo.sendKeys(testContext.getMapTestData().get("srNo"));
		onProjectPage.txtBox_projectCode.sendKeys(testContext.getMapTestData().get("projectCode"));
		onProjectPage.txtBox_projectName.sendKeys(testContext.getMapTestData().get("projectName"));
		onProjectPage.txtBox_budgetAmount.sendKeys(testContext.getMapTestData().get("budgetAmout"));
		
//		Select select = new Select(onProjectPage.dropdown_custName);
//		select.selectByVisibleText(testContext.getMapTestData().get("customerName"));
		
		doDropDownUsingVisibleText(onProjectPage.dropdown_custName, testContext.getMapTestData().get("customerName"));
	}
	
	@When("user clicks on save button")
	public void user_clicks_on_save_button() {
		onProjectPage.btn_save.click();
	}
	@When("user clicks on ok button on popup")
	public void user_clicks_on_ok_button_on_popup() {
		acceptAlert(driver);
	}
	@When("clicks on project details button")
	public void clicks_on_project_details_button() {
		onProjectPage.link_projectDetails.click();
	}
	@Then("user verifies that the new project is created")
	public void user_verifies_that_the_new_project_is_created() {
	    Assert.assertEquals(driver.findElement(By.xpath("//td[text()='PurnaData']")).getText(), "PurnaData");
	}

}
