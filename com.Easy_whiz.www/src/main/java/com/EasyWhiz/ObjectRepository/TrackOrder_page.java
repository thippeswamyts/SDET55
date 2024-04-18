package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrackOrder_page 
{
  @FindBy(xpath = "//span[.='Track Order']")private WebElement clickOntracklink;
  @FindBy(id = "exampleOrderId1")private WebElement enterorderid;
  @FindBy(id = "exampleBillingEmail1")private WebElement enteruseremail;
  @FindBy(name = "submit") private WebElement submitbutton;
  
  public TrackOrder_page(WebDriver driver )
  {
	  PageFactory.initElements(driver , this ); 
  }
  
  
  
  
  public WebElement getClickOntracklink() {
	return clickOntracklink;
}




public WebElement getEnterorderid() {
	return enterorderid;
}




public WebElement getEnteruseremail() {
	return enteruseremail;
}




public WebElement getSubmitbutton() {
	return submitbutton;
}




public void TrackOrder(String order_id ,String username_email)
  {
	  clickOntracklink.click();
	  enterorderid.sendKeys(order_id);
	  enteruseremail.sendKeys(username_email);
	  submitbutton.click();
  }
  
  
  
}
