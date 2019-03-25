package com.fg.IO;

import java.io.FileReader;

public class FileReaderTest {
	public static void main(String[] args) {

		try (
				// 创建字节输入流
				FileReader fis = new FileReader(".\\src\\com\\fg\\IO\\FileReaderTest.java");) {
			// 创建一个长度为32的竹筒
			char[] bbuf = new char[32];
			// 用于保存实际读取的字节数
			int hasRead = 0;
			// 使用循环来重复 读取 的过程
			while ((hasRead = fis.read(bbuf)) > 0) {
				// 取出读取的字节,将字节数组转换成字符串输入
				System.out.println(new String(bbuf, 0, hasRead));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
