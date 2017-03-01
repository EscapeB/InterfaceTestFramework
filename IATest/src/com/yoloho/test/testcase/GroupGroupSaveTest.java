package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.yoloho.test.framework.TestcaseManager;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class GroupGroupSaveTest {
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	
	public GroupGroupSaveTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath){
		this.tcEntry = new TestcaseEntry();
		//this.tcEntry.tcFilePathName="./testdata/TC_UserLoginTest.xls";
		this.tcEntry.tcFilePathName=testdatapath+"TC_GroupGroupSaveTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		//this.tcEntry.tcLogFilePathName=logfile.getAbsolutePath();
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	public void GroupSave() throws IOException{
		this.tcEntry.tcName="GroupSave";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		String str=tcEntry.jsonRequest.get("title").toString();
		//UUID randomSign=UUID.randomUUID();
		Date date1 = new Date();//获取当前时间
		SimpleDateFormat sdf = new SimpleDateFormat("dd-HH-mm-ss");
		String randomSign = sdf.format(date1);
		str=randomSign;
		System.out.println(str);
		tcEntry.jsonRequest.remove("title");
		tcEntry.jsonRequest.put("title", randomSign);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupSaveNoCat_id() throws Exception{
		this.tcEntry.tcName="GroupSaveNoCat_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupSaveWrongCat_id() throws Exception{
		this.tcEntry.tcName="GroupSaveWrongCat_id";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupSaveTitle_repeat() throws Exception{
		this.tcEntry.tcName="GroupSaveTitle_repeat";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupSaveWrongType() throws Exception{
		this.tcEntry.tcName="GroupSaveWrongType";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void GroupSaveWithoutPic() throws Exception{
		this.tcEntry.tcName="GroupSaveWithoutPic";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
}
