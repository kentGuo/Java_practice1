package com.fg.IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
	public static void main(String[] args) {
		try(
			FileOutputStream fos=new FileOutputStream("test.txt");
			PrintStream ps=new PrintStream(fos);
			){
			//ʹ��PrintStreamִ�����
			ps.println("��ͨ�ַ���");
			//ֱ��ʹ��PrintSteam�������
			ps.print(new PrintStreamTest());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
