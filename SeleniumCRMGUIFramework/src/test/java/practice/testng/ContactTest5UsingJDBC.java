package practice.testng;

import org.testng.annotations.Test;

public class ContactTest5UsingJDBC {

	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest with -->HDFC");
	}
	
	@Test
	public void modifyContactTest() {
		System.out.println("create contact ICICI");
		System.out.println("execute modifyContactTest-->ICICI==>ICICI_1");
	}
	
	@Test
	public void deleteContactTest() {
		System.out.println("create UPI Contact");
		System.out.println("execute deleteContactTest UPI");
	}
}
