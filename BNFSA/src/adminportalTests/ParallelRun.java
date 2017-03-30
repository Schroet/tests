package adminportalTests;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

public class ParallelRun extends BrowserSettings {

	@Test
	public void runAllTests() {
		Class<?>[] classes = { ParallelTest1.class, ParallelTest2.class };

		// ParallelComputer(true,true) will run all classes and methods
		// in parallel. (First arg for classes, second arg for methods)
		JUnitCore.runClasses(new ParallelComputer(true, true), classes);
	}

	public static class ParallelTest1 extends BrowserSettings {
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
	}

	public static class ParallelTest2 extends BrowserSettings {
		@Test
		public void test3() {
			driver.get("http://www.github.com");
			System.out.println("Test 3 was executed");
		}

		@Test
		public void test4() {
			driver.get("http://www.tesla.com");
			System.out.println("Test 4 was executed");
		}
	}

}
