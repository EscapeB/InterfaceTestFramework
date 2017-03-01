package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class UserGetuserrankTest 
{
	private TestcaseEntry tcEntry;
	//private TestcaseEntry afterTC;
	private TestcaseManager tcm;
	
	public UserGetuserrankTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserGetuserrankTest.xls";
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
		//tcEntry.jsonExpectedResult.has(key)
		tcEntry.jsonExpectedResult.remove("stay");
		tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		tcEntry.jsonExpectedResult.remove("staydays");
		tcEntry.jsonExpectedResult.put("staydays", tcEntry.jsonResponse.get("staydays"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void AfterTest(){
		TestcaseEntry tc = tcEntry;		
		tc.APIURL = "https://uicapi.test.yoloho.com/follow/cancel";
		//Testcase.getResponse(tc);
		if(tc.APIURL.trim().toLowerCase().substring(0,5).equals("https")){
			tc.jsonResponse=JSONUtility.String2JSON(HttpsMethods.sendHttpsClientPost(tc.APIURL,JSONUtility.JSON2Map(tc.jsonRequest) ,"utf-8"));	
		}
		else if(tc.APIURL.trim().substring(0,4).equals("http")){
			tc.jsonResponse=JSONUtility.String2JSON(HttpMethods.sendHttpClientPost(tc.APIURL,JSONUtility.JSON2Map(tc.jsonRequest) ,"utf-8"));
		}
	}
	public void Testcase_02() throws IOException
	{
		
		this.tcEntry.tcName="Testcase_02";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		tcEntry.jsonExpectedResult.remove("stay");
		tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		tcEntry.jsonExpectedResult.remove("staydays");
		tcEntry.jsonExpectedResult.put("staydays", tcEntry.jsonResponse.get("staydays"));
		//tcEntry.jsonResponse.put("visited", value)
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
		Testcase.getResponse(this.tcEntry);
		tcEntry.jsonExpectedResult.remove("stay");
		tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		tcEntry.jsonExpectedResult.remove("staydays");
		tcEntry.jsonExpectedResult.put("staydays", tcEntry.jsonResponse.get("staydays"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("UserGetInfo:GetInfo_g1");
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
}
