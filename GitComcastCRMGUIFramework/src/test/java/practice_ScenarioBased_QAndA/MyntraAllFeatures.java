package practice_ScenarioBased_QAndA;

import java.io.File;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MyntraAllFeatures {
	
	@Test
	public void Tc01() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		List<WebElement> ele1 = driver.findElements(By.xpath("//div[@class='desktop-navLink']"));
		
		for(int i=0; i<=5; i++) {
			Thread.sleep(2000);
			
			WebElement ele = ele1.get(i);
			action.moveToElement(ele).perform();
			
		List<WebElement> list1 = driver.findElements(By.xpath("//li[@class='desktop-oddColumnContenet']/ul/li/a|//li[@class='desktop-evenColumnContent desktop-oddColumnContent']/ul/li/a"));
			for(WebElement w : list1) {
				String values = w.getText();
				if(!values.isEmpty()) {
					System.out.println(values);
				}
			}
		}
		WebElement ele2 = driver.findElement(By.xpath("(//div[@class='desktop-navLink'])[7]"));
		action.moveToElement(ele2).perform();
		WebElement photo = driver.findElement(By.xpath("//div[@class='desktop-newPaneContent']"));
		
		File src = photo.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShot/photo.jpg");
//		FileHandler.copy(src, dest);
		
	}
	
//	@Test
	

}
