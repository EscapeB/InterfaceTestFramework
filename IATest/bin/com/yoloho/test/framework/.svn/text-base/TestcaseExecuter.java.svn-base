package com.yoloho.test.framework;
import com.yoloho.test.testcase.*;

import java.io.File;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;  
import java.net.URLClassLoader;  

public class TestcaseExecuter {
	
	public static void run(String scriptname,String tcname,TestcaseManager tcmanager,String testsuitname,File logFile,String testdatapath) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException{
	/*	
		URL javaURL=null;
		Constructor con =null;
		Constructor[] cons=null;
		Object obj=null;		
		URLClassLoader myClassLoader=null;
		Class myClass = null;
		Class[] parameterTypes=null;
		 Method declaredMethods[] =null;
		 
		javaURL = new URL("./com.yoloho.test.testcase/"+scriptname+".java");
		myClassLoader=new URLClassLoader(new URL[]{javaURL},Thread.currentThread().getContextClassLoader());
		myClass = myClassLoader.loadClass(scriptname);
		cons = myClass.getDeclaredConstructors();
		con=cons[0];
		parameterTypes=con.getParameterTypes(); 
		Object[] param={};	
		obj=con.newInstance(param);
		declaredMethods =  myClass.getDeclaredMethods();
		
		for (Method method: declaredMethods){
			if(tcname.equals(method.getName())){method.invoke(obj);}
		}
		
		*/
		Constructor con=null;
		Constructor[] cons=null;
		
		Class myClass=null;
		 Method declaredMethods[]=null;
		 Object instance =null;
		myClass=Class.forName("com.yoloho.test.testcase."+scriptname);
		cons=myClass.getConstructors();
		con=cons[0];
		Class[] parameterTypes=con.getParameterTypes(); 
		Object[] param={tcmanager,testsuitname,logFile,testdatapath};	
		//Object instance=myClass.newInstance();
		
		 instance =con.newInstance(param);
 		declaredMethods =  myClass.getDeclaredMethods();
 		Logger.logTestcaseHeaderFooter(logFile,tcname,"Start");
		for (Method method: declaredMethods){
			if(tcname.equals(method.getName())){method.invoke(instance);}
	}
		Logger.logTestcaseHeaderFooter(logFile,tcname,"End");
	}
}
