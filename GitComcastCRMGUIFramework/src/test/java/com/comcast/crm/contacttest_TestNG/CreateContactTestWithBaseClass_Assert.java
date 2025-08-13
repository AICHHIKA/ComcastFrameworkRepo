package com.comcast.crm.contacttest_TestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.comcast.crm.basetest_TestNG.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactsPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
/**
 * 
 * @author Aichhika
 * 
 */
public class CreateContactTestWithBaseClass_Assert extends BaseClass {
	@Test(groups = "smokeTest")
	//	@Test(groups = {"smokeTest", "regressionTest"})
	public void createContactTest() throws Throwable {
		
		/* read TestScript data from Excel File */
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
		//Instead of driver.findElement() use contact class cp
		String actHeader = driver.findElement(By.className("dvHeaderText")).getText();
//			String actHeader = cp.getHeaderMsg().getText();
				
	
//		if (actHeader.equals(lastName)) {
//			System.out.println(lastName + "Header is verified==PASS");
//		} else {
//			System.out.println(lastName + "Header is not verified==FAIL");
//		}
		// use Assertion
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
		
		String actLastName = driver.findElement(By.id("mouseArea_Last Name")).getText();
//		if (actLastName.equals(lastName)) {
//			System.out.println(lastName + "Information is verified==PASS");
//		} else {
//			System.out.println(lastName + "Information is not verified==FAIL");
//		}
		Assert.assertEquals(actLastName, lastName);
	}
//	public class CreateContactWithSupportDateTest extends BaseClass {
	@Test(groups = "regressionTest")
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
	
//	public class CreateContactWithOrgTestIntegrationTest extends BaseClass {
	@Test(groups = "regressionTest")
	public void createContactWithOrgTestIntegration() throws Throwable {
		// read TestScript data from Excel File
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		System.out.println(orgName);
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();
		System.out.println(contactLastName);

		// step 2: navigate to Contact Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// step 3: click on "Create Contact" button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// step 4: Enter all the details & create new Contact
		CreatingNewOrganisationPage cnop = new CreatingNewOrganisationPage(driver);
		cnop.createOrg(orgName);
		
		//verify Header OrgName info Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			System.out.println(actOrgName);
				
		if(actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + " information is Created==PASS");
		}else {
			System.out.println(orgName + " information is not Created==FAIL");
		}
		
		//step-5: navigate to Contact Module
		hp.getContactLink().click();
		
		//step-6: Click on "Create Contact Button"
		ContactsPage cp = new ContactsPage(driver);
		cp.getContact_img().click();
		
		//step-7: Enter all the details & Create new Contact
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.CreateContactWithOrgTestIntegrationTest(contactLastName, orgName);
		
		//verify Header orgName info Expected Result
		actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "information is created==PASS");
		}else {
			System.out.println(orgName + "information is not created==FAIL");
		}
		
		// step 5: logout
				driver.quit();
	}
}

