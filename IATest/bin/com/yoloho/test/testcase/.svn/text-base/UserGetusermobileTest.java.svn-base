package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class UserGetusermobileTest {
	private TestcaseEntry tcEntry;
	private TestcaseManager tcm;
	

	public UserGetusermobileTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserGetusermobileTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	
	public void Getusermobile_g1() throws IOException
	{
		
		this.tcEntry.tcName="Getusermobile_g1";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("GroupTagTaglistTest:TaglistTest");
		//System.out.println(this.tcEntry.jsonExpectedResult);
	}
	
	public void Getusermobile_g4() throws IOException
	{
		
		this.tcEntry.tcName="Getusermobile_g4";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);
		//this.preCondition();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
		//System.out.println("GroupTagTaglistTest:TaglistTest");
		//System.out.println(this.tcEntry.jsonExpectedResult);
	}
	
	//user login
		public void                                                                                          preCondition(){
			TestcaseEntry precondition = new TestcaseEntry();
			//String strJSONRequest="{\"username\":\"g1\",\"password\":\"1\"}";
			String strJSONRequest="{\"token\": \"104974037#8e8cb8a1a63ba0750a10a4a12af65e49\"}";
			precondition.jsonRequest=JSONUtility.String2JSON(strJSONRequest);
			Testcase.getResponse(precondition);
			Map<String,Object> map = new HashMap<String,Object>();
			String result=null;
			map.put("token", "104974037#8e8cb8a1a63ba0750a10a4a12af65e49");
			result=HttpMethods.sendHttpClientGet(this.tcEntry.APIURL, map);
			
			System.out.println(result);
				
		}
			/*
			public void UserPointsTest(){
				this.preCondition();	//user login
				
			}
			*/
}
