package pagesMember;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pagesAdmin.AddClient;

   public class AddClaimPage {
	
	WebDriver driver;
	
   public AddClaimPage(WebDriver driver){
		
		this.driver = driver;
	}
   
   By claimtypefield = By.xpath(".//*[@id='claimType']");
   By claimtypevalue= By.xpath(".//*[@id='claimType']/option[2]");
   By receiptdatefield= By.xpath(".//*[@id='datepicker']");
   By receiptdatevalue= By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[5]/a");
   By receiptnumber= By.xpath(".//*[@id='receiptNumber']");
   By currencyfield= By.xpath(".//*[@id='currency']");
   By currencyvalueusd= By.xpath(".//*[@id='currency']/option[3]");
   By receiptamount= By.xpath(".//*[@id='amount']");
   By claimsubmit= By.xpath(".//*[@id='addClaim']/form/loading-spinner/div/ng-transclude/div/div/div[20]/div/div/button[1]");


   AddClient waitmethod = new AddClient(driver);
   LoginPageMember loginmem = new LoginPageMember(driver);
   Summary sum = new Summary(driver);
   //WebDriverWait wait = new WebDriverWait(driver, 10);
	
	
   public void AddNewClaimUAH(){
		
		
		driver.findElement(claimtypefield).click();
		waitmethod.Waitsec();
		driver.findElement(claimtypevalue).click();
		waitmethod.Waitsec();
		driver.findElement(receiptdatefield).sendKeys("03/04/2017");
		waitmethod.Waitsec();
		//driver.findElement(receiptdatevalue).click();
		//waitmethod.Waitsec();
		driver.findElement(receiptnumber).sendKeys(RandomStringUtils.randomNumeric(6));
		waitmethod.Waitsec();
		driver.findElement(receiptamount).sendKeys(RandomStringUtils.randomNumeric(2));
		waitmethod.Waitsec();
		driver.findElement(claimsubmit).click();
		waitmethod.Waitsec();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='addClaimButton']")));
	};
}
