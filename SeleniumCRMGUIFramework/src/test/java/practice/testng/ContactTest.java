package practice.testng;

import org.testng.annotations.Test;

public class ContactTest {

	@Test
	public void createContactTest() {
		System.out.println("execute login");
		System.out.println("execute navigateToContactTest");
		System.out.println("execute createContactTest");
		System.out.println("execute verifycontactTest");
		System.out.println("execute logout");
	}
	
	@Test
	public void createContactWithMobileNumberTest() {
		System.out.println("execute createContactWithMobileNumberTest");
	}
}
