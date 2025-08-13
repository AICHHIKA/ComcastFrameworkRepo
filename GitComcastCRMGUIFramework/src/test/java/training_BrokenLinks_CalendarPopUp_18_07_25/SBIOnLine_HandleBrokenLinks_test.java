package training_BrokenLinks_CalendarPopUp_18_07_25;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SBIOnLine_HandleBrokenLinks_test {
public class handleBrokenLinks_test {
	
//	@SuppressWarnings("deprecation")
//	@Test
//	public void handleBrokenLinks_test() {
//		WebDriver driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		driver.get("https://www.onlinesbi.sbi/");
//		
//		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
//		System.out.println(allLinks.size());
//		
//		for(WebElement eachLink : allLinks) {
//			String link = eachLink.getDomAttribute("href");
//			
//			try {
//				URL url=new URL(link);
//				HttpURLConnection conn=(HttpURLConnection) url.openConnection();
//				int statusCode = conn.getResponseCode();
//				if(statusCode>=400) {
//					System.out.println(link + "==>" + statusCode);
//				}
//				}catch(Exception e) {
//			}
//		}
//		driver.quit();
//	}

	@Test
    public void handleBrokenLinks_test() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://www.onlinesbi.sbi/");

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Total links found: " + allLinks.size());

        for (WebElement eachLink : allLinks) {
            String link = eachLink.getDomAttribute("href");

            // Skip empty, null, javascript, or mailto links
            if (link == null || link.isEmpty() || 
                link.startsWith("javascript") || 
                link.startsWith("mailto")) {
                continue;
            }

            try {
                URL url = new URL(link);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setConnectTimeout(2000); // Set timeout to avoid hanging
                conn.connect();
                int statusCode = conn.getResponseCode();

                if (statusCode >= 400) {
                    System.out.println("Broken Link: " + link + " ==> HTTP Status: " + statusCode);
                }
            } catch (Exception e) {
                System.out.println("Exception for URL: " + link + " ==> " + e.getMessage());
            }
        }

        driver.quit();
    }
}
}

