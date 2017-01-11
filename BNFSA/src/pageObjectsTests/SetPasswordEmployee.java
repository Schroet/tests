package pageObjectsTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pages.AddClient;
import pages.ClaimLimitsPage;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class SetPasswordEmployee extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC12");
	
	try {
 	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	ClaimLimitsPage limits = new ClaimLimitsPage(driver);
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	details.ClickMemberButton();
	details.SetPass("123", "123");
	
	 if(driver.getPageSource().contains("Global ID")){
			test.log(LogStatus.PASS, "Password was set");
			extent.endTest(test);
			
	    	}else{
	    		
	    		test.log(LogStatus.FAIL, "Pass not set");
	    		extent.endTest(test);
	    	}
	
	} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
	};

	extent.flush();
	driver.quit();
}
}
