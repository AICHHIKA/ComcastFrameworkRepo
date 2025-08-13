package training_BrokenLinks_CalendarPopUp_18_07_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RedBus_HandleSingleCalenderDate_test {

	@Test
	public void handleCalender_test() {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/");
	
		driver.findElement(By.xpath("//div[@class='dojWrapper___cfd382']")).click();
		driver.findElement(By.xpath("//span[.=30]"));
		
		driver.quit();
	}
}

