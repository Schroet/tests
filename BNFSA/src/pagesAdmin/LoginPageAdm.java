package pagesAdmin;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LoginPageAdm {
	
	WebDriver driver;

	By username = By.id("signin_username");
	By password = By.id("signin_password");
	By loginButton = By.xpath("//input[@value='Sign In']");
	By forgotpass = By.xpath("/html/body/div/div[2]/div/div[1]/div/form/div[4]/input");
	By contactus = By.xpath("/html/body/div/div[2]/div/div[2]/div/a/b");
	
	AddClient waitmethod = new AddClient(driver);
	
	public LoginPageAdm(WebDriver driver){
		
		this.driver = driver;
	}
	
public void PreConditions(String userid, String pass){
	
	driver.manage().window().maximize();
	GetLoginPage();
	LoginAdminPortal(userid,pass);
	waitmethod.Waitsec();
	}	

public void LoginAdminPortal(String userid, String pass){
		
		driver.findElement(username).sendKeys(userid);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
	
	
	public void TypeUsername(){
		
		driver.findElement(username).sendKeys("sys");
	}
		
public void TypePassword(){
	
	    driver.findElement(password).sendKeys("sys");
	}
	
public void ClickLoginButton(){
	
    driver.findElement(loginButton).click();
}

public void ClickForgotPassButton(){
	
    driver.findElement(forgotpass).click();	
}

public void ClickContactusButton(){
	
    driver.findElement(contactus).click();	
}

public String email_name = RandomStringUtils.randomAlphabetic(5) + "@" + "yopmail.com";


public void TypeUsernameEmail(){
	
	driver.findElement(username).sendKeys(email_name);
}

public void TypePasswordEmail(){
	
    driver.findElement(password).sendKeys(email_name);
}




public void GetLoginPage(){
	
	driver.get("https://admin-qa.wtwbenefitsmarketplacefsa.com/Auth/SignIn");
}

}

