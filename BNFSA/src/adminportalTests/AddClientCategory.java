package adminportalTests;

import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;

public class AddClientCategory extends BrowserSettings {
	

	@Test
	public void AddCategory() throws Exception {

		extent = new ExtentReports("src/QA report.html", false);
		ExtentTest test = extent.startTest("TC4 - Add category");

		LoginPageAdm login = new LoginPageAdm(driver);
		Clients client = new Clients(driver);
		ClientDetails details = new ClientDetails(driver);
		TakeScreenshot screen = new TakeScreenshot(driver);

		try {

			login.PreConditions();
			client.GotoClient();
			details.AddnewCategory("cat");

			if (driver.getPageSource().contains("Category with same Name already exists.")) {
				test.log(LogStatus.PASS, "Category was added");
				screen.ScreenShot("TC4");
				extent.endTest(test);
			} else {
				details.ClickOkCategoryButton();
				test.log(LogStatus.PASS, "Category was added");
				screen.ScreenShot("TC4");
				extent.endTest(test);
			}

		

		} catch (NoSuchElementException e) {
			test.log(LogStatus.ERROR, "Test not executed");
			extent.endTest(test);
		}
		;

	}
}
