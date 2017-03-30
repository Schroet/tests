package memberportalTests;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import adminportalTests.BrowserSettings;
import adminportalTests.TakeScreenshot;
import pagesAdmin.AddClient;
import pagesMember.LoginPageMember;

public class FirstLoginMember extends BrowserSettings  {
	
	private static ExtentReports extent;
	
	@Test
	public void FirstLoginMemberTest() throws IOException{
		
	AddClient client = new AddClient(driver);
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TCM-1");
   	
   	LoginPageMember loginmember = new LoginPageMember(driver);
   	TakeScreenshot screen = new TakeScreenshot(driver);
   	
   	try {
   	
   	loginmember.FirstLoginMemberPortal("123");
   	
   	
    if(driver.getPageSource().contains("Summary")){
    	screen.ScreenShot("TCM-1");
		test.log(LogStatus.PASS, "Member was login");
		extent.endTest(test);
		
    	
    	}else{
    		
    		screen.ScreenShot("TCM-1");
    		test.log(LogStatus.FAIL, "Member not login");
    		extent.endTest(test);
    		
    	} 
   	}catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
    }; 		

    extent.flush();
	driver.quit();
	}
}
