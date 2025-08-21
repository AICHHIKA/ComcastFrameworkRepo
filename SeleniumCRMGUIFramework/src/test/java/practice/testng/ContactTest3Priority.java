package practice.testng;

import org.testng.annotations.Test;

public class ContactTest3Priority {

	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest with --->HDFC");
	}
	
	@Test
	public void modifyContactTest() {
		System.out.println("execute modifyContactTest --->HDFC==>ICICI");
	}
	
	@Test
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest -->ICICI");
	}
}
