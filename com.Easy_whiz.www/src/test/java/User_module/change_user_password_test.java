package User_module;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class change_user_password_test {

	public static void main(String[] args) throws IOException, InterruptedException {
		  
		// fetch data from property file
	    FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\commomdata.properties");
	    Properties pobj = new Properties();
	    pobj.load(fis1);
       
	    
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
	    
	    driver.findElement(By.xpath("//a[.='My Account']")).click();
                 Thread.sleep(5000);
	    driver.findElement(By.className("collapsed")).click();
	    
	    
	    
	    
	    
	}

}
