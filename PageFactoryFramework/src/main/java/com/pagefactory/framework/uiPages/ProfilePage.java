package com.pagefactory.framework.uiPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pagefactory.framework.testBase.TestBase;

import freemarker.log.Logger;

public class ProfilePage extends TestBase {

	public static final Logger log= Logger.getLogger(ProfilePage.class.getName());
	
	WebDriver driver;
	

	//Page Factory
	@FindBy(xpath="//div[@class='profile-section-wrapper']//div//a//div//img[@class='circle nk-userdp']")
	WebElement PencilImgForBasicInfo;
	
	@FindBy(xpath="//a[contains(text(),'DELETE RESUME')]")
	WebElement DeleteResumeLink;
	
	@FindBy(xpath="//p[text()='Are you sure you want to delete the Resume?']/following-sibling::div//button[text()='DELETE']")
	WebElement DeleteButtonFromConfirmBox;	
	
	@FindBy(xpath="//p[contains(text(),'Attached Resume has been successfully deleted.')]")
	WebElement DeleteResumeConfirmationMessage;
	
	
	@FindBy(xpath="//input[@id='attachCV']")
	WebElement UploadResumeButton;
	

	public ProfilePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String profilePageTitle() {
		return driver.getTitle();
	}
	
	public void ClickPencilImgForBasicInfo() {
		PencilImgForBasicInfo.click();
	}
	
	public void ClickDELETERESUME() throws InterruptedException{
		Thread.sleep(3000);
		DeleteResumeLink.click();
		Thread.sleep(3000);
		DeleteButtonFromConfirmBox.click();
	}
	
	public String DeleteResumeConfirmation() {
		 return DeleteResumeConfirmationMessage.getText();
	}
	
	public void uploadResumeFromPath(String fpath) throws Exception {
		Thread.sleep(3000);
		UploadResumeButton.sendKeys(fpath);
	}
}
