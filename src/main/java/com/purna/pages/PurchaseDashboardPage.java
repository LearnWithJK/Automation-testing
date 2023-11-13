package com.purna.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseDashboardPage {
	
	public PurchaseDashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="btn_new_party")
	public WebElement btn_newPuchaseInvoice;
	
	@FindBy(xpath="//td[text()='John']/following::a[text()='Delete']")
	public WebElement link_delete;
}
