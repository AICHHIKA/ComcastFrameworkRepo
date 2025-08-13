package com.comcast.crm.listenerutility;

import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest_TestNG.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListImpClass implements ITestListener, ISuiteListener {
//	public static ExtentSparkReporter spark;

	public ExtentReports report;
	public static ExtentTest test;

	public void onStart(ISuite suite) {

		System.out.println("Report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":" , "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		// Spark report Config
		spark = new ExtentSparkReporter("./AdvanceReport/report.html"); 
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add Environment Information & Create Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backUp");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("== ==>" + result.getMethod().getMethodName() + ">==START==");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+ "==> STARTED<==");
	} 

	public void onTestSuccess(ITestResult result) {
		System.out.println("== ==>" + result.getMethod().getMethodName() + ">==END==");
		test.log(Status.PASS, result.getMethod().getMethodName()+ "==> COMPLETED<==");
	}

	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();
				
//		TakesScreenshot edriver = (TakesScreenshot) (BaseClass.sdriver);
//		File srcFile = edriver.getScreenshotAs(OutputType.FILE);
		
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath= eDriver.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace("", "_").replace(":" , "_");
//		try {
//
//			FileUtils.copyFile(srcFile, new File("./screenshot/" + testName + "+" + time+".png"));
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		test.addScreenCaptureFromBase64String(filePath, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+ "==> FAILED<==");
	}

	public void onTestSkipped(ITestResult result) {

		ITestListener.super.onTestSkipped(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}
	public void onTestFailedWithTimeout(ITestResult result) {

		ITestListener.super.onTestFailedWithTimeout(result);
	}

	public void onStart(ITestContext context) {

		ITestListener.super.onStart(context);
	}

	public void onFinish(ITestContext context) {

		ITestListener.super.onFinish(context);
	}

}
