package practice.testng;

import org.testng.annotations.Test;

public class ContactTest6UsingDependency {

	@Test
	public void createContactTest() {
		System.out.println("execute createContactTest with -->HDFC");
	}
	
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		System.out.println("create contact ICICI");
		System.out.println("execute modifyContactTest-->HDFC==>ICICI_1");
	}
	
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		System.out.println("create UPI Contact");
		System.out.println("execute deleteContactTest ICICI");
	}
}
