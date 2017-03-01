package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.JSONObject;

public class UserRegbymobileTest 
{
	private TestcaseEntry tcEntry;
	private TestcaseEntry tctemp;
	private TestcaseManager tcm;
	
	public UserRegbymobileTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tctemp= new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_BlackGetListTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}

	public void beforeTest()
	{
		//this.tctemp.tcName = "TokenReg";
		tctemp.APIURL = "https://uicapi.test.yoloho.com/user/reg";
		//tctemp.jsonRequest.put("noinit", "0");
		//tctemp.jsonRequest.put("password", "dayima123");
		//tctemp.jsonRequest.put("platform", "iphone");
		//Map<String,Object> tempMap= new HashMap<String, Object>();
		//tempMap= JSONUtility.JSON2Map(tctemp.jsonRequest);
		//tempMap.put("noinit", "0");
		//tempMap.put("password", "dayima123");
		String jsonRequest = "{\"noinit\":\"0\",\"password\":\"123456\",\"platform\":\"iphone\"}";
		tctemp.jsonRequest = JSONObject.fromObject(jsonRequest);	//String to JSON
		tctemp.jsonResponse = JSONUtility.String2JSON(HttpsMethods.sendHttpsClientPost(tctemp.APIURL,JSONUtility.JSON2Map(tctemp.jsonRequest) ,"utf-8"));	
		//System.out.println(tctemp.jsonResponse.toString());
	}
	
	public void TokenReg() throws IOException
	{
		this.tcEntry.tcName = "TokenReg";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);			
		//update token
		this.beforeTest();
		tcEntry.jsonRequest.remove("token");
		tcEntry.jsonRequest.put("token", tctemp.jsonResponse.get("access_token"));
		//System.out.println(tcEntry.jsonRequest.toString());
		Testcase.getResponse(this.tcEntry);
		//System.out.println(tcEntry.jsonResponse.toString());
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void CodeNull() throws IOException
	{
		
		this.tcEntry.tcName="CodeNull";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//update token
		this.beforeTest();
		tcEntry.jsonRequest.remove("token");
		tcEntry.jsonRequest.put("token", tctemp.jsonResponse.get("access_token"));
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void NoParam() throws IOException
	{
		
		this.tcEntry.tcName="NoParam";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);			
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void OnlyMobile() throws IOException
	{
		
		this.tcEntry.tcName="OnlyMobile";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);			
		//update token
		this.beforeTest();
		tcEntry.jsonRequest.remove("token");
		tcEntry.jsonRequest.put("token", tctemp.jsonResponse.get("access_token"));
		Testcase.getResponse(this.tcEntry);
		//tcEntry.jsonExpectedResult.put("stay", tcEntry.jsonResponse.get("stay"));
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
	public void CodeMismatch() throws IOException
	{
		
		this.tcEntry.tcName="CodeMismatch";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);			
		//update token
		this.beforeTest();
		tcEntry.jsonRequest.remove("token");
		tcEntry.jsonRequest.put("token", tctemp.jsonResponse.get("access_token"));
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println(this.tcEntry.jsonExpectedResult);
		//this.AfterTest();
	}
}
