package adminportalTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class AddAccount extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void DeleteCl() throws InterruptedException{
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC5");
   	
   	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	
	try {
	
	login.PreConditions();
	client.GotoClient();
	details.OpenAccounts();
	details.ClickAddNewAccountButton();
	details.AddnewAccount("FSA" + RandomStringUtils.randomNumeric(3), "777", "2017", "01/01/2017", "01/01/2018");
	
	} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
	};
	
	
	if(driver.getPageSource().contains("Action")){
		test.log(LogStatus.PASS, "Account was added");
		screen.ScreenShot("TC5");
		extent.endTest(test);

    	}else{
    		
    		test.log(LogStatus.FAIL, "Account not added");
    		screen.ScreenShot("TC5");
    		extent.endTest(test);
    	}

	extent.flush();
	driver.quit();

	}
}
