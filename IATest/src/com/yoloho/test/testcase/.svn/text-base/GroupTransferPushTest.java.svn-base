package com.yoloho.test.testcase;

import java.io.File;

import com.yoloho.test.framework.HttpMethods;
import com.yoloho.test.framework.HttpsMethods;
import com.yoloho.test.framework.JSONUtility;
import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.JSONObject;

public class GroupTransferPushTest {
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	public GroupTransferPushTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupTransferPushTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	 
	public void GroupTransferPush() throws Exception{
		this.tcEntry.tcName="GroupTransferPush";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//AfterTransferPush();
		
	}
	public void AfterTransferPush(){
		String url="https://forumapi.test.yoloho.com/group/transfer/getlist";
		String req="{\"token\":\"104976828#9e05a6637a3e32fede635132d92a8b41\"}";
		JSONObject jsonrequest=JSONObject.fromObject(req);
		String response=HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest),"UTF-8");
		JSONObject jsonresponse=JSONObject.fromObject(response);
		JSONObject json=JSONObject.fromObject(jsonresponse.getJSONArray("list").get(0));
		String transferId=json.get("id").toString();
		
        TestcaseEntry tc = tcEntry;       
        tc.APIURL = "https://forumapi.test.yoloho.com/group/transfer/cancel";
        //Testcase.getResponse(tc);
        tc.jsonRequest=JSONObject.fromObject("{\"token\":\"104976828#9e05a6637a3e32fede635132d92a8b41\",\"group_id\" :\"150349\",\"id\":\""+transferId+"\"}");
        if(tc.APIURL.trim().toLowerCase().substring(0,5).equals("https")){
            tc.jsonResponse=JSONUtility.String2JSON(HttpsMethods.sendHttpsClientPost(tc.APIURL,JSONUtility.JSON2Map(tc.jsonRequest) ,"utf-8"));   
        }
        else if(tc.APIURL.trim().substring(0,4).equals("http")){
            tc.jsonResponse=JSONUtility.String2JSON(HttpMethods.sendHttpClientPost(tc.APIURL,JSONUtility.JSON2Map(tc.jsonRequest) ,"utf-8"));
        }
    }
	public void GroupTransferPush_WrongGroupid() throws Exception{
		this.tcEntry.tcName="GroupTransferPush_WrongGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupTransferPush_WrongUid() throws Exception{
		this.tcEntry.tcName="GroupTransferPush_WrongUid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupTransferPush_AlreadyPush() throws Exception{
		
		this.tcEntry.tcName="GroupTransferPush_AlreadyPush";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterTransferPush();
	}
	public void GroupTransferPush_NullGroupid() throws Exception{
		this.tcEntry.tcName="GroupTransferPush_NullGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupTransferPush_NullUid() throws Exception{
		this.tcEntry.tcName="GroupTransferPush_NullUid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupTransferPush_NullIntro() throws Exception{
		this.tcEntry.tcName="GroupTransferPush_NullIntro";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterTransferPush();
	}
	
	public void finalize(){
		this.tcEntry=null;
		this.tcm=null;
	}
}
