package practice.testng;

import org.testng.annotations.Test;

public class OrderTest2InvocationCount {

	@Test(invocationCount = 5)
	public void createOrderTest() {
		
		System.out.println("Execute createOrderTest==>123");
	}
	
	@Test(enabled = false)
	public void billingAnOrderTest() {
		System.out.println("Execute billingAnOrderTest==>123");
	}
}
