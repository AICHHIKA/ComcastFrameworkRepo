package practice_test_InvoiceTest_Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest_TestNG.BaseClass;

@Listeners( com.comcast.crm.listenerutility.ListImpClass.class)
public class InvoiceTest_itest_isuite extends BaseClass{

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
