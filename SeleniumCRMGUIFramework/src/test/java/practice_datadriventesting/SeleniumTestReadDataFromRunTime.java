package practice_datadriventesting;

import java.io.FileInputStream;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SeleniumTestReadDataFromRunTime {

	@Test
	public void createOrgTest() throws Throwable {
	{
		//Want to read this data from Command Line, 
		//In order to rcv the Parameters in Selenium TestNG Test we have to Install maven CommandLine Plugin
		
		//Read Common Data from Command Line(CMD line)
			String URL=System.getProperty("url");
			String BROWSER=System.getProperty("browser");
			String USERNAME=System.getProperty("username");
			String PASSWORD=System.getProperty("password");
				
				//Generate the Random Number
				Random random=new Random();
				int randomInt = random.nextInt(10000);
				
				//Read TestScript Data from Excel File
				FileInputStream fis1=new FileInputStream("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\testScriptdata.xlsx");
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
				  Thread.sleep(3000);

				// step 5: logout
				  Actions action=new Actions(driver);
				  action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
				  Thread.sleep(3000);
				  driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				  driver.quit();

			}
	}
}


