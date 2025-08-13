package practiceDataProvider.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest_WithoutHardCoding_Dynamic_Amazon2 {

	@Test(dataProvider = "getData")
	public void GetProductInfoTest_WithoutHardCoding_Dynamic_Amazon2Test(String brandName , String productName) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		//Search Product
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iPhone", Keys.ENTER);
		
		//Capture Product Info
		String x = "//span[text()='"+productName+"']/../../../../div[3]/div[1]/div/div[1]/div[1]/div[1]/a/span/span[2]/span[2]";
		String price = driver.findElement(By.xpath(x)).getText();
		System.out.println(price);
		
		driver.quit();
	}
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		int rowCount = eLib.getRowcount("product");		
		
		Object[][] objArr= new Object[rowCount][2];
	
		for(int i=0; i<rowCount; i++) {
		objArr[i][0] = eLib.getDataFromExcel("product", i+1, 0);
		objArr[i][1] = eLib.getDataFromExcel("product", i+1, 1);
		}
	
		return objArr;
}
}
