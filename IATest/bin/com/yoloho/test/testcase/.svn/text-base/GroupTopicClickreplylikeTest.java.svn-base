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

public class GroupTopicClickreplylikeTest {
	public TestcaseEntry tcEntry;
	public TestcaseManager tcm;
	private String replylikeId;
	public GroupTopicClickreplylikeTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupTopicClickreplylikeTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	public void TopicClickreplylike() throws IOException{
		BeforeReplyLike();
		this.tcEntry.tcName="TopicClickreplylike";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		tcEntry.jsonRequest.remove("reply_id");
		tcEntry.jsonRequest.put("reply_id", this.replylikeId);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//AfterCreatGroup();
	}
	public void BeforeReplyLike(){
		Date date1 = new Date();//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss");
		String randomSign = sdf.format(date1);

		String url="https://forumapi.test.yoloho.com/group/topic/reply";
		String req="{\"topic_id\":\"8316129\",\"reply_id\":\"\",\"token\":\"104976828#9e05a6637a3e32fede635132d92a8b41\",\"content\":\""+randomSign+"\"}";
		JSONObject jsonrequest=JSONObject.fromObject(req);
		String response=HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest),"UTF-8");
		JSONObject jsonresponse=JSONObject.fromObject(response);
		//Testcase.getResponse(t);
		
		String response_id=jsonresponse.get("id").toString();
		this.replylikeId=response_id;
//		System.out.println(response_id);
//		t.APIURL="https://forumapi.test.yoloho.com/group/admin/delgroup";
//		String req1="{\"group_ids\":\""+response_id+"\",\"token\":\"104974038#42590d6e058af30a515aabe651adbd90\"}";
//		t.jsonRequest=JSONObject.fromObject(req1);
//	   Testcase.getResponse(t);
//	   System.out.println(t.jsonResponse.toString());
		
		
	}
	public void TopicClickreplylikeAlready() throws Exception{
		this.tcEntry.tcName="TopicClickreplylikeAlready";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
//	public void GroupCreateWrongCat_id() throws Exception{
//		this.tcEntry.tcName="GroupCreateWrongCat_id";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//	}
//	public void GroupCreateTitle_repeat() throws Exception{
//		this.tcEntry.tcName="GroupCreateTitle_repeat";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//	}
//	public void GroupCreateWrongType() throws Exception{
//		this.tcEntry.tcName="GroupCreateWrongType";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//	}
//	public void GroupCreateWithoutPic() throws Exception{
//		this.tcEntry.tcName="GroupCreateWithoutPic";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//	}*/
}
