package com.yoloho.test.framework;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;  
import java.util.Iterator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;  
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;  
import org.apache.http.util.EntityUtils;
import com.yoloho.test.framework.api.Testcase;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.http.entity.mime.MultipartEntity; 
import org.apache.http.entity.mime.content.FileBody;  
import org.apache.http.entity.mime.content.StringBody;


public class HttpsMethods {	
	 public static String sendHttpsClientPost(String path,Map<String, Object> params, String encode) {
		 HttpClient httpClient = null;  
	      HttpPost httpPost = null;  
	      String result = null; 
	      List<NameValuePair> list = new ArrayList<NameValuePair>();
	      List<NameValuePair>filelist=new ArrayList<NameValuePair>();
		  if (params != null && !params.isEmpty()) {
			  for (Map.Entry<String, Object> entry : params.entrySet()) {
				  if(!entry.getKey().toLowerCase().equals("files")){
					  list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));  
				  }
				  else{					 
					  //add to the filelist
					  //System.out.println(entry.getValue().getClass().getSimpleName());
					  if(entry.getValue().getClass().getSimpleName().equals("ArrayList")){
						  //List<Map> lst = new ArrayList<Map>();
						  List<Map> lst = (ArrayList)(entry.getValue());
						  for(Map m:lst){
							  //filelist.add(new BasicNameValuePair(m));
							  //System.out.println(m.toString());
							  //System.out.println(m.);
							  //Iterator it = m.entrySet().iterator();
							  Set<String> keys= m.keySet();
							  for(String key:keys){
								  filelist.add(new BasicNameValuePair(key,(String) (m.get(key))));
								 // System.out.println(m.get(key));
								  //System.out.println(filelist.toString());
							  	}
							  }
						  }	
					  else{
						  filelist.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));  
					  	}
					  }
				  }
				  
			  }

		  if(filelist.size()==0){
			  try {
				  UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, encode);
				  httpClient = new SSLClient();	
				   httpPost = new HttpPost(path);
				  httpPost.setEntity(entity);
				  HttpResponse httpResponse = httpClient.execute(httpPost);	      
				  if (httpResponse!=null) {
					  HttpEntity resEntity = httpResponse.getEntity();  
					  if(resEntity!=null){
						  result = EntityUtils.toString(resEntity,encode);  
					  }
				  }
			  	}catch (Exception e) {
			  		// TODO Auto-generated catch block
			  		e.printStackTrace();
			  	}
		  }
		  else{
			  try {
				httpClient = new SSLClient();
				httpPost = new HttpPost(path);
				MultipartEntity reqEntity = new MultipartEntity();
				for(NameValuePair item:list){
					reqEntity.addPart(item.getName(), new StringBody(item.getValue(),Charset.forName("UTF-8")));					
				}
				for(NameValuePair item:filelist){
					//System.out.println(item.getValue());
					File file= new File(item.getValue());
					if(file.isFile()&&file.exists()){
						reqEntity.addPart(item.getName(), new FileBody(file));	
					}
					else
					{
						result="{errdesc:\"文件不存在\",\"文件名\":"+"\""+item.getValue()+"\"}";
						return result;
					}					
				}
				  httpPost.setEntity(reqEntity);
				  HttpResponse httpResponse = httpClient.execute(httpPost);	      
				  if (httpResponse!=null) {
					  HttpEntity resEntity = httpResponse.getEntity();  
					  if(resEntity!=null){
						  //result = EntityUtils.toString(resEntity,encode);
						   JSONObject a=JSONObject.fromObject(EntityUtils.toString(resEntity, encode));
						   result=a.toString();		
					  }
				  }
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			  
		  }
		  		return result;
	 }
	
	public static String sendHttpsClientGet(String path,Map<String,Object> params,String encode){
		HttpClient httpClient=null;
		HttpGet httpget=null;
		CloseableHttpResponse response =null;
		String result=null;
		HttpEntity entity =null;
		  if(StringUtils.isBlank(path)){
	          return result;
	      }
		 try{
			  if(params!=null){
				  List<NameValuePair> pairs= new ArrayList<NameValuePair>(params.size());
				for(Map.Entry<String,Object> entry:params.entrySet()){
					Object value=entry.getValue();
					if(value!=null){
						pairs.add(new BasicNameValuePair(entry.getKey(),value.toString()));			    
					}  				
				}
				  path += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, encode));
				 // System.out.println(path);
			  }	 
			  httpClient = new SSLClient();
			 // httpClient.
			  httpget = new HttpGet(path);
			  response=(CloseableHttpResponse) httpClient.execute(httpget);
			  int statusCode=response.getStatusLine().getStatusCode();
			  if(statusCode!=200){
				  httpget.abort();
				  throw new RuntimeException("HttpClient,error status code :" + statusCode);
			  }
			   entity = response.getEntity();
			   if(entity!=null){			
				   JSONObject a=JSONObject.fromObject(EntityUtils.toString(entity, encode));
				  result=a.toString();		
			   }
			   
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		  
		return  result;
	}
	public static String sendHttpsClientGetPost(String path,Map<String,Object> params,String encode){
	
		HttpClient httpClient=null;
		//HttpGet httpGet=null;
		HttpPost httpPost=null;
		//CloseableHttpResponse GetResponse =null;
		CloseableHttpResponse PostResponse =null;
		String result=null;
		//HttpEntity entity =null;
		List<NameValuePair> lsGetRequest=null;;
		List<NameValuePair> lsPostRequest=null;
		List<NameValuePair> lsFiles=null;
		MultipartEntity reqEntity =null;
		HttpEntity resEntity =null;
		//int intGetRequestStatusCode=0;
		//int intPostRequestStatusCode=0;
		
		  if(StringUtils.isBlank(path)){
	          return result;
	      }
	
		  lsGetRequest = new ArrayList<NameValuePair>();
		  lsPostRequest = new ArrayList<NameValuePair>();
		  lsFiles = new ArrayList<NameValuePair>();
		 
		  
		  if (params != null && !params.isEmpty()) {
			  for (Map.Entry<String, Object> entry : params.entrySet()) {
	
				  if(entry.getKey().toUpperCase().trim().equals("POST")){
					  if(entry.getValue().getClass().getSimpleName().equals("HashMap")){
						 Map<String,Object> mpPostRequest=(Map<String,Object>)(entry.getValue());
						  Set<String> strPostRequestKeys= mpPostRequest.keySet();
						  for(String strPostRequestKey:strPostRequestKeys ){
							  if(strPostRequestKey.equals("files")){
								  if(mpPostRequest.get(strPostRequestKey).getClass().getSimpleName().equals("ArrayList")){
									  List<Map> filelist=(ArrayList)mpPostRequest.get(strPostRequestKey);
									  for(Map m: filelist){
										  Set<String> keys= m.keySet();
										  for(String key:keys){
											  lsFiles.add(new BasicNameValuePair(key,(String) (m.get(key))));
										  }
									  }
								  }
								  if(mpPostRequest.get(strPostRequestKey).getClass().getSimpleName().equals("HashMap")){
									  lsFiles.add(new BasicNameValuePair(strPostRequestKey,mpPostRequest.get(strPostRequestKey).toString()));
								  }
							  }
							  else{
								  lsPostRequest.add(new BasicNameValuePair(strPostRequestKey,mpPostRequest.get(strPostRequestKey).toString()));  
							  }
							  
							  
						  }						
					  }
				  }
				  if(entry.getKey().toUpperCase().trim().equals("GET")){
					  if(entry.getValue().getClass().getSimpleName().equals("HashMap")){
						  Map<String,Object>mpGetRequest=(Map<String,Object>)(entry.getValue());
						  Set<String> strGetRequestKeys= mpGetRequest.keySet();
						  for(String strGetRequestKey:strGetRequestKeys){
							  lsGetRequest.add(new BasicNameValuePair(strGetRequestKey,mpGetRequest.get(strGetRequestKey).toString()));
						  }
					  }					
				  }		
			  }
		  }

		 try{
			 httpClient = new SSLClient();
			 //strGetRequestPath=path + "?" + EntityUtils.toString(new UrlEncodedFormEntity(lsGetRequest, encode));
			 path += "?" + EntityUtils.toString(new UrlEncodedFormEntity(lsGetRequest, encode));
			 //httpPost = new HttpPost(strPostRequestPath);
			 //httpGet = new HttpGet(strGetRequestPath);
			 //httpGet = new HttpGet(path);
			 httpPost = new HttpPost(path);			
			 //GetResponse= (CloseableHttpResponse) httpClient.execute(httpGet);
			 //intGetRequestStatusCode = GetResponse.getStatusLine().getStatusCode();
			 /*0
			 if(intGetRequestStatusCode!=200){
				 httpGet.abort();
				  throw new RuntimeException("HttpClient,error status code :" + intGetRequestStatusCode);
			 }
			   entity = GetResponse.getEntity();
			   if(entity!=null){			
				   JSONObject a=JSONObject.fromObject(EntityUtils.toString(entity, encode));
				  result=a.toString();		
			   }*/
			   reqEntity =new MultipartEntity();
				for(NameValuePair item:lsPostRequest){
					reqEntity.addPart(item.getName(), new StringBody(item.getValue(),Charset.forName("UTF-8")));					
				}
				if(lsFiles.size()>0){
					for(NameValuePair item:lsFiles){						
						File file= new File(item.getValue());
						if(file.isFile()&&file.exists()){
							reqEntity.addPart(item.getName(), new FileBody(file));	
						}
						else
						{
							result="{errdesc:\"文件不存在\",\"文件名\":"+"\""+item.getValue()+"\"}";
							return result;
						}					
					}
				}
				 httpPost.setEntity(reqEntity);
				 PostResponse =  (CloseableHttpResponse)httpClient.execute(httpPost);	      
				  if (PostResponse!=null) {
					   resEntity = PostResponse.getEntity();  
					  if(resEntity!=null){
						  //result = EntityUtils.toString(resEntity,encode);
						   JSONObject a=JSONObject.fromObject(EntityUtils.toString(resEntity, encode));
						   result=a.toString();		
					  }
				  }
		 }
		 catch(Exception e){
			 e.printStackTrace();
		 }
		  
		return  result;

	}

}
