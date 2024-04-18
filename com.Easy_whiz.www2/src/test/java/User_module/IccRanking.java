package User_module;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccRanking {

	public static void main(String[] args) throws InterruptedException {
		       String exp = "SRI LANKA";
		       String ans = null;
		       boolean flag = false;
		       WebDriver driver = new ChromeDriver();
		       driver.manage().window().maximize();
		       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       driver.get("https://www.icc-cricket.com/rankings/team-rankings/mens/t20i");
		    
                   Thread.sleep(10000);
               List<WebElement> countrys = driver.findElements(By.xpath("//span[@class='si-fname si-text']"));
               
                ArrayList<String> ar = new ArrayList<String>();
                  
                for (WebElement webEle : countrys)
                {
                	     ans = webEle.getText(); 
                	     ar.add(ans);
                	     
                	
				}
               //  System.out.println(ans);
                
                for(String finalar:ar)
                {
                if(finalar.equalsIgnoreCase(exp))
          	  {
                	flag =true;
                	break;
          	  }
                }
                
          	  if(flag)
          	  {
          		  System.out.println("sri lank present ");
          	  }
          	  else
          	  {
          		  System.out.println("not present");
          	  }
                
                
	}

}
