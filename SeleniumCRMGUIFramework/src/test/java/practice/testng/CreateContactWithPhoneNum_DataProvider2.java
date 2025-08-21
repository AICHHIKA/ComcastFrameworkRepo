package practice.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithPhoneNum_DataProvider2 {

	@Test(dataProvider = "getData")
	public void createContact_DataProviderTest(String firstName, String lastName, long phoneNumber) {
		
	System.out.println("FirstName :" + firstName + ",LastName :" + lastName + ",PhoneNumber:" + phoneNumber);
	}
	
	@DataProvider
	public Object[][] getData() {
		
	Object[][] objArr= new Object[3][3];
	objArr[0][0] = "Aichhika";
	objArr[0][1] = "Sw";
	objArr[0][2] = 9819872556l;
	
	objArr[1][0] = "Deepak";
	objArr[1][1] = "hd";
	objArr[1][2] = 9819872557l;
	
	objArr[2][0] = "Sam";
	objArr[2][1] = "hr";
	objArr[2][2] = 9819872558l;
	
	return objArr;
}
	
}
