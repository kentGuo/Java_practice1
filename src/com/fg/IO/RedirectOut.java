package com.fg.IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {
	public static void main(String[] args) {
		try (
			//һ���Դ���PrintStream�����
		PrintStream ps=new PrintStream(new FileOutputStream("out.txt"));
			){
			//����׼����ض���ps�����
			System.setOut(ps);
			//���׼������һ���ַ���
			System.out.println("��ͨ�ַ���");
			//���׼���һ������
			System.out.println(new RedirectOut());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
