package com.yoloho.test.framework;


import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import com.yoloho.test.framework.api.TestcaseEntry;

public class TestcaseManager {

private String strTCControllerFilePathName;
private List<Map> TestSuit;
private List<Map> TestTask;
private String strResultPath;
private String strTestSuitName;
private String strHTMLReportPathName;
private String strStartTime;
private String strEndTime;
private int intTotalTestcase;
private int intPassedTestcase;
private int intFailedTestcase;
private float fltPassrate;

private String strEmailToList;
private String strEmailFrom;
private String strEmailServerAddress;
private int intEmailPort;
private String strEmailUserName;
private String strEmailPassword;
private String strLogPath;
private String strLogURL;
private String strTestdataPath;


	public TestcaseManager(String tccontrollerfilepathname,String strresultpath,String strreportpath){
		this.strTCControllerFilePathName = tccontrollerfilepathname;
		this.TestSuit=null;
		this.TestTask=new ArrayList<Map>();
		this.strResultPath=strresultpath;
		this.strTestSuitName="";
		this.strHTMLReportPathName=strreportpath;
		this.intTotalTestcase=0;
		this.intPassedTestcase=0;
		this.intFailedTestcase=0;
		this.fltPassrate=0;
		
		//this.strEmailToList="liubin@dayima.com;gengdongya@dayima.com;chenzhelong@dayima.com";
		this.strEmailToList="chenzhelong@dayima.com";
	}
	public TestcaseManager(Config config){
		this.strTCControllerFilePathName = config.getControllerFileName();
		this.TestSuit=null;
		this.TestTask=new ArrayList<Map>();
		this.strResultPath=config.getTestResultPath();
		this.strTestSuitName="";
		this.strHTMLReportPathName=config.getHtmlReportPath();
		this.intTotalTestcase=0;
		this.intPassedTestcase=0;
		this.intFailedTestcase=0;
		this.fltPassrate=0;
		//this.strEmailToList="liubin@dayima.com;gengdongya@dayima.com;chenzhelong@dayima.com";
		this.strEmailToList=config.getEmailTo();
		this.strEmailFrom=config.getEmailFrom();
		this.strEmailServerAddress=config.getEmailServerAddress();
		this.intEmailPort=config.getEmailServerPort();
		this.strEmailUserName=config.getEmailUserName();
		this.strEmailPassword=config.getEmailUserPassword();
		this.strLogPath=config.getLogPath();
		this.strLogURL=config.getLogURL();
		this.strTestdataPath=config.getTestDataPath();
		
	}
	private void getSingleInterfaceTestSuit(){		
		try {
			this.TestSuit = ExcelFileManager.readData(this.strTCControllerFilePathName,"SingleInterface");
			this.strTestSuitName="SingleInterface";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void getCombineInterfaceTestSuit(){
		try {
			this.TestSuit = ExcelFileManager.readData(this.strTCControllerFilePathName,"CombineInterface");
			this.strTestSuitName="CombineInterface";
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void getTestTask(String testType){
	
		switch (testType){
			case "SingleInterfaceTest": {
				
				this.getSingleInterfaceTestSuit();
				this.createTestResultExcelFile();
				
				break;
			}
			case "CombinInterfaceTest":{
				//this.getCombineInterfaceTestSuit();
				break;
			}
		}
		//this.getSingleInterfaceTestSuit();
		if(this.TestSuit!=null){
			for(Map<String, Object> i: this.TestSuit){
				if(i.get("isRun").equals("TRUE")){
					//System.out.println("Hello");
					this.TestTask.add(i);
				}				
			}			
			//System.out.println(this.TestTask);			
		}		
	}
	public void runTestTask() {
		String APIName=this.TestTask.get(0).get("APIName").toString();
		String ScriptName=this.TestTask.get(0).get("ScriptName").toString();
		String TestcaseName=this.TestTask.get(0).get("TestcaseName").toString();
		//File logFile=Logger.createLogFile("./log/", ScriptName);
		File logFile=Logger.createLogFile(this.strLogPath, ScriptName);
		Logger.logTestScriptHeaderFooter(logFile,ScriptName,"Start");
		String logContent=null;
		
		this.intTotalTestcase=this.TestTask.size();
		for(Map<String,Object> i: this.TestTask){			
			if (!i.get("APIName").equals(APIName)){
				APIName = i.get("APIName").toString();
			}
			if(!i.get("ScriptName").equals(ScriptName)){
				Logger.logTestScriptHeaderFooter(logFile,ScriptName,"End");
				ScriptName=i.get("ScriptName").toString();
				//logFile=Logger.createLogFile("./log/", ScriptName);
				logFile=Logger.createLogFile(this.strLogPath, ScriptName);
				Logger.logTestScriptHeaderFooter(logFile,ScriptName,"Start");				
			}
			
			if(!i.get("TestcaseName").equals(TestcaseName)){
				TestcaseName=i.get("TestcaseName").toString();
			}
			try {
				
				TestcaseExecuter.run(ScriptName, TestcaseName,this,this.strTestSuitName,logFile,this.strTestdataPath);
			} catch (MalformedURLException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException |InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	

		}
		Logger.logTestScriptHeaderFooter(logFile,ScriptName,"End");
		System.out.println("**************Test End****************");
	}
	private void createTestResultExcelFile() {
		// TODO Auto-generated method stub
		this.strResultPath=ExcelFileManager.CreateExcelFile(this.strResultPath,this.strTestSuitName);
	}
	public void updateTestResult(TestcaseEntry tcentry) throws IOException{
		
		ExcelFileManager.AppendToTestResult(this.strResultPath,tcentry);
		if(tcentry.tcResult.trim().toUpperCase().equals("PASS")){
			this.intPassedTestcase++;
		}
		else if(tcentry.tcResult.trim().toUpperCase().equals("FAIL")){
			this.intFailedTestcase++;
		}
	}
	private String formatDateTime(){
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=format.format(date); 
		return time;
	}
	private String getDateTime(){
		return this.formatDateTime();
	}
	public void setStartDateTime(){
		this.strStartTime=getDateTime();
	}
	public void setEndDateTime(){
		this.strEndTime=getDateTime();
	}
	public void createHTMLReport(){
		this.strHTMLReportPathName= htmlReportManager.createHTMLReport(this.strHTMLReportPathName,
				this.strTestSuitName,this.strStartTime, this.strEndTime, this.intTotalTestcase,this.intPassedTestcase, 
				this.intFailedTestcase, this.fltPassrate,this.strResultPath,this.strLogURL);
		
	}
	public void calcPassrate(){
		if(this.intTotalTestcase>0){
			this.fltPassrate=((float)(this.intPassedTestcase)/(float)(this.intTotalTestcase));
			//this.fltPassrate=(Math.round(this.fltPassrate*100)/100);
			this.fltPassrate*=100;
		}
		else{
			this.fltPassrate=0;
		}
	}
	public void sendHTMLReport(){
		try {
			try {
				//ReportEmailUtility.sendReportEmail(this.strHTMLReportPathName,this.strEmailToList);
				ReportEmailUtility.sendReportEmail(this.strHTMLReportPathName,this.strEmailToList,this.strEmailFrom,this.strEmailServerAddress,this.intEmailPort,this.strEmailUserName,this.strEmailPassword);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		int a,b;
		float c,d;
		a =1;
		b=1000;
		c=(float)a/(float)b;
		//c=(Math.round(c*100)/100);
		d=(float)(Math.round(c*100)/100);
		
	}
}
