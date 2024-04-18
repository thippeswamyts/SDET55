package com.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;

public class JavaUtility 
{      
	ExcelUtility exutil = new ExcelUtility();
	/**
	 * 
	 * @return
	 */
       public int getRandom()
       {
    	  Random r = new Random(); 
    	 int random = r.nextInt(500);
    	 return random;
       }
       
       public String getSystemDate()
       {
    	    
    	   Date dt = new Date();
    	   String date = dt.toString();
    	   return date ;
       }
       
       public String getSystemDateInformat()
       {
    	   SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");  // 
    	     Date dt = new Date(); 
    	     String sysDateInFormat = dateformat.format(dt);
    	     return sysDateInFormat;
    	   
       }
       
		   }
       
       
