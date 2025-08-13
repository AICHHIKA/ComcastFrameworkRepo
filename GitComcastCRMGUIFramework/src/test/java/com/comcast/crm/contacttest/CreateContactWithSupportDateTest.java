package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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

public class CreateContactWithSupportDateTest {

	public static void main(String[] args) throws Throwable {

		/*
		 * //Read Common Data From Properties File FileInputStream fis = new
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
		 * ); Workbook wb =WorkbookFactory.create(fis1); Sheet sh =
		 * wb.getSheet("contact"); Row row = sh.getRow(1); String lastName =
		 * row.getCell(2).toString() + randomInt; wb.close();
				
		//read TestScript data from Excel File
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3);	
		 */
		/* Create Object */
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
		
		//Read Common data From Property File
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		
		//read TestScript data from Excel File
		
				String orgName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();
//				String contactLastName = eLib.getDataFromExcel("contact", 7, 3);
			
		
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
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(URL);
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitbutton")).click();
				  
				// step 2: navigate to Organization Module
				driver.findElement(By.linkText("Contacts")).click();
				  
				// step 3: click on "Create Organization" button
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				  
				// step 4: Enter all the details & create new Organizations
				/*
				 * //To Capture the Current System Date Date dateObj =new Date();
				 * 
				 * SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd"); String startDate
				 * =sim.format(dateObj);
				 * 
				 * //To capature the Current System Date 30 Days After Calendar cal =
				 * sim.getCalendar(); // cal.add(Calendar.DAY_OF_MONTH, -30);
				 * cal.add(Calendar.DAY_OF_MONTH, +30); String endDate
				 * =sim.format(cal.getTime());
				 */
			String startDate = jLib.getSystemDateYYYYDDMM();
			String endDate = jLib.getRequiredDateYYYYDDMM(30);

			
				driver.findElement(By.name("lastname"));
				driver.findElement(By.name("support_start_date")).clear();
				driver.findElement(By.name("support_start_date")).sendKeys(startDate);
				
				driver.findElement(By.name("support_end_date")).clear();
				driver.findElement(By.name("support_end_date")).sendKeys(endDate);
				
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//Verify StartDate and EndDate
				String actstartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
				if(actstartDate.equals(startDate))
				{
					System.out.println(startDate + " information is verified==PASS");
				}else
				{
					System.out.println(startDate + " information is not verified==FAIL");
				}
				
				String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
				if(actEndDate.equals(endDate))
				{
					System.out.println(endDate + " information is Verified==PASS");
				}
				else
				{
					System.out.println(endDate + " information is not created==FAIL");
				}
						
				// step 5: logout
				driver.quit();
				
				
	}

}
