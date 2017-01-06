package memberportalTests;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import pageObjectsTests.BrowserSettings;
import pages.AddClient;
import pagesMember.AddClaimPage;
import pagesMember.LoginPageMember;
import pagesMember.Summary;

public class AddClaimUAH extends BrowserSettings {
	
	@Test
	public void UploadEmployees(){
	
	LaunchBrowser();
	
	ExtentReports logger = ExtentReports.get(AddClaimUAH.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC-Member-2");
   	
   	
   	LoginPageMember loginmember = new LoginPageMember(driver);
   	Summary sumpage = new Summary(driver);
   	AddClaimPage addclaimpage = new AddClaimPage(driver);
   	AddClient waitmethod = new AddClient(driver);
   	WebDriverWait wait = new WebDriverWait(driver, 10);
   	
   	
   	loginmember.PreConditionsMember("fsa@yopmail.com", "123");
   	
   	wait.until(ExpectedConditions.elementToBeClickable(By.id("addClaimButton")));
   	sumpage.ClickBtnAddnewClaim();
   	
   	addclaimpage.AddNewClaimUAH();
   	waitmethod.Waitsec();
   	
   	
    if(driver.getPageSource().contains("Summary")){
  		logger.log(LogStatus.PASS, "Claim added");
  		logger.endTest();
  		driver.quit();
      	
      	}else{
      		
      		logger.log(LogStatus.FAIL, "Claim not added");
      		logger.endTest();
      		driver.quit();
      	}
	}
}
