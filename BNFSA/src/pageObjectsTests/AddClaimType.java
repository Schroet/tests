package pageObjectsTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.AddClient;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class AddClaimType extends BrowserSettings {
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	LaunchBrowser();
	
    ExtentReports logger = ExtentReports.get(AddClaimType.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC8");
	
 	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	
	details.ClickClaimTypesTab();
	details.ClickAddClaimType();
	details.AddClaimType("Sport", "2017-01-01", "2017-12-31");
	
	
	waitmethod.Waitsec();
	
	 if(driver.getPageSource().contains("Delete")){
			logger.log(LogStatus.PASS, "Claim type was added");
			logger.endTest();
			driver.quit();
	    	
	    	}else{
	    		
	    		logger.log(LogStatus.FAIL, "Claim type not added");
	    		logger.endTest();
	    		driver.quit();
	    	}

	}
}
