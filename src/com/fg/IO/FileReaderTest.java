package com.fg.IO;

import java.io.FileReader;

public class FileReaderTest {
	public static void main(String[] args) {

		try (
				// �����ֽ�������
				FileReader fis = new FileReader(".\\src\\com\\fg\\IO\\FileReaderTest.java");) {
			// ����һ������Ϊ32����Ͳ
			char[] bbuf = new char[32];
			// ���ڱ���ʵ�ʶ�ȡ���ֽ���
			int hasRead = 0;
			// ʹ��ѭ�����ظ� ��ȡ �Ĺ���
			while ((hasRead = fis.read(bbuf)) > 0) {
				// ȡ����ȡ���ֽ�,���ֽ�����ת�����ַ�������
				System.out.println(new String(bbuf, 0, hasRead));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
