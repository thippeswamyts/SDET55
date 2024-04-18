package testng;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepository.cart_page;
import com.EasyWhiz.ObjectRepository.payment_track_order_page;
import com.genericUtilities.BASECLASS2;
import com.genericUtilities.ExcelUtility;

@Listeners(com.genericUtilities.ListerImpClass.class)
public class Multi_item_cart_orderTest  extends BASECLASS2{

	@Test(retryAnalyzer = com.genericUtilities.RetryImpClass.class)
	public  void multi_order() throws Exception
	{
		ExcelUtility excel = new ExcelUtility();
		String search_for = excel.ReadSingleDatafromExcel("EWtestdata", 13, 1);
		String search_for2 = excel.ReadSingleDatafromExcel("EWtestdata", 24, 1);
		
//		System.out.println(search_for);
//		System.out.println(search_for2);
        
		cart_page cart = new cart_page(driver);
		cart.addtocart(driver, search_for);
		
		cart.addtocart(driver, search_for2);
		
		cart.cartToPayment();
		
		payment_track_order_page payment = new payment_track_order_page(driver);
		payment.payment_Internet_bank();
		
    
	}

}

/**
 * 
 * -------------------------------------------------------------------------------------------------------------
 * 
 * 
 * // fetch data from property file
	    FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\commomdata.properties");
	    Properties pobj = new Properties();
	    pobj.load(fis1);
        
	    
	    // fetch data from excel file   
	    FileInputStream fis2 = new FileInputStream("C:\\Users\\Dell\\Downloads\\finnalTC.xlsx");
	             Workbook wb = WorkbookFactory.create(fis2);
	             Sheet sh=    wb.getSheet("EWtestdata");
	             String search_for = sh.getRow(13).getCell(1).getStringCellValue();
	             String search_for2 = sh.getRow(24).getCell(1).getStringCellValue();
	             
	             String URL = pobj.getProperty("user_url");
	 		    String USERNAME = pobj.getProperty("user_username");
	 		    String PASSWORD = pobj.getProperty("user_password");
	 		    
	 		    ChromeDriver driver = new ChromeDriver();
	 		     driver.manage().window().maximize();
	 		    driver.get(URL);
	 		    
	 		    //user login 
	 		    driver.findElement(By.xpath("//a[.='My Account']")).click();
	 		    driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
	 		    driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
	 		    driver.findElement(By.name("login")).click();
	 		    System.out.println("user login sucessfully");
	 		    
	 		    // add 1 item to cart
	 		    driver.findElement(By.className("search-field")).sendKeys(search_for);
			    driver.findElement(By.className("search-button")).click();
			  driver.findElement(By.xpath("//a[.='Apple iPhone 6 (Silver, 16 GB)']/ancestor "
			 + ":: div[@class=\"product-info text-left\"]/following-sibling :: div//button[@class=\"btn btn-primary\"]")).click();
			  driver.switchTo().alert().accept();
			  
			
	             // add 2 item to cart
			  driver.findElement(By.className("search-field")).sendKeys(search_for2);
			    driver.findElement(By.className("search-button")).click();
			    driver.findElement(By.xpath("//a[.='Redmi Note 4 (Gold, 32 GB)  (With 3 GB RAM)']/ancestor"
			 + " :: div[@class=\"product-info text-left\"]/following-sibling :: div//button[@class=\"btn btn-primary\"]")).click();
			    driver.switchTo().alert().accept();
			    
			    
			    driver.findElement(By.name("ordersubmit")).click();
			    
			 // make payment through internet banking
			    driver.findElement(By.xpath("//input[@value=\"Internet Banking\"]")).click();
			    driver.findElement(By.name("submit")).click();
			    System.out.println("order placed sucessfully");
 * **/

