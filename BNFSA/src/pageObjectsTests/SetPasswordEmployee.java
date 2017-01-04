package pageObjectsTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;

import pages.AddClient;
import pages.ClaimLimitsPage;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class SetPasswordEmployee {
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
	
    ExtentReports logger = ExtentReports.get(SetPasswordEmployee.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC12");
	
 	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	ClaimLimitsPage limits = new ClaimLimitsPage(driver);
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	
	details.ClickMemberButton();
	details.SetPass("123", "123");
	
	driver.quit();

}
}
