package com.fg.NETWORK;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLDecoderTest {
	public static void main(String[] args) throws Exception {
		/**
		 * 将application/x-www-form-urlencoder字符串 转换成普通字符串
		 * 其中的字符串直接从谷歌搜索“疯狂java”的地址栏上直接复制过来
		 * 
		 */
		String keyWord = URLDecoder.decode("%E7%96%AF%E7%8B%82java", "utf-8");
		System.out.println(keyWord);
		/**
		 * 将普通字符串转换成application/x-www-form-urlencoder字符串
		 * 
		 */
		String urlStr = URLEncoder.encode("疯狂java讲义", "GBK");
		System.out.println(urlStr);
	}
}
