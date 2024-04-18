package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.JavaUtility;
import com.genericUtilities.WebdriverUtility;

public class Create_subcategory_page
  {
	WebdriverUtility wutil = new WebdriverUtility();
	   @FindBy(xpath = "//a[.='Sub Category ']") private WebElement clickOnsubCreate_cat;
	   @FindBy(xpath = "//select[@name ='category']")private WebElement category_dd_txt;
	   @FindBy(xpath = "//input[@name='subcategory']")private WebElement subcat_name_edt_txt;
	   @FindBy(name = "submit")private WebElement submit_btn_txt;
	   @FindBy(xpath = "//div[@class='alert alert-success']")private WebElement act_msg_txt;
	   
	   
	   public Create_subcategory_page(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }


	public WebElement getClickOnsubCreate_cat() {
		return clickOnsubCreate_cat;
	}
	

	public WebElement getcategory_dd_txt() {
		return category_dd_txt;
	}
	
	public WebElement getsubcat_name_edt_txt()
	{
		return subcat_name_edt_txt;
	}
	
	public WebElement getsubmit_btn_txt()
	{
		return submit_btn_txt;
	}
	
	public WebElement getact_msg_txt()
	{
		return act_msg_txt;
	}
	   
	   public void Create_subcategory(String cat_name, String subcat_name, String exp_confmsg)
	   {
		   clickOnsubCreate_cat.click();
		   wutil.handleDropdown(category_dd_txt, cat_name);
		   subcat_name_edt_txt.sendKeys(subcat_name);
		   submit_btn_txt.click();
		   String act_confmsg = act_msg_txt.getText();
		      if(act_confmsg.contains(exp_confmsg))
		      {
		    	  System.out.println("Confirmation message is matched,,");
		      }
		      else
		      {
		    	  System.out.println("confirmation message is not matched");
		      }
		      System.out.println(subcat_name+" sub category is created");
	   }
	   
} 

