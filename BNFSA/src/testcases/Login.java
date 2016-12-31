package testcases;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login{

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C://Java libraries//ChromeDriver//chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void logintosystem() throws Exception {
    	
    	driver.manage().window().maximize();
        driver.get("https://admin-qa.wtwbenefitsmarketplacefsa.com/Auth/SignIn");
        Thread.sleep(2000);
        
        driver.findElement(By.id("signin_username")).sendKeys("sys");
        driver.findElement(By.id("signin_password")).sendKeys("sys");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@value='Sign In']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void TC2() throws Exception {
    
    	   driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[2]/ul/li[2]/a")).click();
    	    
    	    Thread.sleep(1000);
    	    
    	    
    	    if(driver.getPageSource().contains("Sign in")){
    	    	System.out.println("Test Passed");
    	    	
    	      	}else{
    	      		
    	      		System.out.println("Test Fail");
    	      	} 
   
    }
    
    @AfterClass
    
    public static void cleanUp(){
    	
    	driver.quit();
    }

}