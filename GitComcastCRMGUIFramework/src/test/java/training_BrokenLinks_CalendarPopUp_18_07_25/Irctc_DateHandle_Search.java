package training_BrokenLinks_CalendarPopUp_18_07_25;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Irctc_DateHandle_Search {

	@Test
	public void irctc_DateHandle_SearchTest() {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver= new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		driver.findElement(By.xpath("//div[@class='text-center col-xs-12']/descendant::button[.='OK']")).click();
		
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-8 ui-autocomplete ui-widget']/descendant::input[@type='text']")).sendKeys("PUNE");
		driver.findElement(By.xpath("//span[@class='ng-tns-c58-9 ui-autocomplete ui-widget']/descendant::input[@type='text']")).sendKeys("MUMBAI");
		
		
	}
}
