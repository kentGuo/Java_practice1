package com.fg.IO;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
	public static void main(String[] args) throws IOException {
		// �����ֽ�������
		FileInputStream fis = new FileInputStream(".\\src\\com\\fg\\IO\\FileInputStreamTest.java");
		// ����һ������Ϊ1024����Ͳ
		byte[] bbuf = new byte[1024];
		// ���ڱ���ʵ�ʶ�ȡ���ֽ���
		int hasRead = 0;
		// ʹ��ѭ�����ظ� ��ȡ �Ĺ���
		while ((hasRead = fis.read(bbuf)) > 0) {
			// ȡ����ȡ���ֽ�,���ֽ�����ת�����ַ�������
			System.out.println(new String(bbuf, 0, hasRead));
		}
		// �ر���
		fis.close();
	}
}
