package adminportalTests;

import org.openqa.selenium.WebDriver;

public class FakeLogin {
	
    WebDriver driver;
	

	public FakeLogin(WebDriver driver){
		
		this.driver = driver;
	}

	public void GetFakeLoginpage(){
		
		driver.get("https://admin.wtwbenefitsmarketplacefsa.com/Auth/SignIn");
	}

}
