package training_BrokenLinks_CalendarPopUp_18_07_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KSRTC_Date_Search {

	@Test
	public void KSRTC_Date_SearchTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/");
		
		driver.findElement(By.xpath("//div[@class=\"search-from-city\"]/descendant::label[text()='Leaving From']")).sendKeys("");
	}
}
