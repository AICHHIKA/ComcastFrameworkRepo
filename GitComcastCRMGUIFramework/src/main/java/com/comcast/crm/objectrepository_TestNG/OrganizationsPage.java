package com.comcast.crm.objectrepository_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.basetest_TestNG.BaseClass;

public class OrganizationsPage extends BaseClass {

	WebDriver driver;
	 public OrganizationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	 }
	 
	 @FindBy(xpath= "//img[@alt='Create Organization...']")
	private WebElement createNewOrgBtn;
		
		public WebElement getCreateNewOrgBtn() {
			return createNewOrgBtn;
		}
		
	@FindBy(xpath = "//span[.='Creating New Organization']")
	private WebElement CreatingNewOrganizationPage;
	
	public WebElement getCreatingNewOrganizationPage() {
		return CreatingNewOrganizationPage;
	}

}