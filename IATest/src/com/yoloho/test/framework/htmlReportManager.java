package com.yoloho.test.framework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class htmlReportManager {

	public static String createHTMLReport(String path,String strTestSuit,String strStart,String strEnd,int totalCase,int passedCase,int failedCase,float passrate,String result,String strLogURL){
		String HTMLReportFilePathName=null;
		File htmlreport=null;
		HTMLReportFilePathName = makeHTMLReportFileName(path);
		htmlreport = new File(HTMLReportFilePathName);
		while( htmlreport.exists()){
			HTMLReportFilePathName = makeHTMLReportFileName(path);
			htmlreport = new File(HTMLReportFilePathName);
		}	
			try {
				htmlreport.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			drawReportCSS(HTMLReportFilePathName);
			drawReportHeader(HTMLReportFilePathName);
			drawReportSummary(HTMLReportFilePathName,strTestSuit,strStart,strEnd,totalCase,passedCase,failedCase,passrate);
			drawReportDetails(HTMLReportFilePathName,result,strTestSuit,strLogURL);
			drawReportFooter(HTMLReportFilePathName);
		return HTMLReportFilePathName;
		
	}
	private static String  makeHTMLReportFileName(String path){
		String filename="";
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time=format.format(date); 
		filename="TestReport"+time+".html";
		filename=path+filename;
		return filename;
	}
	private static void drawReportCSS(String report){
		String css=null;
		css="<style type=\"text/css\">"
				+ "	    body{"
				+ "  font:normal 95% helvetica;"
				+ " color:#000000;"
				+ " }"
				+ " table tr td, table tr th {"
				+ "font-size: 85%;"
				+ " }"
				+ " table.details tr th{"
				+ "  font-weight: bold;"
				+ "  text-align:center;"
				+ " background:#a6caf0;"
				+ "vertical-align: middle;"
				+ " }"
				+ " table.details tr td{"
				+ " background:#eeeee0;"
				+ " }"
				+ " A:link {text-decoration: none; color: red;}"
				+ "  A:visited {text-decoration: none; color: red;}"
				+ "A:active {text-decoration: none; color: red;}"
				+ "A:hover {text-decoration: underline; color: red;}"
				+ "p{"
				+ "line-height:1.5em;"
				+ "margin-top:0.5em; margin-bottom:1.0em;"
				+ " }"
				+ "h1{"
				+ "margin: 0px 0px 5px; font: bold 165% verdana,arial,helvetica"
				+ "  }"
				+ " h2{"
				+ "margin-top: 1em; margin-bottom: 0.5em; font: bold 135% verdana,arial,helvetica"
				+ "}"
				+ "h3{"
				+ " margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica"
				+ " }"
				+ "h4{"
				+ "margin-bottom: 0.1em; font: bold 100% verdana,arial,helvetica"
				+ " }"
				+ " h5{"
				+ " margin-bottom: 0.5em; font: bold 100% verdana,arial,helvetica"
				+ " }"
				+ " h6{"
				+ " margin-bottom: 0.5em; font: bold 100% verdana,arial,helvetica"
				+ " }"
				+ ".Error{"
				+ "font-weight:bold; color:red;"
				+ "  }"
				+ ".Failure {"
				+ " font-weight:bold; color:purple;"
				+ "}"
				+ " .Success {"
				+ " color:green;"
				+ " }"
				+ ".Properties {"
				+ " text-align:right;"
				+ "}"
				+ ".style1 {color: #FF0000}"
				+ " .style2 {color: #009900}"
				+"</style>";
		drawReportContent(report,css);
	}
	private static void drawReportHeader(String report){
		String header=null;
		header="<html>"
				+ "<meta http-equiv=\"content-type\" content=\"text/html;charset=utf-8\">"
						+ "<body>"
						+ "<h1 style=\"margin: 0px 0px 5px; font: bold 165% verdana,arial,helvetica\">接口自动化测试报告</h1>";
		drawReportContent(report,header);
	}
	private static void drawReportFooter(String report){
		String footer =null;
		footer="</body>"
				+ "</html>";
		drawReportContent(report,footer);
	}
	private static void drawReportSummary(String report,String testsuit,String starttime,String endtime,int totalcase,int passedcase,int failedcase,float passrate){
		String summary=null;
		summary="<h2 style=\"margin-top: 1em; margin-bottom: 0.5em; font: bold 135% verdana,arial,helvetica\">摘要</h2>"
				+ "<h3 style=\"margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica\">"+testsuit+" </h3>    "
				+ "<h3 style=\"margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica\">测试开始时间： "+starttime+"</h3>"
				+ "<h3 style=\"margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica\">测试结束时间： "+endtime+"</h3>"
				+ "<h3 style=\"margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica\">总的测试用例数： "+Integer.toString(totalcase)+"</h3>"
				+ "<h3 style=\"margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica\">通过的测试用例数： "+Integer.toString(passedcase)+"</h3>"
				+ "<h3 style=\"margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica\">失败的测试用例数： "+Integer.toString(failedcase)+"</h3>"
				+ "<h3 style=\"margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica\">测试用例通过率： "+Float.toString(passrate)+"%"+"</h3>";
		drawReportContent(report,summary);
	}
	private static void drawReportDetails(String report, String result,String testsuit,String logurl ){
		String strDetail=null;
		List<Map> valueList=null;
		//String logPathOnServer="http://192.168.124.80/";
		try {
			 valueList=ExcelFileManager.readData(result, testsuit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		strDetail="<h3  style=\"margin-bottom: 0.5em; font: bold 115% verdana,arial,helvetica\"> 详细情况： </h3>";
		strDetail+="<table class=\"details\" border=\"0\" cellpadding=\"5\" cellspacing=\"2\" width=\"80%\">"
				+ "<tr> "
				+ "<th width=\"5%\">序号</th>"
				+ "<th width=\"30%\">接口地址</th>"
				+ "<th width=\"5%\">接口版本</th>"
				+ "<th width=\"10%\">接口类型</th>"
				+ "<th width=\"30%\">测试用例</th>"
				+ "<th width=\"10%\">测试结果</th>"
				+ "<th width=\"10%\">备注</th>"
				+ " </tr> ";
		for(Map map:valueList){
			strDetail+="<tr align=\"center\">";
			strDetail+="<td>" +map.get("ID").toString()+"</td>";
			strDetail+="<td>" +map.get("Api_Name").toString()+"</td>";
			strDetail+="<td>" +map.get("Api_Version").toString()+"</td>";
			strDetail+="<td>" +map.get("Api_Type").toString()+"</td>";
			strDetail+="<td>" +map.get("TestCase").toString()+"</td>";
			if(map.get("Result").toString().trim().toUpperCase().equals("PASS")){
				strDetail+="<td style=\"color:green\">" +map.get("Result").toString()+"</td>";
			}
			else if(map.get("Result").toString().trim().toUpperCase().equals("FAIL")){
				strDetail+="<td style=\"font-weight:bold; color:purple\">" +map.get("Result").toString()+"</td>";
				}
			else if(map.get("Result").toString().trim().toUpperCase().equals("ERROR")){
				strDetail+="<td style=\"font-weight:bold; color:red\">" +map.get("Result").toString()+"</td>";
				}
			
			else{
				strDetail+="<td>" +map.get("Result").toString()+"</td>";
			}			
			//strDetail+="<td><a href=\"../"+map.get("Comments").toString()+"\">" +"log"+"</a>"+"</td>";
			//strDetail+="<td><a href=\"javascript:window.open("+map.get("Comments").toString()+");\">"+"log"+"</a></td>";
			//strDetail+="<td><a href=\"javascript:window.open(http://www.baidu.com\")>"+"log"+"</a></td>";
			//strDetail+="<td><a href=\""+logurl+map.get("Comments").toString().substring(6,map.get("Comments").toString().length())+"\">" +"log"+"</a>"+"</td>";
			strDetail+="<td><a href=\""+logurl+map.get("Comments").toString()+"\">" +"log"+"</a>"+"</td>";
			strDetail+="</tr>";
		}
		strDetail+="</table>";
		drawReportContent(report,strDetail);
	}
	/*
	public static void main(String args[]){
		drawReportCSS("./htmlreport/temp.html");
	}*/
	private static void drawReportContent(String report, String content){
		File html= new File(report);
		BufferedWriter bw=null;
		try {
			bw=new BufferedWriter(new FileWriter(html,true));
			bw.write(content);
			bw.close();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}
}
