package com.pagefactory.framework.uiPages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pagefactory.framework.testBase.TestBase;

public class HomePage extends TestBase {

	public static final Logger log= Logger.getLogger(HomePage.class.getName());
	
	WebDriver driver;

	
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	

	
}
