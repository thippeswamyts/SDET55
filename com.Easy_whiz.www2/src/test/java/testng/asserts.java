package testng;


import static org.testng.Assert.*;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class asserts 
{ 
	// WebDriver driver = new ChromeDriver();
	 int a ;
   //  @Test
    public  void hardassert()
    {
    	
    	
    	// String exp_tit = "Facebook ? log in or sign up";
    	// driver.get("https://www.facebook.com/");
    	//   String act_tit = driver.getTitle();
    	//   System.out.println(act_tit);
    	 //  assertEquals(act_tit, exp_tit);
        //  assertNotEquals(act_tit, exp_tit, "titile is not matched"); // when mismatch in bw act_tit and  exp_tit 
    	System.out.println("-----1-----");  
    	System.out.println("-----2-----");
    	assertSame("meghaaa2", "megha" ,"matching status "); //  
    	System.out.println("-----3-----");
    	 // sa.assertAll();
    	  
        
       // assertNotNull(a);
         // assertNull(a);
    	
    	assertTrue(false);
    	
    	
    	  System.out.println("done"); 
    	  //  driver.close();
    }
    
    public void softassert()
    {
    	SoftAssert sa = new SoftAssert(); 	
    }
    
    
}
