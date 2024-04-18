package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class addTowisht_to_CartPage 
{ 
	 // delaeration
   @FindBy(className = "search-field") private WebElement searchFieldedt_txt;
   @FindBy(className = "search-button") private WebElement searchBtnedt_txt;
   @FindBy(xpath = "//a[.='Apple iPhone 6 (Silver, 16 GB)']") private WebElement appleIphoneedt_txt;
   @FindBy(xpath = "//a[@data-original-title='Wishlist']") private WebElement clickOnWishedt_txt;
   @FindBy(xpath = "//a[.='Add to cart']") private WebElement clickOnCart_btn_edt_cart ;
   @FindBy(xpath = "//i[@class='icon fa fa-shopping-cart']") private WebElement clickOnCarticonedt_txt;
   
   
	// initization
   public addTowisht_to_CartPage(WebDriver driver )
   {
	   PageFactory.initElements(driver, this);
   }

   // utilization
   
public WebElement getSearchFieldedt_txt() {
	return searchFieldedt_txt;
}

public WebElement getSearchBtnedt_txt() {
	return searchBtnedt_txt;
}

public WebElement getAppleIphoneedt_txt() {
	return appleIphoneedt_txt;
}

public WebElement getClickOnWishedt_txt() {
	return clickOnWishedt_txt;
}
	
public WebElement getClickOnCart_btn_edt_cart() {
	return clickOnCart_btn_edt_cart;
}

public WebElement getClickOnCarticonedt_txt() {
	return clickOnCarticonedt_txt;
}
	// business library
    public void addTowisht_to_Cart(String search_for)
    {
    	searchFieldedt_txt.sendKeys(search_for);
    	searchBtnedt_txt.click();
    	appleIphoneedt_txt.click();
    	clickOnWishedt_txt.click();
    	clickOnCart_btn_edt_cart.click();
    	clickOnCarticonedt_txt.click();
    	
    }
	 
	
}
