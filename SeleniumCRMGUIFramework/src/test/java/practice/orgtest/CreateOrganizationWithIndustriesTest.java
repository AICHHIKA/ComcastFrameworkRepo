package practice.orgtest;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustriesTest {

	public static void main(String[] args, String type) throws IOException, InterruptedException {
		
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
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(4);
		String orgName = row.getCell(2).toString() + randomInt;
		String industry= row.getCell(3).toString();
		row.getCell(4).toString();
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
		
		WebElement websel1 = driver.findElement(By.name("txtbox_Type"));
		Select sel2=new Select(websel1);
		sel2.selectByVisibleText(type);
		
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
		
		if(actType.equals(type))
		{
			System.out.println(type + "information is verified==PASS");
		}
		else
		{	
			System.out.println(type + "information is not verified==FAIL");
		}
		
		// step 5: logout
		driver.quit();

	}

}
