package adminportalTests;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.AddClient;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class AddNewClient extends BrowserSettings {
	
	@Test
	public void Login2AdminPortal() throws InterruptedException{	
		
	//LaunchBrowser();
	    
	extent = new ExtentReports("src/QA report.html", false);
	ExtentTest test = extent.startTest("TC3");
	
	LoginPageAdm login = new LoginPageAdm(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	
    login.GetLoginPage();
    driver.manage().window().maximize();
     
    Clients clients = new Clients(driver);
    AddClient addclient = new AddClient(driver);
    
    try {
    login.LoginAdminPortal();
    clients.ClickAddСlientButton();
    addclient.TypeClient();
    addclient.TypeCountry();
    addclient.TypeStatus();
    addclient.TypeMultiLingual();
    addclient.TypeLanguage();
    addclient.TypeCurrency();
    test.log(LogStatus.INFO, "Currency was added");
    addclient.ClickAddButton();
    
    if(driver.getPageSource().contains("AAA")){
    	test.log(LogStatus.PASS, "Client was added");
    	screen.ScreenShot("TC3");
    	
    	
    	extent.endTest(test);
    	}else{
    		
    		test.log(LogStatus.FAIL, "Client not added");
    		extent.endTest(test);
    		screen.ScreenShot("TC3");
    	}
	} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");
	  extent.endTest(test);
	};

   
	}
}
