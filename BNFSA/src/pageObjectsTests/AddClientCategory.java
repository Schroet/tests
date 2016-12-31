package pageObjectsTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;

public class AddClientCategory {
	
	@Test
	public void AddCategory() throws InterruptedException{
	
	System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    
    ExtentReports logger = ExtentReports.get(AddClientCategory.class);
	logger.init ("bin/QA report.html", false); 
	logger.startTest("TC4");
	
	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	
	login.GetLoginPage();
	driver.manage().window().maximize();
	
	login.LoginAdminPortal("sys", "sys");
	
	client.GotoClient();
	
	details.AddnewCategory("cat");
	
	if(driver.getPageSource().contains("Category with same Name already exists.")){
    	logger.log(LogStatus.PASS, "Category was added");
    	logger.endTest();
    	}else{
    		details.ClickOkCategoryButton();		
    	}
	
	if(driver.getPageSource().contains("cat")){
    	logger.log(LogStatus.PASS, "Category was added");
    	logger.endTest();
    	}else{
    		
    		logger.log(LogStatus.FAIL, "Category not added");
    		logger.endTest();		
    	}

	driver.quit();
	
	}
}
