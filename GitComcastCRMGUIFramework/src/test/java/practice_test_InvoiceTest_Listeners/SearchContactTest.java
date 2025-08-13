package practice_test_InvoiceTest_Listeners;
/**
 * test class for Contact Module
 * @author Aichhika
 */

import org.testng.annotations.Test;

import com.comcast.crm.basetest_TestNG.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass {
	/**
	 * Scenario : login() ==> navigateContact ==>createcontact()==>verify
	 */
	
	@Test
	public void searchcontactTest() {
		
		/* Step 1: Login to app*/
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp("url", "username", "password");
		
	}
}
