package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.WebdriverUtility;

public class AddBilling_ShippingAddress_page
{
	
	WebdriverUtility wutil = new WebdriverUtility();
    @FindBy(name = "billingaddress") private WebElement  BillingAdd_edt_txt;
    @FindBy(name = "bilingstate") private WebElement     Billingstate_edt_txt;
    @FindBy(name = "billingcity") private WebElement     Billingcity_edt_txt;
    @FindBy(name = "billingpincode") private WebElement  Billingpincode_edt_txt;
    @FindBy(name = "update") private WebElement          bill_updatebtn_edt_txt;
    @FindBy(name = "shippingaddress") private WebElement shippinghAdd_edt_txt;
    @FindBy(name = "shippingstate") private WebElement   shippingstate_edt_txt;;
    @FindBy(name = "shippingcity") private WebElement    shippinghcity_edt_txt;
    @FindBy(name = "shippingpincode") private WebElement shippinghpincode_edt_txt;
    @FindBy(name = "shipupdate") private WebElement      ship_updatebtn_edt_txt;
    @FindBy(name = "ordersubmit")private WebElement ordersubmit_edt_txt;
    
       
    public AddBilling_ShippingAddress_page(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }

    
    
	public WebElement getBillingAdd_edt_txt() {
		return BillingAdd_edt_txt;
	}

	public WebElement getBillingstate_edt_txt() {
		return Billingstate_edt_txt;
	}

	public WebElement getBillingcity_edt_txt() {
		return Billingcity_edt_txt;
	}

	public WebElement getBillingpincode_edt_txt() {
		return Billingpincode_edt_txt;
	}

	public WebElement getBill_updatebtn_edt_txt() {
		return bill_updatebtn_edt_txt;
	}

	public WebElement getShippinghAdd_edt_txt() {
		return shippinghAdd_edt_txt;
	}

	public WebElement getShippingstate_edt_txt() {
		return shippingstate_edt_txt;
	}

	public WebElement getShippinghcity_edt_txt() {
		return shippinghcity_edt_txt;
	}

	public WebElement getShippinghpincode_edt_txt() {
		return shippinghpincode_edt_txt;
	}

	public WebElement getShip_updatebtn_edt_txt() {
		return ship_updatebtn_edt_txt;
	}
    
	public WebElement getordersubmit_edt_txt()
	{
		return ordersubmit_edt_txt;
	}
	
    public void AddBilling_Address(WebDriver driver ,String bill_add,String bill_sta ,String bill_city ,String bill_pin )
    {
    	BillingAdd_edt_txt.sendKeys(bill_add);
    	Billingstate_edt_txt.sendKeys(bill_sta);
    	Billingcity_edt_txt.sendKeys(bill_city);
    	Billingpincode_edt_txt.sendKeys(bill_pin);
    	bill_updatebtn_edt_txt.click();
    	wutil.acceptAlert(driver);
    	
    }
    
    public void Addshipping_Address(WebDriver driver ,String ship_add,String ship_sta ,String ship_city ,String ship_pin )
    {
    	shippinghAdd_edt_txt.sendKeys(ship_add);
    	shippingstate_edt_txt.sendKeys(ship_sta);
    	shippinghcity_edt_txt.sendKeys(ship_city);
    	shippinghpincode_edt_txt.sendKeys(ship_pin);
    	ship_updatebtn_edt_txt.click();
    	wutil.acceptAlert(driver);
    	ordersubmit_edt_txt.click();
    }
    
} 
