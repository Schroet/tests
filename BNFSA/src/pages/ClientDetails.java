package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClientDetails {
	
WebDriver driver;
	
	public ClientDetails(WebDriver driver){
		
		this.driver = driver;
	}
	
	//Navigation
	
	//Categories
	By categorytab = By.xpath("//a[contains(text(),'Categories')]"); 
	By addcategory = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[3]/div/a"); //Button
	
	//Add Category
	By catname = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/div[1]/div/input");
	By catstatus = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/div[2]/div/span[1]/span/span[1]");
	By catstatusactive = By.xpath("/html/body/div[2]/div/div[3]/ul/li[1]");
	By catsave = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/div[3]/div/button");
	By catok = By.xpath("/html/body/div[6]/div[7]/div/button");
		
	//Accounts
	By accounts = By.xpath("//a[contains(text(),'FSA Accounts')]");
	By addaccounts = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[4]/a");
	By findaccounts = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[4]/a");
	By editaccounts = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[4]/a");
	
	//Add Account	
	By acconame = By.id("Account_Name");
	By number = By.id("Account_AccountNumber");
	By benefityear = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[3]/div/span/span/input");
	By accstart = By.id("Account_StartDate");
	By accend = By.id("Account_EndDate");
	By accadd = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[19]/div/button");
	
	
	//Claim Types
	By claimtypes = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[5]/a");
	
	
	//Reports
	By reports = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[6]/a");
	
	//Admins
	By admins = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[7]/a");
	
	//Emails
	By emails = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[8]/a");
	
	//Buttons
	By editclient = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/a[1]");
	By memberportalsettings = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/a[2]");
	
	//bulk operations
	By bulkoperation = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/div[4]/button");
	By importemplbulk = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/div[4]/ul/li[1]/a");
	By updateclaimlbulk = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/div[4]/ul/li[2]/a");
	By importdependentlbulk = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[1]/div/div[2]/div[4]/ul/li[3]/a");
	
    //nav buttons
	
	By members = By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/ul/li[3]/a");
	By fsaclaims = By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/ul/li[4]/a");
	
	//Methods for navigations
	
	AddClient waitmethod = new AddClient(driver);
	
	public void AddnewAccount(String name, String accnumber, String ben, String start, String end ){
		
		waitmethod.Waitsec();
	    driver.findElement(acconame).sendKeys(name);
	    waitmethod.Waitsec();
	    driver.findElement(number).sendKeys(accnumber);
	    driver.findElement(benefityear).clear();
	    driver.findElement(benefityear).sendKeys(ben);
	    waitmethod.Waitsec();
	    driver.findElement(accstart).clear();
	    driver.findElement(accstart).sendKeys(start);
	    waitmethod.Waitsec();
	    driver.findElement(accend).clear();
	    driver.findElement(accend).sendKeys(end);
	    waitmethod.Waitsec();
	    driver.findElement(accadd).click();
	    waitmethod.Waitsec();
	  
	}
	
	public void AddnewCategory(String name){
		
		waitmethod.Waitsec();
	    driver.findElement(categorytab).click();
	    waitmethod.Waitsec();
	    driver.findElement(addcategory).click();
	    driver.findElement(catname).sendKeys(name);
	    waitmethod.Waitsec();
	    driver.findElement(accend).click();
	    waitmethod.Waitsec();
	    driver.findElement(catstatusactive).click();
	    waitmethod.Waitsec();
	    driver.findElement(catsave).click();
	    waitmethod.Waitsec();
	    
	}	
	
    public void ClickAddCategoryButton(){
		
	    driver.findElement(addcategory).click();
	}	
    
    public void ClickOkCategoryButton(){
		
	    driver.findElement(catok).click();
	}
	
	
	
	public void OpenAccounts(){
		
	    driver.findElement(accounts).click();
	}
	
    public void OpenClaimTypes(){
		
	    driver.findElement(claimtypes).click();
	}
	
    public void OpenReports(){
		
	    driver.findElement(reports).click();
	}    
    
    public void OpenAdmins(){
		
	    driver.findElement(admins).click();
	}
    
    public void OpenEmails(){
		
	    driver.findElement(emails).click();
	}
    
  //Methods for buttons
    
    public void OpenEditClient(){
		
	    driver.findElement(editclient).click();
	}
    
    public void OpenMemberPortalSettings(){
		
	    driver.findElement(memberportalsettings).click();
	}
    
  //Methods for bulk operations
    
    
   AddClient addclient = new AddClient(driver);
    
   public void ClickImportEmployeeButton(){
		
	    driver.findElement(bulkoperation).click();
	    addclient.Waitsec();
	    driver.findElement(importemplbulk).click();
	    addclient.Waitsec();
	}
   
   public void ClickUpdateClaimButton(){
		
	    driver.findElement(bulkoperation).click();
	    addclient.Waitsec();
	    driver.findElement(updateclaimlbulk).click();
	    addclient.Waitsec();
	}
   
   public void ClickImportDependentButton(){
		
	    driver.findElement(bulkoperation).click();
	    addclient.Waitsec();
	    driver.findElement(importdependentlbulk).click();
	    addclient.Waitsec();
	}
   
   
   
   
   
   
   
  
   public void OpenBulkOperations(){
		
	    driver.findElement(bulkoperation).click();
	}
   
   public void ClickImportEmployeeBulk(){
		
	    driver.findElement(importemplbulk).click();
	}
    
   public void ClickUpdateClaimBulk(){
		
	    driver.findElement(updateclaimlbulk).click();
	}
    
   public void ClickImportDependentBulk(){
		
	    driver.findElement(importdependentlbulk).click();
	}
   
   
   
   
   //Methods for nav buttons
   
   
   
   
    
    
    
}
