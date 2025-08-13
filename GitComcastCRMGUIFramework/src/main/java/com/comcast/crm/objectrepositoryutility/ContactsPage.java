package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	
	WebDriver driver;
	
	//Rule-2: Object Identification by FindBy Annotation & 
	//Rule-4: Object Encapsulation
	
	//Rule-3: Object Initialization
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement Contact_img;
	
//	//Rule-5: Object Utilization
//	public void click_contact_img() {
//		Contact_img.click();
//	}
	
	public WebElement getContact_img() {
		return Contact_img;
	}
}
