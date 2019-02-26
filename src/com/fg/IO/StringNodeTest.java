package com.fg.IO;

import java.io.StringReader;
import java.io.StringWriter;

public class StringNodeTest {
	public static void main(String[] args) {
		String src = "��������,��һ���Ҹ�����\n" + "ι��,����,��������\n" + "��������,������ʳ���߲�\n" + "����һ������,�泯��,��ů����\n" + "��������,��ÿһ������ͨ��\n"
				+ "���������ҵ��Ҹ�\n";
		char[] buffer=new char[32];
		int hasRead=0;
		try(
			StringReader sr=new StringReader(src);	
			) {
			//����ѭ����ȡ�ķ�ʽ��ȡ�ַ���
			while((hasRead=sr.read(buffer))>0) {
				System.out.println(new String(buffer,0,hasRead));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try (
			//����StringWriterʱ��ʵ������һ��StringBuffer��Ϊ����ڵ�
			//����ָ����20����StringBuffer�ĳ�ʼ����
			StringWriter sw=new StringWriter();
				){
			//����StringWriter�ķ���ִ�����
			sw.write("��һ��������������,\n");
			sw.write("����Զ������,\n");
			sw.write("����������ĺ���,\n");
			sw.write("���й���ľ���.\n");
			System.out.println("========������sw�ַ����ڵ��������=========");
			//ʹ��toString()��������StringWriter�ַ����ڵ������
			System.out.println(sw.toString());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
