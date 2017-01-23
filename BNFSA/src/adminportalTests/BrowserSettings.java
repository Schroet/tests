package adminportalTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserSettings {
	

	public WebDriver driver= null;
	
    String browser="chrome";
    //String browser="mozilla";
   

    public void LaunchBrowser() {

        if (browser.equalsIgnoreCase("mozilla")) 

        	//System.setProperty("webdriver.chrome.driver", "C:/Java libraries/Gecko/geckodriver.exe");
            driver = new FirefoxDriver(); 
 
        else if (browser.equalsIgnoreCase("chrome")) 
        	
        System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
    }

}
