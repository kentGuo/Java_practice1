package com.fg.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(
			//�Զ�д��ʽ��һ��RandomAccessFile����
				RandomAccessFile raf=new RandomAccessFile("out.txt", "rw");
			){
			//����¼ָ���ƶ���out.txt�ļ������
			raf.seek(raf.length());
			raf.write("׷�ӵ�����!\r\n".getBytes());
		}
	}
}
