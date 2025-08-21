package practice.hometest_Assert;

import java.lang.reflect.Method;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import junit.framework.Assert;

public class HomePageSampleTest {

	@Test
	public void homePageTest(Method mtd) {
		
		System.out.println(mtd.getName() + "Test Start");
//		System.out.println("step-1");
//		System.out.println("step-2");
////	Assert.assertEquals("Home", "Home");
		
//		//Try to Fail the TestCase here
//		Assert.assertEquals("Home", "Home-Page");
//		System.out.println("step-3");
//		Assert.assertEquals("Home-CRM", "Home-CRM");
//		System.out.println("step-4");
//		System.out.println(mtd.getName() + "Test End");
	
//      Below we are using Soft Assert now
		SoftAssert assertObj = new SoftAssert();
		System.out.println("step-1");
		System.out.println("step-2");
		//To verify Mandatory Fields use Hard Assert
		Assert.assertEquals("Home", "Home");
		System.out.println("step-3");
		//Soft Assert
		assertObj.assertEquals("Title", "Title-1");
		System.out.println("step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName() + "Test End");
}

	@Test
	public void verifyLogoHomePageTest(Method mtd) {
		System.out.println(mtd.getName() + "Test Start");

//		System.out.println(mtd.getName() + "Test End");
//		System.out.println("step-1");
//		System.out.println("step-2");
//		Assert.assertTrue(true);
//		System.out.println("step-3");
//		System.out.println("step-4");
//		System.out.println(mtd.getName() + "Test END");
		
		SoftAssert assertObj = new SoftAssert();
		System.out.println(mtd.getName() + "Test Start");
		System.out.println("step-1");
		System.out.println("step-2");
		assertObj.assertTrue(true);
		
		System.out.println("step-3");
		System.out.println("step-4");
		assertObj.assertAll();
		System.out.println(mtd.getName() + "Test End");
	}
}
