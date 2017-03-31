package adminportalTests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
	
	WebDriver driver;
	
	@Test
	
	public void test1 () {
		
		 
		 System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		 driver = new ChromeDriver();	
		 
		 driver.get("http://www.bigmir.net");
	
	}

}
