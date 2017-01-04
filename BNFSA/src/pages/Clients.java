package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.sun.jna.platform.FileUtils;

public class Clients {
	
	WebDriver driver;
	
	public Clients(WebDriver driver){
		
		this.driver = driver;
	}
	
	By client = By.partialLinkText("AAA");	
	By addclient = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div[3]/a");
	By editclient = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div[3]/div/table/tbody/tr[1]/td[5]/a");
	By deleteclient = By.xpath("/html/body/div[1]/div[1]/div[3]/div[2]/div[3]/div/table/tbody/tr[1]/td[5]/button");
	By deleteclientok = By.xpath("/html/body/div[4]/div/div/div[3]/button[2]");
	By logout = By.xpath("/html/body/div[1]/div[1]/div[1]/nav/div[2]/div[2]/ul/li[2]/a");
	
	
	AddClient waitmethod = new AddClient(driver);
	
	
	/*
	public void Shot() {
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(scrFile, new File("C:/testScreenShot.png"));
		};
	*/
	
	
	public void GotoClient(){
		
	    driver.findElement(client).click();
	}	
	
public void ClickAddСlientButton(){
		
	    driver.findElement(addclient).click();
	}	

public void ClickEditСlient(){
	
    driver.findElement(editclient).click();
}

public void ClickDeleteСlient(){
	
    driver.findElement(deleteclient).click();
    waitmethod.Waitsec();
}

public void ClickDeleteСlientOk(){
	
    driver.findElement(deleteclientok).click();
    waitmethod.Waitsec();
}


public void ClickLogout(){
	
    driver.findElement(logout).click();
}

	
}
