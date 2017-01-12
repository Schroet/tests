package pageObjectsTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.AddClient;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class AddClaimType extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC8");
	
 	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	
	try {
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	
	details.ClickClaimTypesTab();
	details.ClickAddClaimType();
	details.AddClaimType("Sport", "2017-01-01", "2017-12-31");
	
	waitmethod.Waitsec();
	
	
	
	 if(driver.getPageSource().contains("Delete")){
			test.log(LogStatus.PASS, "Claim type was added");
			screen.ScreenShot("TC8");
			extent.endTest(test);
	    	}else{
	    		
	    		test.log(LogStatus.FAIL, "Claim type not added");
	    		screen.ScreenShot("TC8");
	    		extent.endTest(test);
	    	}
	 
	} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
	};
	 extent.flush();
	 driver.quit();

	}
}
