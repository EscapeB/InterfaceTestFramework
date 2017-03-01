package com.yoloho.test.testcase;

import java.io.File;

import com.yoloho.test.framework.HttpMethods;
import com.yoloho.test.framework.HttpsMethods;
import com.yoloho.test.framework.JSONUtility;
import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.JSONObject;

public class GroupGroupQuitTest {
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	
	public GroupGroupQuitTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupGroupQuitTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	 
	public void GroupQiut() throws Exception{
		beforetest_01();
		this.tcEntry.tcName="GroupQiut";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		
	}
	public void beforetest_01(){
        TestcaseEntry tc = tcEntry;       
        tc.APIURL = "https://forumapi.test.yoloho.com/group/group/apply";
        //Testcase.getResponse(tc);
        tc.jsonRequest=JSONObject.fromObject("{\"token\":\"104976828#9e05a6637a3e32fede635132d92a8b41\",\"group_id\" :9}");
        if(tc.APIURL.trim().toLowerCase().substring(0,5).equals("https")){
            tc.jsonResponse=JSONUtility.String2JSON(HttpsMethods.sendHttpsClientPost(tc.APIURL,JSONUtility.JSON2Map(tc.jsonRequest) ,"utf-8"));   
        }
        else if(tc.APIURL.trim().substring(0,4).equals("http")){
            tc.jsonResponse=JSONUtility.String2JSON(HttpMethods.sendHttpClientPost(tc.APIURL,JSONUtility.JSON2Map(tc.jsonRequest) ,"utf-8"));
        }
    }
	public void GroupQiutWrongGroup_id() throws Exception{
		this.tcEntry.tcName="GroupQiutWrongGroup_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupQiutNoGroup_id() throws Exception{
		this.tcEntry.tcName="GroupQiutNoGroup_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupQiutNullGroup_id() throws Exception{
		this.tcEntry.tcName="GroupQiutNullGroup_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void finalize(){
		this.tcEntry=null;
		this.tcm=null;
	}
}
