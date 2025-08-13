package com.comcast.crm.contacttest_TestNG;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.basetest_TestNG.*;
import com.comcast.crm.objectrepositoryutility.*;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactWithOrgTestIntegrationTest extends BaseClass {
	@Test
	public void createContactWithOrgTestIntegrationTest() throws Throwable {
		//read TestScript data from Excel File
		
		String orgName = eLib.getDataFromExcel("contact", 7, 2) + jLib.getRandomNumber();
		String contactLastName = eLib.getDataFromExcel("contact", 7, 3) + jLib.getRandomNumber();

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
}
	
}
