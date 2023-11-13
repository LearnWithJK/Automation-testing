package com.purna.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.purna.libraries.Utilities;

public class SalesInvoicePage extends Utilities
{
	public SalesInvoicePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(id="invoice_no")
    public WebElement txtbox_invoiceNo;
    
    @FindBy(id="powo")
    public WebElement txtbox_powo;
    
    @FindBy(id="powo_date")
    public WebElement txtbox_powoDate;
    
    @FindBy(id="bill_to")
    public WebElement dropdown_billTo;
    
    @FindBy(id="contc_no")
    public WebElement txtbox_contactNo;

    @FindBy(id="btn")
    public WebElement btn_save;
    
    @FindBy(linkText="Sale Invoice Details")
    public WebElement link_saveInvoiceDetail;
    
}
