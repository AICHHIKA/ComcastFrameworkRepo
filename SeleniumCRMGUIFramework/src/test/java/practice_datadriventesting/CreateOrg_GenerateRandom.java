package practice_datadriventesting;

import java.io.FileInputStream;
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

public class CreateOrg_GenerateRandom {

     public static void main(String[] args) throws Throwable {
//		Read Common Data from Properties File
		
		FileInputStream fis = new FileInputStream(".//src\\test\\resources\\commondata.properties");
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
		Sheet sh	=	wb.getSheet("org");
		Row row = sh.getRow(1);
		@SuppressWarnings("unused")
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
		  
		  driver.findElement(By.linkText("Organizations")).click(); 
//		  driver.close();
	}
}

