package com.pagefactory.framework.uiPages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pagefactory.framework.testBase.TestBase;
import freemarker.log.Logger;

public class LoginPage extends TestBase {
	

	public static final Logger log= Logger.getLogger(LoginPage.class.getName());
	
	WebDriver driver;

	
	//Page Factory
	@FindBy(xpath="//input[@id='usernameField']")
	WebElement txt_UserName;
	
	@FindBy(xpath="//input[@id='passwordField']")
	WebElement txt_Password;
	
	@FindBy(xpath="//button[@class='waves-effect waves-light btn-large btn-block btn-bold blue-btn textTransform']")
	WebElement btn_LoginButton;
	
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void loginToApplication() throws InterruptedException {
		String strEmailID = "pushpraj0906@gmail.com";
		String strPassword = "HariOm@2020";

		txt_UserName.sendKeys(strEmailID);
		log("Entered email address " + strEmailID + " and object is:" + txt_UserName.toString());
		
		txt_Password.sendKeys(strPassword);
		log("Entered email address " + strPassword + " and object is:" + txt_Password.toString());
		
		btn_LoginButton.click();
		log("Clicked on Submit button and object is:" + btn_LoginButton.toString());
		
	}
	
	public void verifySuccessfulLogin() {
		
		WebElement lnk_home = driver.findElement(By.xpath("/html/body/div[2]/div/div/ul[2]/li[2]/a/div[2]"));
		log("My Naukari link visibality is:" + lnk_home.isDisplayed());

		
	}
	
}
