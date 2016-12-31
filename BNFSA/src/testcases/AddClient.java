package testcases;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddClient {
  private WebDriver driver;

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
	  
    driver.findElement(By.xpath("//div[3]/a")).click(); 
    
    Thread.sleep(3000);
    
    driver.findElement(By.id("clientName")).sendKeys("Tesla");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='addClientForm']/div/div[6]/div/span/span/span")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//ul[@id='CountryId_listbox']/li[2]")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//form[@id='addClientForm']/div/div[10]/div/span/span/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//ul[@id='MultiLingualSelected_listbox']/li[2]")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//div[@id='ddlLanguage']/div/span/span/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//ul[@id='LanguagesSelectedDdl_listbox']/li")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='addClientForm']/div/div[13]/div/span/span/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//form[@id='addClientForm']/div/div[14]/div/span/span/span")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("/html/body/div[8]/div/div[3]/ul/li[1]")).click();
    Thread.sleep(2000);

    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[15]/div/div")).click();
    Thread.sleep(2000);
    
  
    
    driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/ul/li[147]")).click();
    Thread.sleep(2000);
   
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[15]/div/div")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/ul/li[148]")).click();
    Thread.sleep(1000);
    
    driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[18]/div/button[2]")).click();
    
    Thread.sleep(3000);
    
    
    if(driver.getPageSource().contains("Tesla")){
    	System.out.println("Client Was Added");
    	}else{
    	System.out.println("Client Add was fail");
    	}
      
  }
 
  @After
  public void tearDown() throws Exception {
	  

    driver.quit(); 
 
  }

}