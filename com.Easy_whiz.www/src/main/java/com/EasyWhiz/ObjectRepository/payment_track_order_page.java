package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.ExcelUtility;
import com.genericUtilities.WebdriverUtility;

public class payment_track_order_page 
{  
	  WebdriverUtility wutil = new WebdriverUtility();
	  
	 
     @FindBy(name = "paymethod") private WebElement cod_radio_btn;
     @FindBy(name = "submit") private WebElement submitclick_edt_txt;
     @FindBy(xpath = "//tr[last()]/td[last()]//a") private WebElement track_link_edt_txt;
     @FindBy(xpath = "//td[@class='fontkink']") private WebElement orderid_edttxt;
     @FindBy(name = "paymethod") private WebElement internetbank_radio_btn;
     @FindBy(xpath = "//input[@value ='Debit / Credit card']")private WebElement debit_credit_card_radio_btn;
     
     // initizalation
     public payment_track_order_page(WebDriver driver)
     {
    	 PageFactory.initElements(driver, this);
     }
     
     // utilization
     
	public WebElement getCodclick_edt_txt() {
		return cod_radio_btn;
	}
	
	public WebElement getSubmitclick_edt_txt() {
		return submitclick_edt_txt;
	}
     
	public WebElement gettrack_link_edt_txt()
    {
   	 return track_link_edt_txt;
    }
	
	public WebElement getorderid_edttxt()
	{
		return orderid_edttxt;
	}
	
	
     public void payment_throW_COD()
     {
    	 cod_radio_btn.click();
    	 submitclick_edt_txt.click();
     }
     
     public void payment_Internet_bank()
     {
    	 internetbank_radio_btn.click();
    	 submitclick_edt_txt.click();
     }
     
     public void payment_debit_credit_card()
     {
    	 debit_credit_card_radio_btn.click();
    	 submitclick_edt_txt.click();
     }
     
     public String trackOrder(WebDriver driver,String exp_url) throws Exception
     {
    	 String pwind = driver.getWindowHandle();
    	 track_link_edt_txt.click();
    	  wutil.switchToWindow(driver,exp_url);
    	  String orderid = orderid_edttxt.getText();
    	 System.out.println("orderis ------->"+ orderid); 
    	 driver.switchTo().window(pwind);
    	//  driver.quit();
    	 Thread.sleep(3000);
    	 return orderid;
       
     }
         
     }
