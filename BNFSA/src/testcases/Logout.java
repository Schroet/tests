package testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

public class Logout {
	
	private static WebDriver driver;
 
  public void logout() throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver", "C://Java libraries//ChromeDriver//chromedriver.exe");
      driver = new ChromeDriver();
	  

    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[2]/ul/li[2]/a")).click();
    
    Thread.sleep(1000);
    
    
    if(driver.getPageSource().contains("Sign in")){
    	System.out.println("Test Passed");
    	
      	}else{
      		
      		System.out.println("Test Fail");
      	}  
    
    
  }

}
