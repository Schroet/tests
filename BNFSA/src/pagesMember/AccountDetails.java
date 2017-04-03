package pagesMember;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pagesAdmin.AddClient;

public class AccountDetails {

	WebDriver driver;

	public AccountDetails(WebDriver driver) {

		this.driver = driver;
	}

	By editclaimbtn = By.xpath(".//*[@id='page']/div/client-settings/loading-spinner/div/div/div/div/div[1]");
	By editclaimbtncss = By.cssSelector("tr.ng-scope:nth-child(1) > td:nth-child(12) > div:nth-child(1) > a:nth-child(2)");
	String waitprintaccdet = ".//*[@id='detail']/div[2]/button[1]";
	By removebtn = By.xpath(".//*[@id='detail']/loading-spinner/div/ng-transclude/table/tbody/tr/td[12]/div/a[1]");
	By printbtn = By.xpath(".//*[@id='detail']/div[2]/button[1]");
	
	AddClient waitmethod = new AddClient(driver);

    //waitmethod.Waitsec(); 

	public void ClicktoEditbtn() {
		
		waitmethod.Waitsec();
		waitmethod.Waitsec();
		driver.findElement(editclaimbtncss).click();
		waitmethod.Waitsec();
		
	}
	
	public void ClicktoRemove() {
		
		WaitPrintSum();
		driver.findElement(removebtn).click();
	}
	
	public void WaitPrintSum() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(printbtn));

	}

}
