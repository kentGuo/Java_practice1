package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamTest {
	public static void main(String[] args) {
		try (
				// �����ֽ�������
				FileInputStream fis = new FileInputStream(".\\src\\com\\fg\\IO\\FileOutputStreamTest.java");
		// �����ֽ������
				FileOutputStream fos=new FileOutputStream("newFile.txt");
		) {
			byte[] bbuf=new byte[32];
			int hasRead=0;
			//ѭ������������ȡ������
			while((hasRead=(fis.read(bbuf)))>0)
			{
				//ÿ��һ��,��д���ļ������,���˶��٣��������
				fos.write(bbuf, 0, hasRead);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
