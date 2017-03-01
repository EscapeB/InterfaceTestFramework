package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.*;
public class TaglistTest {
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	
	public TaglistTest(TestcaseManager tcmanager,String testsuitname,File logfile){
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName="./testdata/TC_TaglistTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
		//this.tcEntry.Username="g1";
		//this.tcEntry.Password="1";
		//this.tcEntry.UId="104974037";
		//this.tcEntry.Token="104974037#8e8cb8a1a63ba0750a10a4a12af65e49";
	}
	public void HotTaglist() throws Exception{
		this.tcEntry.tcName="HotTaglist";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	
}
