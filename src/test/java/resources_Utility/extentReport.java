package resources_Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport 
{
	public ExtentReports extentTestNGReport()
	{
		String path = System.getProperty("user.dir")+"//reports//extentReport.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		
		report.config().setDocumentTitle("Automation_Test_Result");
		report.config().setReportName("GreenKart-Project");
		
		ExtentReports ex_reports = new ExtentReports();
		ex_reports.attachReporter(report);
		ex_reports.setSystemInfo("TestName", "TestQA");
		return ex_reports;
		
	}
}
