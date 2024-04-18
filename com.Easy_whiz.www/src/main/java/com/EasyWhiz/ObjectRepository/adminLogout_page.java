package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class adminLogout_page 
{
 //   @FindBy(xpath = "//a[@class='dropdown-toggle']")	private WebElement admin_toggle_logout;
   
  
  public adminLogout_page(WebDriver driver)
  {
	  PageFactory.initElements (driver ,this);
  }
  
  @FindBy(partialLinkText = "Logout") private WebElement logoutlink;
  
  public WebElement getLogoutlink() {
	return logoutlink;
  }
//  public WebElement getadmin_toggle_logout()
//  {
//	  return admin_toggle_logout;
//  }



public void adminlogout()
  {
	//  admin_toggle_logout.click();
	  logoutlink.click();
  }
  
}
