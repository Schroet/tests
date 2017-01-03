package pageObjectsTests;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.AddClient;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class AddAccount {
	
	@Test
	public void DeleteCl() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
	
    ExtentReports logger = ExtentReports.get(AddAccount.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC5");
   	
   	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	
	
	login.PreConditions("sys", "sys");
	client.GotoClient();
	details.OpenAccounts();
	details.ClickAddNewAccountButton();
	details.AddnewAccount("FSA" + RandomStringUtils.randomNumeric(3), RandomStringUtils.randomNumeric(3), "2017", "01/01/2017", "01/01/2018");
	
	
	if(driver.getPageSource().contains("Action")){
		logger.log(LogStatus.PASS, "Account was added");
		logger.endTest();
		driver.quit();
    	
    	}else{
    		
    		logger.log(LogStatus.FAIL, "Account not added");
    		logger.endTest();
    		driver.quit();
    	}
	
	
	}
}
