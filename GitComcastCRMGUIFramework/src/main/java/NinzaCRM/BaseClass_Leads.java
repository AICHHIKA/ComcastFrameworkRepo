package NinzaCRM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.Leads;

public class BaseClass_Leads {

	public WebDriver driver = null;
	public FileUtility futil = new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	
	@BeforeSuite
	public void Bs() {
		System.out.println("DB connection");
	}
	
	@BeforeTest
	public void Bt() {
		System.out.println("Create Leads");
	}
	
	@BeforeClass
	public void Bc() throws Throwable {
		String URL = futil.getDataFromPropertiesFile("url");
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(URL);
	}
	
	@BeforeMethod
	public void Bm() throws Throwable {
		String FIRSTNAME = futil.getDataFromPropertiesFile("firstname");
		String LASTNAME = futil.getDataFromPropertiesFile("lastname");
		String COMPANYNAME = futil.getDataFromPropertiesFile("companyname");
		Leads leadsPage = new Leads(driver);
		
		leadsPage.getCreateleads().sendKeys("aichhika");
		leadsPage.getCreateleads().sendKeys("senapati");
		leadsPage.getCreateleads().sendKeys("tekpyramid");
		
		WebElement savebtn = null;
		savebtn.click();
		
		
		
	}
}
