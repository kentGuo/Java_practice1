package com.fg.Generic;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class AutoCloseTest {
	public static void main(String[] args) throws IOException {
		try(
				//��������ʼ�������ɹرյ���Դ
				//try�����Զ��ر���������Դ
				BufferedReader br=new BufferedReader(new FileReader("G://Mt.java"));
				PrintStream ps=new PrintStream(new FileOutputStream("a.txt")))
		{
		//ʹ��������Դ
			System.out.println(br.readLine());
			ps.println("aaaa");
		}
	}
}
