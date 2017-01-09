package pagesMember;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.AddClient;

public class LoginPageMember {
	
WebDriver driver;
	
	By login = By.xpath(".//*[@id='page']/div/div/div/div/div/section/form/fieldset/div[1]/div/input");
	By passw = By.xpath(".//*[@id='page']/div/div/div/div/div/section/form/fieldset/div[3]/div/input");
	By signinbtn = By.xpath(".//*[@id='page']/div/div/div/div/div/section/form/div[1]/button");
	By clicktickbox = By.xpath(".//*[@id='agree']"); //add
	By clickagree = By.xpath(".//*[@id='btAccept']");
	By clickproceed = By.xpath(".//*[@id='into']/div/div[5]/button");

public LoginPageMember(WebDriver driver){
		
		this.driver = driver;
	}
	

AddClient waitmethod = new AddClient(driver);


public void FirstLoginMemberPortal(String userid, String pass){
	
	driver.manage().window().maximize();
    GetLoginPageMember();
	driver.findElement(login).sendKeys(userid);
	driver.findElement(passw).sendKeys(pass);
	waitmethod.Waitsec();
	driver.findElement(signinbtn).click();
	waitmethod.Waitsec();
	driver.findElement(clicktickbox).click();
	waitmethod.Waitsec();
	driver.findElement(clickagree).click();
	waitmethod.Waitsec();
	driver.findElement(clickproceed).click();
	waitmethod.Waitsec();
	
}

public void LoginMemberPortal(String userid, String pass){
	
	    GetLoginPageMember();
	    driver.manage().window().maximize();
		driver.findElement(login).sendKeys(userid);
		driver.findElement(passw).sendKeys(pass);
		driver.findElement(signinbtn).click();
	}


public void PreConditionsMember(String userid, String pass){
	
	LoginMemberPortal(userid,pass);
	
};

public void GetLoginPageMember(){
	
	driver.get("https://portal-qa.wtwbenefitsmarketplacefsa.com");
}

}
