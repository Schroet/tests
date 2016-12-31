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

public class AddAccount {
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
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[4]/a")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[5]/div/a")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[1]/div/input")).sendKeys("FSA 1");
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[2]/div/input")).sendKeys("777");
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[3]/div/span/span/span/span")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[11]/div/div/table/tbody/tr[2]/td[4]/a")).click(); //YEAR
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[5]/div/span/span/input")).clear(); //START
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[5]/div/span/span/input")).sendKeys("01/01/2016"); //START
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[6]/div/span/span/input")).clear(); //START
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[6]/div/span/span/input")).sendKeys("31/12/2016"); //END
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[19]/div/button")).click();
    Thread.sleep(1000);
    
    
    if(driver.getPageSource().contains("FSA 1")){
    	System.out.println("Account was uploaded successfuly");
    	}else{
    	System.out.println("Account not uploaded");
    	}
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}
