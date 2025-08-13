package practice_test_InvoiceTest_Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.basetest_TestNG.BaseClass;


public class InvoiceTest_Listners_SuiteLevel extends BaseClass{

	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		//Take a Screenshot after Login
		String actTitle = driver.getTitle();
		Assert.assertEquals(actTitle, "Login");
		//For taking a Screenshot 1st we have to create Listeners implementation Class
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoiceWithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}
}
