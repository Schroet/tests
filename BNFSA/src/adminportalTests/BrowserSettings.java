package adminportalTests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BrowserSettings {

	public WebDriver driver = null;
	public ExtentReports extent;
	public ExtentTest test;

	String browser = "chrome";
	//String browser="mozilla";
	//String browser="PhantomJs";

	@Before
	public void LaunchBrowser() {

		if (browser.equalsIgnoreCase("mozilla"))

			// System.setProperty("webdriver.chrome.driver", "C:/Java
			// libraries/Gecko/geckodriver.exe");
			driver = new FirefoxDriver();

		else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "src/resourses/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		else if (browser.equalsIgnoreCase("PhantomJs")) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability("takesScreenshot", true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"C://Users//Shroet//BNFSA//BNFSA//src//resourses//phantomjs.exe");
			driver = new PhantomJSDriver(caps);

			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}

	}

	@After

	public void CloseBrowser() {

		extent.flush();
		driver.quit();

	}

}
