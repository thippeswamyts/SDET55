package com.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.EasyWhiz.ObjectRepository.LoginIntoAppPage;
import com.EasyWhiz.ObjectRepository.userlogout_page;

public class BASECLASS2 {
	
	public DataBaseUtility dbutil = new  DataBaseUtility();
	  public ExcelUtility eutil = new ExcelUtility();
	  public FileUtility futil = new FileUtility();
	  public JavaUtility jutil = new JavaUtility();
	  public WebdriverUtility wutil = new WebdriverUtility();
	  public WebDriver driver;
	  public static WebDriver  sdriver;
	  
	     @BeforeSuite(alwaysRun = true)
	     public void conn_db() throws Exception
	   {
	    	 dbutil.connectToDB();
	    	 Reporter.log("connected to db");
	   }
	
      @BeforeClass(alwaysRun = true)
      public void launchbrowser() throws Exception {
   		String browser=futil.ReadDataFromPropertyFile("browser");
   		String url=futil.ReadDataFromPropertyFile("user_url");
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
   			Reporter.log("this is edge");
   		}
   		sdriver=driver;
   		wutil.maximizeBrowser(driver);
   		driver.get(url);
   		wutil.waitForPageLoad(driver, 20);
   	}
      
      @BeforeMethod(alwaysRun = true)
      public void loginto_user_app() throws Exception
      {
    	 String username = futil.ReadDataFromPropertyFile("user_username");
    	  String password = futil.ReadDataFromPropertyFile("user_password");
    	  LoginIntoAppPage LoginIntoApp =  new LoginIntoAppPage(driver);
    	  LoginIntoApp.loginToApp(driver,username, password);
    	  Reporter.log("user login successfully");
    	  
      }
      
      @AfterMethod
      public void user_logout() throws InterruptedException
      {
    	  userlogout_page userlogout = new userlogout_page(driver);
    	  userlogout.logout();
    	  Reporter.log("Application was closed",true);
      }
      
      
      @AfterClass
      public void closebrowser()
      {
            driver.quit();
          Reporter.log("browser has been closed",true);
      }
      
      
    @AfterSuite(alwaysRun = true)
    public void close_db_conn() throws Exception
    {
  	  dbutil.closeConnection();
  	  Reporter.log("db connection has been closed",true);
    }
      
      
}
