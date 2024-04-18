package testng;

import org.testng.annotations.Test;

import com.EasyWhiz.ObjectRepository.AddBilling_ShippingAddress_page;
import com.EasyWhiz.ObjectRepository.addTowisht_to_CartPage;
import com.EasyWhiz.ObjectRepository.payment_track_order_page;
import com.genericUtilities.BASECLASS2;
import com.genericUtilities.ExcelUtility;
import com.genericUtilities.WebdriverUtility;

// @Listeners(com.genericUtilities.ListerImpClass.class)
public class Add_to_wishlist_genericTest  extends BASECLASS2{

	 
	
	@Test(groups =  "smoke", retryAnalyzer = com.genericUtilities.RetryImpClass.class  )
	public void order()throws Exception
	{
		// generic utilitys
		//   FileUtility futil = new FileUtility();
		    WebdriverUtility wutil = new WebdriverUtility();
		    ExcelUtility exutil = new ExcelUtility();
		
		// fetch data from property file
//		  String USER_URL = futil.ReadDataFromPropertyFile("user_url");
//		  String USER_UN = futil.ReadDataFromPropertyFile("user_username");
//		  String USER_PASSWORD = futil.ReadDataFromPropertyFile("user_password");
		  
		// fetch data from excel file
		     String search_for = exutil.ReadSingleDatafromExcel("EWtestdata", 13, 1);
		     String BILLING_ADD = exutil.ReadSingleDatafromExcel("EWtestdata", 14, 1);
			 String BILLING_STATE = exutil.ReadSingleDatafromExcel("EWtestdata", 15, 1);
			 String BILLING_CITY = exutil.ReadSingleDatafromExcel("EWtestdata", 16, 1);
			 String BILLING_PINCODE = exutil.ReadSingleDatafromExcel("EWtestdata", 17, 1);
			 String SHIPPING_ADD = exutil.ReadSingleDatafromExcel("EWtestdata", 18, 1);
			 String SHIPPING_STATE = exutil.ReadSingleDatafromExcel("EWtestdata", 19, 1);
			 String SHIPPING_CITY = exutil.ReadSingleDatafromExcel("EWtestdata", 20, 1);
			 String SHIPPING_PINCODE = exutil.ReadSingleDatafromExcel("EWtestdata", 21, 1);
			 String exp_url = exutil.ReadSingleDatafromExcel("EWtestdata", 22, 1);
			   
		  
//		   WebDriver driver = new ChromeDriver();
//		   wutil.maximizeBrowser(driver);
//		  //  driver.get(USER_URL);
//		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		   LoginIntoAppPage LoginIntoApp = new LoginIntoAppPage(driver);
//		  LoginIntoApp.loginToApp(driver ,USER_URL,USER_UN, USER_PASSWORD);
		  
		   Thread.sleep(10000);
		   addTowisht_to_CartPage addTowisht_to_Cart = new addTowisht_to_CartPage(driver);
		   addTowisht_to_Cart.addTowisht_to_Cart(search_for);
		   
		   AddBilling_ShippingAddress_page AddBilling_ShippingAddress = new AddBilling_ShippingAddress_page(driver);
		   AddBilling_ShippingAddress.AddBilling_Address(driver, BILLING_ADD, BILLING_STATE, BILLING_CITY, BILLING_PINCODE);
		   AddBilling_ShippingAddress.Addshipping_Address(driver, SHIPPING_ADD, SHIPPING_STATE, SHIPPING_CITY, SHIPPING_PINCODE);
		  
		   payment_track_order_page payment_track_order = new payment_track_order_page(driver);
		   payment_track_order.payment_throW_COD();
		   String orderidnum = payment_track_order.trackOrder(driver, exp_url);
		   exutil.writeDataSingleIntoExcel("EWtestdata", 23, 1, orderidnum);
		   System.out.println("order placed and tracked ");
		   Thread.sleep(5000);
		   
		  
	}
}


  
		/** using generics 
		  
		 JavaUtility jutil = new JavaUtility();
		ExcelUtility exutil = new ExcelUtility();
		DataBaseUtility dbutil = new DataBaseUtility();
		WebdriverUtility wutil = new WebdriverUtility();
		
		// fetch data from property file
		  String USER_URL = futil.ReadDataFromPropertyFile("user_url");
		  String USER_UN = futil.ReadDataFromPropertyFile("user_username");
		  String USER_PASSWORD = futil.ReadDataFromPropertyFile("user_password");
		
		// fetch data from excel file
		  String search_for = exutil.ReadSingleDatafromExcel("EWtestdata", 13, 1);
		 String BILLING_ADD = exutil.ReadSingleDatafromExcel("EWtestdata", 14, 1);
		 String BILLING_STATE = exutil.ReadSingleDatafromExcel("EWtestdata", 15, 1);
		 String BILLING_CITY = exutil.ReadSingleDatafromExcel("EWtestdata", 16, 1);
		 String BILLING_PINCODE = exutil.ReadSingleDatafromExcel("EWtestdata", 17, 1);
		 String SHIPPING_ADD = exutil.ReadSingleDatafromExcel("EWtestdata", 18, 1);
		 String SHIPPING_STATE = exutil.ReadSingleDatafromExcel("EWtestdata", 19, 1);
		 String SHIPPING_CITY = exutil.ReadSingleDatafromExcel("EWtestdata", 20, 1);
		 String SHIPPING_PINCODE = exutil.ReadSingleDatafromExcel("EWtestdata", 21, 1);
		 String TO_url = exutil.ReadSingleDatafromExcel("EWtestdata", 22, 1);
		
		 WebDriver driver = new ChromeDriver();
		 wutil.maximizeBrowser(driver);
		  driver.get(USER_URL);
		
		  
		//user login 
		    driver.findElement(By.xpath("//a[.='My Account']")).click();
		    driver.findElement(By.id("exampleInputEmail1")).sendKeys(USER_UN);
		    driver.findElement(By.id("exampleInputPassword1")).sendKeys(USER_PASSWORD);
		    driver.findElement(By.name("login")).click();
		    System.out.println("user login sucessfully");
		  
		  
		 // add to wishlist 
		    driver.findElement(By.className("search-field")).sendKeys(search_for);
		    driver.findElement(By.className("search-button")).click();
		    driver.findElement(By.xpath("//a[.='Apple iPhone 6 (Silver, 16 GB)']")).click();
		    driver.findElement(By.xpath("//a[@data-original-title=\"Wishlist\"]")).click();
		    System.out.println("item addedd to wishlist sucessfully");
		    
		 // wishlist to add to cart 
		    driver.findElement(By.xpath("//a[.='Add to cart']")).click();
		    driver.findElement(By.xpath("//i[@class=\"icon fa fa-shopping-cart\"]")).click();
		    System.out.println("item moved to cart from wishlist");
		    
		    // add shipping address and billing address
		    driver.findElement(By.name("billingaddress")).sendKeys(BILLING_ADD);
		    driver.findElement(By.name("bilingstate")).sendKeys(BILLING_STATE);
		    driver.findElement(By.name("billingcity")).sendKeys(BILLING_CITY );
		    driver.findElement(By.name("billingpincode")).sendKeys(BILLING_PINCODE);
		    driver.findElement(By.name("update")).click();
		    wutil.acceptAlert(driver);
		    
		    driver.findElement(By.name("shippingaddress")).sendKeys(SHIPPING_ADD);
		    driver.findElement(By.name("shippingstate")).sendKeys(SHIPPING_STATE);
		    driver.findElement(By.name("shippingcity")).sendKeys(SHIPPING_CITY);
		    driver.findElement(By.name("shippingpincode")).sendKeys(SHIPPING_PINCODE);
		    driver.findElement(By.name("shipupdate")).click();
		    wutil.acceptAlert(driver);
		    System.out.println("billing ans shipping address addedd sucessfully");
		    driver.findElement(By.name("ordersubmit")).click();
		    
		 // make payment through COD
		    driver.findElement(By.name("paymethod")).click();
		    driver.findElement(By.name("submit")).click();
		    System.out.println("order placed sucessfully");
		    
		 // track the order 
		    
		    driver.findElement(By.xpath("//tr[last()]/td[last()]//a")).click();
		    String pwind = driver.getWindowHandle();
		    Set<String> winds = driver.getWindowHandles();
		    for(String windsf:winds)
		    {
		    	driver.switchTo().window(windsf);;
		    	String TO_url_temp = driver.getCurrentUrl();
		    	if(TO_url_temp.contains(TO_url))
		    		break;
		    }
		    
		    WebElement orderid = driver.findElement(By.xpath("//td[@class='fontkink']"));
		    String orderid_num = orderid.getText();
		    System.out.println(orderid.getText());
	        driver.close();
	        driver.switchTo().window(pwind);
	        
	       exutil.writeDataSingleIntoExcel("EWtestdata", 23, 1, orderid_num);
	       Thread.sleep(3000);
	       driver.close();
		        
		    
	//----------------------------------------------------------------------------------------------------------------------------	
		/** using hard coding
		 * 
		 * 
		 
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
	               String BILLING_ADD = sh.getRow(14).getCell(1).getStringCellValue();
	               String BILLING_STATE = sh.getRow(15).getCell(1).getStringCellValue();
	               String BILLING_CITY = sh.getRow(16).getCell(1).getStringCellValue();
	               String BILLING_PINCODE = sh.getRow(17).getCell(1).getStringCellValue();
	               String SHIPPING_ADD = sh.getRow(18).getCell(1).getStringCellValue();
	               String SHIPPING_STATE = sh.getRow(19).getCell(1).getStringCellValue();
	               String SHIPPING_CITY = sh.getRow(20).getCell(1).getStringCellValue();
	               String SHIPPING_PINCODE = sh.getRow(21).getCell(1).getStringCellValue();
	               String TO_url = sh.getRow(22).getCell(1).getStringCellValue();
      
      
      
	               WebDriver driver = new ChromeDriver();
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
			   
			   // wishlist to add to cart 
			    driver.findElement(By.xpath("//a[.='Add to cart']")).click();
			    driver.findElement(By.xpath("//i[@class=\"icon fa fa-shopping-cart\"]")).click();
			    System.out.println("item moved to cart from wishlist");
			    
			    // add shipping address and billing address
			    driver.findElement(By.name("billingaddress")).sendKeys(BILLING_ADD);
			    driver.findElement(By.name("bilingstate")).sendKeys(BILLING_STATE);
			    driver.findElement(By.name("billingcity")).sendKeys(BILLING_CITY );
			    driver.findElement(By.name("billingpincode")).sendKeys(BILLING_PINCODE);
			    driver.findElement(By.name("update")).click();
			    driver.switchTo().alert().accept();
      
      
      
			    driver.findElement(By.name("shippingaddress")).sendKeys(SHIPPING_ADD);
			    driver.findElement(By.name("shippingstate")).sendKeys(SHIPPING_STATE);
			    driver.findElement(By.name("shippingcity")).sendKeys(SHIPPING_CITY);
			    driver.findElement(By.name("shippingpincode")).sendKeys(SHIPPING_PINCODE);
			    driver.findElement(By.name("shipupdate")).click();
			   driver.switchTo().alert().accept();
			   System.out.println("billing ans shipping address addedd sucessfully");
			    driver.findElement(By.name("ordersubmit")).click();
			    
			    // make payment through COD
			    driver.findElement(By.name("paymethod")).click();
			    driver.findElement(By.name("submit")).click();
			    System.out.println("order placed sucessfully");
      
      
      
			 // track the order 
			    
			    driver.findElement(By.xpath("//tr[last()]/td[last()]//a")).click();
			    String pwind = driver.getWindowHandle();
			    Set<String> winds = driver.getWindowHandles();
			    for(String windsf:winds)
			    {
			    	driver.switchTo().window(windsf);;
			    	String TO_url_temp = driver.getCurrentUrl();
			    	if(TO_url_temp.contains(TO_url))
			    		break;
			    }
			    
			    
			    WebElement orderid = driver.findElement(By.xpath("//td[@class='fontkink']"));
			    String orderid_num = orderid.getText();
			    System.out.println(orderid.getText());
		        driver.close();
	 		    driver.switchTo().window(pwind);
	 		   sh.createRow(23).createCell(0).setCellValue("orderid");
		        sh.getRow(23).createCell(1).setCellValue(orderid_num);
      
      
      
      
		        FileOutputStream fout = new FileOutputStream("C:\\Users\\Dell\\Downloads\\finnalTC.xlsx");
			    wb.write(fout);
			    wb.close();
			     Thread.sleep(3000);
			     // driver.close();
      
            **/
            

