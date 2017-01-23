package pagesMember;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import adminportalTests.GetEmailText;
import adminportalTests.MemberEdit;
import pagesAdmin.AddClient;
import pagesAdmin.MemberPage;

public class LoginPageMember {
	
WebDriver driver;
	
	By login = By.xpath(".//*[@id='page']/div/div/div/div/div/section/form/fieldset/div[1]/div/input");
	By passw = By.xpath(".//*[@id='page']/div/div/div/div/div/section/form/fieldset/div[3]/div/input");
	By signinbtn = By.xpath(".//*[@id='page']/div/div/div/div/div/section/form/div[1]/button");
	By clicktickbox = By.xpath(".//*[@id='agree']"); //add
	By clickagree = By.xpath(".//*[@id='btAccept']");
	By clickproceed = By.xpath(".//*[@id='into']/div/div[5]/button");

public LoginPageMember(WebDriver driver){
		
		this.driver = driver;
	}
	

AddClient waitmethod = new AddClient(driver);
MemberPage mempage = new MemberPage(driver);

//Reader read = new Reader(driver);


public void FirstLoginMemberPortal(String pass) throws IOException{
	
    GetLoginPageMember();
    driver.manage().window().maximize();
    GetEmail();
    waitmethod.Waitsec();
	driver.findElement(passw).sendKeys(pass);
	waitmethod.Waitsec();
	driver.findElement(signinbtn).click();
	waitmethod.Waitsec();
	driver.findElement(clicktickbox).click();
	waitmethod.Waitsec();
	driver.findElement(clickagree).click();
	waitmethod.Waitsec();
	driver.findElement(clickproceed).click();
	waitmethod.Waitsec();
	
}

public void LoginMemberPortal( String pass) throws IOException{
	
	    GetLoginPageMember();
	    driver.manage().window().maximize();
	    GetEmail();
		driver.findElement(passw).sendKeys(pass);
		driver.findElement(signinbtn).click();
	}


public void GetEmail() throws IOException{
	
    InputStream in = new FileInputStream("bin/emailsrandom.xls");
  
    HSSFWorkbook wb = new HSSFWorkbook(in);

    ExcelExtractor extractor = new ExcelExtractor(wb);
    extractor.setFormulasNotResults(false); // Считать формулы
    extractor.setIncludeSheetNames(false);
    
    String text = extractor.getText();
    driver.findElement(login).sendKeys(text);

}

public void PreConditionsMember(String pass) throws IOException{
	
	LoginMemberPortal(pass);
	
};

public void GetLoginPageMember(){
	
	driver.manage().window().maximize();
	driver.get("https://portal-qa.wtwbenefitsmarketplacefsa.com/#/login");
}
}
