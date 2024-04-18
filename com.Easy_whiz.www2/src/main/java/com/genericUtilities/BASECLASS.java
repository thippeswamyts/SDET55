package com.genericUtilities;

import org.testng.Reporter;
import org.testng.annotations.*;

import com.EasyWhiz.ObjectRepository.Admin_loginPage;
import com.EasyWhiz.ObjectRepository.LoginIntoAppPage;
import com.EasyWhiz.ObjectRepository.adminLogout_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BASECLASS 
{
  public DataBaseUtility dbutil = new  DataBaseUtility();
  public ExcelUtility eutil = new ExcelUtility();
  public FileUtility futil = new FileUtility();
  public JavaUtility jutil = new JavaUtility();
  public WebdriverUtility wutil = new WebdriverUtility();
  public WebDriver driver;
  public static WebDriver  sdriver;
  
     @BeforeSuite
     public void conn_db() throws Exception
   {
    	 dbutil.connectToDB();
    	 Reporter.log("connected to db");
   }
	
   //  @Parameters("browser")
 	@BeforeClass(alwaysRun = true)
 	public void launchbrowser() throws Exception {    // String browser for cross browser test
 	 	String browser=futil.ReadDataFromPropertyFile("browser");
 		String url=futil.ReadDataFromPropertyFile("admin_url");
 		//String browser = System.getProperty("browser");
 		// String url = System.getProperty("url");
 		
 		if(browser.contains("firefox")) {
 			driver=new FirefoxDriver();
 			Reporter.log("this is firefox");
 		}
 		else if(browser.contains("chrome")) {
 			driver=new ChromeDriver();
 			Reporter.log("this is chrome");
 		}
 		else if (browser.contains("edge")) {
 			driver=new EdgeDriver();
 			Thread.sleep(10000);
 			Reporter.log("this is edge");
 		}
 		sdriver=driver;
 		wutil.maximizeBrowser(driver);
 		driver.get(url);
 		wutil.waitForPageLoad(driver, 20);
 	}
    
//    @BeforeMethod(alwaysRun = true)
//	public void adminlogin() throws Exception {
//    	String username=futil.ReadDataFromPropertyFile("admin_usernmae");
//		String pwd=futil.ReadDataFromPropertyFile("admin_password");
//		Admin_loginPage login = new Admin_loginPage(driver);
//		login.adminlogin(username, pwd);
//		 Reporter.log("admin logged in");
//	}
    

    
//    @AfterMethod(alwaysRun = true)
//	public void logout_from_adminApp() 
//	{
//		adminLogout_page logout = new adminLogout_page(driver);
//	  	  logout.adminlogout();
//	  	Reporter.log("admin has been loged out");
//	}

    
    @AfterClass(alwaysRun = true)
    public void closebrowser()
    {
        driver.quit();
        Reporter.log("browser has been closed");
    }
    
    
  @AfterSuite(alwaysRun = true)
  public void close_db_conn() throws Exception
  {
	  dbutil.closeConnection();
	  Reporter.log("db connection has been closed");
  }
  
}


