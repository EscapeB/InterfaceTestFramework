package com.yoloho.test.framework;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

public class txtFileManager {
	public static void readTxtFile(String filePath){
        try {
                //String encoding="GBK";
        		String encoding="UTF8";
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ 
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                        System.out.println(lineTxt);
                    }
                    read.close();
		        }else{
		            System.out.println("Error: File" +filePath+"is not existed");
		        }
        } catch (Exception e) {            
            e.printStackTrace();
        }        
    }
	public static void readTxtFile(File txtfile) {
		if((!txtfile.isFile())||(!txtfile.exists())){
			System.out.println("Error: logfile does not exist");
			return;
		}
		String encoding="UTF8";
        InputStreamReader read=null;
		try {
			read = new InputStreamReader(new FileInputStream(txtfile),encoding);
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                try {
					while((lineTxt = bufferedReader.readLine()) != null){
					    System.out.println(lineTxt);
					}
					read.close();
				 }
                catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	public static File createTxtFile(String txtFilePathName){
		File file= new File(txtFilePathName);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return file;
	}
	public static boolean isFolderExisted(String path){
		File file=new File(path);
			if(file.isDirectory()&&file.exists()){
				return true;
			}
		return false;		
	}
	public static boolean createFolder(String path){
		File file=new File(path);
		if(file.isDirectory()&&(!file.exists())){
			if(file.mkdir()){
				System.out.println("Path:" +file.getAbsolutePath()+"is created");
				return false;
			}
			else{
				System.out.println("Failed to create path:" +file.getAbsolutePath()+"is created");
				return true;
			}
		}
		else{
			System.out.println("Path:" +path+"is an invalid path or path is existed"  );
		}
		return false;
	}
	public static void appendData(File logfile,String content){
		if((!logfile.isFile())||(!logfile.exists())){
			System.out.println("Error: logfile does not exist");
			return;
		}
		/*
		FileOutputStream fout =null;
		try {
			fout = new FileOutputStream(logfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fout.write(content.getBytes());
			fout.flush();
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		FileWriter fw= null;
		try {
				 fw= new FileWriter(logfile,true);
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			 } 
			PrintWriter pw=new PrintWriter(fw);
			pw.println(content);
			try {
				fw.flush();
				pw.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
	}/*
	public static void main(String args[]){
		File f= createTxtFile("./log/tmp.log");
		appendData(f,"abcdefg");
		appendData(f,"abcdefg");appendData(f,"abcdefg");appendData(f,"abcdefg");appendData(f,"abcdefg");
		
		
	}*/
}
