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

public class AddClaimType {
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
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[6]/div/div[2]/a")).click(); //Add
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[1]/div/input")).sendKeys("Sport"); //Name
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[2]/div/span[1]/span/input")).sendKeys("2016-01-01"); //Start
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[3]/div/span[1]/span/input")).sendKeys("2016-12-31"); //End
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[4]/div/div/div")).click(); // Claimants
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/ul/li[17]")).click(); // Me
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[5]/div/span/span/span[2]/span")).click(); // Receipt
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/ul/li[2]")).click(); // Optional
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[6]/div/div[1]/div/div")).click(); //Currency
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/ul/li[133]")).click(); //UAH
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[6]/div/div[1]/div/div")).click(); //Currency
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/ul/li[135]")).click(); //USD
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[10]/div/button")).click();
    Thread.sleep(1000);
    
    
    if(driver.getPageSource().contains("Sport")){
    	System.out.println("Claim type was uploaded successfuly");
    	}else{
    	System.out.println("Claim type not uploaded");
    	}
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}
