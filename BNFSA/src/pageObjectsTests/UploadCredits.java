package pageObjectsTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.AddClient;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class UploadCredits {
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException{
	
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
	
    ExtentReports logger = ExtentReports.get(UploadCredits.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC7");
	
   	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	details.OpenAccounts();
	details.GotoAccounts();
	details.AccountFundingClick();
	details.ChooseCreditsClick();
	
    StringSelection ss = new StringSelection("C:\\GIT\\BNFSA\\bin\\MemberCredits.en-GB.xls");  
    waitmethod.Waitsec();
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   
    Robot robot = new Robot();
    
    waitmethod.Waitsec();
    robot.keyPress(KeyEvent.VK_CONTROL);
    waitmethod.Waitsec();
    robot.keyPress(KeyEvent.VK_V);
    waitmethod.Waitsec();
    robot.keyRelease(KeyEvent.VK_V);
    waitmethod.Waitsec();
    robot.keyRelease(KeyEvent.VK_CONTROL);
    waitmethod.Waitsec();
    robot.keyPress(KeyEvent.VK_ENTER);
    waitmethod.Waitsec();
    robot.keyRelease(KeyEvent.VK_ENTER);
    
    
    details.CreditSubmitClick();
	details.SeccessfulCredClick();
	details.CreditsCancelClick();
	details.GotoAccounts();
	details.TransactionClick();
	
	 if(driver.getPageSource().contains("2500")){
			logger.log(LogStatus.PASS, "Credit added was added");
			logger.endTest();
			driver.quit();
	    	
	    	}else{
	    		
	    		logger.log(LogStatus.FAIL, "Credit not added");
	    		logger.endTest();
	    		driver.quit();
	    	}

}
}
