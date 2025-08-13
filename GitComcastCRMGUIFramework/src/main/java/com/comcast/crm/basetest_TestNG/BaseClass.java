package com.comcast.crm.basetest_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepository_TestNG.LoginPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class BaseClass {
	/* Create Object */
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null; 
	
	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void configBS() throws Throwable {
		System.out.println("==Connect to DB , Report Config==");
		dbLib.getDbconnection("jdbc:mysql:49.249.28.218:8091/projects", "root", "root");
	}
	//practice_test_Invoice_Listeners
	/*
	 * //For Group Execution we required @Parameter, StringBrowser
	 * 
	 * @Parameters("BROWSER")
	 * 
	 * @BeforeClass(groups = {"smokeTest", "regressionTest"})
	 *  // public void configBC() throws Throwable { 
	 *  public void configBC(String browser) throws Throwable {
	 *  System.out.println("==Launch the BROWSER=="); 
	 *  //String BROWSER = fLib.getDataFromPropertiesFile("browser"); 
	 *  String BROWSER = browser;
	 */
		
	//Listners: 
//		@Parameters("BROWSER")
		@BeforeClass(groups = {"smokeTest", "regressionTest"})
		public void configBC() throws Throwable {
			System.out.println("==Launch the BROWSER==");
			String BROWSER = fLib.getDataFromPropertiesFile("browser");
//			String BROWSER = browser;
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("==login==");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");

//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();

		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void configAM() {
		System.out.println("==logout==");
		HomePage hp = new HomePage(driver);
		hp.getAdminImg().click();
		hp.getSignOutLink().click();
	}

	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void configAC() {
		System.out.println("==Close the BROWSER==");
		driver.quit();
	}

	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void configAS() throws Throwable {
		System.out.println("==close Db , Report backUP==");
		dbLib.closeDbconnection();
	}
}
