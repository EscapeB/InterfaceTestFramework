package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;

import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class GroupMyMypostTest {
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	
	public GroupMyMypostTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupMyMypostTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	public void MyMypost() throws IOException{
		this.tcEntry.tcName="MyMypost";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	
}
