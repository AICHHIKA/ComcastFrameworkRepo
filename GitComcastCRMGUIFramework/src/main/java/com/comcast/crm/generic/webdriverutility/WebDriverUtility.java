package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
//The driver session id is available in the Test Script, If we dont pass driver object here then for which browser we need to wait for pageload
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	//Explicit Wait and also pass the driver instance, the argument are: which browser want to search for the element and wait for element
	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	//Switch to another window
	public void switchToTabOnURL(WebDriver driver, String partialURL) {
		//switch to child window, Get the WindowHandles, create Iterator
		//(Becoz Set collection is not index page), using while loop capture 1st window ID,switch to that window ID,
		//using getURL capture the current URL and then compare the current URL which i pass
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		
		while(it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			String actUrl = driver.getCurrentUrl();
			if(actUrl.contains(partialURL)) {
				break;
			}
		}
	}
	//Switch to another window
	public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	
	while(it.hasNext()) {
		String windowID = it.next();
		driver.switchTo().window(windowID);
		String actUrl = driver.getTitle();
		if(actUrl.contains(partialTitle)) {
			break;
		}
	}
	}
	
	//All are OverLoaded Method(Q:Have you used OverLoaded Method in your Selenium FrameWork,
	//Ans: Yes, here the below: method name are same & the arguments are different )
	//Switch to Frame
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	//Switch to Frame based on Name or Id Attribute
	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
}
	//Switch to Frame based on WebElement
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
}
	//Switch to Alert and Accept
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
}
	//Switch to Alert and Cancel
	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
		
}
	//Select a Value from the DropDown
	//Select the value based on visible text
	public void select(WebElement element, String text) {
		Select sel= new Select(element);
		sel.selectByVisibleText(text);
	}
	//Select the value based on Index
		public void select(WebElement element, int index) {
			Select sel= new Select(element);
			sel.selectByIndex(index);
}
	//Action Class(Mousehover, Keyboard)
	//MousemoveonElement on specific Element
		public void mousemoveOnElement(WebDriver driver, WebElement element) {
			Actions act= new Actions(driver);
			act.moveToElement(element).perform();
		}
	//Double click operation
		public void doubleclick(WebDriver driver , WebElement element) {
			Actions act= new Actions(driver);
			act.moveToElement(element).perform();
		}
}
		
