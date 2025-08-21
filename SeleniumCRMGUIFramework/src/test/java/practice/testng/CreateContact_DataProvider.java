package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContact_DataProvider {

	@Test(dataProvider = "getData")
	public void createContact_DataProviderTest(String firstName, String lastName) {
		
	System.out.println("FirstName :" + firstName + ",LastName :" + lastName);
	}
	
	@DataProvider
	public Object[][] getData() {
		
	Object[][] objArr= new Object[3][2];
	objArr[0][0] = "Aichhika";
	objArr[0][1] = "Sw";
	
	objArr[1][0] = "Deepak";
	objArr[1][1] = "hd";
	
	objArr[2][0] = "Sam";
	objArr[2][1] = "hr";
	
	return objArr;
}
	
}
