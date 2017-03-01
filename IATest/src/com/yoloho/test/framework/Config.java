package com.yoloho.test.framework;

import java.io.File;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Config {

	
	private String  TCControllerFileName;
	private String  testResultPath;
	private String htmlReportPath;
	private String logPath;
	private String logURL;
	private String testDataPath;
	private String emailServerAddress;
	private int emailServerPort;
	private String emailFrom;
	private String emailUserName;
	private String emailPassword;
	private String emailTo;
	
   // private Element root;
	public Config(String xmlfile) throws IsNotFileException, FileNotFoundException, IsNotFolderException{
		
		Element root=XMLFileManager.readXML(xmlfile);
		//configList=XMLFileManager.readXML(xmlfile);
		this.getData(root);
	}
	private void getData(Element Root)throws IsNotFileException,FileNotFoundException,IsNotFolderException{
		this.TCControllerFileName=XMLFileManager.getNodeValue(Root,"controllerfile","path").toString()+XMLFileManager.getNodeValue(Root,"controllerfile","name").toString();
		this.testResultPath=XMLFileManager.getNodeValue(Root, "testresult", "path").toString();
		this.htmlReportPath=XMLFileManager.getNodeValue(Root, "htmlreport", "path").toString();
		this.logPath = XMLFileManager.getNodeValue(Root,"log","path" ).toString();
		this.logURL=XMLFileManager.getNodeValue(Root, "log", "url").toString();
		this.testDataPath=XMLFileManager.getNodeValue(Root, "testdata", "path").toString();
		this.emailServerAddress=XMLFileManager.getNodeValue(Root, "email", "server").toString();
		this.emailServerPort=Integer.parseInt(XMLFileManager.getNodeValue(Root, "email", "port").toString());
		this.emailFrom=XMLFileManager.getNodeValue(Root, "email", "from").toString();
		this.emailUserName=XMLFileManager.getNodeValue(Root, "email", "username").toString();
		this.emailPassword=XMLFileManager.getNodeValue(Root, "email","password").toString();
		this.emailTo=XMLFileManager.getNodeValue(Root, "email", "to").toString();
		/*
		System.out.println(this.TCControllerFileName);
		System.out.println(this.testResultPath);
		System.out.println(this.htmlReportPath);
		System.out.println(this.logPath);
		System.out.println(this.logURL);
		System.out.println(this.testDataPath);
		System.out.println(this.emailServerAddress);
		System.out.println(this.emailServerPort);
		System.out.println(this.emailFrom);
		System.out.println(this.emailUserName);
		System.out.println(this.emailPassword);
		System.out.println(this.emailTo);*/
		
		//this.TCControllerFileName=
		
		
		//this.testResultPath=XMLFileManager.getNodeValue(configList, key)
		if(isTCControllerFileExists()&&isTestResultPathExists()&&isLogPathExists()&&isHTMLReportPathExists()){
			return;
		}
	}
	/*
	public static void main(String args[]){
		try {
			Config c=new Config("./config/config.xml");
		} catch (IsNotFileException | FileNotFoundException | IsNotFolderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}*/
	public String getControllerFileName(){
		return this.TCControllerFileName;
	}
	public String getTestResultPath(){
		return this.testResultPath;
	}
	public String getHtmlReportPath(){
		return this.htmlReportPath;
	}
	public String getLogPath(){
		return this.logPath;
	}
	public String getLogURL(){
		return this.logURL;
	}
	public String getTestDataPath(){
		return this.testDataPath;
	}
	public String getEmailServerAddress(){
		return this.emailServerAddress;
	}
	public int getEmailServerPort(){
		return this.emailServerPort;
	}
	public String getEmailFrom(){
		return this.emailFrom;
	}
	public String getEmailUserName(){
		return this.emailUserName;
	}
	public String getEmailUserPassword(){
		return this.emailPassword;
	}
	public String getEmailTo(){
		return this.emailTo;
	}
	public boolean isTCControllerFileExists() throws IsNotFileException,FileNotFoundException{
		boolean result=false;
		File TCControllerFile = new File(this.TCControllerFileName);
		if(TCControllerFile.isFile()){
			if(TCControllerFile.exists()){
				result=true;
				return result;
			}
			else{
				throw new FileNotFoundException("[Error In config]文件:"+this.TCControllerFileName+"不存在,请检查配置文件");
			}
		}
		else{
			throw new IsNotFileException("[Error In config]文件:"+this.TCControllerFileName+"不是一个有效的文件,请检查配置文件");
		}
		
		//return result;
	}
	public boolean isTestResultPathExists() throws IsNotFolderException{
		boolean result=false;
		File TestResultDirectory=new File(this.testResultPath);
		if(TestResultDirectory.isDirectory()){
			if(TestResultDirectory.exists()){
				result=true;
				return result;
			}
			else{
				TestResultDirectory.mkdir();
			}
		}
		else{
			throw new IsNotFolderException("[Error In config]目录:"+this.testResultPath+"不是一个有效的目录，请检查配置文件");
		}
		return result;
	}
	public boolean isLogPathExists() throws IsNotFolderException{
		boolean result=false;
		File logDirectory=new File(this.logPath);
		if(logDirectory.isDirectory()){
			if(logDirectory.exists()){
				result=true;
				return result;
			}
			else{
				logDirectory.mkdir();
			}
		}
		else{
			throw new IsNotFolderException("[Error In config]目录:"+this.logPath+"不是一个有效的目录，请检查配置文件");
		}
		return result;
	}
	public boolean isHTMLReportPathExists() throws IsNotFolderException{
		boolean result=false;
		File htmlReportDirectory=new File(this.htmlReportPath);
		if(htmlReportDirectory.isDirectory()){
			if(htmlReportDirectory.exists()){
				result=true;
				return result;
			}
			else{
				htmlReportDirectory.mkdir();
			}
		}
		else{
			throw new IsNotFolderException("[Error In config]目录:"+this.htmlReportPath+"不是一个有效的目录，请检查配置文件");
		}
		return result;
	}
	public boolean isTestDataPathExists() throws IsNotFolderException{
		boolean result=false;
		File testDataDirectory=new File(this.htmlReportPath);
		if(testDataDirectory.isDirectory()){
			if(testDataDirectory.exists()){
				result=true;
				return result;
			}
			else{
				testDataDirectory.mkdir();
			}
		}
		else{
			throw new IsNotFolderException("[Error In config]目录:"+this.htmlReportPath+"不是一个有效的目录，请检查配置文件");
		}
		return result;
	}
}
