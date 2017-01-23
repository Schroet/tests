package suitRunner;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import adminportalTests.AddAccount;
import adminportalTests.AddClaimLimitUAH;
import adminportalTests.AddClaimLimitUSD;
import adminportalTests.AddClaimType;
import adminportalTests.AddClientCategory;
import adminportalTests.AddNewClient;
import adminportalTests.AddNewEmployee;
import adminportalTests.DeleteClient;
import adminportalTests.LinkAccount;
import adminportalTests.MemberEdit;
import adminportalTests.SetPasswordEmployee;
import adminportalTests.Test1Login;
import adminportalTests.UploadCredits;
import adminportalTests.UploadEmployeeBulk;
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
AddNewEmployee.class,
FirstLoginMember.class,
AddClaimUAH.class,



})

public class TestSuiteRunner {
  // the class remains empty,
  // used only as a holder for the above annotations
	
	
}