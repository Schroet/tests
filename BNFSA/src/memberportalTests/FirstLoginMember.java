package memberportalTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjectsTests.BrowserSettings;
import pageObjectsTests.LinkAccount;
import pages.LoginPageAdm;
import pagesMember.LoginPageMember;

public class FirstLoginMember extends BrowserSettings  {
	
	private static ExtentReports extent;
	
	@Test
	public void FirstLoginMemberTest(){
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TCM-1");
   	
   	LoginPageMember loginmember = new LoginPageMember(driver);
   	
   	try {
   	
   	loginmember.FirstLoginMemberPortal("fsa@yopmail.com", "123");
   	
    if(driver.getPageSource().contains("Summary")){
		test.log(LogStatus.PASS, "Member was login");
		extent.endTest(test);
		
    	
    	}else{
    		
    		test.log(LogStatus.FAIL, "Member not login");
    		extent.endTest(test);
    		
    	} 
   	}catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
    }; 		

    extent.flush();
	driver.quit();
	}
}
