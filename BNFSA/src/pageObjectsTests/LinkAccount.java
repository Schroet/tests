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

public class LinkAccount {
	
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
	
    ExtentReports logger = ExtentReports.get(LinkAccount.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC9");
	
 	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	
	details.LinkFSAaccount();
	
	 if(driver.getPageSource().contains("FSA")){
			logger.log(LogStatus.PASS, "Claim type was linked");
			logger.endTest();
			driver.quit();
	    	
	    	}else{
	    		
	    		logger.log(LogStatus.FAIL, "Claim type not linked");
	    		logger.endTest();
	    		driver.quit();
	    	}
	
	}
}
