package pageObjectsTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.AddClient;
import pages.Clients;
import pages.LoginPageAdm;


public class AddNewClient {
	
	@Test
	public void Login2AdminPortal() throws InterruptedException{	
		
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
	WebDriver driver = new ChromeDriver();	
	    
	ExtentReports logger = ExtentReports.get(AddNewClient.class);
	logger.init ("bin/QA report.html", false); 
	logger.startTest("TC3");
	
	LoginPageAdm login = new LoginPageAdm(driver);
	
		
    login.GetLoginPage();
    driver.manage().window().maximize();
     
    Clients clients = new Clients(driver);
    AddClient addclient = new AddClient(driver);
    
    login.LoginAdminPortal("sys", "sys");
    
    clients.ClickAddСlientButton();
    
    addclient.TypeClient();
    
    addclient.TypeCountry();
  
    addclient.TypeStatus();
    
    addclient.TypeMultiLingual();
    
    addclient.TypeLanguage();
    
    addclient.TypeCurrency();
    
    logger.log(LogStatus.INFO, "Currency was added");
    
    addclient.ClickAddButton();
    
    
    if(driver.getPageSource().contains("AAA")){
    	logger.log(LogStatus.PASS, "Client was added");
    	logger.endTest();
    	}else{
    		
    		logger.log(LogStatus.FAIL, "Client not added");
    		logger.endTest();
    	}
    

    driver.quit();


	}
}
