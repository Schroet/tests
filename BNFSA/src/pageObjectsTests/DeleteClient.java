package pageObjectsTests;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pages.Clients;
import pages.LoginPageAdm;

public class DeleteClient extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void DeleteCl() throws InterruptedException{
	
	LaunchBrowser();
    
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC2");
	
	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	
	  try {
	login.GetLoginPage();
	driver.manage().window().maximize();
	
	login.LoginAdminPortal("sys", "sys");
	
	
	if(driver.getPageSource().contains("AAA")){
		client.ClickDeleteСlient();
    	
    	}else{
    		
    		test.log(LogStatus.PASS, "Client AAA not exist");
    		extent.endTest(test);
    	}
	
	client.ClickDeleteСlientOk();
	
	if(driver.getPageSource().contains("AAA")){
		client.ClickDeleteСlient();

    	}else{
    		test.log(LogStatus.PASS, "Client AAA not exist");
    		extent.endTest(test);
    		
    	}
	  } catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
		};
	extent.flush();
	driver.quit();
	}
}
