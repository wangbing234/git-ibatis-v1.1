package com.qk.module.font.coin.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.mysql.jdbc.StringUtils;
import com.qk.core.domain.Busi;


public class HttpTookit
{
	 private static final CloseableHttpClient httpClient;
	    public static final String CHARSET = "UTF-8";

	    static
	    {
	        RequestConfig config = RequestConfig.custom().setConnectTimeout(60000).setSocketTimeout(15000).build();
	        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
	    }
	/**
	 * 向指定URL发送GET方法的请求
	 * 
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 * @throws Exception 
	 */
	public static String sendGet(String url, String token) throws Exception {
		String result = null;
		try {
			HttpClient httpClient = new HttpClient();
			GetMethod getMethod = new GetMethod(url);
			httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
			getMethod.getParams().setParameter("http.method.retry-handler", new DefaultHttpMethodRetryHandler());
			if (null != token) {
				getMethod.setRequestHeader(Busi.TOKEN, token);
			}
			int statusCode = httpClient.executeMethod(getMethod);
			if (statusCode == 200) {
				StringBuffer temp = new StringBuffer();
				InputStream in = getMethod.getResponseBodyAsStream();
				BufferedReader buffer = new BufferedReader(new InputStreamReader(in, "UTF-8"));
				for (String tempstr = ""; (tempstr = buffer.readLine()) != null;)
					temp = temp.append(tempstr);
				buffer.close();
				in.close();
				result = temp.toString().trim();
			} else {
				System.err.println((new StringBuilder("Can't get page:")).append(url).append("#").append(getMethod.getStatusLine()).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return result;
	}
	
	 /**
     * HTTP Post 获取内容
     * @param url  请求的url地址 ?之前的地址
     * @param params	请求的参数
     * @param charset	编码格式
     * @return	页面内容
     */
    public static String doPost(String url,Map<String,String> params,String charset){
    	
    	if(StringUtils.isEmptyOrWhitespaceOnly(url)){
    		return null;
    	}
    	try {
    		List<NameValuePair> pairs = null;
    		if(params != null && !params.isEmpty()){
    			pairs = new ArrayList<NameValuePair>(params.size());
    			for(Map.Entry<String,String> entry : params.entrySet()){
    				String value = entry.getValue();
    				if(value != null){
    					pairs.add(new BasicNameValuePair(entry.getKey(),value));
    				}
    			}
    		}
    		HttpPost httpPost = new HttpPost(url);
    		if(pairs != null && pairs.size() > 0){
    			httpPost.setEntity(new UrlEncodedFormEntity(pairs,CHARSET));
    		}
    		
    		CloseableHttpResponse response = httpClient.execute(httpPost);
    		int statusCode = response.getStatusLine().getStatusCode();
    		if (statusCode != 200) {
    			httpPost.abort();
    			throw new RuntimeException("HttpClient,error status code :" + statusCode);
    		}
    		HttpEntity entity = response.getEntity();
    		String result = null;
    		if (entity != null){
    			result = EntityUtils.toString(entity, "utf-8");
    		}
    		EntityUtils.consume(entity);
    		response.close();
    		return result;
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }

	/*public static void main(String[] args) 
	{
		// 发送 GET 请求
		// String s= getkuaidi100("zhongtong","435036844771");
		// System.out.println(s);

		// String rr=HttpTookit.getRemoteToken("http://106.14.206.109:9998/f1/token?t=0e391690-d2bb-4b87-916c-2b770f920dda");
		// System.out.println("rrrrr"+rr);
		String url = "http://api.coinvc.com/api/v2/auth/signup";
		Map<String,String> params = new HashMap<String,String>();
		params.put("account", "293514029@qq.com");
		params.put("username", "");
		params.put("password", "");
		params.put("robot", "");
		params.put("from", "");
		
		String rr=HttpTookit.doPost(url, params, CHARSET);
		System.out.println("rrrrr"+rr);
	}*/
}