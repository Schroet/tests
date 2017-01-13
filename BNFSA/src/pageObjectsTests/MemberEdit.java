package pageObjectsTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.AddClient;
import pages.ClientDetails;
import pages.Clients;
import pages.LoginPageAdm;
import pages.MemberPage;

public class MemberEdit extends BrowserSettings {
	
	private static ExtentReports extent;
	//private String elementval;

	@Test
	public void MemberEditInfo() throws InterruptedException{
		
		LaunchBrowser();
		
		 extent = new ExtentReports("bin/QA report.html", true);
		 ExtentTest test = extent.startTest("TC13");
		
		
		LoginPageAdm login = new LoginPageAdm(driver);
		Clients client = new Clients(driver);
		AddClient addclient = new AddClient(driver);	
		ClientDetails details = new ClientDetails(driver);
		MemberPage mempage = new MemberPage(driver);
		AddClient waitmethod = new AddClient(driver);
	
		try {
		
		//extent = new ExtentReports("bin/QA report.html", false);
		//ExtentTest test = extent.startTest("TC13");
		
		login.PreConditions("sys", "sys");
		client.GotoClient();
		details.ClickMemberButton();
		mempage.WaitVisible();
		mempage.EditBtnClick();
		mempage.AddEMail();
		
		mempage.SaveBtnClick();
		mempage.WaitVisibleEditBtn();
		mempage.EditBtn2Click();
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("Member_Email"));
		String elementval = element.getAttribute("value");
		
		System.out.println(elementval);
		
		Thread.sleep(2000);
		
		  if(driver.getPageSource().contains("Edit")){
		    	test.log(LogStatus.PASS, "Data was verify");
		    	extent.endTest(test);
		    	}else{
		    		test.log(LogStatus.FAIL, "Data was not verify");
		    		extent.endTest(test);
		    	} 

		} catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
		};
		
		
		
		   extent.flush();
		   driver.quit();
		  
	}
	
	
}
