package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

/**
 * 
 * @author Aichhika
 * 
 * Contains Login page elements & Business Library like login()
 */
public class LoginPage {
	//Rule 1: Create a Separate Java Class
	//Rule 2: Object Creation
	
	WebDriver driver;
		public LoginPage(WebDriver driver) {
			this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="user_name")
	private	WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private	WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;

	//Rule 3: Object Initialization
	
	//Rule 4: Object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * Login to application based on username, password, url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	
	//Rule 5: Provide Action
	public void loginToapp(String url, String username , String password) {
		WebDriverUtility wu=new WebDriverUtility();
		wu.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
	
	
}
