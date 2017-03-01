package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class UserSetpushTest 
{
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	
	public UserSetpushTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserSetpushTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void OnlyToken() throws IOException
	{
		this.tcEntry.tcName="OnlyToken";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void Push0() throws IOException
	{
		this.tcEntry.tcName="Push0";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void PushNull() throws IOException
	{
		this.tcEntry.tcName="PushNull";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void Push1() throws IOException
	{
		this.tcEntry.tcName="Push1";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void PushNot0() throws IOException
	{
		this.tcEntry.tcName="PushNot0";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void PushType() throws IOException
	{
		this.tcEntry.tcName="PushType";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
}
