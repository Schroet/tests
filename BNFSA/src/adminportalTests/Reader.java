package adminportalTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Reader {
	
	static By login = By.xpath(".//*[@id='page']/div/div/div/div/div/section/form/fieldset/div[1]/div/input");
	
	static WebDriver driver;
	
       public Reader(WebDriver driver){
		
		Reader.driver = driver;
	}
       
     
	    public static void GetEmail() throws IOException{
	    	
	        InputStream in = new FileInputStream("C:/GIT/BNFSA/bin/emailsrandom.xls");
	        // Внимание InputStream будет закрыт
	        // Е�?ли нужно не закрывающий �?м. JavaDoc по POIFSFileSystem :  http://goo.gl/1Auu7
	        
	        HSSFWorkbook wb = new HSSFWorkbook(in);
	 
	        ExcelExtractor extractor = new ExcelExtractor(wb);
	        extractor.setFormulasNotResults(false); // Считать формулы
	        extractor.setIncludeSheetNames(false);
	        
	        String text = extractor.getText();
	        driver.findElement(login).sendKeys(text);

	        
	    }



	}
	
