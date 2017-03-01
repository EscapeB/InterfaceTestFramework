package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.JSONObject;

public class UserGetpushTest 
{
	private TestcaseEntry tcEntry;
	private TestcaseEntry tcTemp;
	private TestcaseManager tcm;
	
	
	public UserGetpushTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcTemp = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserGetpushTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void setPush()
	{
		tcTemp.APIURL = "https://uicapi.test.yoloho.com/user/setpush";
		String jsonRequest = "{}";
		tcTemp.jsonRequest = JSONObject.fromObject(jsonRequest);
		//tcTemp.jsonRequest.remove("push");
		tcTemp.jsonRequest.put("push", tcEntry.jsonRequest.get("push"));
		tcTemp.jsonRequest.put("token", tcEntry.jsonRequest.get("token"));
		tcTemp.jsonResponse = JSONUtility.String2JSON(HttpsMethods.sendHttpsClientPost(tcTemp.APIURL,JSONUtility.JSON2Map(tcTemp.jsonRequest) ,"utf-8"));
		//System.out.println(tcTemp.jsonResponse.toString());
	}
	
	public void OnlyToken() throws IOException
	{
		this.tcEntry.tcName="OnlyToken";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		setPush();
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
		setPush();
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
		setPush();
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
		setPush();
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
		setPush();
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
		setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
}
