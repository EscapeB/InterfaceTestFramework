package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;

import com.yoloho.test.framework.HttpsMethods;
import com.yoloho.test.framework.JSONUtility;
import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

import net.sf.json.JSONObject;

public class GroupAdminPermitTest {
	public TestcaseEntry tcEntry;
	public TestcaseManager tcm;
private String perimitId;
	public GroupAdminPermitTest(TestcaseManager tcmanager, String testsuitname, File logfile, String testdatapath) {
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName = testdatapath + "TC_GroupAdminPermitTest.xls";
		this.tcEntry.TestSuitName = testsuitname;
		this.tcEntry.logFile = logfile;
		this.tcm = tcmanager;
	}

	public void AdminPermit_status1() throws IOException {
		BeforeAdminPermit();
		this.tcEntry.tcName = "AdminPermit_status1";
		boolean result = false;
		Testcase.getTestdata(this.tcEntry);
		tcEntry.jsonRequest.remove("id");
		tcEntry.jsonRequest.put("id", perimitId);
		Testcase.getResponse(this.tcEntry);
		result = Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result, this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		AfterAdminPermit();
	}

	public void AdminPermit_status2() throws IOException {
		BeforeAdminPermit();
		this.tcEntry.tcName = "AdminPermit_status2";
		boolean result = false;
		Testcase.getTestdata(this.tcEntry);
		tcEntry.jsonRequest.remove("id");
		tcEntry.jsonRequest.put("id", perimitId);
		Testcase.getResponse(this.tcEntry);
		result = Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result, this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//AfterAdminPermit();
	}

	public void AdminPermit_statusother() throws IOException {
		this.tcEntry.tcName = "AdminPermit_statusother";
		boolean result = false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result = Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result, this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);

	}

	public void AdminPermit_WrongGroupid() throws IOException {

		this.tcEntry.tcName = "AdminPermit_WrongGroupid";
		boolean result = false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result = Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result, this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);

	}

	public void AdminPermit_NullGroupid() throws IOException {

		this.tcEntry.tcName = "AdminPermit_NullGroupid";
		boolean result = false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result = Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result, this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}

	public void AdminPermit_wrongid() throws IOException {

		this.tcEntry.tcName = "AdminPermit_wrongid";
		boolean result = false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result = Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result, this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);

	}

	public void BeforeAdminPermit() {
		String url = "https://forumapi.test.yoloho.com/group/group/apply";
		String req ="{\"group_id\":\"150392\",\"reason\":\"xxxxx\",\"token\":\"104974038#42590d6e058af30a515aabe651adbd90\"}";
		JSONObject jsonrequest = JSONObject.fromObject(req);
		String response = HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest), "UTF-8");
		String url2 = "https://forumapi.test.yoloho.com/group/admin/permitlist";
		String req2="{\"token\":\"104974037#8e8cb8a1a63ba0750a10a4a12af65e49\",\"group_id\":\"150392\"}";
		JSONObject jsonrequest2=JSONObject.fromObject(req2);
		String response2=HttpsMethods.sendHttpsClientPost(url2, JSONUtility.JSON2Map(jsonrequest2), "UTF-8");
		JSONObject result=JSONObject.fromObject(response2).getJSONArray("list").getJSONObject(0);
		perimitId=result.get("id").toString();
	}

	public void AfterAdminPermit() {
		String url = "https://forumapi.test.yoloho.com/group/group/quit";
		String req = "{\"token\":\"104974038#42590d6e058af30a515aabe651adbd90\",\"group_id\":\"150392\"}";
		JSONObject jsonrequest = JSONObject.fromObject(req);
		String response = HttpsMethods.sendHttpsClientPost(url, JSONUtility.JSON2Map(jsonrequest), "UTF-8");
		// System.out.println(response);
	}
}
