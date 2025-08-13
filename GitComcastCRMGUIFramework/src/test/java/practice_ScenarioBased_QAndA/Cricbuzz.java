package practice_ScenarioBased_QAndA;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cricbuzz {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.cricbuzz.com/");
		
		driver.findElement(By.xpath("//a[.='Rankings']")).click();
		driver.findElement(By.xpath("//a[.='Rankings']/../nav[@class='cb-sub-navigation']/descendant::a[@title='ICC Rankings Men']"));
		driver.findElement(By.xpath("//a[.='ODI']")).click();
		// Step 4: Choose player name
        String playerName = "Babar Azam";
        String rating="(//a[.='Babar Azam']/ancestor::div[@class='cb-col cb-col-67 cb-rank-plyr'])[1]/../..";
        
        try {
        	WebElement ratingScore = driver.findElement(By.xpath(rating));
        	System.out.println("Player: " + playerName);
            System.out.println("Rating: " + ratingScore.getText());
            
        } catch (Exception e) {
            System.out.println("Player not found or structure changed.");
        }	
        
        driver.quit();
    }
}


