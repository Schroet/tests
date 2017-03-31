package adminportalTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.AddClient;
import pagesAdmin.ClaimLimitsPage;
import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class AddClaimLimitUAH extends BrowserSettings {
	

	@Test
	public void UploadEmployees() throws InterruptedException, AWTException {

		extent = new ExtentReports("src/QA report.html", false);
		ExtentTest test = extent.startTest("TC10");

		LoginPageAdm login = new LoginPageAdm(driver);
		Clients client = new Clients(driver);
		ClientDetails details = new ClientDetails(driver);
		AddClient waitmethod = new AddClient(driver);
		ClaimLimitsPage limits = new ClaimLimitsPage(driver);
		TakeScreenshot screen = new TakeScreenshot(driver);

		try {
			login.PreConditions();
			client.GotoClient();
			details.ClickClaimTypesTab();
			details.GotoClaimType();
			limits.AddClaimLimitUAH("100", "2", "10", "20");

			if (driver.getPageSource().contains("Edit")) {
				test.log(LogStatus.PASS, "Limit was added");
				screen.ScreenShot("TC10");
				extent.endTest(test);

			} else {

				test.log(LogStatus.FAIL, "Limit type not added");
				screen.ScreenShot("TC10");
				extent.endTest(test);
			}
		} catch (NoSuchElementException e) {
			test.log(LogStatus.ERROR, "Test not executed");
			extent.endTest(test);
		}
		;

	}
}
