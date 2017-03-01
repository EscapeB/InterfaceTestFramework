package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class UserSignatureTest 
{
	private TestcaseEntry tcEntry;
	//private TestcaseEntry tcTemp;
	private TestcaseManager tcm;
	
	public UserSignatureTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserSignatureTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
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
	public void SignatureNull() throws IOException
	{
		this.tcEntry.tcName="SignatureNull";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void SignatureLong() throws IOException
	{
		this.tcEntry.tcName="SignatureLong";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void SignatureNormal() throws IOException
	{
		this.tcEntry.tcName="SignatureNormal";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
}
