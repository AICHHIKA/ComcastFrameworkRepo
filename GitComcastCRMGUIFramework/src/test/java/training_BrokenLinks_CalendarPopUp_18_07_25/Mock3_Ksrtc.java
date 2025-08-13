package training_BrokenLinks_CalendarPopUp_18_07_25;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Mock3_Ksrtc {

	@Test
	public void ksrtc_Calender_Price_Seats() throws InterruptedException {
//
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		driver.get("https://ksrtc.in/");
//
//		Actions action = new Actions(driver);
//
//		List<WebElement> ele = driver.findElements(By.xpath("//span[.='Select Departure City']"));
////			driver.findElement(By.xpath("//span[.='Coorg']"));
//		for (int i = 0; i <= 5; i++) {
//			WebElement ele1 = ele.get(i);
//			action.moveToElement(ele1).perform();
//		}
//
//		List<WebElement> ele1 = driver.findElements(By.xpath("//label[.='Going To']"));
//		driver.findElement(By.xpath("//span[.='Bengaluru']")).click();
//
//		driver.findElement(By.xpath("(//label[@for='departDate'])[1]"));
//		driver.findElement(By.xpath("//a[.='13']")).click();
//
//	}
//
//	}

	WebDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.manage().window().maximize();

	driver.get("https://ksrtc.in/");

	WebElement wb = driver.findElement(By.xpath("//span[text()='Select Departure City']"));

	wb.click();

	WebElement wb1 = driver.findElement(By.xpath("//input[@placeholder='Search Your City Name']"));

	wb1.sendKeys("Bangalore");

	wb1.sendKeys(Keys.ENTER);

	Thread.sleep(2000);

	WebElement dest = driver.findElement(By.xpath("//span[text()='Select Destination City']"));

	dest.click();

	WebElement dest1 = driver.findElement(By.xpath("(//input[@placeholder='Search Your City Name'])[2]"));

	dest1.sendKeys("Belgaum");

	dest1.sendKeys(Keys.ENTER);

	driver.findElement(By.id("departDate")).click();

	driver.findElement(By.xpath("//a[contains(text(),'10')]")).click();

	driver.findElement(By.id("submitSearch")).click();

	List<WebElement> element = driver.findElements(By.xpath("//div[@class='srch-card-row']"));

	if(element.size()>0)
	{

	int count=9;

	for (WebElement data : element) {

		System.out.println(data.getText());

	}	

	}
	}
}

	
