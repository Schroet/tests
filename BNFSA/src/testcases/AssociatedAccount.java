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

public class AssociatedAccount {
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
    Thread.sleep(2000);
    
  }

  @Test
  public void testUntitled() throws Exception {
	  
	driver.findElement(By.partialLinkText("Tesla")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[5]/a")).click(); //Claims
    Thread.sleep(1000);
    driver.findElement(By.partialLinkText("Sport")).click(); //Sport
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[1]/ul/li[3]/a")).click(); // Associated
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[2]/div/div[2]/button")).click(); // Link Acc
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[15]/div/div/div[2]/div/div[1]/div/span/span/span/span")).click(); //Acc
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/ul/li")).click(); //Account
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[15]/div/div/div[2]/div/div[2]/div[1]/span[1]/span/span/span")).click(); //Priority
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[10]/div/div[2]/ul/li")).click(); //1
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[15]/div/div/div[3]/button[2]")).click();
    Thread.sleep(1000);
    
    
    if(driver.getPageSource().contains("FSA 1")){
    	System.out.println("Priority was uploaded successfuly");
    	}else{
    	System.out.println("Priority not uploaded");
    	}
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}

