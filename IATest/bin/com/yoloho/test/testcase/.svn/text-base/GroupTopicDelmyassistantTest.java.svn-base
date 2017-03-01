package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;

import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class GroupTopicDelmyassistantTest {
	public TestcaseEntry tcEntry;
	public TestcaseManager tcm;
	
	public GroupTopicDelmyassistantTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupTopicDelmyassistantTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	public void TopicDelmyassistant() throws IOException{
		this.tcEntry.tcName="TopicDelmyassistant";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//AfterCreatGroup();
	}
/*	public void AfterCreatGroup(){
		TestcaseEntry t=this.tcEntry;
		//System.out.println(tcEntry.jsonResponse.toString());
		String response_id=t.jsonResponse.get("id").toString();
		System.out.println(response_id);
		t.APIURL="https://forumapi.test.yoloho.com/group/admin/delgroup";
		String req1="{\"group_ids\":\""+response_id+"\",\"token\":\"104974038#42590d6e058af30a515aabe651adbd90\"}";
		t.jsonRequest=JSONObject.fromObject(req1);
	   Testcase.getResponse(t);
	   System.out.println(t.jsonResponse.toString());
		
		
	}*/
	/*public void GroupCreateNoCat_id() throws Exception{
		this.tcEntry.tcName="GroupCreateNoCat_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupCreateWrongCat_id() throws Exception{
		this.tcEntry.tcName="GroupCreateWrongCat_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupCreateTitle_repeat() throws Exception{
		this.tcEntry.tcName="GroupCreateTitle_repeat";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupCreateWrongType() throws Exception{
		this.tcEntry.tcName="GroupCreateWrongType";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupCreateWithoutPic() throws Exception{
		this.tcEntry.tcName="GroupCreateWithoutPic";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}*/
}
