package pageObjectsTests;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.LoginPageAdm;

public class Test1Login extends BrowserSettings {
	
	private static ExtentReports extent;
	
@Test
public void Login2AdminPortal(){
	
	LaunchBrowser();

    
    extent = new ExtentReports("bin/QA report.html", true);
    ExtentTest test = extent.startTest("TC1");
	
	LoginPageAdm login = new LoginPageAdm(driver);
	
	try {
	
    driver.manage().window().maximize();
    login.GetLoginPage();
    
    login.TypeUsername();
    login.TypePassword();
    login.ClickLoginButton();
    test.log(LogStatus.INFO, "User logged");
    
	} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
	};
    	
    	
    
    if(driver.getPageSource().contains("Clients")){
    	test.log(LogStatus.PASS, "Data was verify");
    	extent.endTest(test);
    	}else{
    		test.log(LogStatus.FAIL, "Admin was sign in");
    		extent.endTest(test);
    	}
    
    extent.flush();
    driver.quit();
		
}
}