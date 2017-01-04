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
	By addaccounts = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[5]/div/a");
	By findaccounts = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[4]/a");
	By editaccounts = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/ul/li[4]/a");
	By gotoaccount = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[5]/div/div/table/tbody/tr/td[1]/a");
	By accountfundingclick = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/a[3]");
	By choosecredit =  By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[3]/div[2]/form/div[1]/div/div[1]/div");
	By creditsubmit =  By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[3]/div[2]/form/div[3]/div/button");
	By creditsok =  By.xpath("/html/body/div[4]/div[7]/div/button");
	By transaction =  By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[2]/div/div[1]/a[2]/button");
	By creditscancel =  By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[3]/div[2]/form/div[3]/div/a");
	
	
	
	//Add Account	
	By acconame = By.id("Account_Name");
	By number = By.id("Account_AccountNumber");
	By benefityear = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[3]/div/span/span/input");
	By accstart = By.id("Account_StartDate");
	By accend = By.id("Account_EndDate");
	By accadd = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div/form/div[19]/div/button");
	
	
	//Claim Types
	By claimtypes = By.xpath("//a[contains(text(),'Claim Types')]");
	By addclaimtypes = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[6]/div/div[2]/a");
	By claimtypename = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[1]/div/input");
	By claimtypestart = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[2]/div/span[1]/span/input");
	By claimtypeend = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[3]/div/span[1]/span/input");
	By claimtypeclaimant = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[4]/div/div/div");
	By claimtypeclaimantvalue = By.xpath("/html/body/div[4]/div/div[2]/ul/li[17]");
	By claimtypecurrency = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[6]/div/div[2]/span");
	By claimtypecurrencyvalueuah = By.xpath("/html/body/div[6]/div/div[2]/ul/li[133]");
	By claimtypecurrencyvalueusd = By.xpath("/html/body/div[6]/div/div[2]/ul/li[135]");
	By claimtypesave = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[2]/div[1]/form/div[10]/div/button");
	By gotoclaimtype = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div[6]/div/div[1]/div[2]/table/tbody/tr/td[1]/strong/a");
	By gotoassociated = By.xpath("//a[contains(text(),'Associated FSA Accounts')]");
	By linkaccount = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[2]/div/div[2]/button");
	By accountfield = By.xpath("/html/body/div[15]/div/div/div[2]/div/div[1]/div/span/span/span/span");
	By accountvalue = By.xpath("/html/body/div[9]/div/div[2]/ul/li");
	By accountpriorityfield = By.xpath("/html/body/div[15]/div/div/div[2]/div/div[2]/div[1]/span[1]/span/span/span");
	By accountpriorityvalue = By.xpath("/html/body/div[10]/div/div[2]/ul/li");
	By accountpriorityok = By.xpath("/html/body/div[15]/div/div/div[3]/button[2]");
	
	// Claim limits
	
	
	
	
	
	
	 public void LinkFSAaccount(){
		 
		    waitmethod.Waitsec();
		    driver.findElement(claimtypes).click();
		    waitmethod.Waitsec();
		    driver.findElement(gotoclaimtype).click();
		    waitmethod.Waitsec();
		    driver.findElement(gotoassociated).click();
		    waitmethod.Waitsec();
		    driver.findElement(linkaccount).click();
		    waitmethod.Waitsec();
		    driver.findElement(accountfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(accountvalue).click();
		    waitmethod.Waitsec();
		    driver.findElement(accountpriorityfield).click();
		    waitmethod.Waitsec();
		    driver.findElement(accountpriorityvalue).click();
		    waitmethod.Waitsec();
		    driver.findElement(accountpriorityok).click();
		    waitmethod.Waitsec();
		    
		}
	
	
	
	
	
	 public void ClickClaimTypesTab(){
			
		    driver.findElement(claimtypes).click();
		}

	 public void ClickAddClaimType(){
			
		    driver.findElement(addclaimtypes).click();
		}
	
	 public void AddClaimType(String name, String start, String end){
			
		    waitmethod.Waitsec();
		    driver.findElement(claimtypename).sendKeys(name);
		    waitmethod.Waitsec();
		    driver.findElement(claimtypestart).sendKeys(start);
		    waitmethod.Waitsec();
		    driver.findElement(claimtypeend).sendKeys(end);
		    waitmethod.Waitsec();
		    driver.findElement(claimtypeclaimant).click();
		    waitmethod.Waitsec();
		    driver.findElement(claimtypeclaimantvalue).click();
		    waitmethod.Waitsec();
		    driver.findElement(claimtypecurrency).click();
		    waitmethod.Waitsec();
		    driver.findElement(claimtypecurrencyvalueuah).click();
		    waitmethod.Waitsec();
		    driver.findElement(claimtypecurrency).click();
		    waitmethod.Waitsec();
		    driver.findElement(claimtypecurrencyvalueusd).click();
		    waitmethod.Waitsec();
		    driver.findElement(claimtypesave).click();
		}
	
	 public void ClickAddClaimTypeSave(){
			
		    driver.findElement(claimtypesave).click();
		}
	 
	 public void GotoClaimType(){
			
		    driver.findElement(gotoclaimtype).click();
		}

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
	
	//Employee bulk
	By chooseemplfile =  By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[3]/div[2]/form/div[1]/div/div[1]/div");
	By clickokafterupload =  By.xpath("/html/body/div[4]/div[7]/div/button");
	By clicsubmitemp=  By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div/div/div/div[3]/div[2]/form/div[3]/div/button");
	
	
    //nav buttons
	
	By members = By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[1]/ul/li[3]/a");
	By gotomember = By.xpath(".//*[@id='Members']/table/tbody/tr/td[1]/a");
	By setpassword = By.xpath(".//*[@id='tab-details']/div/div[2]/button");
	By setpassfield = By.xpath(".//*[@id='inputPassword']");
	By confirmpass = By.xpath(".//*[@id='inputConfirmPassword']");
	By passsave = By.xpath(".//*[@id='setPasswordBtn']");
	By passok = By.xpath(".//*[@id='modalResult']/div/div/div[3]/button");
	
	
public void SetPass(String setpass, String confirm){
		
		waitmethod.Waitsec();
	    driver.findElement(gotomember).click();
	    waitmethod.Waitsec();
	    driver.findElement(setpassword).click();
	    waitmethod.Waitsec();
	    driver.findElement(setpassfield).sendKeys(setpass);
	    waitmethod.Waitsec();
	    driver.findElement(confirmpass).sendKeys(confirm);
	    waitmethod.Waitsec();
	    driver.findElement(passsave).click();
	    waitmethod.Waitsec();
	    driver.findElement(passok).click();
	    waitmethod.Waitsec();
	  
	}
	
	
	
	
	
	
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
	    driver.findElement(catstatus).click();
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
	
	//FSA accounts
	
	public void OpenAccounts(){
		
	    driver.findElement(accounts).click();
	    waitmethod.Waitsec();
	}
	
    public void ClickAddNewAccountButton(){
		
	    driver.findElement(addaccounts).click();
	    waitmethod.Waitsec();
	}

    public void GotoAccounts(){
		
	    driver.findElement(gotoaccount).click();
	    waitmethod.Waitsec();
	}
    
    public void AccountFundingClick(){
		
	    driver.findElement(accountfundingclick).click();
	    waitmethod.Waitsec();
	}
    
  public void ChooseCreditsClick(){
		
	    driver.findElement(choosecredit).click();
	    waitmethod.Waitsec();
	}
    
  public void SeccessfulCredClick(){
		
	    driver.findElement(creditsok).click();
	    waitmethod.Waitsec();
	}
    
  public void CreditSubmitClick(){
		
	    driver.findElement(creditsubmit).click();
	    waitmethod.Waitsec();
	}

  public void TransactionClick(){
		
	    driver.findElement(transaction).click();
	    waitmethod.Waitsec();
	}
    
  public void CreditsCancelClick(){
		
	    driver.findElement(creditscancel).click();
	    waitmethod.Waitsec();
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
   
   
   public void ClickChooseFile(){
		
	    driver.findElement(chooseemplfile).click();
	    addclient.Waitsec();
	}
   
   public void ClickOkafterUpload(){
		
	    driver.findElement(clickokafterupload).click();
	    addclient.Waitsec();
	}
   
   public void ClickSubmitEmpl(){
		
	    driver.findElement(clicsubmitemp).click();
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
   
   
   public void ClickMemberButton(){
		
	    driver.findElement(members).click();
	}
   
    
   
   
   
    
    
}
