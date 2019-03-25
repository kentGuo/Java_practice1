package com.fg.IO;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		// 创建字节输入流
		FileInputStream fis = new FileInputStream(".\\src\\com\\fg\\IO\\FileInputStreamTest.java");
		// 创建一个长度为1024的竹筒
		byte[] bbuf = new byte[1024];
		// 用于保存实际读取的字节数
		int hasRead = 0;
		// 使用循环来重复 读取 的过程
		while ((hasRead = fis.read(bbuf)) > 0) {
			// 取出读取的字节,将字节数组转换成字符串输入
			System.out.println(new String(bbuf, 0, hasRead));
		}
		// 关闭流
		fis.close();
	}
}
