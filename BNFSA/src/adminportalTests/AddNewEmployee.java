package adminportalTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.AddClient;
import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;
import pagesAdmin.MembersList;

public class AddNewEmployee extends BrowserSettings {
	

	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{

	extent = new ExtentReports("src/QA report.html", false);
	ExtentTest test = extent.startTest("TC14");
	
   	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	MembersList list = new MembersList(driver);
	
	 try {
			login.PreConditions();
			
			client.GotoClient();
			details.ClickMemberButton();
			list.WaitAddbtn();
			list.ClickAddEmplBtn();
			list.AddNewEmpl();
			list.WaitEditbtn();
			
			
			   if(driver.getPageSource().contains("AAA")){
			    	test.log(LogStatus.PASS, "Employee was added");
			    	screen.ScreenShot("TC14");
			    	
			    	
			    	extent.endTest(test);
			    	}else{
			    		
			    		test.log(LogStatus.FAIL, "Employee not added");
			    		extent.endTest(test);
			    		screen.ScreenShot("TC14");
			    	}

	
	 } catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");
	   extent.endTest(test);
		};

	}
}
