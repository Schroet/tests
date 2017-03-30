package suitRunner;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

import adminportalTests.BrowserSettings;
import adminportalTests.ParallelRun.ParallelTest1;
import adminportalTests.ParallelRun.ParallelTest2;

public class ParallelSuiteRunner extends BrowserSettings {

	@Test
	public void runAllTests() {
		Class<?>[] classes = { ParallelTest1.class, ParallelTest2.class };

		// ParallelComputer(true,true) will run all classes and methods
		// in parallel. (First arg for classes, second arg for methods)
		JUnitCore.runClasses(new ParallelComputer(true, true), classes);
	}
}
