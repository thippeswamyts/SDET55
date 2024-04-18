package com.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility 
{
	/**
	 * This method is used to return value of key from propertyFile
	 * @param key
	 * @return value
	 * @throws Exception
	 */
     public String ReadDataFromPropertyFile(String key) throws Exception
     {
    	FileInputStream fi = new FileInputStream(IPathConstant.FilePath);
    	            Properties pobj =  new Properties();
    	            pobj.load(fi);
    	          String value = pobj.getProperty(key);
    	            return value;
     }
     
     /**
      * This method is used to store  key and values into  propertyFile
      * @param key
      * @param value
      * @return
      * @throws Throwable
      */
     public void  InsertDataIntoPropertyFile(String key,String value , String commentvalue) throws Throwable
     {
    	 FileInputStream fi = new FileInputStream(IPathConstant.FilePath);
         Properties pobj =  new Properties();
            
             pobj.setProperty(key, value);
                
          FileOutputStream fout = new FileOutputStream(IPathConstant.FilePath);
                 pobj.store(fout, commentvalue);
                 pobj.load(fi);
			   	 
                          
     }
     
     
     
     
}
