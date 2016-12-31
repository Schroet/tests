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

public class AddCategory {
	
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws InterruptedException{
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
	Thread.sleep(2000);
    driver.findElement(By.xpath("//div[@id='page-wrapper']/div[3]/div[2]/div/ul/li[3]/a")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='tab-categories']/div/a")).click();
    Thread.sleep(1000);
    driver.findElement(By.id("categoryName")).sendKeys("QA");
    driver.findElement(By.xpath("//div[@id='page-wrapper']/div[3]/div[2]/div/div/div[2]/div/div[2]/div/span/span/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/ul/li[1]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/div[3]/div/button")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[6]/div[7]/div/button")).click();
    Thread.sleep(1000);
    
    
    
    if(driver.getPageSource().contains("QA")){
    	System.out.println("Category was added");
    	}else{
    	System.out.println("Category Add was fail");
    	}
    
    
    
   
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
  
  }

}
