package testng;

import static org.testng.Assert.fail;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

  public class practicetest {
	  
//
//	@Test(invocationCount = 0)
//      public void create()
//   {
//	   System.out.println("from 1st method");
//	  
//   }
//	
//	@Test(priority=-2 )
//	public void execute()
//	{
//		System.out.println("from second method"); 
//		
//	}
	
//	@Test(priority=-1)
//	 public void save()
//	 {
//		 System.out.println("from third method");
//	 }
	
	
	
	
	
	// @Test(dataProvider = "data")
	public void getdata(String one, String two, int three )
	{
		System.out.println(one +"---->"+ two+"----->"+three);
	}
	
	
	@DataProvider
	public Object[][] data()
	{
	
		 Object[][] obj = new Object[3][3];
		 
		 obj[0][0] = "qspider";
		 obj[0][1] = "bangalore";
		  obj[0][2] = 1000;
		 
		 obj[1][0] = "jspider";
		 obj[1][1] = "mysore";
		 obj[1][2] = 2000;
		 
		 obj[2][0] = "pyspider";
		 obj[2][1] = "hubli";
		 obj[2][2] = 3000;
		 
		return obj;
		 
		
	}
	
}
	

