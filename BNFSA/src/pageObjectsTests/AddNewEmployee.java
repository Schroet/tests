package pageObjectsTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.AddClient;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;
import pages.MembersList;

public class AddNewEmployee extends BrowserSettings {
	
private static ExtentReports extent;
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC14");
	
   	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	MembersList list = new MembersList(driver);
	
	 try {
			login.PreConditions("sys", "sys");
			
			client.GotoClient();
			details.ClickMemberButton();
			list.ClickAddEmplBtn();
			list.AddNewEmpl();
			list.WaitEditbtn();
			
			
			   if(driver.getPageSource().contains("AAA")){
			    	test.log(LogStatus.PASS, "Employee was added");
			    	screen.ScreenShot("TC14");
			    	
			    	
			    	extent.endTest(test);
			    	}else{
			    		
			    		test.log(LogStatus.FAIL, "Employee not added");
			    		extent.endTest(test);
			    		screen.ScreenShot("TC14");
			    	}

	
	 } catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
		};
	 extent.flush();
	 driver.quit();
	
	
	}
}
