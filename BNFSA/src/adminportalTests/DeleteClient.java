package adminportalTests;

import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class DeleteClient extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void DeleteCl() throws InterruptedException{
	
	LaunchBrowser();
    
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC2");
	TakeScreenshot screen = new TakeScreenshot(driver);
	
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
    		screen.ScreenShot("TC2");
    		extent.endTest(test);
    		extent.flush();
    	}
	
	client.ClickDeleteСlientOk();
	
	if(driver.getPageSource().contains("AAA")){
		client.ClickDeleteСlient();

    	}else{
    		test.log(LogStatus.PASS, "Client AAA not exist");
    		screen.ScreenShot("TC2");
    		extent.endTest(test);
    		extent.flush();
    		
    	}
	
	  } catch (NoSuchElementException e) {test.log(LogStatus.ERROR, "Test not executed"); }
	  
	    catch (ElementNotVisibleException e) {test.log(LogStatus.ERROR, "Test not executed");
	    screen.ScreenShot("TC2");
	    }
	 
	extent.flush();
	driver.quit();
	
	}
}
