package practice.testng;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportForAnotherTestCaseTest_Extent_Report {
	
	// Create this Variable Globally
	public ExtentReports report;
	
	// Use for another TestCase we use: @BS & @AS
	@BeforeSuite
	public void configBS() {
		// Spark report Config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// Add Environment Information & Create Test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10");
		report.setSystemInfo("BROWSER", "CHROME-100");
	} 

	@AfterSuite
	public void configAS() {
		report.flush();
	}
	@Test
	public void createContactTest() {

		ExtentTest test = report.createTest("createContactTest");

		// We never use Sopln statement , use log
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}
	
	@Test
	public void createContactWithORG() {

		// For Configure Extent Report ExtentSparkReporter, Create an Object of this class
		// Spark report Config
		ExtentTest test = report.createTest("createContactWithORG");

		// We never use Sopln statement , use log
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
}
	
	@Test
	public void createContactWithPhoneNumber() {

		// For Configure Extent Report ExtentSparkReporter, Create an Object of this Class
		// Spark report Config
		
		ExtentTest test = report.createTest("createContactWithPhoneNumber");

		// We never use Sopln statement , use log
		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");

		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "contact is created");
		} else {
			test.log(Status.FAIL, "contact is not created");
		}
	}
	
}
