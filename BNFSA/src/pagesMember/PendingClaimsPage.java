package pagesMember;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class PendingClaimsPage {
	
	WebDriver driver;
	
	   public PendingClaimsPage(WebDriver driver){
			
			this.driver = driver;
		}
	   
	   By claimtype = By.xpath(".//*[@id='claimType']");
	
	
	

}
