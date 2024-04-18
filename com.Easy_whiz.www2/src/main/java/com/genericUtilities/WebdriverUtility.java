package com.genericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebdriverUtility 
{      
	
       /**
        * this method will mazimize
        * @param driver
        */
       public void maximizeBrowser(WebDriver driver)
       {
    	   driver.manage().window().maximize();
       }
       
       
       /**
        * this method will minimise
        * @param driver
        */
       public void minimizeBrowser(WebDriver driver)
       {
    	   driver.manage().window().minimize();
       }
       
       
       
       /**
        * this method will implicity wait for page load
        * @param driver
        */
       public void waitForPageLoad(WebDriver driver, int sec)
       {
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
       }
       
       
       
       /**
        * this method will webdriverwaitobject   reusability for explicit wait
        * @param driver
        */
       public WebDriverWait webdriverWaitObj(WebDriver driver, int sec)
       {
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
    	   return wait;
       }
       
       
       /**
        * this method will waittillvisiblityofelement for explicit wait
        * @param driver
        */
       public void waitEleTobeVisiblity(WebDriver driver,int sec, WebElement element)
       {
    	   webdriverWaitObj(driver, sec).until(ExpectedConditions.visibilityOf(element));
       }
       
       /**
        * this method will waittillvisiblityofelement for explicit wait
        * @param driver
        */
       public void waitEleTobeclickable(WebDriver driver,int sec, WebElement element)
       {
    	   webdriverWaitObj(driver, sec).until(ExpectedConditions.elementToBeClickable(element));
       }
       
       /**
        * this method will  wait till element to be clickable for explicit wait
        * @param driver
        */
       public void waitEletitlecontains(WebDriver driver,int sec, String title)
       {
    	   webdriverWaitObj(driver, sec).until(ExpectedConditions.titleContains(title));
       }
       
       
       //
       public Select Dropdownobj(WebElement element)
       {
    	   Select s = new Select(element);
    	   return s;
       }
       
       // 
       public void handleDropdown(WebElement element,String text)
       {
    	   Dropdownobj(element).selectByVisibleText(text);
       }
       
       // 
       public void handleDropdown(String value,WebElement element)
       {
    	   Dropdownobj(element).selectByValue(value);
       }
       
       //
       public void handleDropdown(WebElement element , int index)
       {
    	   Dropdownobj(element).selectByIndex(index);
       }
       
       // 
       public Actions actionsobj(WebDriver driver)
       {
    	   Actions act = new Actions(driver);
    	   return act;
       }
       
       //
       public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst)
       {
    	   actionsobj(driver).dragAndDrop(src, dst).perform();
       }
       
       //
       public void dragAndDrop(WebDriver driver, WebElement src, WebElement element, int x , int y)
       {
    	   actionsobj(driver).dragAndDropBy(src, x, y).perform();
       }
       
       
       //
       public void mouseOver(WebDriver driver, WebElement Element)
       {
    	   actionsobj(driver).moveToElement(Element).perform();
       }
       
       
       //
       public void passData(WebDriver driver,WebElement element, String keys)
       {
    	   actionsobj(driver).sendKeys(element, keys).perform();
       }
       
       // double click 
       public void doubleClick(WebDriver driver, WebElement element)
		{
    	   actionsobj(driver).doubleClick(element).perform();
		}
       
       // right click
       public void rightClick(WebDriver driver, WebElement element)
		{
    	   actionsobj(driver).contextClick(element).perform();
		}
       
       // click on element
       public void singleClick(WebDriver driver, WebElement element)
		{
   	   actionsobj(driver).click().perform();
		}
       
       public void switchTONewTab(WebDriver driver)
       {
    	   driver.switchTo().newWindow(WindowType.TAB);
       }
       
       
       
       // switchtowindow
       public void switchToWindow(WebDriver driver, String expWind)
       {
    	   Set<String> windows = driver.getWindowHandles();
    	   Iterator<String> it = windows.iterator();
    	   while(it.hasNext())
    	   {
    		 String win = it.next();
    		String currentTitle = driver.switchTo().window(win).getCurrentUrl();   // gettitle, getpagesource, getstringurl
    		
    		if(currentTitle.contains(expWind))
    		{
    			break;
    		}
    	   }
    	   
       }
         
       // robot 
       public Robot robotobj() throws AWTException
       {
    	   Robot r = new Robot();
    	   return r ;
       }
       
       //keypress
       public void enterKey() throws AWTException
       {
    	   robotobj().keyPress(KeyEvent.VK_ENTER);
       }
       
       //keyrelese
       public void releseKey() throws AWTException
       {
    	   robotobj().keyRelease(KeyEvent.VK_ENTER);
       }
       
       // switch to frames based on index
       
       public void switchToFrame(WebDriver driver, int index)
       {
    	   driver.switchTo().frame(index);
       }
       
       // switch to frames based on 
       
       public void switchToFrame(WebDriver driver,String Name)
       {
    	   driver.switchTo().frame(Name);
       }
       
          // switch to frames based on 
       
       public void switchToFrame(WebDriver driver,WebElement element)
       {
    	   driver.switchTo().frame(element);
       }
       
       // accept alert
       public void acceptAlert(WebDriver driver)
       {
    	   driver.switchTo().alert().accept();
       }
       
       // dismiss alert
       public void dismissAlert(WebDriver driver)
       {
    	   driver.switchTo().alert().dismiss();
       }

        // screenshot
       public  static String getscreenshot(WebDriver driver ,String screenshotname  ) throws IOException
       {    JavaUtility jutil = new JavaUtility();
    	    TakesScreenshot ts = (TakesScreenshot)driver; 
    	      File scr = ts.getScreenshotAs(OutputType.FILE);
    	      String path = "./screenshots/"+screenshotname+" "+jutil.getSystemDateInformat()+".png"; // primary path
    	      File dst = new File(path);
    	     String srcpath = dst.getAbsolutePath();
    	    FileUtils.copyFile(scr, dst);   // filehandler , fileutil.copyfile(src, dst)
    	     return srcpath;
    	      
       }
       
       /**
		 * This method will perform random scroll based on pixel
		 * @param driver
		 */
		public void scrollBarAction(WebDriver driver)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,800)");
		}
		
		
		/**
		 * This method will scroll until specified element is found
		 * @param driver
		 * @param element
		 */
		public void scrollActionTillEle(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			int y = element.getLocation().getY();
			int x = element.getLocation().getX();
			jse.executeScript("window.scrollBy("+x+","+y+")");
		}
       
		/**
		 * scrollDown till the bottom of the page
		 * @param driver
		 */
		public void scrollDownTillBottomOfThePage(WebDriver driver)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
		
		/**
		 *scroll Till Element To Be Visisble // move to element
		 * @param driver
		 * @param element
		 */
		
		
		 // scroll till move to element
		public void scrollMoveToElement(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].scrollIntoView()",element);
		}
		
		
		// click actions
		public void click(WebDriver driver, WebElement element)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click()",element);
			
		}
		
		
		// send data 
		public void UsingSendKeys(WebDriver driver, WebElement element, String expData)
		{
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].value=arguments[1]", element, expData);
		}
		
		
		
		
}
