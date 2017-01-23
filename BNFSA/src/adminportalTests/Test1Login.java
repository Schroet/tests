package adminportalTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class Test1Login extends BrowserSettings {
	
	private static ExtentReports extent;

	
@Test
public void Login2AdminPortal(){
	
	LaunchBrowser();

    extent = new ExtentReports("bin/QA report.html", true);
    ExtentTest test = extent.startTest("TC1");
	
	LoginPageAdm login = new LoginPageAdm(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	Clients client = new Clients(driver);
	
	try {
	
    driver.manage().window().maximize();
    login.GetLoginPage();
    login.TypeUsername();
    login.TypePassword();
    login.ClickLoginButton();
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
	};
    extent.flush();
    driver.quit();	
}
}