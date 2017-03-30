package adminportalTests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 extends BrowserSettings {

	@Test

	public void test1() {
		driver.get("http://stackoverflow.com");
		System.out.println("Test 1 was executed");
	}

	@Test

	public void test2() {
		driver.get("http://www.google.ua");
		System.out.println("Test 2 was executed");
	}

	@Test

	public void test3() {
		driver.get("http://www.github.com");
		System.out.println("Test 3 was executed");
	}

	

}
