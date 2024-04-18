package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.JavaUtility;
import com.genericUtilities.WebdriverUtility;

public class wishlist_page 
{      
	   WebdriverUtility wutil = new WebdriverUtility();
	   @FindBy(className = "search-field") private WebElement searchFieldedt_txt;
	   @FindBy(className = "search-button") private WebElement searchBtnedt_txt;
	   @FindBy(xpath = "//a[.='Apple iPhone 6 (Silver, 16 GB)']") private WebElement appleIphoneedt_txt;
	   @FindBy(xpath = "//a[@data-original-title='Wishlist']") private WebElement clickOnWishedt_txt;
	   @FindBy(xpath = "//i[@class ='fa fa-times']")private WebElement cancel_icon_txt;
	   
	   public wishlist_page(WebDriver driver )
	   {
		   PageFactory.initElements(driver, this);
	   }
	   
	   public void add_to_wishlist(String search_for)
	   {
		   searchFieldedt_txt.sendKeys(search_for);
		   searchBtnedt_txt.click();
		   appleIphoneedt_txt.click();
		   clickOnWishedt_txt.click();
		   System.out.println("item added to wishlist");
	   }
	   
	   
	   public void rermove_from_wishlist(WebDriver driver)
	   {
		   cancel_icon_txt.click();
		   wutil.acceptAlert(driver);
		   System.out.println("item removed from wishlist");
	   }
	   
	   
}
