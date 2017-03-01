package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

//添加黑名单
public class BlackAddTest 
{
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	
	public BlackAddTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_BlackAddTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void Testcase_01() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_01";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		this.AfterTest();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		this.AfterTest();
	}
	
	public void Testcase_02() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_02";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	
	public void Testcase_03() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_03";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		this.AfterTest();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		this.AfterTest();
	}
	
	public void Testcase_04() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_04";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		this.AfterTest();
	}
	
	public void Testcase_05() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_05";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		this.AfterTest();
	}
	
	public void Testcase_06() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_06";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		this.AfterTest();
	}
	
	public void Testcase_07() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_07";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		this.AfterTest();
	}
	
	public void AfterTest()
	{
		TestcaseEntry tc = tcEntry;
		tc.APIURL = "https://uicapi.test.yoloho.com/black/cancel";
		
		if(tc.APIURL.trim().toLowerCase().substring(0,5).equals("https")){
			tc.jsonResponse=JSONUtility.String2JSON(HttpsMethods.sendHttpsClientPost(tc.APIURL,JSONUtility.JSON2Map(tc.jsonRequest) ,"utf-8"));	
		}
		else if(tc.APIURL.trim().substring(0,4).equals("http")){
			tc.jsonResponse=JSONUtility.String2JSON(HttpMethods.sendHttpClientPost(tc.APIURL,JSONUtility.JSON2Map(tc.jsonRequest) ,"utf-8"));
		}
	}
	
	/*
	public void preCondition(){
		TestcaseEntry precondition = new TestcaseEntry();
		//String strJSONRequest="{\"username\":\"g1\",\"password\":\"1\"}";
		String strJSONRequest="{\"token\": \"104974037#8e8cb8a1a63ba0750a10a4a12af65e49\"}";
		precondition.jsonRequest=JSONUtility.String2JSON(strJSONRequest);
		Testcase.getResponse(precondition);
		Map<String,String> map = new HashMap<String,String>();
		String result=null;
		map.put("token", "104974037#8e8cb8a1a63ba0750a10a4a12af65e49");
		result=HttpMethods.sendHttpClientGet(this.tcEntry.APIURL, map);
		
		System.out.println(result);
			
	}*/
	


}
