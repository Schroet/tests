package adminportalTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.AddClient;
import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class LinkAccount extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC9");
	
	
	 try {
 	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	
	login.PreConditions();
	client.GotoClient();
	
	details.LinkFSAaccount();
	
	 if(driver.getPageSource().contains("FSA")){
			test.log(LogStatus.PASS, "Claim type was linked");
			screen.ScreenShot("TC9");
			extent.endTest(test);
			
	    	}else{
	    		
	    		test.log(LogStatus.FAIL, "Claim type not linked");
	    		screen.ScreenShot("TC9");
	    		extent.endTest(test);
	    	}
	 
	 } catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
		};
	 extent.flush();
	 driver.quit();
	}
}
