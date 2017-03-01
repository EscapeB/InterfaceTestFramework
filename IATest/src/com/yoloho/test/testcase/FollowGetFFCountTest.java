package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

//获取用户的关注数和粉丝数
public class FollowGetFFCountTest 
{
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	
	public FollowGetFFCountTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_FollowGetFFCountTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void Testcase_01() throws IOException
	{
		this.tcEntry.tcName="Testcase_01";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
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
	}
	
	public void Testcase_03() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_03";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
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
	}
	/*public void preCondition(){
		TestcaseEntry precondition = new TestcaseEntry();
		//String strJSONRequest="{\"username\":\"g1\",\"password\":\"1\"}";
		String strJSONRequest="{\"token\": \"104974037#8e8cb8a1a63ba0750a10a4a12af65e49\"}";
		precondition.jsonRequest=JSONUtility.String2JSON(strJSONRequest);
		Testcase.getResponse(precondition);
		Map<String,Object> map = new HashMap<String,Object>();
		String result=null;
		map.put("token", "104974037#8e8cb8a1a63ba0750a10a4a12af65e49");
		result=HttpMethods.sendHttpClientGet(this.tcEntry.APIURL, map);
		
		System.out.println(result);
			
	}*/
}
