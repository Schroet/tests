package adminportalTests;

import org.junit.Test;
import org.openqa.selenium.By;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import pagesAdmin.AddClient;
import pagesAdmin.ClientDetails;
import pagesAdmin.Clients;
import pagesAdmin.LoginPageAdm;


public class ExceptionCatch extends BrowserSettings {
	
	
	private static ExtentReports extent;

	@Test
	public void CatchEx(){
	
	LaunchBrowser();
	
	
		
	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	
	
	
	extent = new ExtentReports("bin/QA report.html", false);
	ExtentTest test = extent.startTest("TCX");
   	

   	login.PreConditions();
	client.GotoClient(); 
	
	driver.findElement(By.xpath(".//*[@id='page-wrapper']/div[3]/div[2]/div/div/div[2]/form/div/div[18]/div/button")).click();
	driver.findElement(By.xpath(".//*[@id='tab-details']/div/div[2]/a[1]")).click();
	// original  .//*[@id='tab-details']/div/div[2]/a[1]
	}


	
}

   	


   	
   	
   	
   	
   	/*
   	try
	{
		fake.GetFakeLoginpage();
	}
	
	catch (Exception e) {
	    logger.log(LogStatus.FAIL, e);
	    
	} */
		
		
/*
    ExtentReports logger = ExtentReports.get(ExceptionCatch.class);
   	logger.init ("bin/QA report.html", false); 
   	logger.startTest("TC#");
	
   	
   	LoginPageAdm login = new LoginPageAdm(driver);
	Clients client = new Clients(driver);
	ClientDetails details = new ClientDetails(driver);
	AddClient waitmethod = new AddClient(driver);
	
	login.PreConditions("sys", "sys");
	
	client.GotoClient();  
	

	//client.CatchEx1();
	
	//driver.findElement(By.xpath(".//*[@id='tab-details']/div/div[2]/a[1]/i"));
	
	
	
	waitmethod.Waitsec();  */
	
	
	
	

