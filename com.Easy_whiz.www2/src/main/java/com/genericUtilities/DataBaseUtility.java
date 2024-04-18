package com.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility
{     
	Connection con = null;
     public void connectToDB() throws Exception
     {
    	 // registering driver 
    	    Driver driver = new Driver();
    	    DriverManager.registerDriver(driver);
    	    
    	    // establish the connection
    	    
    	    con = DriverManager.getConnection(IPathConstant.DBURL,IPathConstant.DBUSERNAME,IPathConstant.DBPASSWORD);
    	    
     }
     
     public void exceuteQuery(String Query, int colindex, String expdata) throws Exception
     {
    	Statement state = con.createStatement();
    	 ResultSet result = state.executeQuery(Query);
    	  boolean flag = false ;
    	while(result.next())
    	{
    		 String actData = result.getString(colindex);
    		 
    		 if(actData.contains(expdata))
    		 {
    			 flag = true;
    			 break;
    		 }
    	}
    	if(flag)
    	{
    		System.out.println("data is validated");
    	}
    	else
    	{
    		System.out.println("data is not matching");
    	}
    	
    	
     }
     
     
     public void updateQuery(String Query) throws SQLException
     {
    	 // for updating the table data non select query
    	 Statement state = con.createStatement();
    	 int result = state.executeUpdate(Query);
    	 
    	 System.out.println(result);
    	 
     }
     
     public void closeConnection() throws Exception
     {
    	 // close the db coonection
    	 
    	 con.close();
     }
}
