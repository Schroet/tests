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

public class EmployeeBulk {
  private WebDriver driver;

  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws InterruptedException {
      System.setProperty("webdriver.chrome.driver", "C://Java libraries//ChromeDriver//chromedriver.exe");
      driver = new ChromeDriver();
      
  	driver.manage().window().maximize();
    driver.get("https://admin-qa.wtwbenefitsmarketplacefsa.com/Auth/SignIn");
    Thread.sleep(3000);
    driver.findElement(By.id("signin_username")).sendKeys("sys");
    driver.findElement(By.id("signin_password")).sendKeys("sys");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@value='Sign In']")).click();
    Thread.sleep(2000);
  }

  @Test
  public void testUntitled() throws Exception {
	  
	driver.findElement(By.partialLinkText("Tesla")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("//div[@id='tab-details']/div/div[2]/div[4]/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='tab-details']/div/div[2]/div[4]/ul/li/a")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[3]/div[2]/form/div[1]/div/div[1]/div")).click();
    Thread.sleep(2000);
    
    StringSelection ss = new StringSelection("C:\\Avel\\Bulks\\Client Tesla\\Employees.en-GB.xls");  
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
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/ul/li[3]/a")).click();
    Thread.sleep(1000);
    
    
    if(driver.getPageSource().contains("new new")){
    	System.out.println("Employee was uploaded successfuly");
    	}else{
    	System.out.println("Employee not uploaded");
    	}
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}
