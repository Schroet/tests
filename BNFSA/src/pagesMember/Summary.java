package pagesMember;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pagesAdmin.AddClient;

public class Summary {
	
	WebDriver driver;
	
	By profile = By.xpath(".//*[@id='page']/client-settings/header/div/div/div/div[2]/nav/div/ul/li[1]/a");
	By summary = By.xpath(".//*[@id='page']/client-settings/header/div/div/div/div[2]/nav/div/ul/li[2]/a");
	By help = By.xpath(".//*[@id='page']/client-settings/header/div/div/div/div[2]/nav/div/ul/li[3]/a");
	By english = By.xpath(".//*[@id='page']/client-settings/header/div/div/div/div[2]/nav/div/ul/li[4]/button");	
	By signout = By.xpath(".//*[@id='page']/client-settings/header/div/div/div/div[2]/nav/div/ul/li[5]/a");
	By clickadd = By.xpath(".//*[@id='addClaimButton']");
	By accountdetails = By.xpath(".//*[@id='main']/div[2]/div/div[3]/div[2]/div/div/div/div[2]/div[2]/a");
	By claimhistory = By.xpath(".//*[@id='main']/div[2]/div/div[3]/div[2]/div/div/div/div[2]/div[5]/a']");
	By print = By.xpath(".//*[@id='main']/div[3]/div/button");
	String btnprint = ".//*[@id='main']/div[3]/div/button"; 
	
    public Summary(WebDriver driver){
		this.driver = driver;
	}
	
    AddClient waitmethod = new AddClient(driver);

    //waitmethod.Waitsec();

public void ClickBtnAddnewClaim(){
	
	waitmethod.Waitsec();
	driver.findElement(clickadd).click();
	
}

public void WaitForBtnPrint(){

	waitmethod.Waitsec();
	driver.findElement(print).click();
}

public void ClickBtnPrint(){
	
	waitmethod.Waitsec();
	driver.findElement(print).click();
	
}


}
