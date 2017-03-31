package adminportalTests;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class Test1Login extends BrowserSettings {
	
@Test
public void Login2AdminPortal(){
	
    extent = new ExtentReports("src/QA report.html", true);
    ExtentTest test = extent.startTest("TC1 - Log in");
	
	LoginPageAdm login = new LoginPageAdm(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	Clients client = new Clients(driver);
	
	try {
    login.PreConditions();
    test.log(LogStatus.INFO, "User logged");
    
    client.WaitForElement(); 
    screen.ScreenShot("TC1");

    if(driver.getPageSource().contains("Clients")){
    	test.log(LogStatus.PASS, "Data was verify");
    	extent.endTest(test);
    	}else{
    		test.log(LogStatus.FAIL, "Admin was not sign in");
    		extent.endTest(test);
    	} 

	} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");
	  extent.endTest(test);
	};
	
}
}