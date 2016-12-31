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

public class AddAdmin {
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
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[7]/a")).click(); //Admins
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[7]/div/div[2]/a")).click(); //Add
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/form/div/div/div[1]/div[1]/div/div[1]/div[1]/div/div")).click(); //Role
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/ul/li[10]")).click(); //Ultimate
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/form/div/div/div[1]/div[2]/div/input")).sendKeys("Ad"); //Name
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/form/div/div/div[1]/div[3]/div/input")).sendKeys("An"); //First
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/form/div/div/div[1]/div[5]/div/input")).sendKeys("An"); //Last
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/form/div/div/div[1]/div[6]/div/input")).sendKeys("an@yopmail.com"); //Email
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/form/div/div/div[2]/div/input")).click(); // Add
    Thread.sleep(1000);

    if(driver.getPageSource().contains("An An")){
    	System.out.println("Admin type was uploaded successfuly");
    	}else{
    	System.out.println("Admin type not uploaded");
    	}
    
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    
  }

}
