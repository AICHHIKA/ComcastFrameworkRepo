package practice.testng;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.Test;

public class SampleTestForScreenShotTest_TestNG {

	@Test
	public void amazonTest() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("http://amazon.com");
		
		//step-1 : create an object to EventFiring Webdriver
		TakesScreenshot eDriver = (TakesScreenshot) driver;
		
		//step-2 : use getScreenshotAs method to get file type of screenshot
		File srcFile = eDriver.getScreenshotAs(OutputType.FILE); 
		
		//step-3 : Store screen on local driver
		FileUtils.copyFile(srcFile, new File("./screenshot/test.png"));
		
		//if we want to take full screenshot there is a tool called Ashot
	}
}
