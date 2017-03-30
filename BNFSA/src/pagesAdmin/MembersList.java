package pagesAdmin;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MembersList {
	
	WebDriver driver;
	AddClient waitmethod = new AddClient(driver);
	
	public MembersList(WebDriver driver){
		
		this.driver = driver;
	}

	MemberPage mempage = new MemberPage(driver);
	
	//Employee Page
	By addemployeebtn = By.xpath(".//*[@id='page-wrapper']/div[3]/div[2]/div/div/div[3]/a");
	
	//Add new Employee Page
	By firstname = By.xpath(".//*[@id='Member_FirstName']");
	By lastname = By.xpath(".//*[@id='Member_LastName']");
	By email = By.xpath(".//*[@id='Member_Email']");
	By genderfield = By.xpath(".//*[@id='add_member_form']/div[1]/div[14]/div/span[1]/span/span[2]/span");
	By gendervalue = By.xpath(".//*[@id='Member_GenderId_listbox']/li[1]");
	By emplnumber = By.xpath(".//*[@id='Member_EmployeeNumber']");
	By save = By.xpath(".//*[@id='add_member_form']/div[2]/div/button");
	By editbtn = By.xpath(".//*[@id='Members']/table/tbody/tr[1]/td[4]/a");
	By emplname = By.xpath(".//*[@id='Members']/table/tbody/tr[1]/td[1]/a");
	
	public void ClickAddEmplBtn(){
		
		driver.findElement(addemployeebtn).click();
		
	}
	
	public void AddNewEmpl(){
		
		driver.findElement(firstname).sendKeys("Adam");
		driver.findElement(lastname).sendKeys("Morgan");
		driver.findElement(email).sendKeys(MemberPage.randomEmail());
		driver.findElement(emplnumber).sendKeys(RandomStringUtils.randomNumeric(6));
		driver.findElement(genderfield).click();
		waitmethod.Waitsec();
		driver.findElement(gendervalue).click();
		driver.findElement(save).click();
	}
	
	
	public void WaitEditbtn(){
		 WebDriverWait wait = new WebDriverWait(driver, 10);
			WebElement element = wait.until(
			ExpectedConditions.visibilityOfElementLocated(emplname));
		}
	
	
}
