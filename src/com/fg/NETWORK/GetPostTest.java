package com.fg.NETWORK;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {
	/**
	 * 向会自动URL发送GET方式的请求
	 * 
	 * @param url  发送请求的URL
	 * @param parm 请求参数，格式满足name1=value1&name2=value2的形式
	 * @return URL代表远程资源的响应
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1; SV1)");
			// 建立实际的连接
			conn.connect();
			// 获取所有的响应头字段
			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "----->" + map.get(key));
			}
			try (
					// 定义BufferedReader输入流来读取URL的响应
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常!" + e);
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 向指定URL发送POST方式的请求
	 * 
	 * @param url 发送请求的URL
	 * @param     param请求参数，格式满足name1=value1&name2=value2的形式
	 * @return URL代表远程资源的响应
	 */
	public static String sendPost(String url, String param) {
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0(compatible;MSIE 6.0;Windows NT 5.1; SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoInput(true);
			conn.setDoOutput(true);
			try (
					// 获取URLConnection对象对应的输出流
					PrintWriter out = new PrintWriter(conn.getOutputStream())) {
				// 发送请求参数
				out.println(param);
				// flush输出流 的缓冲
				out.flush();
			}
			try (
					// 定义BufferedReader输入流来读取URL的响应
					BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常!" + e);
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args) {
		//发送GET请求
//		String s=GetPostTest.sendGet("http://localhost:8080/spring/index.htm", null);
//		System.out.println(s);
		//发送POST请求
		String s1=GetPostTest.sendPost("http://localhost:8080/Test/", "username=admin&password=admin");
		System.out.println(s1);
				
	}
}
