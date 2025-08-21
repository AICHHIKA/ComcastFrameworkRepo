package practice_datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DDIwithSeleniumCode {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
	
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
		// step 1: login to app
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
		  driver.findElement(By.name("accountname")).sendKeys("faceBook1");
		  driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		  
		// step 5: logout
		  Actions action=new Actions(driver);
		  action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		  driver.findElement(By.linkText("Sign Out")).click();
		  driver.quit();

	}

}
