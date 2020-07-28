package com.pagefactory.framework.naukari;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pagefactory.framework.testBase.TestBase;
import com.pagefactory.framework.uiPages.HomePage;
import com.pagefactory.framework.uiPages.LoginPage;

import freemarker.log.Logger;

public class TC01_Login extends TestBase{
	
	LoginPage loginPage;
	
	public static final  Logger log = Logger.getLogger(TC01_Login.class.getName());
	

	
	@BeforeClass
	public void setup() throws IOException {
		init();
	}
	
	@Test(priority=1)
	 public void verifyLoginwithValidCredential() {
			try {
				log("---------------------Starting TC - Verify Login Credential --------------");
				
				loginPage = new LoginPage(driver);
				loginPage.loginToApplication();
				Thread.sleep(5000);
	
			} catch (Exception e) {
				log("xxxxxxxxxxxxxxxxx verifyLoginwithValidCredential Test Failed xxxxxxxxxxxxxxxxxxxxxx");
			}
	}
	
	@Test(priority=2)
	public void verifySuccessfullLogin() throws Exception {
		try {
			log("---------------------Starting TC - Verify Successfull Login --------------");
			Thread.sleep(5000);
			loginPage = new LoginPage(driver);
			loginPage.verifySuccessfulLogin();
		} catch (Exception e) {
			log("xxxxxxxxxxxxxxxxx verifyHomePageTitleTest Test Failed xxxxxxxxxxxxxxxxxxxxxx");

		}
	}
	
}
