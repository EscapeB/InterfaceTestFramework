package com.yoloho.test.framework;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLFileManager {
	 
	//public static 
	public static Element readXML(String xmlfilename){
		NodeList nodelist=null;
		File xmlfile=null;
		DocumentBuilderFactory factory =DocumentBuilderFactory .newInstance();
		 DocumentBuilder builder;
	     Document document =null;
		try {
			builder = factory.newDocumentBuilder();
		    //document = builder.newDocument();
			xmlfile=new File(xmlfilename);
			System.out.println(xmlfile.getAbsolutePath());
			if(xmlfile.isFile()&&xmlfile.exists()){				
					document = builder.parse(xmlfilename);			
			}
			} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//nodelist=document.getChildNodes();
		Element root=document.getDocumentElement() ;
		//System.out.println(root.getNodeName());
		//nodelist=root.getElementsByTagName(root.getNodeName());
		
		return root;
	}
	public static Object getNodeValue(Element root,String nodename,String key){
		Object value=null;
			NodeList nl=root.getElementsByTagName(nodename);
			Node node=null;
			for(int j = 0; j<nl.getLength();j++){
				if(nl.item(j).getNodeName().equals(nodename)){
					node=nl.item(j);		
				}
			}
			if(node==null){
				return value;
			}
			NamedNodeMap attributes=node.getAttributes();
			for(int i=0; i<attributes.getLength();i++){
				if(attributes.item(i).getNodeName().equals(key)){
					value=attributes.item(i).getNodeValue();
				}
			}
		return value;
	}
	/*
	public static void main(String args[]){
		//XMLFileManager dd=new XMLFileManager();
        String str="./config/config.xml";      
        Object obj;
        Element root=XMLFileManager.readXML(str);
        //System.out.println(configlist.getLength());
        //String[] key= {"controllerfile","path"};
        obj=XMLFileManager.getNodeValue(root,"controllerfile","path");
        System.out.println(obj.toString());
	}
	*/
	
}
