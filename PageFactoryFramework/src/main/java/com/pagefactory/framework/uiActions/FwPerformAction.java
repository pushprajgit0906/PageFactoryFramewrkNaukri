/*package com.pagefactory.framework.uiActions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FwPerformAction {
	WebElement objElement;
	public void funcClick(By sElementLocater)throws InterruptedException, IOException
	{
		try{			
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);
			objElement = wait.until(ExpectedConditions.elementToBeClickable(sElementLocater));
			objElement.click();		
		}
		catch (IllegalArgumentException e)
		{
			//report.FuncReport("Fail","IllegalArgumentException");
			FwReport.log("FAIL", "Exception", "IllegalArgumentException - Ckeck if <b>"+sElementLocater+ " </b>present");
			FwReport.logScreenshot("FAIL", "Failed Screenshot ");
			//throw e;
		}
		catch(Exception e)
		{
			//report.FuncReport("Fail","The element <b>- "+FuncGetText(sElementLocater)+"</b> not present in current page");
			FwReport.log("FAIL", "Exception", "Exception - Ckeck if <b>"+sElementLocater+ " </b> present");
			FwReport.logScreenshot("FAIL", "Failed Screenshot ");
			//throw e;
		}
	}
			
	public String funcBtnClick(By sElementLocater)throws InterruptedException, IOException
	{
		try{			
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);
			objElement = wait.until(ExpectedConditions.elementToBeClickable(sElementLocater));
			objElement.click();	
			return "PASS";
		}
		catch (IllegalArgumentException e)
		{			
			FwReport.log("FAIL", "Exception", "IllegalArgumentException - Ckeck if <b>"+sElementLocater+ " </b>present");
			FwReport.logScreenshot("FAIL", "Failed Screenshot ");
			return "FAIL";
			
		}
		catch(Exception e)
		{			
			FwReport.log("FAIL", "Exception", "Exception - Ckeck if <b>"+sElementLocater+ " </b> present");
			FwReport.logScreenshot("FAIL", "Failed Screenshot ");
			return "FAIL";
			
		}
	}
	public String funcLinkClick(By sElementLocater)throws InterruptedException, IOException
	{
		try{			
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);
			objElement = wait.until(ExpectedConditions.elementToBeClickable(sElementLocater));
			objElement.click();	
			return "PASS";
		}
		catch (IllegalArgumentException e)
		{			
			FwReport.log("FAIL", "Exception", "IllegalArgumentException - Ckeck if <b>"+sElementLocater+ " </b>present");
			FwReport.logScreenshot("FAIL", "Failed Screenshot ");
			return "FAIL";
			
		}
		catch(Exception e)
		{			
			FwReport.log("FAIL", "Exception", "Exception - Ckeck if <b>"+sElementLocater+ " </b> present");
			FwReport.logScreenshot("FAIL", "Failed Screenshot ");
			return "FAIL";
			
		}
	}
	public  void funcSendKeys(By sElementLocater, String sTextToSend)throws InterruptedException, IOException,  Exception
	
	{
		try{	
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);		
			objElement = wait.until(ExpectedConditions.presenceOfElementLocated(sElementLocater));
			objElement.clear();
			objElement.sendKeys(sTextToSend);
		}
		catch (IllegalArgumentException e)
		{
			//report.FuncReport("Fail","IllegalArgumentException Exception occurred");
			throw e;
		}
		catch(Exception e)
		{
			//report.FuncReport("Fail","<b>- "+sElementLocater+"</b> not present in current page");
			throw e;
		}
	}
	public  void funcEditSendKeys(By sElementLocater, String sTextToSend)throws InterruptedException, IOException,  Exception
	
	{
		try{	
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);		
			objElement = wait.until(ExpectedConditions.presenceOfElementLocated(sElementLocater));
			//objElement.click();
			objElement.clear();
			objElement.sendKeys(sTextToSend);
		}
		catch (IllegalArgumentException e)
		{
			//report.FuncReport("Fail","IllegalArgumentException Exception occurred");
			System.out.println(e);
			throw e;
		}
		catch(Exception e)
		{
			//report.FuncReport("Fail","<b>- "+sElementLocater+"</b> not present in current page");
			System.out.println(e);
			throw e;
		}
	}
	public String funcVerifyLink(By  sElementLocater)throws InterruptedException, IOException ,  Exception
	{
		try{
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);
			objElement = wait.until(ExpectedConditions.elementToBeClickable(sElementLocater));
			FwReport.log("PASS", "Link Verification","<b>- "+sElementLocater+"</b> present in current page ");
			return "PASS";			
			}
			catch (IllegalArgumentException e)
			{				
				FwReport.log("FAIL", "Link Verification","<b>- "+sElementLocater+"</b> not present in current page ");
				throw e;
			}
			catch(Exception e)
			{
				FwReport.log("FAIL", "Link Verification","<b>- "+sElementLocater+"</b> not present in current page ");
				throw e;
			}
	}
	public String funcVerifyButtonWithMSG(By  sElementLocater,String MSG)throws InterruptedException, IOException ,  Exception
	{
		try{
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);
			objElement = wait.until(ExpectedConditions.elementToBeClickable(sElementLocater));
			FwReport.log("PASS", "Button Verification","<b>- "+sElementLocater+"</b> present in current page ");
			FwReport.logScreenshot("PASS", MSG + " Successful");
			return "PASS";			
			}
			catch (IllegalArgumentException e)
			{				
				FwReport.log("FAIL", "Button Verification","<b>- "+sElementLocater+"</b> not present in current page ");
				throw e;
			}
			catch(Exception e)
			{
				FwReport.log("FAIL", "Button Verification","<b>- "+sElementLocater+"</b> not present in current page ");
				throw e;
			}
	}
	//public void FuncKeyPress(String sElementLocater,String sLocval,String sKey)throws InterruptedException, IOException
	public void FuncKeyPress(By sElementLocater,String sKey)throws InterruptedException, IOException,  Exception
	{
		try{
			
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);		
			objElement = wait.until(ExpectedConditions.presenceOfElementLocated(sElementLocater));
			objElement.sendKeys(Keys.valueOf(sKey));
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e);
			throw e;
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}
	public String  funcGetText(By sElementLocater) throws InterruptedException, IOException,  Exception
	{
		try{
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);		
			objElement = wait.until(ExpectedConditions.presenceOfElementLocated(sElementLocater));
			String pageText = objElement.getText();		
			return pageText;		
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(e);
				throw e;
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw e;
			}
	}
	
	public boolean funcFindElement(By sElementLocater) throws InterruptedException, IOException,  Exception
	{
		try{
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);		
			objElement = wait.until(ExpectedConditions.presenceOfElementLocated(sElementLocater));
			objElement.isDisplayed();
			return true;
			boolean elementPresence = objElement.isDisplayed();
			if (elementPresence == true)
			{
				System.out.println("Element Present");
			}
			else
			{
				System.out.println("Element Not Present");
			}
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(e);
				throw e;
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw e;
			}
	}
	public void  funcVerifyTextwithMsg(By sElementLocater,String ExpectedText, String MSG) throws InterruptedException, IOException,  Exception
	{
		try{
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);		
			objElement = wait.until(ExpectedConditions.presenceOfElementLocated(sElementLocater));
			String pageText = objElement.getText();		
			if (pageText.equalsIgnoreCase(ExpectedText))
			{
				FwReport.log("PASS", "Text Verification","<b>- "+ExpectedText+"</b> present in current page ");
				FwReport.logScreenshot("PASS", MSG + "Successful");
			}
			else
			{
				FwReport.log("FAIL", "Text Verification","<b>- "+ExpectedText+"</b> present in current page ");
				FwReport.logScreenshot("FAIL", MSG + "UNsuccessful");
			}
			
			
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(e);
				throw e;
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw e;
			}
	}
	public void funcMoveToElement(By sElementLocater) throws InterruptedException, IOException,  Exception{
		try{
			WebDriverWait wait = new WebDriverWait(FwUtill.currentWebDriver(),60);		
			objElement = wait.until(ExpectedConditions.presenceOfElementLocated(sElementLocater));
			Thread.sleep(2000);	
			Actions actions = new Actions(FwUtill.currentWebDriver());
			WebElement lnkSel = FwUtill.currentWebDriver().findElement(sElementLocater);
			actions.moveToElement(lnkSel).sendKeys(lnkSel,Keys.ARROW_DOWN).perform();
		
			
			Thread.sleep(2000);	
			
			}
			catch (IllegalArgumentException e)
			{
				System.out.println(e);
				throw e;
								
			}
			catch(Exception e)
			{
				System.out.println(e);
				throw e;
			}
		
	}
	public void funcSelectFromDropdown(By sElementLocater,String sListValue)throws InterruptedException, IOException, Exception
	{
	
		Select droplist = null;
		try{
			
		//WebDriverWait wait = new WebDriverWait(GlobalVariables.BrowserDriver,20);

				
			for (int second = 0;; second++) {
				    
				    try { 
				        droplist = new Select(FwUtill.currentWebDriver().findElement(sElementLocater));
				        if((!droplist.getOptions().isEmpty())||(second >= 60))
				        {
				            break;
				        }
				    } catch (Exception e) {
				         // best put something here
				    }
				    Thread.sleep(1000);
				}
		
			
		droplist.selectByVisibleText(sListValue);
		
		}
		catch (IllegalArgumentException e)
		{
			System.out.println(e);
			throw e;
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			throw e;
		}
	}
	
	public void funcSelectFromDropdownValue(By sElementLocater,int sListValue)throws InterruptedException, IOException, Exception
	{
		//System.out.println(sListValue);	
		Select droplist = null;
		try{
			
		//WebDriverWait wait = new WebDriverWait(GlobalVariables.BrowserDriver,20);

				
			for (int second = 0;; second++) {
				    
				    try { 
				        droplist = new Select(FwUtill.currentWebDriver().findElement(sElementLocater));
				        if((!droplist.getOptions().isEmpty())||(second >= 60))
				        {
				            break;
				        }
				    } catch (Exception e) {
				         // best put something here
				    }
				    Thread.sleep(1000);
				}			
		droplist.selectByIndex(sListValue);
		//System.out.println(sListValue);	
		}
		catch (IllegalArgumentException e)
		{;
			System.out.println(e);
			throw e;
		}
		catch(Exception e)
		{
			
			System.out.println(e);
			throw e;
		}
	}
	
	public void Assrt_Values(String Actual,String Expected) throws Exception
	  {
		// Validation against actual on Application data with expected value from Excel data	
		try {
			
			System.out.println("Assertions being Validated !!");
			Assert.assertEquals(Actual, Expected);
		}
		catch (AssertionError e1)
		{
			
			FwReport.logScreenshot("FAIL","Please check snapshot for failure details");	
			FwUtill.closeWindow();
			throw e1;
		}
			
	}

	public boolean AssertEqualMessage(String Actual,String Expected,String Message) throws Exception
	{
		// Validation against actual on Application data with expected value from Excel data	
		try {
			Assert.assertEquals(Actual, Expected, Message);
		return true;
		}
		catch(Exception e) 
		{
			return false;
		}	
	}

}
*/