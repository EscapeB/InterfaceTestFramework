package com.yoloho.test.testcase;
import java.io.File;

import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class GroupAdminAuditlistTest {
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	public GroupAdminAuditlistTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupAdminAuditlistTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	public void GroupAdminAuditlist() throws Exception{
		this.tcEntry.tcName="GroupAdminAuditlist";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupAdminAuditlist_WrongGroupid() throws Exception{
		this.tcEntry.tcName="GroupAdminAuditlist_WrongGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupAdminAuditlist_NullGroupid() throws Exception{
		this.tcEntry.tcName="GroupAdminAuditlist_NullGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupAdminAuditlist_WrongTypeGroupid() throws Exception{
		this.tcEntry.tcName="GroupAdminAuditlist_WrongTypeGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void finalize(){
		this.tcEntry=null;
		this.tcm=null;
	}
}
