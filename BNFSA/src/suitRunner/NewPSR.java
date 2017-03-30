package suitRunner;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

import adminportalTests.DeleteClient;
import adminportalTests.Test1Login;


public class NewPSR {

	@Test
	public void runAllTests() {
		Class<?>[] classes = {

				Test1Login.class,
				DeleteClient.class,
				
		};

		// ParallelComputer(true,true) will run all classes and methods
		// in parallel. (First arg for classes, second arg for methods)
		JUnitCore.runClasses(new ParallelComputer(true, true), classes);
	}
}