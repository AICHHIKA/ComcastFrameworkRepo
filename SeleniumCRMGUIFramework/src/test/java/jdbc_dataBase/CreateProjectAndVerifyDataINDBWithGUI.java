package jdbc_dataBase;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectAndVerifyDataINDBWithGUI {

	public static void main(String[] args) {
		String projectName="FaceBook_0102";
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8091");
		driver.findElement(By.name("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.linkText("Projects")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("Aichhika");
		Select sel=new Select(driver.findElement(By.name("status")));
		sel.selectByVisibleText("On Going");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	}

}
