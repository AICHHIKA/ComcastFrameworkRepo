package com.comcast.crm.contacttest_TestNG;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.basetest_TestNG.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithSupportDateTest extends BaseClass {

	@Test
	public void createContactWithSupportDateTest() throws Throwable {
		// read TestScript data from Excel File
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		// step 2: navigate to Contact Module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step 3: click on "Create Contact" button
		ContactsPage cp = new ContactsPage(driver);
		cp.getContact_img().click();

		// step 4: Enter all the details & create new Contact
		String endDate = jLib.getSystemDateYYYYDDMM();
		String startDate = jLib.getRequiredDateYYYYDDMM(30);
	
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactWithSupportDate(lastName, startDate, endDate);

		// Verify StartDate and EndDate
		String actstartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actstartDate.equals(startDate)) {
			System.out.println(startDate + " information is verified==PASS");
		} else {
			System.out.println(startDate + " information is not verified==FAIL");
		}

		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " information is Verified==PASS");
		} else {
			System.out.println(endDate + " information is not created==FAIL");
		}
	}
}
