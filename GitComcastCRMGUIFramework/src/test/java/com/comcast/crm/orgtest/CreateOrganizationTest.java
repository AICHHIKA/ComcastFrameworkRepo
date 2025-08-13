package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
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

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//Read Common Data From Properties File
		FileInputStream fis = new FileInputStream("./configAppData/commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
	
		//Generate the Random Number
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		
		//Read TestScript Data from Excel File
		FileInputStream fis1=new FileInputStream("./testData/testScriptData.xlsx");
		Workbook wb =WorkbookFactory.create(fis1);
		Sheet sh	=	wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(2).toString() + randomInt;
		wb.close();
		
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
