package testcases;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreditsBulk {
  private WebDriver driver;

  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "C://Java libraries//ChromeDriver//chromedriver.exe");
      driver = new ChromeDriver();
      
  	driver.manage().window().maximize();
    driver.get("https://admin-qa.wtwbenefitsmarketplacefsa.com/Auth/SignIn");
    Thread.sleep(1000);
    driver.findElement(By.id("signin_username")).sendKeys("sys");
    driver.findElement(By.id("signin_password")).sendKeys("sys");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//input[@value='Sign In']")).click();
    Thread.sleep(1000);
  }

  @Test
  public void testUntitled() throws Exception {
	  
		driver.findElement(By.partialLinkText("Tesla")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[4]/a")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.partialLinkText("FSA 1")).click();
	    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/a[3]")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[3]/div[2]/form/div[1]/div/div[1]/div")).click();
    
    Thread.sleep(2000);
    
    StringSelection ss = new StringSelection("C:\\Avel\\Bulks\\Client Tesla\\MemberCredits.en-GB.xls");  
    Thread.sleep(1000);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
   
    Robot robot = new Robot();
 
    robot.keyPress(KeyEvent.VK_CONTROL);
    Thread.sleep(1000);
    robot.keyPress(KeyEvent.VK_V);
    Thread.sleep(1000);
    robot.keyRelease(KeyEvent.VK_V);
    robot.keyRelease(KeyEvent.VK_CONTROL);
    Thread.sleep(1000);
    robot.keyPress(KeyEvent.VK_ENTER);
    Thread.sleep(1000);
    robot.keyRelease(KeyEvent.VK_ENTER);
    
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[3]/div[2]/form/div[3]/div/button")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("/html/body/div[4]/div[7]/div/button")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/ol/li[2]/a")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[2]/a")).click();
    Thread.sleep(1000);
    
    if(driver.getPageSource().contains("2500")){
    	System.out.println("Credits was uploaded successfuly");
    	}else{
    	System.out.println("Credits not uploaded");
    	}
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}
