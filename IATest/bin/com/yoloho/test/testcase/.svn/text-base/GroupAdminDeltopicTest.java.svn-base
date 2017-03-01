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

public class GroupAdminDeltopicTest {
	public TestcaseEntry tcEntry;
	public TestcaseManager tcm;
	private String topicid;
	public GroupAdminDeltopicTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupAdminDeltopicTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	public void AdminDeltopic() throws IOException{
		BeforeTopicDel();
		this.tcEntry.tcName="AdminDeltopic";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		tcEntry.jsonRequest.remove("topic_id");
		tcEntry.jsonRequest.put("topic_id", this.topicid);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//AfterCreatGroup();
	}
	public void BeforeTopicDel(){
		Date date1 = new Date();//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss");
		String randomSign = sdf.format(date1);
		String url="https://forumapi.test.yoloho.com/group/topic/post";
		String req="{\"group_id\":\"150190\",\"title\":\""+randomSign+"\",\"token\":\"104976828#9e05a6637a3e32fede635132d92a8b41\",\"content\":\"hahahah\",\"files\":[{\"head_pic\":\"./testdata/pic/6.jpeg\"}]}";
		JSONObject jsonrequest=JSONObject.fromObject(req);
		String response=HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest),"UTF-8");
		JSONObject jsonresponse=JSONObject.fromObject(response);
		//Testcase.getResponse(t);
		String response_id=jsonresponse.get("id").toString();
		this.topicid=response_id;
//		System.out.println(response_id);
//		t.APIURL="https://forumapi.test.yoloho.com/group/admin/delgroup";
//		String req1="{\"group_ids\":\""+response_id+"\",\"token\":\"104974038#42590d6e058af30a515aabe651adbd90\"}";
//		t.jsonRequest=JSONObject.fromObject(req1);
//	   Testcase.getResponse(t);
//	   System.out.println(t.jsonResponse.toString());
		
		
	}
	public void AdminDeltopic_NullTopicid() throws Exception{
		this.tcEntry.tcName="AdminDeltopic_NullTopicid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminDeltopic_WrongTopicid() throws Exception{
		this.tcEntry.tcName="AdminDeltopic_WrongTopicid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminDeltopic_AlreadyDel() throws Exception{
		this.tcEntry.tcName="AdminDeltopic_AlreadyDel";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminDelreply_NullReason() throws Exception{
		BeforeTopicDel();
		this.tcEntry.tcName="AdminDelreply_NullReason";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		tcEntry.jsonRequest.remove("topic_id");
		tcEntry.jsonRequest.put("topic_id", this.topicid);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
}
