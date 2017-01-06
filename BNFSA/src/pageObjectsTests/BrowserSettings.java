package pageObjectsTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserSettings {
	

	public WebDriver driver= null;
	
    String browser="chrome";
   

    public void LaunchBrowser() {

        if (browser.equalsIgnoreCase("mozilla"))
        	
            driver = new FirefoxDriver();
        
        else if (browser.equalsIgnoreCase("chrome"))
        	
            System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        
        driver = new ChromeDriver();
    
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
    }

}
