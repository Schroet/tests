package adminportalTests;

import java.awt.AWTException;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.AddClient;
import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class AddClaimType extends BrowserSettings {
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException {

		extent = new ExtentReports("src/QA report.html", false);
		ExtentTest test = extent.startTest("TC8");

		LoginPageAdm login = new LoginPageAdm(driver);
		Clients client = new Clients(driver);
		ClientDetails details = new ClientDetails(driver);
		AddClient waitmethod = new AddClient(driver);
		TakeScreenshot screen = new TakeScreenshot(driver);

		try {

			login.PreConditions();
			client.GotoClient();

			details.ClickClaimTypesTab();
			details.ClickAddClaimType();
			details.AddClaimType("Sport", "2017-01-01", "2017-12-31");

			waitmethod.Waitsec();

			if (driver.getPageSource().contains("Delete")) {
				test.log(LogStatus.PASS, "Claim type was added");
				screen.ScreenShot("TC8");
				extent.endTest(test);
			} else {

				test.log(LogStatus.FAIL, "Claim type not added");
				screen.ScreenShot("TC8");
				extent.endTest(test);
			}

		} catch (NoSuchElementException e) {
			test.log(LogStatus.ERROR, "Test not executed");
			extent.endTest(test);
		}
		;

	}
}
