package adminportalTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.junit.Test;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.AddClient;
import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class UploadCredits extends BrowserSettings {
	
	@Test
	public void UploadEmployees() throws InterruptedException, AWTException {

		extent = new ExtentReports("src/QA report.html", false);
		ExtentTest test = extent.startTest("TC7 - Upload credits");

		LoginPageAdm login = new LoginPageAdm(driver);
		Clients client = new Clients(driver);
		ClientDetails details = new ClientDetails(driver);
		AddClient waitmethod = new AddClient(driver);
		TakeScreenshot screen = new TakeScreenshot(driver);

		try {
			login.PreConditions();
			client.GotoClient();
			details.OpenAccounts();
			details.GotoAccounts();
			details.AccountFundingClick();
			details.ChooseCreditsClick();

			StringSelection ss = new StringSelection("C:\\bulks\\MemberCredits.en-GB.xls");
			waitmethod.Waitsec();
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

			Robot robot = new Robot();

			waitmethod.Waitsec();
			robot.keyPress(KeyEvent.VK_CONTROL);
			waitmethod.Waitsec();
			robot.keyPress(KeyEvent.VK_V);
			waitmethod.Waitsec();
			robot.keyRelease(KeyEvent.VK_V);
			waitmethod.Waitsec();
			robot.keyRelease(KeyEvent.VK_CONTROL);
			waitmethod.Waitsec();
			robot.keyPress(KeyEvent.VK_ENTER);
			waitmethod.Waitsec();
			robot.keyRelease(KeyEvent.VK_ENTER);

			details.CreditSubmitClick();
			details.SeccessfulCredClick();
			details.CreditsCancelClick();
			details.GotoAccounts();
			details.TransactionClick();

			if (driver.getPageSource().contains("1250")) {
				test.log(LogStatus.PASS, "Credit added was added");
				screen.ScreenShot("TC7");
				extent.endTest(test);

			} else {

				test.log(LogStatus.FAIL, "Credit not added");
				screen.ScreenShot("TC7");
				extent.endTest(test);

			}

		} catch (NoSuchElementException e) {
			test.log(LogStatus.ERROR, "Test not executed");
			extent.endTest(test);
		} catch (ElementNotVisibleException e) {
			test.log(LogStatus.ERROR, "Test not executed");
			extent.endTest(test);
		} catch (NullPointerException e) {
			test.log(LogStatus.ERROR, "Test not executed");
			extent.endTest(test);
		}

	}
}
