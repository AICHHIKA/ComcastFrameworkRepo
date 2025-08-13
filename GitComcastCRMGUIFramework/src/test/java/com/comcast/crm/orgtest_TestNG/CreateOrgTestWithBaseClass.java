package com.comcast.crm.orgtest_TestNG;

import com.aventstack.extentreports.Status;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.basetest_TestNG.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.comcast.crm.listenerutility.ListImpClass.class)

public class CreateOrgTestWithBaseClass extends BaseClass {

	@Test(groups = "smokeTest")
	public void CreateOrganizationTest() throws Throwable {
		
		//we put UtilityClass for parallel Execution, whereever we use ListenerImpClass we modify it to Utility C
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");

		// Read TestScript Data from Excel File
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();

		// step 2: navigate to Organization Module
		//ListImpClass.test.log(Status.INFO, "navigate to Org Page");
		UtilityClassObject.getTest().log(Status.INFO, "navigate to Org Page");
		HomePage hp = new HomePage(driver); 
		hp.getOrgLink().click();

		// step 3: click on "Create Organization" button
		//ListImpClass.test.log(Status.INFO, "navigate to craete Org Page");
		UtilityClassObject.getTest().log(Status.INFO, "navigate to craete Org Page");
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();
		
		// step 4: Enter all the details & create new Organizations
		//ListImpClass.test.log(Status.INFO, "create a new Org");
		UtilityClassObject.getTest().log(Status.INFO, "create a new Org");
		CreatingNewOrganisationPage cnop = new CreatingNewOrganisationPage(driver);
		cnop.createOrg(orgName);

		UtilityClassObject.getTest().log(Status.INFO, orgName + "==> Create a New Org==>");

		// verify Header msg Expected Result
//		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//		if (headerInfo.contains(orgName)) {
//			System.out.println(orgName + " is created==PASS");
//		} else {
//			System.out.println(orgName + " is not created==FAIL");
//		}

		// verify Header OrgName info Expected Result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
	}
//		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if (actOrgName.contains(actOrgName)) {
//			System.out.println(actOrgName + " is created==PASS");
//		} else {
//			System.out.println(actOrgName + " is not created==FAIL");
//		}

//	public class CreateOrganizationWithPhoneNumberTest {
	@Test(groups = "regressionTest")
	public void createOrganizationWithPhoneNumberTest() throws Throwable {

		// Read TestScript Data from Excel File
		String orgName = eLib.getDataFromExcel("org", 7, 2) + jLib.getRandomNumber();
		String phoneNumber = eLib.getDataFromExcel("org", 7, 3);

		// step 2: navigate to Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		
		//driver.findElement(By.linkText("Organizations")).click();

		// step 3: click on "Create Organization" button
		OrganizationsPage cnp = new OrganizationsPage(driver);
		cnp.getCreateNewOrgBtn().click();	
		
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// step 4: Enter all the details & create new Organizations
		CreatingNewOrganisationPage cnop = new CreatingNewOrganisationPage(driver);
		cnop.createOrg(orgName);
		
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		//driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		// verify Header msg Expected Result
//		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//
//		if (headerInfo.contains(orgName)) {
//			System.out.println(orgName + " is created==PASS");
//		} else {
//			System.out.println(orgName + " is not created==FAIL");
//		}

		// verify Header Phone Number info Expected Result
		
//		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//
//		if (actOrgName.contains(actOrgName)) {
//			System.out.println(actOrgName + " is created==PASS");
//		} else {
//			System.out.println(actOrgName + " is not created==FAIL");
//		}
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true, actOrgName.contains(orgName));
		String actPhoneNumber = oip.getGetPhoneNumInfo().getText();
		Assert.assertEquals(actPhoneNumber, phoneNumber);
	}

//	public class CreateOrganizationWithIndustriesTest {
	@Test(groups = "regressionTest")
	public void CreateOrganizationWithIndustriesTest() throws Throwable {
		
		// Read TestScript Data from Excel File
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);		

		// step 2: navigate to Organization Module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();
		//driver.findElement(By.linkText("Organizations")).click();

		// step 3: click on "Create Organization" button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNewOrgBtn().click();		
		//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// step 4: Enter all the details & create new Organizations
		CreatingNewOrganisationPage cnop = new CreatingNewOrganisationPage(driver);
		cnop.createOrg(orgName, industry, type);
		
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
//		WebElement websel = driver.findElement(By.name("industry"));
//		Select sel1 = new Select(websel);
//		sel1.selectByVisibleText(industry);
//
//		WebElement websel1 = driver.findElement(By.name("accounttype"));
//		Select sel2 = new Select(websel1);
//		sel2.selectByValue(type1);
//		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();

		// verify the industries and type info
//		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
//		if (actIndustries.equals(industry)) {
//			System.out.println(industry + "information is verified==PASS");
//		} else {
//			System.out.println(industry + "information is not verified==FAIL");
//		}
//
//		String actType = driver.findElement(By.id("dtlview_Type")).getText();
//
//		if (actType.equals(type)) {
//			System.out.println(type + "information is verified==PASS");
//		} else {
//			System.out.println(type + "information is not verified==FAIL");
//		}
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actIndustry = oip.getGetActualIndustryName().getText();
		Assert.assertEquals(true, actIndustry);
		
		// step 5: logout
		driver.quit();
	}
}
