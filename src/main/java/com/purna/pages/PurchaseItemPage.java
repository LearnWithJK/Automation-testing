package com.purna.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseItemPage {
	
	public PurchaseItemPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="sr_no")
	public WebElement textbox_srNo;
	
	@FindBy(id="itemcode")
	public WebElement textbox_itemcode;
	
	@FindBy(id="itemname")
	public WebElement textbox_itemname;
	
	@FindBy(name="units")
	public WebElement dropdown_units;
	
	@FindBy(id="supp_product_code")
	public WebElement textbox_suppCode;
	
	@FindBy(id="weight")
	public WebElement textbox_weight;
	
	@FindBy(id="txt_rate")
	public WebElement textbox_rate;
	
	@FindBy(id="txt_qty")
	public WebElement textbox_quantity;
	
	@FindBy(id = "txt_discount")      
	public WebElement textbox_discount;
	
	@FindBy(id="txt_amount")
	public WebElement textbox_amount;
	
	@FindBy(name="submit")
	public WebElement btn_addItem;
	
	@FindBy(linkText="Item Details")
	public WebElement link_itemDetails;
}
