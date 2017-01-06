package memberportalTests;

import java.awt.AWTException;

import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pageObjectsTests.BrowserSettings;
import pageObjectsTests.LinkAccount;
import pages.LoginPageAdm;
import pagesMember.LoginPageMember;

public class FirstLoginMember extends BrowserSettings  {
	
	
	@Test
	public void FirstLoginMemberTest(){
	
	LaunchBrowser();
	
    ExtentReports logger = ExtentReports.get(FirstLoginMember.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC-Member-1");
   	
   	LoginPageMember loginmember = new LoginPageMember(driver);
   	
   	loginmember.FirstLoginMemberPortal("fsa@yopmail.com", "123");
   	
    if(driver.getPageSource().contains("Summary")){
		logger.log(LogStatus.PASS, "Member was login");
		logger.endTest();
		driver.quit();
    	
    	}else{
    		
    		logger.log(LogStatus.FAIL, "Member not login");
    		logger.endTest();
    		driver.quit();
    	}

	}
}
