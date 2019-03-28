package com.sangbill.advanced.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class TestUrl {
//	public static String URL = "http://quote.futures.hexun.com/2010/JsData/FRunTimeQuote.aspx?code=AG1507";
	public static String URL = "http://www.ku6.com/";
//	public static String URL = "http://www.google.com.hk/";
	public static void main(String[] args) {
		 	try{		 		
		 		URL url = new URL(URL);
		 		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		 		conn.setConnectTimeout(1000);//设置连接超时
		 		if (conn.getResponseCode() != 200) throw new RuntimeException("请求url失败");
		 		InputStream is = conn.getInputStream();//得到网络返回的输入流
		 		BufferedReader br = new BufferedReader(new InputStreamReader(is, "GBK"));
		 		String data = null;
		 		while (null != (data = br.readLine())) {
		 			System.out.println(data);
		 		}
		 		br.close();
		 		is.close();
		 	}catch (Exception e) {
				e.printStackTrace();
			}
	}
}
