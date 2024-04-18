package testng;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepository.LoginIntoAppPage;
import com.EasyWhiz.ObjectRepository.wishlist_page;
import com.genericUtilities.BASECLASS2;
import com.genericUtilities.ExcelUtility;
import com.genericUtilities.FileUtility;
import com.genericUtilities.WebdriverUtility;

@Listeners(com.genericUtilities.ListerImpClass.class)
public class wishlist_add_remove_itemTest extends BASECLASS2 {

	     @Test(retryAnalyzer = com.genericUtilities.RetryImpClass.class)
	    public void wishlist() throws Exception {
		 WebdriverUtility wutil = new WebdriverUtility();
		// fetch data from property file
//		 FileUtility futil = new FileUtility();
//		 String user_url =  futil.ReadDataFromPropertyFile("user_url");
//		 String username  = futil.ReadDataFromPropertyFile("user_username");
//		 String password =  futil.ReadDataFromPropertyFile("user_password");
		
		// fetch data from excel file 
		ExcelUtility eutil = new ExcelUtility();
		String search_for = eutil.ReadSingleDatafromExcel("EWtestdata", 13, 1);
		
//		WebDriver driver = new ChromeDriver();
//		wutil.maximizeBrowser(driver);
//		wutil.waitForPageLoad(driver, 10);
		
//		LoginIntoAppPage LoginIntoApp = new LoginIntoAppPage(driver);
//		LoginIntoApp.loginToApp(driver, user_url, username, password);
		
		wishlist_page wishlist = new wishlist_page(driver );
		wishlist.add_to_wishlist(search_for);
		wishlist.rermove_from_wishlist(driver);
		 
		
	}}
		// -------------------------------------------------------------------------------------------------------
		
		
		
		/**
		
		// fetch data from property file
	    FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\commomdata.properties");
	    Properties pobj = new Properties();
	    pobj.load(fis1);
	    String URL = pobj.getProperty("user_url");
	    String USERNAME = pobj.getProperty("user_username");
	    String PASSWORD = pobj.getProperty("user_password");
        
	    
	// fetch data from excel file   
	    FileInputStream fis2 = new FileInputStream("C:\\Users\\Dell\\Downloads\\finnalTC.xlsx");
	             Workbook wb = WorkbookFactory.create(fis2);
	                		Sheet sh=    wb.getSheet("EWtestdata");
	                		String search_for = sh.getRow(13).getCell(1).getStringCellValue();
	                		
	                		
	            		    
	            		    ChromeDriver driver = new ChromeDriver();
	            		     driver.manage().window().maximize();
	            		    driver.get(URL);
	            		    
	            		    //user login 
	            		    driver.findElement(By.xpath("//a[.='My Account']")).click();
	            		    driver.findElement(By.id("exampleInputEmail1")).sendKeys(USERNAME);
	            		    driver.findElement(By.id("exampleInputPassword1")).sendKeys(PASSWORD);
	            		    driver.findElement(By.name("login")).click();
	            		    System.out.println("user login sucessfully");
	            		    
	            		 // add to wishlist 
	            		    driver.findElement(By.className("search-field")).sendKeys(search_for);
	            		    driver.findElement(By.className("search-button")).click();
	            		    driver.findElement(By.xpath("//a[.='Apple iPhone 6 (Silver, 16 GB)']")).click();
	            		    driver.findElement(By.xpath("//a[@data-original-title=\"Wishlist\"]")).click();
	            		    System.out.println("item addedd to wishlist sucessfully");
	            		    Thread.sleep(5000);
	            		    
	            		    
	            		 // remove from wishlist
	            		    driver.findElement(By.xpath("//i[@class=\"fa fa-times\"]")).click();
	            		    Thread.sleep(5000);
	            		   Alert al = driver.switchTo().alert();
	            		   Thread.sleep(5000);
	            		   String msg = al.getText();
	            		   System.out.println(msg);
//	            		   if(msg.equalsIgnoreCase("ok"))
//	            		   {
//	            			   al.accept();
//	            		   }
//	            		   else if(msg.equalsIgnoreCase("cancel"))
//	            		   {
//	            			   al.dismiss();
//	            		   }
	            		   Thread.sleep(5000);
	            		    al.accept();
	            		  //   al.dismiss();
                            System.out.println("item removed finally from wishlist ");
                            driver.close();
	}

}
    **/