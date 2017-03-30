package adminportalTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.AddClient;
import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class UploadEmployeeBulk extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
		
		LaunchBrowser();
		
		extent = new ExtentReports("bin/QA report.html", false);
		ExtentTest test = extent.startTest("TC6");
		
	   	LoginPageAdm login = new LoginPageAdm(driver);
		Clients client = new Clients(driver);
		ClientDetails details = new ClientDetails(driver);
		AddClient waitmethod = new AddClient(driver);
		TakeScreenshot screen = new TakeScreenshot(driver);
		
		
		try {
		login.PreConditions();
		client.GotoClient();
				
		details.ClickImportEmployeeButton();
		details.ClickChooseFile();
		
	    StringSelection ss = new StringSelection("C:\\GIT\\BNFSA\\bin\\bulks\\Employees.en-GB.xls");  
	    waitmethod.Waitsec();
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    Robot robot = new Robot();
	    
	    waitmethod.Waitsec();
	    robot.keyPress(KeyEvent.VK_CONTROL);
	    waitmethod.Waitsec();
	    robot.keyPress(KeyEvent.VK_V);
	    waitmethod.Waitsec();
	    robot.keyRelease(KeyEvent.VK_V);
	    waitmethod.Waitsec();
	    robot.keyRelease(KeyEvent.VK_CONTROL);
	    waitmethod.Waitsec();
	    robot.keyPress(KeyEvent.VK_ENTER);
	    waitmethod.Waitsec();
	    robot.keyRelease(KeyEvent.VK_ENTER);
	    waitmethod.Waitsec();
	    
	    details.ClickSubmitEmpl();
	    waitmethod.Waitsec();
	    details.ClickOkafterUpload();
	    waitmethod.Waitsec();
	    details.ClickMemberButton();
	    waitmethod.Waitsec();

	    if(driver.getPageSource().contains("John")){
			test.log(LogStatus.PASS, "Member added was added");
			screen.ScreenShot("TC6");
			extent.endTest(test);
			
	    	}else{
	    		
	    		test.log(LogStatus.FAIL, "Member not added");
	    		extent.endTest(test);
	    		screen.ScreenShot("TC6");
	    	}
	    
		} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");}
		  catch (ElementNotVisibleException e) {test.log(LogStatus.ERROR, "Test not executed");}
		  catch (NullPointerException e) {test.log(LogStatus.ERROR, "Test not executed");}

		extent.endTest(test);
		screen.ScreenShot("TC6");
	    extent.flush();
		driver.quit();
	}
}
