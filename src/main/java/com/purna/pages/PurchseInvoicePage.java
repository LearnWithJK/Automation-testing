package com.purna.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchseInvoicePage {
	
	public PurchseInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="supplier_name")
	public WebElement dropdown_suppName;
	
	@FindBy(id="cont_no")
	public WebElement textbox_contactNo;
	
	@FindBy(id="credit_period")
	public WebElement dropdown_creditPeriod;
	
	@FindBy(name="credit_period1")
	public WebElement textbox_creditPeriodName;
	
	@FindBy(id="total_amount")
	public WebElement textbox_totalAmount;
	
	@FindBy(id="cgst")
	public WebElement dropdown_cgst;
	
	@FindBy(id="igst")
	public WebElement dropdown_igst;
	
	@FindBy(id="sgst")
	public WebElement dropdown_sgst;
	
	@FindBy(id="myButtonlast")
	public WebElement btn_calculate;
	
	@FindBy(id = "packing_and_forwarding")
	public WebElement textbox_packingAndForwarding;
	
	@FindBy(id = "deliverycharges")
	public WebElement textbox_deliveryCharges;
	
	@FindBy(id="btn")
	public WebElement btn_save;	
	
	@FindBy(linkText="Purchase Invoice Details")
	public WebElement link_purchaseInvoiceDetails;
	

}
