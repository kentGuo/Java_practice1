package com.fg.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(
			RandomAccessFile raf=new RandomAccessFile(".\\\\src\\\\com\\\\fg\\\\IO\\\\RandomAccessFileTest.java", "r");	
			){
			//��ȡRandomAccessFile�����ļ�ָ���λ��,��ʼλ��Ϊ0
			System.out.println("RandomAccessFile���ļ�ָ��ĳ�ʼλ��Ϊ:"+raf.getFilePointer());
			//�ƶ�raf���ļ���¼ָ���λ��
			raf.seek(100);
			byte[] bbuf=new byte[1024];
			//���ڱ���ʵ�ʶ�ȡ���ֽ���
			int hasRead=0;
			//ʹ��ѭ����ʽ��ȡ��
			while((hasRead=raf.read(bbuf))>0) {
				//ȡ���ֽ��������ֽ�����ת�����ַ�������
				System.out.println(new String(bbuf,0,hasRead));
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
