package adminportalTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowserSettings {
	

	public WebDriver driver= null;
	
    String browser="chrome";
    //String browser="mozilla";
   

    public void LaunchBrowser() {

        if (browser.equalsIgnoreCase("mozilla")) 

        	//System.setProperty("webdriver.chrome.driver", "C:/Java libraries/Gecko/geckodriver.exe");
            driver = new FirefoxDriver(); 
 
        else if (browser.equalsIgnoreCase("chrome")) {
        	
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); }
        
      else if (browser.equalsIgnoreCase("PhantomJs"))  {
        	
        	DesiredCapabilities caps = new DesiredCapabilities();
    		caps.setJavascriptEnabled(true);                
    		caps.setCapability("takesScreenshot", true);  
    		caps.setCapability(
    		PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
    		"D:\\Тестирование\\PhantomJs\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe"
    		                    );
    		driver = new  PhantomJSDriver(caps);
    		
    		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		
    		 } 

    }

}
