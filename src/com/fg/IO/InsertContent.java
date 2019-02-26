package com.fg.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	public static void insert(String fileName,long pos,String content) throws IOException{
		File tmp=File.createTempFile("tmp", null);
		tmp.deleteOnExit();
		try(
			RandomAccessFile raf=new RandomAccessFile(fileName, "rw");
			//����һ����ʱ�ļ�����������������
			FileOutputStream tmpOut=new FileOutputStream(tmp);
			FileInputStream tmpIn=new FileInputStream(tmp);
			){
			raf.seek(pos);
			//������뽫����������ݶ�����ʱ�ļ�����
			byte[] bbuf=new byte[64];
			//���ڱ���ʵ�� ��ȡ���ֽ���
			int hasRead=0;
			//ѭ����ȡ�����������
			while((hasRead=raf.read(bbuf))>0) {
				//����ȡ������д����ʱ�ļ�
				tmpOut.write(bbuf, 0, hasRead);
			}
			//����������ڲ�������
			//���ļ���¼ָ�����¶�λ��posλ��
			raf.seek(pos);
			//׷����Ҫ���������
			raf.write(content.getBytes());
			//׷����ʱ�ļ�������
			while((hasRead=tmpIn.read(bbuf))>0) {
				raf.write(bbuf, 0, hasRead);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		insert(".\\poem.txt", 45, "���������!\r\n");
	}
}
