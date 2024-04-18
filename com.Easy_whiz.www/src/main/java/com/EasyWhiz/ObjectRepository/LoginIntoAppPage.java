package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginIntoAppPage 
{ 
	
     //declearction
	 @FindBy(xpath  ="//a[.='My Account']") private WebElement myAccountlinkedttxt;
	 @FindBy(id = "exampleInputEmail1") private WebElement email_edt_txt;
	 @FindBy(id = "exampleInputPassword1") private WebElement password_edt_txt;
	 @FindBy(name = "login") private WebElement loginbtn_edt_txt;
	
	 
	 // initialization
	 public LoginIntoAppPage(WebDriver driver)
	 {
		 PageFactory.initElements(driver,this );
	 }

	 // utilization
	 
	public WebElement getMyAccountlinkedttxt() {
		return myAccountlinkedttxt;
	}

	public WebElement getEmail_edt_txt() {
		return email_edt_txt;
	}

	public WebElement getPassword_edt_txt() {
		return password_edt_txt;
	}

	public WebElement getLoginbtn_edt_txt() {
		return loginbtn_edt_txt;
	}
	 
//	public WebElement getLogout_btn() 
//	{
//		return logout_btn;
//	}
	 // bussiness library
	/**
	 * this method is used to login
	 * @param username
	 * @param Password
	 */
	
	public void loginToApp(WebDriver driver, String username ,String Password)
	{
		
		myAccountlinkedttxt.click();
		email_edt_txt.sendKeys(username);
		password_edt_txt.sendKeys(Password);
		loginbtn_edt_txt.click();
	}
	 
	

	public void loginToApp(WebDriver driver,String url, String username ,String Password)
	{
		driver.get(url);
		myAccountlinkedttxt.click();
		email_edt_txt.sendKeys(username);
		password_edt_txt.sendKeys(Password);
		loginbtn_edt_txt.click();
	}
	
	
//	public void logout_from_app() throws InterruptedException
//	{
//		Thread.sleep(2000);
//		logout_btn.click();
//		
//	}
	
	 
}
