package suitRunner;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import memberportalTests.AddClaimUAH;
import memberportalTests.FirstLoginMember;
import pageObjectsTests.AddAccount;
import pageObjectsTests.AddClaimLimitUAH;
import pageObjectsTests.AddClaimLimitUSD;
import pageObjectsTests.AddClaimType;
import pageObjectsTests.AddClientCategory;
import pageObjectsTests.AddNewClient;
import pageObjectsTests.AddNewEmployee;
import pageObjectsTests.DeleteClient;
import pageObjectsTests.LinkAccount;
import pageObjectsTests.MemberEdit;
import pageObjectsTests.SetPasswordEmployee;
import pageObjectsTests.Test1Login;
import pageObjectsTests.UploadCredits;
import pageObjectsTests.UploadEmployeeBulk;


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
AddNewEmployee.class,
FirstLoginMember.class,
AddClaimUAH.class,



})

public class TestSuiteRunner {
  // the class remains empty,
  // used only as a holder for the above annotations
	
	
}