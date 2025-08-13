package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTestPom {

	public static void main(String[] args) throws Throwable {

		/* Create Object */
		//Read the data from Property File
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		JavaUtility jLib= new JavaUtility();
				
				String BROWSER = fLib.getDataFromPropertiesFile("browser");
				String URL = fLib.getDataFromPropertiesFile("url");
				String USERNAME = fLib.getDataFromPropertiesFile("username");
				String PASSWORD = fLib.getDataFromPropertiesFile("password");
							
				//Read TestScript Data from Excel File
			String orgName = eLib.getDataFromExcel("org", 10, 2) + jLib.getRandomNumber();
				
				WebDriver driver = null;
				
				if(BROWSER.equals("chrome")) {
					driver=new ChromeDriver();
				}else if(BROWSER.equals("firefox")) {
					driver=new FirefoxDriver();
				}else if(BROWSER.equals("edge")) {
					driver=new EdgeDriver();
				}else {
					driver=new ChromeDriver();
				}
				// step 1: Login to app
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get(URL);
				
				/*
				 * LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
				 * lp.getUsernameEdt().sendKeys("admin"); lp.getPasswordEdt().sendKeys("admin");
				 * lp.getLoginBtn().click();
				 */
				LoginPage lp = new LoginPage(driver);
				lp.loginToapp(URL,USERNAME, PASSWORD);
								
				// step 2: navigate to Organization Module
				HomePage hp= new HomePage(driver);
				hp.getOrgLink().click();
				
//				hp.navigateToCampaignPage();
				
				// step 3: click on "Create Organization" button
				OrganizationsPage cnp= new OrganizationsPage(driver);
				cnp.getCreateNewOrgBtn().click();
				  
				// step 4: Enter all the details & create new Organizations
				CreatingNewOrganisationPage cnop= new CreatingNewOrganisationPage(driver);
				cnop.createOrg(orgName);
				
				//verify Header msg Expected Result
				
				OrganizationInfoPage oip= new OrganizationInfoPage(driver);
				String actOrgName=oip.getHeaderMsg().getText();
				
				if(actOrgName.contains(orgName)) {
					System.out.println(orgName + "Name is Verified==PASS");
				}else {
					System.out.println(orgName + "Name is not Verified==FAIL");
	}
				//go back to Organisation Page
				//Search for Organization
				//In Dynamic WebTable Select & Delete Org
				
					
				// step 5: logout
				hp.logOut();
				driver.quit();
	}
				
	}


