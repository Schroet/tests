package memberportalTests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pageObjectsTests.BrowserSettings;
import pages.AddClient;
import pagesMember.AddClaimPage;
import pagesMember.LoginPageMember;
import pagesMember.Summary;

public class AddClaimUAH extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void UploadEmployees(){
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TCM-2");
   	
   	LoginPageMember loginmember = new LoginPageMember(driver);
   	Summary sumpage = new Summary(driver);
   	AddClaimPage addclaimpage = new AddClaimPage(driver);
   	AddClient waitmethod = new AddClient(driver);
   	
	try {
   	loginmember.PreConditionsMember("fsa@yopmail.com", "123");
   	//wait.until(ExpectedConditions.elementToBeClickable(By.id("addClaimButton")));
   	
    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement element = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.id("addClaimButton")));
    
   	sumpage.ClickBtnAddnewClaim();
   	addclaimpage.AddNewClaimUAH();
   	waitmethod.Waitsec();
   	
    if(driver.getPageSource().contains("Summary")){
  		test.log(LogStatus.PASS, "Claim added");
  		extent.endTest(test);
  		
      	}else{
      		
      		test.log(LogStatus.FAIL, "Claim not added");
      		extent.endTest(test);
      	}
    
	}catch (NoSuchElementException e) { test.log(LogStatus.ERROR, "Test not executed");	
    }; 
    extent.flush();
	driver.quit();
	}
}
