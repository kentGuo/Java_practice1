package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		try (
				// 创建字节输入流
				FileInputStream fis = new FileInputStream(".\\src\\com\\fg\\IO\\FileOutputStreamTest.java");
		// 创建字节输出流
				FileOutputStream fos=new FileOutputStream("newFile.txt");
		) {
			byte[] bbuf=new byte[32];
			int hasRead=0;
			//循环从输入流中取出数据
			while((hasRead=(fis.read(bbuf)))>0)
			{
				//每读一次,即写入文件输出流,读了多少，输出多少
				fos.write(bbuf, 0, hasRead);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
