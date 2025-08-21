package practice.contactTest;

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

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {

		//Read Common Data From Properties File
				FileInputStream fis = new FileInputStream("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\commondata.properties");
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
				FileInputStream fis1=new FileInputStream("C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\testScriptdata.xlsx");
				Workbook wb =WorkbookFactory.create(fis1);
				Sheet sh	=	wb.getSheet("contact");
				Row row = sh.getRow(4);
				String lastName = row.getCell(2).toString() + randomInt;
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
				driver.findElement(By.name("lastname")).sendKeys(lastName);
				driver.findElement(By.name("support_start_date")).clear();
				driver.findElement(By.name("support_start_date")).sendKeys("currentDate");
				
				driver.findElement(By.name("support_end_date")).clear();
				driver.findElement(By.name("support_end_date")).sendKeys("DateFor30Days");

								
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				
				//verify Header msg Expected Result
				String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
				if(actLastName.equals(lastName))
				{
					System.out.println(lastName + " is created==PASS");
				}
				else
				{
					System.out.println(lastName + " is not created==FAIL");
				}
				
				// step 5: logout
				driver.quit();
	}

}
