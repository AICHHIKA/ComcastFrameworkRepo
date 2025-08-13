package com.comcast.crm.orgtest_TestNG;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganizationWithPhoneNumberTest {

	public static void main(String[] args) throws Throwable {
		
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
		 * ); Workbook wb =WorkbookFactory.create(fis1); Sheet sh = wb.getSheet("org");
		 * Row row = sh.getRow(1); String orgName = row.getCell(2).toString() +
		 * randomInt; wb.close();
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
			
				//Generate the Random Number
				Random random=new Random();
				int randomInt = random.nextInt(1000);
				
				//Read TestScript Data from Excel File
			String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
			String industry = eLib.getDataFromExcel("org", 7, 3);
		
		
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
		}
		
		else {
			driver=new ChromeDriver();
		}
		// step 1: Login to app
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
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		
		//verify Header msg Expected Result
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(headerInfo.contains(orgName))
		{
			System.out.println(orgName + " is created==PASS");
		}
		else
		{
			System.out.println(orgName + " is not created==FAIL");
		}
		
		//verify Header OrgName info Expected Result
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if(actOrgName.contains(actOrgName))
		{
			System.out.println(actOrgName + " is created==PASS");
		}
		else
		{	
			System.out.println(actOrgName + " is not created==FAIL");
		}
		
		Thread.sleep(2000);
		
		// step 5: logout
		driver.quit();

	}

}
