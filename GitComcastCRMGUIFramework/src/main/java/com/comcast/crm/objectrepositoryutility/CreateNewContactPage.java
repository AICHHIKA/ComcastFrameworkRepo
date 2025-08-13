package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateNewContactPage {

	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Rule-2: Object Identification by FindBy Annotation &
	// Rule-4: Object Encapsulation

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	// Support Start Date
	@FindBy(name = "support_start_date")
	private WebElement startDateEdt;

	// Support End Date
	@FindBy(name = "support_end_date")
	private WebElement endDateEdt;

	// Organization Name
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[1]")
	private WebElement orgNameSearchBtn;

	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement orgNameSearchEdt;

	// Save
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchNowBtn;
	
	@FindBy(id = "1")
	private WebElement click_org_name;	
	

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getOrgNameSearchBtn() {
		return orgNameSearchBtn;
	}

	public WebElement getOrgNameSearchEdt() {
		return orgNameSearchEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}

	public void createContactWithSupportDate(String lastName, String startDate, String endDate) {
		lastNameEdt.sendKeys(lastName);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
	}

	public void CreateContactWithOrgTestIntegrationTest(String lastName, String orgName) {
		lastNameEdt.sendKeys(lastName);
		getOrgNameSearchBtn().click();
		WebDriverUtility wLib = new WebDriverUtility();
		// Switch to Child Window
		wLib.switchToTabOnURL(driver, "module=Accounts&action");
		getOrgNameSearchEdt().sendKeys(orgName);
		getSearchNowBtn().click();
		click_org_name.click();
		//driver.findElement(By.xpath(orgName)).click();
		// Switch to Parent Window
		wLib.switchToTabOnTitle(driver, "module=Contacts&action");
		saveBtn.click();

	}
}