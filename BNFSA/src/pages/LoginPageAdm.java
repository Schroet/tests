package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageAdm {
	
	WebDriver driver;
	
	By username = By.id("signin_username");
	By password = By.id("signin_password");
	By loginButton = By.xpath("//input[@value='Sign In']");
	By forgotpass = By.xpath("/html/body/div/div[2]/div/div[1]/div/form/div[4]/input");
	By contactus = By.xpath("/html/body/div/div[2]/div/div[2]/div/a/b");
	
	public LoginPageAdm(WebDriver driver){
		
		this.driver = driver;
	}
	
public void PreConditions(String userid, String pass){
	
	GetLoginPage();
	driver.manage().window().maximize();
	LoginAdminPortal(userid,pass);
	
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

public void GetLoginPage(){
	
	driver.get("https://admin-qa.wtwbenefitsmarketplacefsa.com");
}

}

