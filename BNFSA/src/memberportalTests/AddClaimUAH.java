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
import pagesMember.AddClaimPage;
import pagesMember.LoginPageMember;
import pagesMember.Summary;

public class AddClaimUAH extends BrowserSettings {
	
	@Test
	public void UploadEmployees() throws Exception {

		extent = new ExtentReports("src/QA report.html", false);
		ExtentTest test = extent.startTest("TCM-2");

		LoginPageMember loginmember = new LoginPageMember(driver);
		Summary sumpage = new Summary(driver);
		AddClaimPage addclaimpage = new AddClaimPage(driver);
		AddClient waitmethod = new AddClient(driver);
		TakeScreenshot screen = new TakeScreenshot(driver);
		GmailLetter send = new GmailLetter();

		try {
			loginmember.PreConditionsMember("123");

			sumpage.WaitPrintSum();
			sumpage.ViewAccoountDetails();
			sumpage.WaitAddclaimbtn();
			sumpage.AccDetAddNewClaim();
			waitmethod.Waitsec();
			addclaimpage.AddNewClaimUAH();
			waitmethod.Waitsec();
			
			send.execute("QA report.html");

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
}
