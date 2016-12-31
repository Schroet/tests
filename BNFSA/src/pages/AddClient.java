package pages;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddClient {
	
WebDriver driver;
	
	public AddClient(WebDriver driver){
		
		this.driver = driver;
	}
	
	By clientname = By.id("clientName");
	By countryfield = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[6]/div/span[1]/span/span[1]");
	By countryname = By.xpath("/html/body/div[2]/div/div[3]/ul/li[2]");
	By multilingualfield = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[10]/div/span/span/span[1]");
	By multilingualno = By.xpath("/html/body/div[4]/div/div[2]/ul/li[2]");
	By langfield = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[11]/div/span[1]/span/span[2]/span");
	By langeng = By.xpath("/html/body/div[5]/div/div[3]/ul/li[1]");
	By langchi = By.xpath("/html/body/div[6]/div/div[2]/ul/li[2]");
	By defaultlang = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[13]/div/span[1]/span/span[1]");
	By defaultenglish = By.xpath("/html/body/div[7]/div/div[3]/ul/li[1]");
	By statusfield = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[14]/div/span[1]/span/span[1]");
	By statusactive = By.xpath("/html/body/div[8]/div/div[3]/ul/li[1]");
	By currencyfield = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[15]/div/div/div");
	By currencyuah = By.xpath("/html/body/div[9]/div/div[2]/ul/li[147]");
	By currencyusd = By.xpath("/html/body/div[9]/div/div[2]/ul/li[148]");
	By cancel = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[18]/div/button[1]");
	By cancelok = By.xpath("/html/body/div[10]/div/div/div[3]/a/button");
	By add = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/form/div/div[18]/div/button[2]");
	By logout = By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[2]/ul/li[2]/a");
	
	public void TypeClient(){
		
	    driver.findElement(clientname).sendKeys("AAA" +" - "+"Test" + RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3));
	}
	
    public void TypeClientRandomName(){
		
	    driver.findElement(clientname).sendKeys(RandomStringUtils.randomAlphabetic(5));
	}
	
	
	
	
public void TypeCountry(){
	
	    driver.findElement(countryfield).click();
	    Waitsec();
	    driver.findElement(countryname).click();
	}

public void TypeMultiLingual(){
	
    driver.findElement(multilingualfield).click();
    Waitsec();
    driver.findElement(multilingualno).click();
    Waitsec();
}

public void TypeLanguage(){
	
    driver.findElement(langfield).click();
    Waitsec();
    driver.findElement(langeng).click();
    Waitsec();

}

public void TypeDefLang(){
	
    driver.findElement(defaultlang).click();
    Waitsec();
    driver.findElement(defaultenglish).click();
}

public void TypeStatus(){
	
    driver.findElement(statusfield).click();
    Waitsec();
    driver.findElement(statusactive).click();
}

public void TypeCurrency(){
	
    driver.findElement(currencyfield).click();
    Waitsec();
    driver.findElement(currencyuah).click();
    Waitsec();
    driver.findElement(currencyfield).click();
    Waitsec();
    driver.findElement(currencyusd).click();
    Waitsec();
}

public void ClickAddButton(){
	
    driver.findElement(add).click();
    Waitsec();
}

public String generateRandomString(int length){
	  return RandomStringUtils.randomAlphabetic(length);
	 }

public String generateRandomNumber(int length){
	  return RandomStringUtils.randomNumeric(length);
	 }

public String generateUrl(int length) {
	  String allowedChars="abcdefghijklmnopqrstuvwxyz" +   //alphabets
	    "1234567890" +   //numbers
	    "_-.";   //special characters
	  String url="";
	  String temp=RandomStringUtils.random(length,allowedChars);
	  url=temp.substring(0,3)+"."+temp.substring(4,temp.length()-4)+"."+temp.substring(temp.length()-3);
	  return url;
	 }

public void Waitsec() {
try {
	Thread.sleep(2000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
/*
public void WaitUntil() {
WebDriverWait wait = new WebDriverWait(driver, 2);
wait.until(ExpectedConditions.elementToBeClickable("name")); 
} */

}
