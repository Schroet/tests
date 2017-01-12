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
import pages.ClaimLimitsPage;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class AddClaimLimitUSD extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC11");
	
 	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	ClaimLimitsPage limits = new ClaimLimitsPage(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	
	try {
		
	login.PreConditions("sys", "sys");
	client.GotoClient();
	details.ClickClaimTypesTab();
	details.GotoClaimType();
	
	limits.AddClaimLimitUSD("10","10");
	
	
	
	 if(driver.getPageSource().contains("USD")){
			test.log(LogStatus.PASS, "Limit was added");
			screen.ScreenShot("TC11");
			extent.endTest(test);
			
	    	}else{
	    		
	    		test.log(LogStatus.FAIL, "Limit type not added");
	    		screen.ScreenShot("TC11");
	    		extent.endTest(test);
	    	}
	 
	} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
	};
	 
	 extent.flush();
	 driver.quit();

	}
}
