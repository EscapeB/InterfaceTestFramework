package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yoloho.test.framework.HttpsMethods;
import com.yoloho.test.framework.JSONUtility;
import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.JSONObject;

public class GroupAdminDelgroupTest {
	public TestcaseEntry tcEntry;
	public TestcaseManager tcm;
	private String delGroup_ids;
	public GroupAdminDelgroupTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupAdminDelgroupTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	public void AdminDelgroup() throws IOException{
		this.tcEntry.tcName="AdminDelgroup";
		boolean result=false;
		BeforeDelgroup();
		Testcase.getTestdata(this.tcEntry);
		tcEntry.jsonRequest.remove("group_ids");
		tcEntry.jsonRequest.put("group_ids", delGroup_ids);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void BeforeDelgroup(){
		Date date1 = new Date();//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss");
		String randomSign = sdf.format(date1);
		String url="https://forumapi.test.yoloho.com/group/group/create";
		String req="{\"cat_id\":3,\"title\":\""+randomSign+"\",\"token\":\"104976828#9e05a6637a3e32fede635132d92a8b41\",\"type\":1,\"tags\":\"xx\",\"descs\":\"sds\",\"files\":[{\"pic\":\"./testdata/pic/1.jpeg\"}]}";
		JSONObject jsonrequest=JSONObject.fromObject(req);
		String response=HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest),"UTF-8");
		JSONObject JsonResponse=JSONObject.fromObject(response);
		delGroup_ids=JsonResponse.getString("id");
		
		
	}
	public void AdminDelgroup_NullGroupid() throws Exception{
		this.tcEntry.tcName="AdminDelgroup_NullGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminDelgroup_WrongGroupid() throws Exception{
		this.tcEntry.tcName="AdminDelgroup_WrongGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminDelgroup_AlreadyDel() throws Exception{
		this.tcEntry.tcName="AdminDelgroup_AlreadyDel";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
}
