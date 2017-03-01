package com.yoloho.test.framework;

public class Start {

	private static Start start;
	private Config conf;
	private final String configFileName="./config/config.xml";
	
	private void getTestTask(String testType){
		
		//TestcaseManager tcm= new TestcaseManager("./config/TC_Controller.xls","./testresult/","./htmlreport/");
		TestcaseManager tcm= new TestcaseManager(conf);
		tcm.setStartDateTime();	
		tcm.getTestTask(testType);	
		tcm.runTestTask();
		tcm.setEndDateTime();
		tcm.calcPassrate();
		tcm.createHTMLReport();
		tcm.sendHTMLReport();
	}

	private Start(){
		
		try {
			conf = new Config(configFileName);
		} catch (IsNotFileException | FileNotFoundException | IsNotFolderException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("[Error in Config],please check" +configFileName);
			System.out.println(e.getMessage());
			e.printStackTrace();
			return;
		}
		
		
		Logger.printWelecomeMsg("./config/welcome.txt");	   		
		this.getTestTask("SingleInterfaceTest");	
		//this.getTestTask("CombineInterfaceTest");
	}
	public static Start GetInstance(){
		if(start==null){
			start = new Start();
		}
		return start;
	}
	public static void main(String args[]){
		Start.GetInstance();

	}
	
}
