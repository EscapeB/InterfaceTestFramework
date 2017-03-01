package com.yoloho.test.testcase;

import java.io.File;
import java.io.IOException;
import com.yoloho.test.framework.*;
import com.yoloho.test.framework.api.Testcase;
import com.yoloho.test.framework.api.TestcaseEntry;

public class UserUpdateinfoTest 
{
	private TestcaseEntry tcEntry;
	//private TestcaseEntry tcTemp;
	private TestcaseManager tcm;
	
	public UserUpdateinfoTest(TestcaseManager tcmanager,String testsuitname,File logfile,String testdatapath)
	{
		this.tcEntry = new TestcaseEntry();
		this.tcEntry.tcFilePathName=testdatapath+"TC_UserUpdateinfoTest.xls";
		this.tcEntry.TestSuitName=testsuitname;
		this.tcEntry.logFile=logfile;
		this.tcm=tcmanager;
	}
	
	public void OnlyToken() throws IOException
	{
		this.tcEntry.tcName="OnlyToken";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AgeOnly() throws IOException
	{
		this.tcEntry.tcName="AgeOnly";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void AgeType() throws IOException
	{
		this.tcEntry.tcName="AgeType";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void PeriodOnly() throws IOException
	{
		this.tcEntry.tcName="PeriodOnly";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void PeriodType() throws IOException
	{
		this.tcEntry.tcName="PeriodType";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void CyleOnly() throws IOException
	{
		this.tcEntry.tcName="CyleOnly";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void CyleType() throws IOException
	{
		this.tcEntry.tcName="CyleType";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void MenarcheNum() throws IOException
	{
		this.tcEntry.tcName="MenarcheNum";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void MenaTimestamp() throws IOException
	{
		this.tcEntry.tcName="MenaTimestamp";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void MenaType() throws IOException
	{
		this.tcEntry.tcName="MenaType";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void Last_period() throws IOException
	{
		this.tcEntry.tcName="Last_period";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void Recent_symptom() throws IOException
	{
		this.tcEntry.tcName="Recent_symptom";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void Recent_symptom_user() throws IOException
	{
		this.tcEntry.tcName="Recent_symptom_user";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
	public void Extra_info() throws IOException
	{
		this.tcEntry.tcName="Extra_info";
		boolean result=false;
		Testcase.getTestdata(this.tcEntry);	
		//setPush();
		Testcase.getResponse(this.tcEntry);
		result=Testcase.VerfyResult(this.tcEntry);
		Testcase.UpdateTestResult(result,this.tcEntry);
		this.tcm.updateTestResult(this.tcEntry);
	}
}
