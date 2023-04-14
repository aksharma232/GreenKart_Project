package resources_Utility;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import greenKart_TestCases.gk_baseclass;

public class listeners extends gk_baseclass implements ITestListener {

	//extentreportNG extest = new extentreportNG();	
//	ExtentReports exreport = extest.extentTestNGReport();
	String destinationfile;
	ExtentTest test;
	extentReport ex_Report = new extentReport();
	ExtentReports reports = ex_Report.extentTestNGReport();
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test case start = "+result.getMethod().getMethodName());
		test = reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "Test Case PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test Case Fail");
	}
/*
	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}
*/
	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
