package com.fg.IO;

import java.io.FileReader;
import java.io.PushbackReader;

public class PushbackTest {
	public static void main(String[] args) {
		try(
			//����һ��PushbackReader����ָ���ƻػ������ĳ���Ϊ64
				PushbackReader pr=new PushbackReader(new FileReader(".\\src\\com\\fg\\IO\\PushbackTest.java"), 64);
				){
			char[] buf=new char[32];
			//���Ա�����һ�ζ�ȡ���ַ�������
			String lastContent="";
			int hasRead=0;
			//ѭ����ȡ�ļ�����
			while((hasRead=pr.read(buf))>0) {
				//����ȡ������ת�����ַ���
				String content=new String(buf,0,hasRead);
				int targetIndex=0;
				//���ϴζ�ȡ���ַ����ͱ��ζ�ȡ���ַ���ƴ������
				//�鿴�Ƿ����Ŀ���ַ���.�������Ŀ���ַ���
				if((targetIndex=(lastContent+content).indexOf("new PushbackReader"))>0)
				{
					//���������ݺ���һ������һ���ƻص�������
					pr.unread((lastContent+content).toCharArray());
					//ָ����ȡǰ���len���ַ���
					int len=targetIndex>32?32:targetIndex;
					//�ٴζ�ȡָ�����ȵ�����(����Ŀ���ַ���֮ǰ������)
					pr.read(buf,0,len);
					//��ӡ��ȡ������
					System.out.println("��ζ�ȡ������:"+new String(buf,0,len));
					System.exit(0);
				}else {
					//��ӡ�ϴζ�ȡ������
					System.out.println("�ϴζ�ȡ������:"+lastContent);
					//������������Ϊ�ϴζ�ȡ������
					lastContent=content;
				}
			
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}