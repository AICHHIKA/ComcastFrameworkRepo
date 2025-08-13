package training_BrokenLinks_CalendarPopUp_18_07_25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

public class MakeMyTrip_Date {

	@Test
	public void MakeMyTrip_DateTest() throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.className("commonModal__close")).click();
		Thread.sleep(2000);
		
		try {
            driver.findElement(By.cssSelector(".commonModal__close")).click();
        } catch (Exception e) {
            System.out.println("Login modal already closed.");
        }
		
//		//close login popup
//		driver.findElement(By.xpath("//span[@data-cy='commonModal__close']")).click();
		
		// Click on 'From' and select Bangalore
        driver.findElement(By.id("fromCity")).click();
        driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bangalore");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[contains(text(),'Bangalore, India')]")).click();
        
        // Click on 'To' and select Mumbai
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("Mumbai");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
		
//		//From City
//        driver.findElement(By.xpath("//span[.='From']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Bangalore");
//		driver.findElement(By.xpath("//div[text()='BOM']")).click();
		
//		//To City
//		driver.findElement(By.xpath("//label[@for='fromCity']")).sendKeys(Keys.TAB);
//		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("New Delhi");
//		driver.findElement(By.xpath("//div[text()='DEL']")).click();
		
		//Departure Date
		driver.findElement(By.id("departure")).click();
		driver.findElement(By.xpath("//div[.='August 2025']/../descendant::p[.='28']")).click();
		Thread.sleep(2000);
		
		//Return Date
		driver.findElement(By.xpath("//p[@data-cy='returnDefaultText']")).click();
		Thread.sleep(2000);
		for(;;) {
			try {
				driver.findElement(By.xpath("//div[text()='September']/../following-sibling::div[@class=\"DayPicker-Body\"]/descendant::div[@aria-label=\"Sun Sep 07 2025\"]")).click();
			break;
			}catch(Exception E) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		Thread.sleep(2000);
//		driver.findElement(By.xpath("//span[@class='lbl_input appendBottom5']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		driver.findElement(By.xpath("//li[@data-cy='children-1']")).click();
		driver.findElement(By.xpath("//li[text()='Business']")).click();
		driver.findElement(By.xpath("//button[text()='APPLY']")).click();
		driver.findElement(By.xpath("//font[text()='View Details']")).click();
		
		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeAsyncScript("arguments[0].click();", ele);
		
//			try {
//				driver.findElement(By.xpath("//div[contains(text(),'"+Month+"')]//span[text()='"+year+"']
//		/ancestor::div[@class='DayPicker-Caption']/following-sibling::div[@class='DayPicker-Body']/descendant::p[text()='"+Date+"']")).click();
//				//div[.='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[.="+Date+"]
//				break;
//			}catch(Exception e) {
//				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//			}
//		}
//		
//		driver.findElement(By.xpath("//span[text()='Return']")).click();
//		for(;;) {
//			try {
//				driver.findElement(By.xpath("//label[@for='departure']/descendant::p[@data-cy='departureDate']")).click();
//			break;
//			}catch(Exception e) {
//				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
//			}
	}
}



