package practice_test_InvoiceTest_Listeners;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest_TestNG.BaseClass;


public class InvoiceTest__RetryAnalyzer_NetworkTC_Listners_SuiteLevel extends BaseClass{

	
	//In order to use RetryAnalyzer  we use retryAnalyzer & give the path:
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImp.class)
	
	public void activateSim() {
		System.out.println("execute createInvoiceTest");
		Assert.assertEquals("", "Login");
		//For taking a Screenshot 1st we have to create Listeners implementation Class
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
}
