package com.pagefactory.framework.naukari;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pagefactory.framework.testBase.TestBase;
import com.pagefactory.framework.uiPages.HomePage;
import com.pagefactory.framework.uiPages.LoginPage;

import freemarker.log.Logger;

public class TC02_Home extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public static final  Logger log = Logger.getLogger(TC01_Login.class.getName());
	

	
	@BeforeClass
	public void setup() throws IOException {
		init();
	}
	
	@Test(priority=1)
	 public void verifyLoginwithValidCredential() {
			try {
				log("---------------------Login inot application with valid credential --------------");
				
				loginPage = new LoginPage(driver);
				loginPage.loginToApplication();
				Thread.sleep(5000);
	
			} catch (Exception e) {
				log("xxxxxxxxxxxxxxxxx LoginwithValidCredential Test Failed xxxxxxxxxxxxxxxxxxxxxx");
			}
	}
	
	@Test(priority=2)
	public void verifyHomePageTitleTest() throws Exception {
			try {
				log("---------------------Starting TC - Verify Home Page Title --------------");
				homePage = new HomePage(driver);
				String title =homePage.homePageTitle();
				Assert.assertEquals(title, "Home | Mynaukri","HomePage not displayed");
			
			} catch (Exception e) {
				log("xxxxxxxxxxxxxxxxx verifyHomePageTitleTest Test Failed xxxxxxxxxxxxxxxxxxxxxx");
			}
	}
	

}
