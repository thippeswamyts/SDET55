package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userlogout_page {

	
	 @FindBy(xpath = "//a[.='Logout']")private WebElement logout_btn;
	 
	 
	 public userlogout_page(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this );
	 }
	 
	 
	 public void logout()
	 {
		 logout_btn.click(); 
	 }
}
