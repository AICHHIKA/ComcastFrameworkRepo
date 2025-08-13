package com.comcast.crm.contacttest_TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.basetest_TestNG.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactTest extends BaseClass {

	@Test
	public void createContactTest() throws Throwable {
		// read TestScript data from Excel File
		String lastName = eLib.getDataFromExcel("contact", 1, 2) + jLib.getRandomNumber();

		// step 2: navigate to Contact Module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step 3: click on "Create Contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getContact_img().click();

		// step 4: Enter all the details & create new Contact
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(lastName);

		// verify Header msg Expected

//		String actHeader = driver.findElement(By.className("dvsHeaderText")).getText();
//		if (actHeader.equals(lastName)) {
//			System.out.println(lastName + "Header is verified==PASS");
//		} else {
//			System.out.println(lastName + "Header is not verified==FAIL");
//		}
//		
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + "Information is verified==PASS");
		} else {
			System.out.println(lastName + "Information is not verified==FAIL");
		}
	}
}
