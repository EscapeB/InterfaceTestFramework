package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.JSONObject;

public class GroupTopicReplyTest {
	public TestcaseEntry tcEntry;
	public TestcaseManager tcm;
	
	public GroupTopicReplyTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupTopicReplyTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	public void TopicReplyTopic() throws IOException{
		this.tcEntry.tcName="TopicReplyTopic";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		String str=tcEntry.jsonRequest.get("content").toString();
		//UUID randomSign=UUID.randomUUID();
		Date date1 = new Date();//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss");
		String randomSign = sdf.format(date1);
		str=randomSign;
		System.out.println(str);
		tcEntry.jsonRequest.remove("content");
		tcEntry.jsonRequest.put("content", randomSign);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterReply_01();
	}
	public void AfterReply_01(){
		TestcaseEntry t=this.tcEntry;
		System.out.println("sssssssssssssssssssssssssss"+tcEntry.jsonResponse.toString());
		String response_id=t.jsonResponse.get("id").toString();
		System.out.println(response_id);
		t.APIURL="https://forumapi.test.yoloho.com/group/admin/delreply";
		String req1="{\"reply_id\":\""+response_id+"\",\"token\":\"104974037#8e8cb8a1a63ba0750a10a4a12af65e49\"}";
		t.jsonRequest=JSONObject.fromObject(req1);
	   Testcase.getResponse(t);
	   System.out.println(""+t.jsonResponse.toString());
		
		
	}
	public void TopicReplyOthersReply() throws Exception{
		this.tcEntry.tcName="TopicReplyOthersReply";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		String str=tcEntry.jsonRequest.get("content").toString();
		//UUID randomSign=UUID.randomUUID();
		Date date1 = new Date();//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss");
		String randomSign = sdf.format(date1);
		str=randomSign;
		System.out.println(str);
		tcEntry.jsonRequest.remove("content");
		tcEntry.jsonRequest.put("content", randomSign);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterReply_01();
	}
	public void TopicWrongTopic_id() throws Exception{
		this.tcEntry.tcName="TopicWrongTopic_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void TopicWrongReply_id() throws Exception{
		this.tcEntry.tcName="TopicWrongReply_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void TopicReplyWithoutPic() throws Exception{
		this.tcEntry.tcName="TopicReplyWithoutPic";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		String str=tcEntry.jsonRequest.get("content").toString();
		//UUID randomSign=UUID.randomUUID();
		Date date1 = new Date();//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss");
		String randomSign = sdf.format(date1);
		str=randomSign;
		System.out.println(str);
		tcEntry.jsonRequest.remove("content");
		tcEntry.jsonRequest.put("content", randomSign);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterReply_01();
	}
	public void TopicReplyNullContent() throws Exception{
		this.tcEntry.tcName="TopicReplyNullContent";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		String str=tcEntry.jsonRequest.get("content").toString();
		//UUID randomSign=UUID.randomUUID();
		Date date1 = new Date();//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss");
		String randomSign = sdf.format(date1);
		str=randomSign;
		System.out.println(str);
		tcEntry.jsonRequest.remove("content");
		tcEntry.jsonRequest.put("content", randomSign);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
	
		this.tcm.updateTestResult(this.tcEntry);
	    AfterReply_01();
	}
}
