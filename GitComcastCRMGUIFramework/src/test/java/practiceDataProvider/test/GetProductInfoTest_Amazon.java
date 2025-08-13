package practiceDataProvider.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GetProductInfoTest_Amazon {

	@Test
	public void getProductInfoTest_AmazonTest() {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("http://amazon.in");
		
		driver.findElement(By.xpath("//button[.='Continue shopping']")).click();
		
		//Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone", Keys.ENTER);
		
		//Capture Product Info
		String x = "//span[text()='Apple iPhone 15 (128 GB) - Black']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = ((WebElement) By.xpath("//h2[number(translate(text(), '₹', ''))<80000])")).getText();
		//a[@class='----']|//a[@class='----']/descendant::span[@class='a-price-whole]
		System.out.println(price);
	}
}

