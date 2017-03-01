package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.*;

public class UserLoginTest  {

private TestcaseEntry tcEntry;
private TestcaseManager tcm;

	
	public UserLoginTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserLoginTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void UsernamePassword_Login() throws IOException{
		this.tcEntry.tcName="UsernamePassword_Login";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UsernamePassword_Login");
		//System.out.println(this.tcEntry.jsonExpectedResult);
	}
	
	
	public void UidPassword_Login() throws IOException{
		this.tcEntry.tcName="UidPassword_Login";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//Testcase.getTestdata("./testdata/TC_UserLoginTest.xls","UidPassword_Login",	this.testdata);
		//Testcase.getResponse(this.jsonRequest, this.jsonResponse);
		//Testcase.VerfyResult(this.jsonResponse, this.jsonExpectedResult, this.jsonExpectedFormat);
		//Testcase.UpdateTestResult();
		//System.out.println("UidPassword_Login");
	}
	public void UsernameUidPassword_Login() throws IOException{
		this.tcEntry.tcName="UsernameUidPassword_Login";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//Testcase.getTestdata("./testdata/TC_UserLoginTest.xls","UsernameUidPassword_Login",this.testdata);
		//Testcase.getResponse(this.jsonRequest, this.jsonResponse);
		//Testcase.VerfyResult(this.jsonResponse, this.jsonExpectedResult, this.jsonExpectedFormat);
		//Testcase.UpdateTestResult();
		//System.out.println("UsernameUidPassword_Login");
	}
	
	public void UsernamePassword_Login1() throws IOException{
		this.tcEntry.tcName="UsernamePassword_Login1";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//Testcase.getTestdata("./testdata/TC_UserLoginTest.xls","UsernameUidPassword_Login",this.testdata);
		//Testcase.getResponse(this.jsonRequest, this.jsonResponse);
		//Testcase.VerfyResult(this.jsonResponse, this.jsonExpectedResult, this.jsonExpectedFormat);
		//Testcase.UpdateTestResult();
		System.out.println("UsernameUidPassword_Login1");
	}
	/*
	public void finalize(){
		this.tcEntry=null;
		this.tcm=null;
	}
*/
}
