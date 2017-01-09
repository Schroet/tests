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
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	
	details.LinkFSAaccount();
	
	 if(driver.getPageSource().contains("FSA")){
			test.log(LogStatus.PASS, "Claim type was linked");
			extent.endTest(test);
			
	    	}else{
	    		
	    		test.log(LogStatus.FAIL, "Claim type not linked");
	    		extent.endTest(test);
	    	}
	 
	 } catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
		};
	 extent.flush();
	 driver.quit();
	}
}
