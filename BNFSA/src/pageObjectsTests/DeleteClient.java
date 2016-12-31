package pageObjectsTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.Clients;
import pages.LoginPageAdm;

public class DeleteClient {
	
	
	@Test
	public void DeleteCl() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
    ExtentReports logger = ExtentReports.get(DeleteClient.class);
	logger.init ("bin/QA report.html", false); 
	logger.startTest("TC2");
	
	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	
	login.GetLoginPage();
	driver.manage().window().maximize();
	
	login.LoginAdminPortal("sys", "sys");
	
	
	if(driver.getPageSource().contains("AAA")){
		client.ClickDeleteСlient();
    	
    	}else{
    		
    		logger.log(LogStatus.PASS, "Client AAA not exist");
    		logger.endTest();
    		driver.quit();
    	}
	
	client.ClickDeleteСlientOk();
	
	if(driver.getPageSource().contains("AAA")){
		client.ClickDeleteСlient();
		
    	
    	}else{
    		logger.log(LogStatus.PASS, "Client AAA not exist");
    		logger.endTest();
    		driver.quit();
    	}
	
	driver.quit();
	
	}
	
}
