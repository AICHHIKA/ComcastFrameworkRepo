package training_BrokenLinks_CalendarPopUp_18_07_25;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class MakemyTrip_Calender_Tkt_Apply {
	
	@Test
	public void MakemyTrip_Calender_Tkt_ApplyTest() throws Throwable {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("disable-notification");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		//pop-up
		driver.findElement(By.className("commonModal__close")).click();
		driver.findElement(By.xpath("//span[@class='styles__Close-sc-1bytt3z-0 kezeYI']")).click();
		//From
		driver.findElement(By.xpath("//span[.='From']")).click();
		//from
		driver.findElement(By.xpath("//input[@placeholder='From']")).click();
		//Search Mumbai
		driver.findElement(By.xpath("//p[.='Mumbai, India']")).click();
		//To
		driver.findElement(By.xpath("//span[.='To']")).click();
		//to
		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).click();
		//Search Bengaluru
		driver.findElement(By.xpath("//p[.='Bengaluru, India']")).click();
		Thread.sleep(2000);
		//Departure Date
		WebElement departure = driver.findElement(By.xpath("//label[@for='departure']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", departure);
		Thread.sleep(2000);

		//November 2025
		String monthofDeparture="November 2025";
		for(int i=1; i<=3; i++) {
			try {
				driver.findElement(By.xpath("//div[text()='November']/../following-sibling::div[@class='DayPicker-Body']/descendant::div[@aria-label='Sun Nov 09 2025']")).click();
			break; 
			}catch(Exception E) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		//Return
			WebElement monthofReturn = driver.findElement(By.xpath("//span[.='Return']"));
			js.executeScript("arguments[0].click();", monthofReturn);
			Thread.sleep(2000);

			//November 2025
			String Return="November 2025";
			
		try {
			driver.findElement(By.xpath("//div[text()='November']/../following-sibling::div[@class='DayPicker-Body']/descendant::div[@aria-label='Thu Nov 20 2025']")).click();
		break; 
		}catch(Exception E) {
			driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		}
	}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Travellers & Class']")).click();
		driver.findElement(By.xpath("//li[@data-cy='adults-2']")).click();
		driver.findElement(By.xpath("//li[@data-cy='children-1']")).click();
		driver.findElement(By.xpath("//li[text()='Business']")).click();
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
		driver.findElement(By.xpath("//p[@class='makeFlex vrtlCenter ' and 'Search']")).click();
//		driver.findElement(By.xpath("//span[@class='bgProperties cross-icon cursorPointer']"));
	}
}



		

