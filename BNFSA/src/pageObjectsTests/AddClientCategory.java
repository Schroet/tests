package pageObjectsTests;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class AddClientCategory extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void AddCategory() throws Exception{
		
	LaunchBrowser();	
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TC4");
	 
	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	TakeScreenshot screen = new TakeScreenshot(driver);
	
	try {
	
	login.GetLoginPage();
	driver.manage().window().maximize();
	login.LoginAdminPortal("sys", "sys");
	client.GotoClient();
	details.AddnewCategory("cat");
	
	if(driver.getPageSource().contains("Category with same Name already exists.")){
		test.log(LogStatus.PASS, "Category was added");
		screen.ScreenShot("TC4");
		extent.endTest(test);
    	}else{
    		details.ClickOkCategoryButton();		
    	}
	
	if(driver.getPageSource().contains("cat")){
    	test.log(LogStatus.PASS, "Category was added");
    	screen.ScreenShot("TC4");
    	extent.endTest(test);
    	}else{
    		
    		test.log(LogStatus.FAIL, "Category not added");
    		extent.endTest(test);		
    	}
	
	} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
	};

	extent.flush();
	driver.quit();
	
	}
}
