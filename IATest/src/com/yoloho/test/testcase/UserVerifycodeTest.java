package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class UserVerifycodeTest 
{
	private TestcaseEntry tcEntry;
	//private TestcaseEntry tcTemp;
	private TestcaseManager tcm;
	
	public UserVerifycodeTest(TestcaseManager tcmanager,String testsuitname, File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserVerifycodeTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void OnlyToken() throws IOException
	{
		this.tcEntry.tcName="OnlyToken";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void CodeNull() throws IOException
	{
		this.tcEntry.tcName="CodeNull";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void MobileNull() throws IOException
	{
		this.tcEntry.tcName="MobileNull";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void MobileShort() throws IOException
	{
		this.tcEntry.tcName="MobileShort";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void MobileLong() throws IOException
	{
		this.tcEntry.tcName="MobileLong";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void MobileWrong() throws IOException
	{
		this.tcEntry.tcName="MobileWrong";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void CodeWrong() throws IOException
	{
		this.tcEntry.tcName="CodeWrong";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
}
