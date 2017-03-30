package suitRunner;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;

import adminportalTests.AddAccount;
import adminportalTests.AddClaimLimitUAH;
import adminportalTests.AddClaimLimitUSD;
import adminportalTests.AddClaimType;
import adminportalTests.AddClientCategory;
import adminportalTests.AddNewClient;
import adminportalTests.AddNewEmployee;
import adminportalTests.BrowserSettings;
import adminportalTests.DeleteClient;
import adminportalTests.LinkAccount;
import adminportalTests.MemberEdit;
import adminportalTests.SetPasswordEmployee;
import adminportalTests.ParallelRun.ParallelTest1;
import adminportalTests.ParallelRun.ParallelTest2;
import adminportalTests.Test1Login;
import adminportalTests.UploadCredits;
import adminportalTests.UploadEmployeeBulk;


public class NewPSR {

	@Test
	public void runAllTests() {
		Class<?>[] classes = {

				Test1Login.class,
				SetPasswordEmployee.class,
				
		};

		// ParallelComputer(true,true) will run all classes and methods
		// in parallel. (First arg for classes, second arg for methods)
		JUnitCore.runClasses(new ParallelComputer(true, true), classes);
	}
}