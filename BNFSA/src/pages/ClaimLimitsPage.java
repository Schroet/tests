package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClaimLimitsPage {
	
	
WebDriver driver;
	
	public ClaimLimitsPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	//Navigation
	By gotoclaimlimits = By.xpath("//a[contains(text(),'Claim Limits and Co-Payments')]");
	//ClaimLimitPage
	By addclaimlimit = By.xpath(".//*[@id='tab-limits']/div/button");	
  
	By catfield = By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div/table[1]/tbody/tr[1]/td[2]/span[1]/span/span/span");
	By catvalue = By.xpath("/html/body/div[19]/div/div[2]/ul/li[1]");
	//From local 
	By catvaluelocal = By.xpath("/html/body/div[19]/div/div[2]/ul/li[1]");
	//Frequency
	By freqfield = By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div/table[1]/tbody/tr[2]/td[2]/span/span/span/span");
	By freqvalueclaimsperyear = By.xpath("/html/body/div[20]/div/div[2]/ul/li[1]");
	By freqvalueperclaim = By.xpath(".//*[@id='frequenciesCombo_listbox']/li[2]");
	By freqvalueperyear = By.xpath("/html/body/div[20]/div/div[2]/ul/li[3]");
	//Type
	By limitvaluefield = By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div/table[1]/tbody/tr[4]/td[2]/div/input");
	By numberoftimes = By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div/table[1]/tbody/tr[5]/td[2]/input");
	
	
	//Co-pay
	By allowcopayfield = By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div/table[1]/tbody/tr[6]/td[2]/span/span/span/span");
	By allowcopayvalueallow = By.xpath("/html/body/div[22]/div/div[2]/ul/li[2]");
	

	By copaytypefield = By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div/table[1]/tbody/tr[7]/td[2]/span/span/span/span");
	By copaytypevalueamount = By.xpath("/html/body/div[23]/div/div[2]/ul/li[1]"); 
	
	By copaytypevalueamountvalue = By.xpath(".//*[@id='inputCoPaymentAmount']");
	By copaytypevaluepercent = By.xpath(".//*[@id='coPaymentsTypesCombo_listbox']/li[2]");
	By copaytypevaluepercentvalue = By.xpath(".//*[@id='inputCoPaymentPercent']");
	By copaytypevaluebase = By.xpath(".//*[@id='inputCoPaymentAmountBase']");
	
    //Currency 
	By currencyfield = By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div/table[1]/tbody/tr[11]/td[2]/span/span/span/span");
	By currencyvalueuah = By.xpath("/html/body/div[24]/div/div[2]/ul/li[1]");
	By currencyvalueusd = By.xpath(".//*[@id='limitAmountCurrencyCombo_listbox']/li");
	//Button
	By clicksave = By.xpath("/html/body/div[13]/div/div/div[2]/div/div/div/div/button[2]");
	
	
	AddClient waitmethod = new AddClient(driver);
	
	
	 public void AddClaimLimitUAH(String limit, String number, String copay, String base) throws AWTException{
			
		    waitmethod.Waitsec();
		    driver.findElement(gotoclaimlimits).click();
		    waitmethod.Waitsec();
		    driver.findElement(addclaimlimit).click();
		    waitmethod.Waitsec();

		    driver.findElement(catfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(catvalue).click();
		    waitmethod.Waitsec();
		    
		    driver.findElement(allowcopayfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(allowcopayvalueallow).click();
		    waitmethod.Waitsec();
		    
		    /*
		    driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[13]/div/div")));
		    Robot robot = new Robot(); 
		    robot.keyRelease(KeyEvent.VK_DOWN);
		    waitmethod.Waitsec();
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    waitmethod.Waitsec();
		    driver.findElement(catvalue).click();
		    waitmethod.Waitsec(); */
		    
		    
		    
		    driver.findElement(freqfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(freqvalueperyear).click();
		    waitmethod.Waitsec();
		    driver.findElement(limitvaluefield).sendKeys(limit);
		    waitmethod.Waitsec();
		    driver.findElement(numberoftimes).sendKeys(number);
		    waitmethod.Waitsec();
		    
	
		    driver.findElement(copaytypefield).click();
		    waitmethod.Waitsec();
		    driver.findElement(copaytypevalueamount).click();
		    waitmethod.Waitsec();
		    driver.findElement(copaytypevalueamountvalue).sendKeys(copay);
		    waitmethod.Waitsec();
		    driver.findElement(copaytypevaluebase).sendKeys(base);
		    
		    waitmethod.Waitsec();
		    driver.findElement(currencyfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(currencyvalueuah).click();
		    waitmethod.Waitsec();
		    driver.findElement(clicksave).click();
		    
		    
		}
	 
	 
	 public void AddClaimLimitUSD(String limit, String copay) throws AWTException{
			
		    waitmethod.Waitsec();
		    driver.findElement(gotoclaimlimits).click();
		    waitmethod.Waitsec();
		    driver.findElement(addclaimlimit).click();
		    waitmethod.Waitsec();

		    driver.findElement(catfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(catvalue).click();
		    waitmethod.Waitsec();
		    
		    driver.findElement(allowcopayfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(allowcopayvalueallow).click();
		    waitmethod.Waitsec();
		    

		 
		    driver.findElement(freqfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(freqvalueperclaim).click();
		    waitmethod.Waitsec();
		    driver.findElement(limitvaluefield).sendKeys(limit);
		    waitmethod.Waitsec();
		    
		    
		    
		   
		    driver.findElement(copaytypefield).click();
		    waitmethod.Waitsec();
		    driver.findElement(copaytypevaluepercent).click();
		    waitmethod.Waitsec();
		    driver.findElement(copaytypevaluepercentvalue).sendKeys(copay);
		   
		    
		    waitmethod.Waitsec();
		    driver.findElement(currencyfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(currencyvalueusd).click();
		    waitmethod.Waitsec();
		    driver.findElement(clicksave).click();
		    waitmethod.Waitsec();
	 
	 }

	
}
