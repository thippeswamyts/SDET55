package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.WebdriverUtility;

public class Insert_item_page 
{     
	WebdriverUtility wutil = new WebdriverUtility(); 
    @FindBy(xpath = "//a[.='Insert Product ']")private WebElement clickOnInsert_link;
    @FindBy(xpath = "//select[@name='category']")private WebElement cat_name_dd_txt;
    @FindBy(xpath = "//select[@name='subcategory']")private WebElement subcat_name_dd_txt;
    @FindBy(name = "productName")private WebElement productName_txt;
    @FindBy(name = "productCompany")private WebElement productCompany_txt;
    @FindBy(name = "productpricebd")private WebElement prodprice_beforedis;
    @FindBy(name = "productprice")private WebElement prod_price_txt;
    @FindBy(name = "productDescription")private WebElement prod_desc;
    @FindBy(name = "productShippingcharge")private WebElement prod_ship_charge;
    @FindBy(name = "productAvailability")private WebElement prod_avialib_dd;
    @FindBy(id = "productimage1")private WebElement img1;
    @FindBy(name = "productimage2")private WebElement img2;
    @FindBy(name = "productimage3")private WebElement img3;
    @FindBy(name = "submit")private WebElement submit_btn;
    @FindBy(xpath = "//div[@class='alert alert-success']")private WebElement conf_msg;
    
    public Insert_item_page(WebDriver driver)
    {
    	PageFactory.initElements(driver ,this);
    }
    
    
    
    public void Insert_item(String cat_name, String subcat_name ,String prod_name,String prod_compname,String prodprice_bd, String prod_price_ad ,String proddesc, String ship_charge , String prodavail , String exp_conf_msg) throws InterruptedException
    {
    	clickOnInsert_link.click();
    	wutil.handleDropdown(cat_name_dd_txt, cat_name);
    	wutil.handleDropdown(subcat_name_dd_txt, subcat_name);
    	productName_txt.sendKeys(prod_name);
    	productCompany_txt.sendKeys(prod_compname);
    	prodprice_beforedis.sendKeys(prodprice_bd);
    	prod_price_txt.sendKeys(prod_price_ad);
    	prod_desc.sendKeys(proddesc);
    	prod_ship_charge.sendKeys(ship_charge);
    	
    	wutil.handleDropdown(prod_avialib_dd, prodavail);
    	// Thread.sleep(10000);
    	img1.sendKeys("D:\\eclipse_works\\com.Easy_whiz.www\\src\\test\\resources\\1355180.jpeg");
    	img2.sendKeys("D:\\eclipse_works\\com.Easy_whiz.www\\src\\test\\resources\\1355180.jpeg");
    	img3.sendKeys("D:\\eclipse_works\\com.Easy_whiz.www\\src\\test\\resources\\1355180.jpeg");
    	submit_btn.click();
    	
    	 String act_conf_msg = conf_msg.getText();
    	 if(act_conf_msg.contains(exp_conf_msg))
    	 {
    		 System.out.println("Confirmation message 3  is matched,,");
    	 }
    	 else
    	 {
    		 System.out.println("confirmation message 3 is not matched");
    	 }
    	 System.out.println(prod_name+" product is inserted");
    }
    
}

