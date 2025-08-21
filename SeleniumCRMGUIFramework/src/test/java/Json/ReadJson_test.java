package Json;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ReadJson_test {
	@Test
	public void createOrgTest() throws Throwable {
		{
			// Read Common Data from JSON File
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(".\\src\\test\\resources\\appCommonData.json"));

			JSONObject map = (JSONObject) obj;

			String BROWSER = map.get("browser").toString();
			String URL = map.get("url").toString();
			String USERNAME = map.get("username").toString();
			String PASSWORD = map.get("password").toString();
		
			// Generate the Random Number
			Random random = new Random();
			int randomInt = random.nextInt(10000);
			
			WebDriver driver = null;
			if (BROWSER.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (BROWSER.equals("firefox")) {
				driver = new FirefoxDriver();
			} else if (BROWSER.equals("edge")) {
				driver = new EdgeDriver();
			}
			else {
				driver = new ChromeDriver();
			}

			driver.get(URL);

			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitbutton")).click();

			// Read TestScript Data from Excel File
			FileInputStream fis1 = new FileInputStream(
					"C:\\Users\\AYEESIDATTA SENAPATI\\Desktop\\Tek Pyramid\\testScriptdata.xlsx");
			Workbook wb = WorkbookFactory.create(fis1);
			Sheet sh = wb.getSheet("org");
			Row row = sh.getRow(1);
			String orgName = row.getCell(2).toString() + randomInt;
			wb.close();
			
			// step 2: navigate to Organization Module
			driver.findElement(By.linkText("Organizations")).click();

			// step 3: click on "Create Organization" button
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

			// step 4: Enter all the details & create new Organizations
			driver.findElement(By.name("accountname")).sendKeys(orgName);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			Thread.sleep(3000);

			// step 5: logout
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[.='Sign Out']")).click();
			driver.quit();
		}
	}
}



	
