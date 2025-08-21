package practice_datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
//import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

//		System.out.println(pObj.getProperty("browser"));
//		System.out.println(pObj.getProperty("url"));

		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		/*Scanner s=new Scanner(System.in);
		System.out.println("Enter the Browser");
		String browser=s.next();*/
		
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		
		else {
			driver=new ChromeDriver();
		}

//		 driver = new ChromeDriver();
		 driver.get(URL); 
//		ChromeDriver driver = new ChromeDriver();
//		 if i want to change complete program we can create a Firefox object directly and the entire program will be changed.
//			FirefoxDriver driver=new FirefoxDriver();
//		For Upcasting
//		WebDriver driver=new FirefoxDriver();
		 
		  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		  driver.findElement(By.id("submitbutton")).click();
		  
		  driver.findElement(By.linkText("Organizations")).click(); 
		  driver.quit();

//		System.out.println(BROWSER);
//		System.out.println(URL);
	}
}

