package com.EasyWhiz.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genericUtilities.WebdriverUtility;

public class cart_page 
{     
	WebdriverUtility wutil = new WebdriverUtility();
	@FindBy(className = "search-field") private WebElement entersearchField;
    @FindBy(className = "search-button") private WebElement searchBtnedt_txt;
    @FindBy(name = "submit")private WebElement update_shopping_cart_btn;
    @FindBy(name = "ordersubmit")private WebElement ordersubmit_button;
    
    public cart_page(WebDriver driver)
    {
    	PageFactory.initElements(driver , this);
    }
    
    
    
    
    public void addtocart(WebDriver driver ,String product_name) throws InterruptedException
    {
    	entersearchField.sendKeys(product_name);
    	searchBtnedt_txt.click();
    	Thread.sleep(4000);
    	WebElement ele = driver.findElement(By.xpath("//a[text()='"+product_name+"']/../../following-sibling ::div[@class ='cart clearfix animate-effect']//button[.='Add to cart']"));
    	ele.click();
    	wutil.acceptAlert(driver);
    }
    
    
    
    public void removeFromCart(WebDriver driver ,String product_name)
    {
    	
    driver.findElement(By.xpath("//a[.='"+product_name+"']/ancestor:: td[@class='cart-product-name-info']/preceding-sibling:: td/input[@name='remove_code[]']")).click();
    update_shopping_cart_btn.click();
    wutil.dismissAlert(driver);
    }
    
    public void cartToPayment()
    {
    	ordersubmit_button.click();
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
