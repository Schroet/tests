package pageObjectsTests;

import java.awt.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;
import pagesAdmin.AddClient;
import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;
import pagesAdmin.MemberPage;

public class GetEmailText extends BrowserSettings {
	
	
	static String elementval;
	
   @Test
   
	public void MemberEditInfo(){
    	
		
		LaunchBrowser();

		LoginPageAdm login = new LoginPageAdm(driver);
		Clients client = new Clients(driver);
		AddClient addclient = new AddClient(driver);	
		ClientDetails details = new ClientDetails(driver);
		MemberPage mempage = new MemberPage(driver);
		AddClient waitmethod = new AddClient(driver);
		
		login.PreConditions("sys", "sys");
		client.GotoClient();
		details.ClickMemberButton();
		mempage.WaitVisible();
		mempage.EditBtnClick();
		
		
		WebElement element = driver.findElement(By.id("Member_Email"));
		this.elementval = element.getAttribute("value");
		
		System.out.println(elementval);
		driver.quit();

	}
    
	
	
	
    //public static String mailtext = MemberEditInfo();

}
