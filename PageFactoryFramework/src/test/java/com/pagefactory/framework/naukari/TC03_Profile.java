package com.pagefactory.framework.naukari;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pagefactory.framework.testBase.TestBase;
import com.pagefactory.framework.uiPages.ProfilePage;
import com.pagefactory.framework.uiPages.HomePage;
import com.pagefactory.framework.uiPages.LoginPage;

public class TC03_Profile extends TestBase {

	public static final Logger log = Logger.getLogger(TC03_Profile.class.getName());

	LoginPage loginPage;
	HomePage homePage;
	ProfilePage profilePage;

	@BeforeClass
	public void setup() throws IOException {
		init();
	}
	
	@Test(priority=1)
	 public void LoginwithValidCredential() {
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
	public void ProfilePage() {
		profilePage = new ProfilePage(driver);
		profilePage.ClickPencilImgForBasicInfo();
		log("--------------Navigated to Profile Page-----------------");
		
	}


	@Test(priority=3)
	public void verifyProfilePageTitleTest() throws Exception {
		profilePage = new ProfilePage(driver);
		log("--------------Verify profile Page title-----------------");
		Thread.sleep(5000);
		String title =profilePage.profilePageTitle();
		Assert.assertEquals(title, "Profile | Mynaukri","Profile page is not displayed");
		log("-----Profile page title displayed successfully with title " + title);
	}
	
	
	//Create a test to Delete resume
	@Test(priority=4)
	public void deleteResumefromProfile() throws Exception {
		log("---------------------Delete Resume --------------");
		profilePage = new ProfilePage(driver);
		profilePage.ClickDELETERESUME();
		Thread.sleep(3000);
		String DeleteMsg = profilePage.DeleteResumeConfirmation();
		Assert.assertEquals(DeleteMsg, "Attached Resume has been successfully deleted.");
		log("---------------------Resume Deleted Successfully --------------");
		
	}
	
	//Upload the resume from resources/Upload folder to profile
	@Test(priority=5)
	public void uploadResumeToProfile() throws Exception {
		log("---------------------Upload Resume --------------");
		profilePage = new ProfilePage(driver);
		String  filePath= System.getProperty("user.dir") + "/src/main/resources/FileToUpload/Pushp RajResume.docx";
		profilePage.uploadResumeFromPath(filePath);	
		Thread.sleep(6000);
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	
}
