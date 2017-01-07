package pageObjectsTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.AddClient;
import pages.ClaimLimitsPage;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class AddClaimLimitUAH extends BrowserSettings {
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	LaunchBrowser();
	
    ExtentReports logger = ExtentReports.get(AddClaimLimitUAH.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC10");
	
 	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	ClaimLimitsPage limits = new ClaimLimitsPage(driver);
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	details.ClickClaimTypesTab();
	details.GotoClaimType();
	limits.AddClaimLimitUAH("100", "2", "10", "20");
	
	 if(driver.getPageSource().contains("Edit")){
			logger.log(LogStatus.PASS, "Limit was added");
			logger.endTest();
			driver.quit();
	    	
	    	}else{
	    		
	    		logger.log(LogStatus.FAIL, "Limit type not added");
	    		logger.endTest();
	    		driver.quit();
	    	}

	}
}
