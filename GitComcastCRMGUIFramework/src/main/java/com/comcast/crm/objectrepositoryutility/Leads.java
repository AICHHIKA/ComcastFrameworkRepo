package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Leads {

	// Rule 1: Create a Separate Java Class
	// Rule 2: Object Creation

	WebDriver driver;
	
	public Leads(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(className = "create_leads")
	private WebElement createleads;
	
	@FindBy(className = "save_btn")
	private WebElement savebtn;

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getCreateleads() {
		return createleads;
	}

}
