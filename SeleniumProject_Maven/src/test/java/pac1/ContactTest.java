package pac1;

import org.testng.annotations.Test;

public class ContactTest {

	@Test
	public void createcontactTest() {
		
		String URL = System.getProperty("url");
		
		//If we are not passing the System.getProperty , we can specify the default data means like firefox 
		String BROWSER = System.getProperty("browser" , "firefox");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");

		System.out.println(URL);
		System.out.println(BROWSER);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

		System.out.println("execute createcontactTest");
	}
	
	@Test
	public void modifycontactTest() {
		System.out.println("execute modifycontactTest");
	}
}
