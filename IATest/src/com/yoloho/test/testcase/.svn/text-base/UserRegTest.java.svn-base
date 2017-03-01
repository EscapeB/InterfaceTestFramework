package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class UserRegTest 
{
	private TestcaseEntry tcEntry;
	//private TestcaseEntry afterTC;
	private TestcaseManager tcm;
	
	public UserRegTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserRegTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void NoParam() throws IOException
	{
		
		this.tcEntry.tcName="NoParam";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	
	public void Noinit0() throws IOException
	{
		
		this.tcEntry.tcName="Noinit0";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void Noinit0PasswordNull() throws IOException
	{
		
		this.tcEntry.tcName="Noinit0PasswordNull";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void NickNull() throws IOException
	{
		
		this.tcEntry.tcName="NickNull";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void PasswordNull() throws IOException
	{
		
		this.tcEntry.tcName="PasswordNull";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void PasswordShort() throws IOException
	{
		
		this.tcEntry.tcName="PasswordShort";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void PasswordLong() throws IOException
	{
		
		this.tcEntry.tcName="PasswordLong";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void NoPlatform() throws IOException
	{
		
		this.tcEntry.tcName="NoPlatform";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void NormalReg() throws IOException
	{
		
		this.tcEntry.tcName="NormalReg";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		String strTest = tcEntry.jsonRequest.get("nick").toString();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("mmss");
		//System.out.println(sdf);
		String randomSign = sdf.format(date);
        strTest += randomSign;
        //System.out.println(strTest);
		tcEntry.jsonRequest.remove("nick");
        tcEntry.jsonRequest.put("nick", strTest);
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void Noinit0Reg() throws IOException
	{
		
		this.tcEntry.tcName="Noinit0Reg";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void NickShort() throws IOException
	{
		
		this.tcEntry.tcName="NickShort";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void NickLong() throws IOException
	{
		
		this.tcEntry.tcName="NickLong";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.has(key)
		//tcEntry.jsonExpectedResult.remove("stay");
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
}
