package testcases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Report {

    private static WebDriver driver;
    
   
    
    @BeforeClass
    public static void setUp(){
    	
        System.setProperty("webdriver.chrome.driver", "C://Java libraries//ChromeDriver//chromedriver.exe");
        driver = new ChromeDriver();
        
        ExtentReports logger = ExtentReports.get(TestClass.class);
     	logger.init ("D:\\Програмирование\\report\\newreport.html", true); 
     	 logger.startTest("TC01.1","This test is a positive login test for ParaBank");
     	Login();
         logger.endTest();
    }

    @Test
    public static void Login() {
    	
    	
    
    	
    	driver.manage().window().maximize();
        driver.get("https://bigmir.net");
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
      
        
        driver.findElement(By.id("signin_username")).sendKeys("sys");
        driver.findElement(By.id("signin_password")).sendKeys("sys");
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
       
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();
        driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
        
    
         
    
    }

    
    @Test
    public void AddCat() throws Exception {
    	
    	 ExtentReports logger = ExtentReports.get(TestClass.class);
     	logger.init ("C:\\Java libraries\\report\\newreport.html", true);
     	
    	logger.startTest("TC2");
   
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
      
      
      if(driver.getPageSource().contains("Category with same Name already exists.")){
      	logger.log(LogStatus.PASS, "Cat was added");
        	}else{
        		logger.log(LogStatus.FAIL, "Cat was added");
        	}      
           
      driver.findElement(By.xpath("/html/body/div[6]/div[7]/div/button")).click();
      Thread.sleep(1000);
                               
      logger.endTest();
     
    }

    @Test
    public void Setpassword() throws Exception {
    	
    	ExtentReports logger = ExtentReports.get(TestClass.class);
    	logger.init ("D:\\Програмирование\\report\\newreport.html", true);
    	
    	logger.startTest("TC3");
  	  
  	driver.findElement(By.partialLinkText("Tesla")).click();
      Thread.sleep(1000);
      
      driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/ul/li[3]/a")).click(); //Member
      Thread.sleep(1000);
      driver.findElement(By.partialLinkText("new new")).click(); //Employee
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/div[1]/div/div[2]/button")).click(); // Reset password
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[1]/div/input")).sendKeys("123"); // Pass1
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]/div/div[2]/div[1]/input")).sendKeys("123"); //Pass2
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div[5]/div/div/div[3]/button[2]")).click(); //Save
      Thread.sleep(1000);
      driver.findElement(By.xpath("/html/body/div[6]/div/div/div[3]/button")).click(); //OK
      Thread.sleep(1000);
      
      logger.log(LogStatus.PASS, "Pass was set");
      
      logger.endTest(); 
      
    }
        
    @AfterClass
    public static void cleanUp(){
    	
    	driver.quit();
    }

}