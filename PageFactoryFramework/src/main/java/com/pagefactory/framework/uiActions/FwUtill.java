/*package com.ibm.automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentTest;

public class FwUtill extends FwGlobalVariables {
	
	public static Hashtable<String,Hashtable<String,String>> loadTestDataOld(String tcID,String testDataXlsFile) {
		Hashtable<String,Hashtable<String,String>> tcHashtable = new Hashtable<String,Hashtable<String,String>>();
		Hashtable <String,String> rowHash = new Hashtable <String,String>();
		try {
		    FileInputStream file = new FileInputStream(new File(testDataXlsFile));     
		    System.out.println("testDataXlsFile-"+testDataXlsFile);
		    //Get the workbook instance for XLS file 
		    XSSFWorkbook workbook = new XSSFWorkbook (file);		 
		    //Get first sheet from the workbook
		    XSSFSheet sheet = workbook.getSheetAt(0);
		    //Get Sheet by Name 
		    //XSSFSheet sheet = workbook.getSheet("xxx");
		    int rownum = sheet.getPhysicalNumberOfRows();//get  number of rows
		    int colnum = sheet.getRow(0).getPhysicalNumberOfCells();// get numbers of column  		   
		    for(int rowLoop = 1;rowLoop < rownum;rowLoop++){
		    	String TCID = sheet.getRow(rowLoop).getCell(0).getStringCellValue();
		    	if(TCID.equals(tcID)){
		    		for(int colLoop = 0;colLoop < colnum;colLoop++){
		    			rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(), sheet.getRow(rowLoop).getCell(colLoop).getStringCellValue());
		            }
		    		tcHashtable.put(tcID, rowHash);
		       }
		    }
		    workbook.close();
		    file.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return tcHashtable;
	}
	public static Hashtable<String,Hashtable<String,String>> loadTestData(String tcID,String testDataXlsFile) throws Exception {
		Hashtable<String,Hashtable<String,String>> tcHashtable = new Hashtable<String,Hashtable<String,String>>();
		Hashtable <String,String> rowHash = new Hashtable <String,String>();
		try {
		    FileInputStream file = new FileInputStream(new File(testDataXlsFile));     
		    //Get the workbook instance for XLS file 
		    XSSFWorkbook workbook = new XSSFWorkbook (file);
		    int  numOfsheet = workbook.getNumberOfSheets();
		    for (int sheetCounter =0 ;sheetCounter< numOfsheet;sheetCounter++){
			    //Get first sheet from the workbook
			    XSSFSheet sheet = workbook.getSheetAt(sheetCounter);
			    int rownum = sheet.getPhysicalNumberOfRows();//get  number of rows
			    int colnum = sheet.getRow(0).getPhysicalNumberOfCells();// get numbers of column 		   
			    for(int rowLoop = 1;rowLoop < rownum;rowLoop++){
			    	String TCID = sheet.getRow(rowLoop).getCell(0).getStringCellValue();
			    	System.out.println(TCID);
			    	if(TCID.equals(tcID)){
			    		for(int colLoop = 0;colLoop < colnum;colLoop++){
			    			//rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(), sheet.getRow(rowLoop).getCell(colLoop).getStringCellValue());
			    			
			    			XSSFCell  cell = (sheet.getRow(rowLoop).getCell(colLoop));
			    			//System.out.println((cell.getCellType()));
			    			if (cell==null) {
			    				rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(),"");
			    			}
			    			else{	
				    			switch (cell.getCellType()) {
				    			case Cell.CELL_TYPE_STRING:
				    			  //  cellValue = cell.getStringCellValue();
				    			    rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(), cell.getStringCellValue());
				    			    break;
	
				    			case Cell.CELL_TYPE_FORMULA:
				    			   // cellValue = cell.getCellFormula();
				    			    rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(), cell.getCellFormula());
				    			    break;
				    			case Cell.CELL_TYPE_NUMERIC:
				    			    if (DateUtil.isCellDateFormatted(cell)) {
				    			       // cellValue = cell.getDateCellValue().toString();
				    			        rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(), cell.getDateCellValue().toString());
				    			    } else {			    			       
				    			        rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(), Double.toString(cell.getNumericCellValue()));
				    			    }
				    			    break;
				    			case Cell.CELL_TYPE_BLANK:	
				    				System.out.println("CELL_TYPE_BLANK");
				    			    rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(),"");
				    			    break;
				    			case Cell.CELL_TYPE_BOOLEAN:			    			    
				    			    rowHash.put(sheet.getRow(0).getCell(colLoop).getStringCellValue(), Boolean.toString(cell.getBooleanCellValue()));
				    			    break;
				    			}

			    			}
			            }//for
			    		break;
			       }
			    }
			    System.out.println("test");
		    }
		    tcHashtable.put(tcID, rowHash);
		    workbook.close();
		    file.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		catch(Exception e)
		{
			throw e;
		}
		return tcHashtable;
	}
	public static void addTestDataTable(String tcID,String colKey,String colValue){
		Hashtable <String,String> tempHash = FwGlobalVariables.tcTestdataTable.get(tcID);
		tempHash.put(colKey,colValue);
		FwGlobalVariables.tcTestdataTable.put(tcID,tempHash);
		
	}
	public static String getTestData(String tcID,String colKey){
		//System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
		return FwGlobalVariables.tcTestdataTable.get(tcID).get(colKey);
	}
	public static String getxlsTestData(String colKey){
		//System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
		return FwGlobalVariables.tcTestdataTable.get(FwUtill.currentTestName()).get(colKey);
	}
	public static String currentTestName(){
		String methodName = null ;
		int i =0;
		while (methodName != "invoke0"){
			methodName = Thread.currentThread().getStackTrace()[i].getMethodName();
			if (methodName.equalsIgnoreCase("invoke0")){
				methodName = Thread.currentThread().getStackTrace()[i-1].getMethodName();
				break;				
			}// max condition need to be added
			else {
				i= i+1;
			}
		}
		return methodName;
	}
	public static WebDriver currentWebDriver(){
		return FwGlobalVariables.driverHash.get(FwUtill.currentTestName());
	}
	
	public static  void openBrowserURL(String browserName ,String url) throws InterruptedException{
		if (browserName.equalsIgnoreCase("FF")){
			
			  ProfilesIni profile = new ProfilesIni(); 
	            FirefoxProfile ffprofile = profile.getProfile("default"); 
	            WebDriver tempBrowserDriver = new FirefoxDriver(ffprofile);
				ffprofile.setPreference("browser.download.folderList", 2);
				ffprofile.setPreference("browser.download.manager.showWhenStarting", false);
				ffprofile.setPreference("browser.download.dir", "C:\\Downloads");
				ffprofile.setPreference("browser.helperApps.neverAsk.openFile",
						"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
				ffprofile.setPreference( "browser.download.manager.showWhenStarting", false );
				ffprofile.setPreference("browser.helperApps.neverAsk.saveToDisk",
						"text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml");
				ffprofile.setPreference("browser.helperApps.alwaysAsk.force", false);
				ffprofile.setPreference("browser.download.manager.alertOnEXEOpen", false);
				ffprofile.setPreference("browser.download.manager.focusWhenStarting", false);
				ffprofile.setPreference("browser.download.manager.useWindow", false);
				ffprofile.setPreference("browser.download.manager.showAlertOnComplete", false);
				ffprofile.setPreference("browser.download.manager.closeWhenDone", false);
				//ffprofile.setPreference( "pdfjs.disabled", true );
	            
				driverHash.put(FwUtill.currentTestName(), tempBrowserDriver);
			  tempBrowserDriver.manage().window().maximize();
				tempBrowserDriver.get(url);
		}
		else if(browserName.equalsIgnoreCase("CH"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Env\\chromedriver.exe");
			WebDriver tempBrowserDriver = new ChromeDriver();
			tempBrowserDriver.manage().window().maximize();
			tempBrowserDriver.get(url);
			driverHash.put(FwUtill.currentTestName(), tempBrowserDriver);
			}
		else if(browserName.equalsIgnoreCase("IE"))
		{			
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			//ieCapabilities.setCapability(CapabilityType.VERSION,"9");
			System.setProperty("webdriver.ie.driver", "C:\\Selenium\\IEDriverServer_Win32\\IEDriverServer.exe");
			ieCapabilities.setPlatform(Platform.ANY);
			WebDriver tempBrowserDriver = new InternetExplorerDriver(ieCapabilities);			
			tempBrowserDriver.manage().window().maximize();
			tempBrowserDriver.get(url);	
			Thread.sleep(5000);
			driverHash.put(FwUtill.currentTestName(), tempBrowserDriver);
			
			}
		
	
	}
	public static String getTimeStamp() {
		Calendar cal = Calendar.getInstance();
		Date currentTime = cal.getTime();
		String aTimeStamp = currentTime.toString();
		aTimeStamp = aTimeStamp.replaceAll(":", "");
		aTimeStamp = aTimeStamp.replaceAll("-", "");
		aTimeStamp = aTimeStamp.replaceAll(" ", "_");
		return aTimeStamp;
	}
	public static String getXLSTestData(String requiredColumn, String requiredRow,String testDataXlsFile) throws Exception {
		String CellValue  = "";		
		try {
		    FileInputStream file = new FileInputStream(new File(testDataXlsFile));     
		    //Get the workbook instance for XLS file 
		    XSSFWorkbook workbook = new XSSFWorkbook (file);
		    int  numOfsheet = workbook.getNumberOfSheets();
		    for (int sheetCounter =0 ;sheetCounter< numOfsheet;sheetCounter++){
			    //Get first sheet from the workbook
			    XSSFSheet sheet = workbook.getSheetAt(sheetCounter);
			    int rownum = sheet.getPhysicalNumberOfRows();//get  number of rows
			    int colnum = sheet.getRow(0).getPhysicalNumberOfCells();// get numbers of column 		   
			    for(int rowLoop = 1;rowLoop < rownum;rowLoop++){
			    	String TempRowValue = sheet.getRow(rowLoop).getCell(0).getStringCellValue();
			    	if(TempRowValue.equals(requiredRow)){
			    		for(int colLoop = 0;colLoop < colnum;colLoop++){
			    			XSSFCell  cell = (sheet.getRow(rowLoop).getCell(colLoop));			    		
			    			if (sheet.getRow(0).getCell(colLoop).getStringCellValue().equalsIgnoreCase(requiredColumn)) {	
			    				switch (cell.getCellType()) {
				    			case Cell.CELL_TYPE_STRING:
				    				CellValue =  cell.getStringCellValue();	
				    				break;
				    			case Cell.CELL_TYPE_FORMULA:
				    				CellValue =  cell.getCellFormula();
				    				break;
				    			case Cell.CELL_TYPE_NUMERIC:
				    			    if (DateUtil.isCellDateFormatted(cell)) {				    			       
				    			    	CellValue =  cell.getDateCellValue().toString();
				    			    	break;
				    			    } else {
				    			    	CellValue =  Double.toString(cell.getNumericCellValue());
				    			    	break;
				    			    }				    			 
				    			case Cell.CELL_TYPE_BLANK:	
				    				System.out.println("CELL_TYPE_BLANK");				    			 
				    				CellValue =  "";
				    				break;
				    			case Cell.CELL_TYPE_BOOLEAN:				    			   
				    				CellValue =  Boolean.toString(cell.getBooleanCellValue());	
				    				break;
			    				}
			    			}
			            }
			    		break;
			       }
			    }
		    }
		    workbook.close();
		    file.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		catch(Exception e)
		{
			throw e;
		}
		return CellValue ;
	}
	
	
	public static String getWinwowHandle(){
		String parentHandle = FwUtill.currentWebDriver().getWindowHandle();
		return parentHandle;
	}
	//switch focus of WebDriver to the next found window handle (that's your newly opened window)	
	public static void switchToNewWindow() throws InterruptedException{
		
		for (String winHandle : FwUtill.currentWebDriver().getWindowHandles()) {
			FwUtill.currentWebDriver().switchTo().window(winHandle); 
		}		
	}	
	public static void closeWindow(){
		FwUtill.currentWebDriver().close();		
	}
	public static void switchToWindoByHandeler(String winHandle){
		FwUtill.currentWebDriver().switchTo().window(winHandle);
	}
	
	public static void DOMObjectHandler()
	{
		try {
		  // Object 	CurrentDriver = FwUtill.currentWebDriver();
			 //Maximize window  
		   FwUtill.currentWebDriver().manage().window().maximize();  
			 //Launching the browser page  
		   FwUtill.currentWebDriver().get("file:///C:/Users/IBM_ADMIN/Desktop/Abhi/DomContent/DOM locator.html");  
			 //Adding wait  
		   FwUtill.currentWebDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
			 
			//Creating the Javascript executor interface object by Type casting  
			 JavascriptExecutor js = (JavascriptExecutor) FwUtill.currentWebDriver();  
			 //Send email address   
			 WebElement email = (WebElement) ((JavascriptExecutor) FwUtill.currentWebDriver()).executeScript("return document.getElementById('email');");  
			 email.sendKeys("abc@aexp.com");  
			 Thread.sleep(3000);  

			 //send pass  
			 WebElement pass = (WebElement) ((JavascriptExecutor) FwUtill.currentWebDriver()).executeScript("return document.forms['domf2'].elements['password'];");  
			 pass.sendKeys("aaaaaa");  
			 Thread.sleep(3000);  

			 //Click on button  
			 WebElement btn = (WebElement) ((JavascriptExecutor) FwUtill.currentWebDriver()).executeScript("return document.forms[1].elements['butt'];");  
			 btn.click();  
			 WebElement last = (WebElement) ((JavascriptExecutor) FwUtill.currentWebDriver()).executeScript("return document.getElementsByName('name1')[0];");  
			 last.sendKeys("aaaaaa");  
			 Thread.sleep(3000);//close firefox browser   
			 FwUtill.currentWebDriver().quit();  	
			
			
		}
	catch (Exception e)
		{
		e.printStackTrace();
		System.out.println("Error received is "+e);
		}
	
	}
	
		
	 // ASSERTION FUNCTIONS TO BE INCLUDED 
	public static void Assrt_Values(String Actual,String Expected)
  {
	// Validation against actual on Application data with expected value from Excel data	
	try {
		
		System.out.println("we are failing at Assertion !!");
		Assert.assertEquals(Actual, Expected);
	}
	catch (AssertionError e1)
	{
				FwUtill.closeWindow();
		throw e1;
	}
		
}

public static boolean AssertEqualMessage(String Actual,String Expected,String Message)
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