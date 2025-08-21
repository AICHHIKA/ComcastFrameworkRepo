package practice.testng;

import org.testng.annotations.Test;

public class ContactTest4UsingCreateContact {

	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest with -->HDFC");
	}
	
	@Test
	public void modifyContactTest() {
		System.out.println("execute query insert contact in DB==> ICICI");
		System.out.println("execute modifyContactTest-->ICICI==>ICICI_1");
	}
	
	@Test
	public void deleteContactTest() {
		System.out.println("execute query insert contact in DB==> UPI");;
		System.out.println("execute deleteContactTest UPI");
	}
}
