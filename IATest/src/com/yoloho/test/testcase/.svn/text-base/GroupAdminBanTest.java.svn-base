package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;

import com.yoloho.test.framework.HttpsMethods;
import com.yoloho.test.framework.JSONUtility;
import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.JSONObject;

public class GroupAdminBanTest {
	public TestcaseEntry tcEntry;
	public TestcaseManager tcm;

	// private String replylikeId;
	public GroupAdminBanTest(TestcaseManager tcmanager, String testsuitname, File logfile, String testdatapath) {
		this.tcEntry = new TestcaseEntry();
		// this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName = testdatapath + "TC_GroupAdminBanTest.xls";
		this.tcEntry.TestSuitName = testsuitname;
		// this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile = logfile;
		this.tcm = tcmanager;
	}

	public void AdminBan() throws IOException {
		//BeforeBanlist();
		this.tcEntry.tcName = "AdminBan";
		boolean result = false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result = Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result, this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterBan();
	}

	public void BeforeBan() {
		String url = "https://forumapi.test.yoloho.com/group/admin/ban";
		String req = "{\"token\":\"104974037#8e8cb8a1a63ba0750a10a4a12af65e49\",\"group_id\":\"150392\",\"uid\":\"104976828\",\"reason\":\"yayya\"}";
		JSONObject jsonrequest = JSONObject.fromObject(req);
		String response = HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest), "UTF-8");
		//System.out.println(response);

	}

	public void AfterBan() {
		String url = "https://forumapi.test.yoloho.com/group/admin/delban";
		String req = "{\"token\":\"104974037#8e8cb8a1a63ba0750a10a4a12af65e49\",\"group_id\":\"150392\",\"uid\":\"104976828\"}";
		JSONObject jsonrequest = JSONObject.fromObject(req);
		String response = HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest), "UTF-8");
		//System.out.println(response);
	}
	public void AdminBan_WrongUid() throws Exception{
		this.tcEntry.tcName="AdminBan_WrongUid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminBan_NullUid() throws Exception{
		this.tcEntry.tcName="AdminBan_NullUid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminBan_WrongGroupid() throws Exception{
		this.tcEntry.tcName="AdminBan_WrongGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminBan_NullGroupid() throws Exception{
		this.tcEntry.tcName="AdminBan_NullGroupid";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AdminBan_NullReason() throws Exception{
		this.tcEntry.tcName="AdminBan_NullReason";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterBan();
	}
	public void AdminBan_AlreadyBan() throws Exception{
		BeforeBan();
		this.tcEntry.tcName="AdminBan_AlreadyBan";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterBan();
	}
	
}
