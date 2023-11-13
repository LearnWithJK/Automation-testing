package com.purna.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {
	
	public ProjectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="sr_no")
	public WebElement txtBox_srNo;
	
	@FindBy(id="project_code")
	public WebElement txtBox_projectCode;
	
	@FindBy(id="project_name")
	public WebElement txtBox_projectName;
	
	@FindBy(id="budget_amount")
	public WebElement txtBox_budgetAmount;
	
	@FindBy(id="cust_name")
	public WebElement dropdown_custName;
	
	@FindBy(id="btn")
	public WebElement btn_save;
	
	@FindBy(linkText="Project Details")
	public WebElement link_projectDetails;
	
	
}
