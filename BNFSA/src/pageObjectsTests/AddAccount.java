package pageObjectsTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import extentreport.ExtentReport;
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
	details.AddnewAccount("FSA 1", "555", "2016", "2016", "2017");
	
	
	if(driver.getPageSource().contains("FSA 1")){
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
