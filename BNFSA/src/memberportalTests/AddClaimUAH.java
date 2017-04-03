package memberportalTests;

import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import adminportalTests.BrowserSettings;
import adminportalTests.GmailLetter;
import adminportalTests.TakeScreenshot;
import pagesAdmin.AddClient;
import pagesMember.AccountDetails;
import pagesMember.AddClaimPage;
import pagesMember.LoginPageMember;
import pagesMember.Summary;

public class AddClaimUAH extends BrowserSettings {
	
	@Test
	public void AddClaim() throws Exception {

		extent = new ExtentReports("src/QA report.html", false);
		ExtentTest test = extent.startTest("TCM-2");

		LoginPageMember loginmember = new LoginPageMember(driver);
		Summary sumpage = new Summary(driver);
		AddClaimPage addclaimpage = new AddClaimPage(driver);
		AddClient waitmethod = new AddClient(driver);
		TakeScreenshot screen = new TakeScreenshot(driver);

		try {
			loginmember.PreConditionsMember("123");

			sumpage.WaitPrintSum();
			sumpage.ViewAccoountDetails();
			sumpage.WaitAddclaimbtn();
			sumpage.AccDetAddNewClaim();
			waitmethod.Waitsec();
			addclaimpage.AddNewClaimUAH();
			waitmethod.Waitsec();
			
			

			if (driver.getPageSource().contains("Summary")) {
				screen.ScreenShot("TCM-2");
				test.log(LogStatus.PASS, "Claim added");
				extent.endTest(test);

			} else {

				screen.ScreenShot("TCM-2");
				test.log(LogStatus.FAIL, "Claim not added");
				extent.endTest(test);
			}

		} catch (NoSuchElementException e) {
			test.log(LogStatus.ERROR, "Test not executed");
			extent.endTest(test);
		};
	}
	
	@Test
	public void ClaimEdit() throws Exception {
		
		extent = new ExtentReports("src/QA report.html", false);
		ExtentTest test = extent.startTest("TCM-3");
		
		LoginPageMember loginmember = new LoginPageMember(driver);
		Summary sumpage = new Summary(driver);
		AddClaimPage addclaimpage = new AddClaimPage(driver);
		AddClient waitmethod = new AddClient(driver);
		TakeScreenshot screen = new TakeScreenshot(driver);
		GmailLetter send = new GmailLetter();
		AccountDetails accdet = new AccountDetails(driver);
		
		try {
			
			loginmember.PreConditionsMember("123");
			
			sumpage.WaitPrintSum();
			sumpage.ViewAccoountDetails();
			accdet.ClicktoEditbtn();
			addclaimpage.EditClaimUAH();
			
			
			if (driver.getPageSource().contains("Pending Claims")) {
				screen.ScreenShot("TCM-3");
				test.log(LogStatus.PASS, "Claim was edited");
				extent.endTest(test);
			} else {
				screen.ScreenShot("TCM-3");
				test.log(LogStatus.FAIL, "Claim not edited");
				extent.endTest(test);
			}
			
	} catch (NoSuchElementException e) {
		test.log(LogStatus.ERROR, "Test not executed");
		extent.endTest(test);
	};
	
	send.execute("QA report.html");
		
	}
}
