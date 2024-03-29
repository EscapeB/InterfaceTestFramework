package com.yoloho.test.framework.api;

import com.yoloho.test.framework.*;
import net.sf.json.*;

import java.io.IOException;
import java.util.*;
import java.sql.*;


public class Testcase {

	
	public static void getTestdata(TestcaseEntry tcentry) {	
		Logger.logMethodHeaderFooter(tcentry.logFile,"getTestdata","Begin");
		try{
			List<Map> testdata=ExcelFileManager.readData(tcentry.tcFilePathName,tcentry.TestSuitName);
			for(Map entry:testdata){
				if (entry.get("TestcaseName").equals(tcentry.tcName)){				
					//System.out.println(entry.get("Request").toString());
					Logger.log(tcentry.logFile,"Testcase:"+tcentry.tcName);					
	 				tcentry.jsonRequest= JSONObject.fromObject(entry.get("Request")); 	
	 				Logger.log(tcentry.logFile,"Request:"+tcentry.jsonRequest);
					tcentry.jsonExpectedResult=JSONObject.fromObject(entry.get("ExpectedResult"));
					Logger.log(tcentry.logFile,"ExpectedResult:"+tcentry.jsonExpectedResult);
					tcentry.jsonExpectedFormat=JSONObject.fromObject(entry.get("ExpetedResultFormat"));			
					Logger.log(tcentry.logFile,"ExpetedResultFormat:"+tcentry.jsonExpectedFormat);
					tcentry.APIURL=entry.get("API_URL").toString();
					Logger.log(tcentry.logFile,"APIURL:"+tcentry.APIURL);
					tcentry.Version=entry.get("Version").toString();
					Logger.log(tcentry.logFile,"Version:"+tcentry.Version);
					tcentry.Method=entry.get("Method").toString();
					Logger.log(tcentry.logFile,"Method:"+tcentry.Method);
					if(!entry.get("TestcaseID").getClass().getSimpleName().equals("Integer")){
						tcentry.tcId=Integer.parseInt(entry.get("TestcaseID").toString());	
						}
					else{
						tcentry.tcId=(int)entry.get("TestcaseID");
					}					
					Logger.log(tcentry.logFile,"TestcaseID:"+tcentry.tcId);					
					tcentry.tcType=entry.get("Type").toString();
					Logger.log(tcentry.logFile,"Type:"+tcentry.tcType);
					tcentry.APIType=entry.get("APIType").toString();
					Logger.log(tcentry.logFile,"APIType:"+tcentry.APIType);
					tcentry.NeedCheckValue=entry.get("NeedCheckValue").toString();
					Logger.log(tcentry.logFile,"NeedCheckValue:"+tcentry.NeedCheckValue);
				}
			}
		}
		catch(Exception e){
			Logger.log(tcentry.logFile, e.getMessage().toString());
		}
		Logger.logMethodHeaderFooter(tcentry.logFile,"getTestdata","End");
	}
	//public void TestcaseRun(TestcaseExecuter te)
	public static  boolean VerfyResult(TestcaseEntry tcentry){
		boolean result=false;
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:VerfyResult","Begin");
		
		if(ChkResponsedJSONSize(tcentry)){
			result=true;
			if(ChkResponsedKey( tcentry)){
				result=true;
				if(ChkResponsedFormat( tcentry)){
					result=true;
					if(tcentry.NeedCheckValue.toUpperCase().equals("TRUE")){
						if(ChkResponsedValue( tcentry)){result=true;	}
						else{	
							result=false;
							//check from database
								//if(chkResponsedValueFromDB(tcentry)){
								//	result=true;
								//}
							}
					}
				}
				else{
					result=false;
					}
				}
			else{
				result=false;
			}
			}
		else{
			result=false;
			}
		//ChkResponsedJSONSize(tcentry)==true&&ChkResponsedKey( tcentry)==true&&ChkResponsedValue( tcentry)==true&&ChkResponsedFormat( tcentry)==true?result=true:result=false;
		if(result){
			Logger.log(tcentry.logFile, "Testcase:" +tcentry.tcName + " PASS");
		}
		else{
			Logger.log(tcentry.logFile, "Testcase:" +tcentry.tcName + " FAIL");
		}
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:VerfyResult","End");
		return result;
	}
	public static void UpdateTestResult(boolean result,TestcaseEntry tcentry){
		if(!result){tcentry.tcResult="FAIL";}
		else{tcentry.tcResult="PASS";}
		
	}
	public static boolean ChkResponsedJSONSize(TestcaseEntry tcentry){
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:ChkResponsedJSONSize","Begin");
		boolean result=false;
		if(JSONUtility.Compare2JSONSize(tcentry.jsonResponse,tcentry.jsonExpectedResult)){result= true;}
		else{result=false;}
		Logger.log(tcentry.logFile, "ResponsedJSONSize: "+ tcentry.jsonResponse.size());
		Logger.log(tcentry.logFile, "ExpectedJSONSize: "+ tcentry.jsonExpectedResult.size());
		
		if(result){
			Logger.log(tcentry.logFile, "Method:ChkResponsedJSONSize, PASS");
		}
		else{
			Logger.log(tcentry.logFile, "Method:ChkResponsedJSONSize, FAIL");
		}
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:ChkResponsedJSONSize","End");
		return result;
	}
	public static void getResponse(TestcaseEntry tcentry){
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:getResponse","Begin");
		//System.out.println(tcentry.APIURL.trim().toLowerCase().substring(0,5));
		
		if(tcentry.APIURL.trim().toLowerCase().substring(0,5).equals("https")){
			if(tcentry.Method.toUpperCase().trim().equals("POST")){
				tcentry.jsonResponse=JSONUtility.String2JSON(HttpsMethods.sendHttpsClientPost(tcentry.APIURL,JSONUtility.JSON2Map(tcentry.jsonRequest) ,"utf-8"));	
			}
			if(tcentry.Method.toUpperCase().trim().equals("GET")){
				tcentry.jsonResponse=JSONUtility.String2JSON(HttpsMethods.sendHttpsClientGet(tcentry.APIURL,JSONUtility.JSON2Map(tcentry.jsonRequest) ,"utf-8"));
			}
			if(tcentry.Method.toUpperCase().trim().equals("ALL")){
				tcentry.jsonResponse=JSONUtility.String2JSON(HttpsMethods.sendHttpsClientGetPost(tcentry.APIURL,JSONUtility.JSON2Map(tcentry.jsonRequest) ,"utf-8"));
			}
		}
		else if(tcentry.APIURL.trim().substring(0,4).equals("http")){
			if(tcentry.Method.toUpperCase().trim().equals("POST")){
			tcentry.jsonResponse=JSONUtility.String2JSON(HttpMethods.sendHttpClientPost(tcentry.APIURL,JSONUtility.JSON2Map(tcentry.jsonRequest) ,"utf-8"));
			}
			if(tcentry.Method.toUpperCase().equals("GET")){
				tcentry.jsonResponse=JSONUtility.String2JSON(HttpMethods.sendHttpClientGet(tcentry.APIURL,JSONUtility.JSON2Map(tcentry.jsonRequest) ,"utf-8"));	
			}
		}		
		Logger.log(tcentry.logFile, tcentry.jsonResponse.toString());
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:getResponse","End");
		
		//System.out.println(tcentry.jsonResponse.toString());
	}
	private static boolean ChkResponsedKey(TestcaseEntry tcentry){
		/*
		Set<String> ExpectedKeys=null;
		Set<String> ResponsedKeys=null;
		boolean result=false;
		//String ExpectedKey=null,ResponsedKey=null;
		if(tcentry.jsonResponse==null){
			return false;
		}
		else{
			ResponsedKeys=tcentry.jsonResponse.keySet();
		}
		if(tcentry.jsonExpectedResult==null){
			ExpectedKeys=tcentry.jsonExpectedFormat.keySet();
		}
		else{
			ExpectedKeys=tcentry.jsonExpectedResult.keySet();
		}
		for(String responsedkey:ResponsedKeys){			
			for(String expectedkey:ExpectedKeys){
				if(responsedkey.equals(expectedkey)){
					result=true;
					break;
				}
				else
				{
					result=false;
				}
			}
			if(!result){
				return false;
			}
		}
		*/
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:ChkResponsedKey","Begin");
		boolean result=false;
		//if(JSONUtility.Compare2JSONKeys(tcentry.jsonResponse, tcentry.jsonExpectedResult)){
		//	result=true;
		//}
		Logger.log(tcentry.logFile, "ResponsedJSON:" +tcentry.jsonResponse.toString());		
		Logger.log(tcentry.logFile, "ExpectedJSON:" +tcentry.jsonExpectedResult.toString());
		
		try{
			result=JSONUtility.Compare2JSONKeys(tcentry.jsonResponse, tcentry.jsonExpectedResult);
		}
		catch(KeyErrorException e){
			result=false;
			Logger.log(tcentry.logFile,e.getMessage());
			//e.printStackTrace();			
		}
				
		if(result){
			Logger.log(tcentry.logFile, "Method:ChkResponsedKey, PASS");
		}
		else{
			Logger.log(tcentry.logFile, "Method:ChkResponsedKey, FAIL");
		}
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:ChkResponsedKey","End");
		return result;
		}
	private static boolean ChkResponsedValue(TestcaseEntry tcentry){
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:ChkResponsedValue","Begin");
		Logger.log(tcentry.logFile, "ResponsedJSON:" +tcentry.jsonResponse.toString());		
		Logger.log(tcentry.logFile, "ExpectedJSON:" +tcentry.jsonExpectedResult.toString());
		boolean result=false;
		//if(JSONUtility.Compare2JSONValues(tcentry.jsonResponse, tcentry.jsonExpectedResult)){result=true;}
		try{
			result=JSONUtility.Compare2JSONValues(tcentry.jsonResponse, tcentry.jsonExpectedResult);			
		}
		catch(ValueErrorException e){
			result=false;
			Logger.log(tcentry.logFile, e.getMessage());
			//e.printStackTrace();			
		}
		if(result){
			Logger.log(tcentry.logFile, "Method:ChkResponsedValue, PASS");
		}
		else{
			Logger.log(tcentry.logFile, "Method:ChkResponsedValue, FAIL");
		}
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:ChkResponsedValue","End");
		return result;
	}
	private static boolean ChkResponsedFormat(TestcaseEntry tcentry){
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:ChkResponsedFormat","Begin");
		Logger.log(tcentry.logFile, "ResponsedJSON:" +tcentry.jsonResponse.toString());		
		Logger.log(tcentry.logFile, "ExpectedJSONFormat:" +tcentry.jsonExpectedFormat.toString());
		boolean result=false;
		//if(JSONUtility.Compare2JSONTypes(tcentry.jsonResponse, tcentry.jsonExpectedFormat)){ result=true;}
		try{
			result=JSONUtility.Compare2JSONTypes(tcentry.jsonResponse, tcentry.jsonExpectedFormat);
		}
		catch(TypeErrorException e){
			result=false;
			Logger.log(tcentry.logFile, e.getMessage());
			//e.printStackTrace();				
		}
		if(result){
			Logger.log(tcentry.logFile, "Method:ChkResponsedFormat, PASS");
		}
		else{
			Logger.log(tcentry.logFile, "Method:ChkResponsedFormat, FAIL");
		}
		Logger.logMethodHeaderFooter(tcentry.logFile,"Method:ChkResponsedFormat","End");
			return result;
	}
	

}
