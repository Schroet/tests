package pagesAdmin;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import adminportalTests.MemberEdit;

public class MemberPage {
	
	WebDriver driver;
	
	public MemberPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	AddClient addclient = new AddClient(driver);
	
	By gomember = By.xpath(".//*[@id='Members']/table/tbody/tr/td[1]/a");
	By editbtn = By.xpath(".//*[@id='Members']/table/tbody/tr/td[4]/a");
	By emailfld = By.xpath(".//*[@id='Member_Email']");
	String memnun = ".//*[@id='Members']/table/tbody/tr/td[1]/a";
	String addclbtn = ".//*[@id='tab-details']/div/div[2]/a[1]";
	String editbutton = ".//*[@id='tab-details']/div/div[2]/a[2]";
	By emailfldlog = By.xpath(".//*[@id='page']/div/div/div/div/div/section/form/fieldset/div[1]/div/input");
	By savebtn = By.xpath(".//*[@id='add_member_form']/div[2]/div/button");
	By addnewclaimbtn = By.xpath(".//*[@id='tab-details']/div/div[2]/a[1]");
	By editbtn2 = By.xpath(".//*[@id='tab-details']/div/div[2]/a[2]");
	
	//String emailvalue = MemberEdit.elementval;
	
public String GetMailValue(){
		
		driver.findElement(gomember).click();		
		driver.findElement(editbtn).click();
		WebElement element = driver.findElement(By.id("Member_Email"));
		String elementval = element.getAttribute("value");
		return elementval;
	}
	
	
	
	
	
	public void GotoMember(){
		
		driver.findElement(gomember).click();		
	}
	
	public void WaitVisible(){
	
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement element = wait.until(
	    ExpectedConditions.visibilityOfElementLocated(By.xpath(memnun)));
	    
	}

	public void WaitVisibleClaimBtn(){
		
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		    WebElement element = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath(addclbtn)));
		    
		}
	
	public void WaitVisibleEditBtn(){
		
		  WebDriverWait wait = new WebDriverWait(driver, 10);
		    WebElement element = wait.until(
		    ExpectedConditions.visibilityOfElementLocated(By.xpath(editbutton)));
		    
		}

public void EditBtn2Click(){
		
		driver.findElement(editbtn2).click();		
	}	
	

public void SaveBtnClick(){
		
		driver.findElement(savebtn).click();		
	}
	
public void AddClaimBtnClick(){
	
	driver.findElement(addnewclaimbtn).click();		
}

public void EditBtnClick(){
		
		driver.findElement(editbtn).click();		
	}
	
public void AddEMail(){
	
	driver.findElement(emailfld).clear();
	driver.findElement(emailfld).sendKeys(randomEmail());	
}	
	
public void AddEMailLogin(){
	
	driver.findElement(emailfldlog).sendKeys();		

}	


public static String randomEmail() {
    return RandomStringUtils.randomAlphabetic(5) + RandomStringUtils.randomNumeric(4) + "@" + "yopmail.com";
}




String memberemail = RandomStringUtils.randomAlphabetic(5) + "@" + "yopmail.com";
String elementval;

/*

private static String memberemail;

public static void setmemberemail(String memberemail) {
	
	memberemail = RandomStringUtils.randomAlphabetic(5) + "@" + "yopmail.com";
	
}

public static String getmemberemail() {
	
    return memberemail;
}   */

}


