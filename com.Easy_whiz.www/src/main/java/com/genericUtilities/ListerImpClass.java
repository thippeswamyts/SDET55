package com.genericUtilities;

import java.io.IOException;

import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListerImpClass implements ITestListener 
{
	ExtentReports report; 
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
	    test = report.createTest(methodname);
		Reporter.log("execution starts from here", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.PASS, methodname);
		Reporter.log("----> executed successfully<-----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		
		try {
			String screenshot = WebdriverUtility.getscreenshot(BASECLASS.sdriver, methodname);
			test.log(Status.FAIL, methodname +"---failed");
			test.log(Status.FAIL,result.getThrowable());
			
			test.addScreenCaptureFromPath(screenshot);
			
			Reporter.log(methodname +"----> failed");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname = result.getMethod().getMethodName();
		test.log(Status.SKIP,methodname+"--->skipped");
		test.log(Status.SKIP,result.getThrowable());
		Reporter.log(methodname +"----->skipped");
	}

	
	
	@Override
	public void onStart(ITestContext context) {
		 ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/Report.html");
		 htmlreport.config().setDocumentTitle("EasyWhiz");
		 htmlreport.config().setReportName("SDET-55");
		 htmlreport.config().setTheme(Theme.DARK);
		 
		report =  new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("Base-Platform", "windows");
		report.setSystemInfo("Base-Browser", "chrome");
		report.setSystemInfo("Base-URL", "http://rmgtestingserver/domain/Online_Shopping_Application/admin/");
		report.setSystemInfo("Reportername", "Thippeswamy");
		
	}

	
	
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		
	}
  
}
