package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {

	@FindBy(name="products")
	private	WebElement productname;

	public WebElement getProductname() {
		return productname;
	}
}
