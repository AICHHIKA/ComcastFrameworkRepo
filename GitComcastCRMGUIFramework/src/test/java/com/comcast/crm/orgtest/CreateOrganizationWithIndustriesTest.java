package com.comcast.crm.orgtest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganizationWithIndustriesTest {

	public static void main(String[] args) throws Throwable{
		
		/*
		 * FileInputStream fis = new
		 * FileInputStream("./configAppData/commondata.properties"
		 * ); Properties pObj = new Properties(); pObj.load(fis);
		 * 
		 * String BROWSER = pObj.getProperty("browser"); String URL =
		 * pObj.getProperty("url"); String USERNAME = pObj.getProperty("username");
		 * String PASSWORD = pObj.getProperty("password");
		 * 
		 * //Generate the Random Number Random random=new Random(); int randomInt =
		 * random.nextInt(1000);
		 * 
		 * //Read TestScript Data from Excel File FileInputStream fis1=new
		 * FileInputStream("./testData/testScriptData.xlsx"
		 * ); Workbook wb = WorkbookFactory.create(fis1); Sheet sh = wb.getSheet("org");
		 * Row row = sh.getRow(4); String orgName = row.getCell(2).toString() +
		 * randomInt; String industry= row.getCell(3).toString();
		 * row.getCell(4).toString(); wb.close();
		 */
		/* Create Object */
		//Read the data from Property File
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
				
				String BROWSER = fLib.getDataFromPropertiesFile("browser");
				String URL = fLib.getDataFromPropertiesFile("url");
				String USERNAME = fLib.getDataFromPropertiesFile("username");
				String PASSWORD = fLib.getDataFromPropertiesFile("password");
							
				//Read TestScript Data from Excel File
			String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
			String industry = eLib.getDataFromExcel("org", 4, 3);
			String type1 = eLib.getDataFromExcel("org", 4, 4);
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BROWSER.equals("edge"))
		{
			driver=new EdgeDriver();
		}else {
			driver=new ChromeDriver();
		}
		// step 1: Login to app
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitbutton")).click();
		  
		// step 2: navigate to Organization Module
		driver.findElement(By.linkText("Organizations")).click();
		  
		// step 3: click on "Create Organization" button
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		  
		// step 4: Enter all the details & create new Organizations
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		WebElement websel = driver.findElement(By.name("industry"));
		Select sel1=new Select(websel);
		sel1.selectByVisibleText(industry);
		
		WebElement websel1 = driver.findElement(By.name("accounttype"));
		Select sel2=new Select(websel1);
		sel2.selectByValue(type1);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//verify the industries and type info
		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if(actIndustries.equals(industry))
		{
			System.out.println(industry + "information is verified==PASS");
		}
		else
		{	
			System.out.println(industry + "information is not verified==FAIL");
		}
		
		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		
		if(actType.equals(type1))
		{
			System.out.println(type1 + "information is verified==PASS");
		}
		else
		{	
			System.out.println(type1 + "information is not verified==FAIL");
		}
		
		// step 5: logout
		driver.quit();

	}

}
