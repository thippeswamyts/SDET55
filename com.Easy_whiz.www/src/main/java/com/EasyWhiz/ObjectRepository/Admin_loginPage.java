package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_loginPage 
{ 
	// declearction
     @FindBy(xpath = "//input[@name='username']")private WebElement username_edt_txt;
     @FindBy(id = "inputPassword")private WebElement password_edt_txt;
     @FindBy(xpath = "//button[.='Login']")private WebElement clickOnLOgin_btn_edttxt;
     
     // initialization
     public Admin_loginPage(WebDriver driver)
     {
    	 PageFactory.initElements( driver, this);
     }

     
     // utilization
     
     public WebElement getUsername_edt_txt() {
 		return username_edt_txt;
 	}

 	public WebElement getPassword_edt_txt() {
 		return password_edt_txt;
 	}

 	public WebElement getClickOnLOgin_btn_edttxt() {
 		return clickOnLOgin_btn_edttxt;
 	}
     
 	// business library
 	
 	public void adminlogin(String username, String password)
 	{
 		username_edt_txt.sendKeys(username);
 		password_edt_txt.sendKeys(password);
 		clickOnLOgin_btn_edttxt.click();
 		System.out.println("admin home page is displayed");
 	}
 	
 	
 	
 	
}