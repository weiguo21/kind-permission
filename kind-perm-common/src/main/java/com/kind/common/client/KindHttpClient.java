/**
 * Project Name:kafa-common-base
 * File Name:KindHttpClient.java
 * Package Name:com.kind.common.client
 * Date:2016-4-28下午4:13:07
 * Copyright (c) 2016, http://www.kindapp.net All Rights Reserved.
 *
 */
package com.kind.common.client;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * Function:对httpClient的封装. <br/>
 * 
 * @date:2016年6月27日 下午1:38:52 <br/>
 * @author weiguo21
 * @version:
 * @since:JDK 1.7
 */
public class KindHttpClient {
	/**
	 * Get提交.
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doGet(String url, Map<String, String> param) {

		/**
		 * 创建HttpClient对象
		 */
		CloseableHttpClient httpclient = HttpClients.createDefault();

		String resultString = "";
		CloseableHttpResponse response = null;
		try {
			/**
			 * 创建URI
			 */
			URIBuilder builder = new URIBuilder(url);
			if (param != null) {
				for (String key : param.keySet()) {
					builder.addParameter(key, param.get(key));
				}
			}
			URI uri = builder.build();

			/**
			 * 创建HTTP GET请求
			 */
			HttpGet httpGet = new HttpGet(uri);

			/**
			 * 执行请求
			 */
			response = httpclient.execute(httpGet);
			/**
			 * 判断返回状态是否为200
			 */
			if (response.getStatusLine().getStatusCode() == 200) {
				resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}

	/**
	 * 无参Get提交.
	 * 
	 * @param url
	 * @return
	 */
	public static String doGet(String url) {
		return doGet(url, null);
	}

	/**
	 * Map Post提交.
	 * 
	 * @param url
	 * @param param
	 * @return
	 */
	public static String doPost(String url, Map<String, String> param) {
		/**
		 * 创建HttpClient对象
		 */
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			/**
			 * 创建HTTP Post请求
			 */
			HttpPost httpPost = new HttpPost(url);
			/**
			 * 创建参数列表
			 */
			if (param != null) {
				List<NameValuePair> paramList = new ArrayList<>();
				for (String key : param.keySet()) {
					paramList.add(new BasicNameValuePair(key, param.get(key)));
				}
				/**
				 * 模拟表单
				 */
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList);
				httpPost.setEntity(entity);
			}
			/**
			 * 执行HTTP请求
			 */
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return resultString;
	}

	/**
	 * 无参提交.
	 * 
	 * @param url
	 * @return
	 */
	public static String doPost(String url) {
		return doPost(url, null);
	}

	/**
	 * JSON数据Post提交.
	 * 
	 * @param url
	 * @param json
	 * @return
	 */
	public static String doPostJson(String url, String json) {
		/**
		 * 创建HttpClient对象
		 */
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			/**
			 * 创建HTTP Post请求
			 */
			HttpPost httpPost = new HttpPost(url);
			/**
			 * 创建请求内容
			 */
			StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);
			httpPost.setEntity(entity);
			/**
			 * 执行HTTP请求
			 */
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
	public static String post(String url, List<NameValuePair> httpParams) {
		return postData(url, httpParams, null);
	}
	public static String postData(String url, List<NameValuePair> httpParams, List<NameValuePair> headers) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		CloseableHttpResponse response = null;
		String resultString = "";
		try {
			HttpPost httpPost = new HttpPost(url);
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(httpParams, Consts.UTF_8);
			httpPost.setEntity(entity);
			response = httpClient.execute(httpPost);
			resultString = EntityUtils.toString(response.getEntity(), "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resultString;
	}
	
}
