package pageObjectsTests;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import memberportalTests.AddClaimUAH;
import memberportalTests.FirstLoginMember;




@RunWith(Suite.class)
@Suite.SuiteClasses({
	
	
		
Test1Login.class, //1
DeleteClient.class,
AddNewClient.class,
AddClientCategory.class, 
AddAccount.class, 
UploadEmployeeBulk.class,
UploadCredits.class,
AddClaimType.class,
LinkAccount.class,
AddClaimLimitUAH.class,
AddClaimLimitUSD.class,
SetPasswordEmployee.class,
MemberEdit.class,
FirstLoginMember.class,
AddClaimUAH.class,



})

public class TestSuiteRunner {
  // the class remains empty,
  // used only as a holder for the above annotations
	
	
}