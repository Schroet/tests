package pagesAdmin;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import adminportalTests.BrowserSettings;

public class ReceiveValue extends BrowserSettings {
	
	public WebDriver driver= null;
	
	
    @Test
    public  String Main(){
    	
	    driver = new ChromeDriver();	
	    System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
    

		LoginPageAdm login = new LoginPageAdm(driver);
		Clients client = new Clients(driver);
		AddClient addclient = new AddClient(driver);	
		ClientDetails details = new ClientDetails(driver);
		MemberPage mempage = new MemberPage(driver);
		AddClient waitmethod = new AddClient(driver);
		
		login.PreConditions();
		client.GotoClient();
		details.ClickMemberButton();
		mempage.WaitVisible();
		mempage.EditBtnClick();
		
		
		WebElement element = driver.findElement(By.id("Member_Email"));
		String elementval = element.getAttribute("value");
		
		System.out.println(elementval);
		driver.quit();
		
		return elementval;

	}

}
