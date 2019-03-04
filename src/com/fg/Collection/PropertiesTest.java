package com.fg.Collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) throws Exception{
		Properties props=new Properties();
		//��Properties�������
		props.setProperty("username", "Kent");
		props.setProperty("password", "123456");
		//��Properties�е�key-value�Ա��浽a.ini�ļ���
		props.store(new FileOutputStream("a.ini"), "comments line");
		//�´���һ��Properties����
		Properties props2=new Properties();
		//��Properties���������
		props2.setProperty("gender", "male");
		//��a.ini�ļ��е�key-value��׷�ӵ�props2��
		props2.load(new FileInputStream("a.ini"));
		System.out.println(props2);
	}
}
