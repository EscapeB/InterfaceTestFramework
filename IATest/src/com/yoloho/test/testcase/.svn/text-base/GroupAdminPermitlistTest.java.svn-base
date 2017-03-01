package com.yoloho.test.testcase;

import java.io.File;

import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class GroupAdminPermitlistTest {
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	//private String cancleId;
	public GroupAdminPermitlistTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupAdminPermitlistTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	 
//	public void GroupTransferRefuse() throws Exception{
//		BeforeTransferRefuse();
//		this.tcEntry.tcName="GroupTransferRefuse";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		tcEntry.jsonRequest.remove("id");
//		tcEntry.jsonRequest.put("id", cancleId);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//		
//	}
//	public void BeforeTransferRefuse(){
//		String url="https://forumapi.test.yoloho.com/group/transfer/push";
//		String req="{\"token\":\"104976828#9e05a6637a3e32fede635132d92a8b41\",\"touid\":\"104974037\",\"group_id\":\"150349\",\"intro\":\"pppp\"}";
//		JSONObject jsonrequest=JSONObject.fromObject(req);
//		String response=HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest),"UTF-8");
//		String url2="https://forumapi.test.yoloho.com/group/transfer/getlist";
//		String req2="{\"token\":\"104976828#9e05a6637a3e32fede635132d92a8b41\"}";
//		JSONObject jsonrequest2=JSONObject.fromObject(req2);
//		String response2=HttpsMethods.sendHttpsClientPost(url2, JSONUtility.JSON2Map(jsonrequest2),"UTF-8");
//		JSONObject jsonresponse2=JSONObject.fromObject(response2);
//		JSONObject json=JSONObject.fromObject(jsonresponse2.getJSONArray("list").get(0));
//		String transferId=json.get("id").toString();
////		JSONObject jsonresponse=JSONObject.fromObject(response);
////		JSONObject json=JSONObject.fromObject(jsonresponse.getJSONArray("list").get(0));
////		String transferId=json.get("id").toString();
//		cancleId=transferId;
//		System.out.println(cancleId);
//    }
	public void GroupAdminPermitlist() throws Exception{
		this.tcEntry.tcName="GroupAdminPermitlist";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
//	public void GroupTransferRefuse_Nullid() throws Exception{
//		this.tcEntry.tcName="GroupTransferRefuse_Nullid";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//	}
//	public void GroupTransferRefuse_NullGroupid() throws Exception{
//		this.tcEntry.tcName="GroupTransferRefuse_NullGroupid";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//	}
//	public void GroupTransferRefuse_WrongGroupid() throws Exception{
//		this.tcEntry.tcName="GroupTransferRefuse_WrongGroupid";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//	}
//	public void GroupTransferRefuse_Alreadyrefuse() throws Exception{
//		this.tcEntry.tcName="GroupTransferRefuse_Alreadyrefuse";
//		boolean result=false;
//		Testcase.getTestdata(this.tcEntry);
//		Testcase.getResponse(this.tcEntry);
//		result=Testcase.VerfyResult(this.tcEntry);
//		Testcase.UpdateTestResult(result,this.tcEntry);
//		this.tcm.updateTestResult(this.tcEntry);
//	}
	public void finalize(){
		this.tcEntry=null;
		this.tcm=null;
	}
}
