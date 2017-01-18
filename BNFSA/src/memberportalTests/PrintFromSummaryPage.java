package memberportalTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import pageObjectsTests.BrowserSettings;
import pages.AddClient;
import pagesMember.LoginPageMember;
import pagesMember.Summary;

public class PrintFromSummaryPage extends BrowserSettings {
	
	private static ExtentReports extent;
	
	@Test
	public void UploadEmployees() throws IOException, AWTException{
	
	LaunchBrowser();
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TCM-3");
   	
   	LoginPageMember loginmember = new LoginPageMember(driver);
   	Summary sumpage = new Summary(driver);
   	AddClient waitmethod = new AddClient(driver);
   	
   	loginmember.PreConditionsMember("123");
   	sumpage.ClickBtnPrint();
    sumpage.WaitForBtnPrint();
    
    StringSelection ss = new StringSelection("C:\\GIT\\BNFSA\\bin\\screenshots\\PrintSummary");  
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
    waitmethod.Waitsec();
   	

	}
}
