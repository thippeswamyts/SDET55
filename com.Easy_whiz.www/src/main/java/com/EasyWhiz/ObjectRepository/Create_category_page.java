package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.JavaUtility;
import com.genericUtilities.WebdriverUtility;

 

public class Create_category_page

{   
	  	  WebdriverUtility wutil = new WebdriverUtility();
   @FindBy(xpath = "//a[.=' Create Category ']")private WebElement clickOnCreate_cat ;
   @FindBy(name = "category")private WebElement category_edt_txt;
   @FindBy(xpath = "//textarea[@name='description']")private WebElement desc_edt_txt;
   @FindBy(xpath = "//button[text()='Create']")private WebElement clickOn_login_btn;
   @FindBy(xpath = "//div[@class='alert alert-success']")private WebElement act_msg_txt;
     
   
   
   public Create_category_page(WebDriver driver )
   {
	   PageFactory.initElements(driver, this);
   }
   
   
   public WebElement getClickOnCreate_cat() {
	return clickOnCreate_cat;
}



public WebElement getCategory_edt_txt() {
	return category_edt_txt;
}



public WebElement getDesc_edt_txt() {
	return desc_edt_txt;
}



public WebElement getClickOn_login_btn() {
	return clickOn_login_btn;
}



public WebElement getAct_msg_txt() {
	return act_msg_txt;
}


// business library
public void create_category(String cat_name, String desc , String Exp_conf_msg) throws Exception
   {
	   clickOnCreate_cat.click();
	   category_edt_txt.sendKeys(cat_name);
	   desc_edt_txt.sendKeys(desc);
	   clickOn_login_btn.click();
	   	 String act_conf_msg = act_msg_txt.getText();
	   	 System.out.println(act_conf_msg);
	   	 
	   	 if(act_conf_msg.contains(Exp_conf_msg))
	   	 {
	   		 System.out.println("Confirmation message is matched,,,");
	   	 }
	   	 else
	   	 {
	   		 System.out.println("confirmation message is not matched");
	   	 }
	  	    System.out.println(cat_name+" category is created");
	 	    
   
   }
   
}
