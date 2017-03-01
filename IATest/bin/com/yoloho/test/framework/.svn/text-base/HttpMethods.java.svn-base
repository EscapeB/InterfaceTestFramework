package com.yoloho.test.framework;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONObject;

/*
 * 声明Http请求方法
 */
@SuppressWarnings("deprecation")
public class HttpMethods {

	    //private static final CloseableHttpClient httpClient;
	    //public static final String encode = "";
    private static  CloseableHttpClient httpClient;
    public static  String encode = "";
	    static {
	        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
	        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
	    }
	 
	    //public static String sendHttpClientGet(String path, Map<String, String> params){
	    public static String sendHttpClientGet(String path, Map<String, Object> params){
	        return sendHttpClientGet(path, params,encode);
	    }
	    public static String sendHttpClientPost(String path, Map<String, Object> params){
	        return sendHttpClientPost(path, params,encode);
	    }

  //用apache接口实现http的post提交数据
  public static String sendHttpClientPost(String path,Map<String, Object> params, String encode) {
	  String result=null;
	  List<NameValuePair> list = new ArrayList<NameValuePair>();
	  if (params != null && !params.isEmpty()) {
		  for (Map.Entry<String, Object> entry : params.entrySet()) {
			 // System.out.println(entry.getKey().toString());
			  //System.out.println(entry.getValue().toString());
			  //list.add(new BasicNameValuePair(entry.getKey(), (String) entry.getValue()));
			  list.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
		  }
	  }
	  try {
		  // 实现将请求的参数封装到表单中，即请求体中
		  UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, encode);
		  // 使用post方式提交数据
		  HttpPost httpPost = new HttpPost(path);
		  httpPost.setEntity(entity);
		  // 执行post请求，并获取服务器端的响应HttpResponse
		  @SuppressWarnings("resource")
		  DefaultHttpClient client = new DefaultHttpClient();
		  HttpResponse httpResponse = client.execute(httpPost);
      
		  //获取服务器端返回的状态码和输入流，将输入流转换成字符串
		  if (httpResponse.getStatusLine().getStatusCode() == 200) {
			  //InputStream inputStream = httpResponse.getEntity().getContent();
			  //return changeInputStream(inputStream, encode);
			  HttpEntity resentity = httpResponse.getEntity();
			   if(resentity!=null){			
				   JSONObject a=JSONObject.fromObject(EntityUtils.toString(resentity, encode));
				  result=a.toString();		
			   }
		  }

	  	} catch (UnsupportedEncodingException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	} catch (ClientProtocolException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	} catch (IOException e) {
	  		// TODO Auto-generated catch block
	  		e.printStackTrace();
	  	}
	  		return null;
  }
  
  /*
   * 设置GET请求
   */

  //public static String sendHttpClientGet(String path ,Map<String , String>params,String encode){
  public static String sendHttpClientGet(String path ,Map<String , Object>params,String encode){
	  if(StringUtils.isBlank(path)){
          return null;
      }
      try {
          if(params != null && !params.isEmpty()){
              List<NameValuePair> pairs = new ArrayList<NameValuePair>(params.size());
             // for(Map.Entry<String,String> entry : params.entrySet()){
              for(Map.Entry<String,Object> entry : params.entrySet()){
                  Object value = entry.getValue();
                  if(value != null){
                     // pairs.add(new BasicNameValuePair(entry.getKey(),value));
                	  pairs.add(new BasicNameValuePair(entry.getKey(),value.toString()));
                  }
              }
              path += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, encode));
          }
          HttpGet httpGet = new HttpGet(path);
          CloseableHttpResponse response = httpClient.execute(httpGet);
          int statusCode = response.getStatusLine().getStatusCode();
          if (statusCode != 200) {
              httpGet.abort();
              throw new RuntimeException("HttpClient,error status code :" + statusCode);
          }
          HttpEntity entity = response.getEntity();
          
          String result = null;
          if (entity != null){
              //result = EntityUtils.toString(entity, encode);              
        	  //result=changeInputStream(entity.getContent(),encode);
	   		   JSONObject a=JSONObject.fromObject(EntityUtils.toString(entity, encode));
			   result=a.toString();	
          }
          //EntityUtils.consume(entity);
          response.close();
          return result;
      } catch (Exception e) {
          e.printStackTrace();
      }
      return null;

  }
  
  /*
   * // 把从输入流InputStream按指定编码格式encode变成字符串String
   */
  /*
  public static String changeInputStream(InputStream inputStream,String encode) {
	  
    // ByteArrayOutputStream 一般叫做内存流
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    byte[] data = new byte[1024];
    int len = 0;
    String result = "";
    if (inputStream != null) {

      try {
        while ((len = inputStream.read(data)) != -1) {
          byteArrayOutputStream.write(data, 0, len);

        }
        result = new String(byteArrayOutputStream.toByteArray(), encode);

      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    return result;
  }*/
public static void main(String args[]){
	 String strrequest="{\"token\"：\"104974038#42590d6e058af30a515aabe651adbd90\"}";
	 String strurl="http://testapi.yoloho.com/v1/index.php/topic/getbanner";
	 String strResponse=null;
	 //JSONObject jsonrequest=JSONObject.fromObject(strrequest);
	 //Map<String,String> map =new HashMap<String,String>();
	 Map<String,Object> map =new HashMap<String,Object>();
	 map.put("token", "104974038#42590d6e058af30a515aabe651adbd90");
	 strResponse = sendHttpClientGet(strurl,map,"UTF8");
	 System.out.println(strResponse);
}
}