package testcases;


import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class SetPassword {
  private WebDriver driver;

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
