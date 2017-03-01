package com.yoloho.test.framework.api;

import java.io.File;

import net.sf.json.JSONObject;

public class TestcaseEntry {

	public JSONObject jsonRequest;
	public JSONObject jsonResponse;
	public JSONObject jsonExpectedResult;
	public JSONObject jsonExpectedFormat; 
	public String tcName;
	public int tcId;
	public String APIURL;
	public String Version;
	public String Method;
	public String tcFilePathName;
	public String tcType;
	public String TestSuitName;
	public String tcResult;
	public File logFile;
	public String APIType;
	public String NeedCheckValue;
	public TestcaseEntry(){
		this.jsonRequest=null;
		this.jsonResponse=null;
		this.jsonExpectedResult=null;
		this.jsonExpectedFormat=null;
		this.tcName="";
		this.tcId=0;
		this.APIURL="";
		this.Version="";
		this.Method="";
		this.tcFilePathName="";
		this.tcResult="";
		this.TestSuitName="";
		this.logFile=null;
		this.APIType="";
		this.NeedCheckValue="";
	}
	
}
