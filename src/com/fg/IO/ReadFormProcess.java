package com.fg.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFormProcess {
	public static void main(String[] args) throws IOException {
		//����javac����������и�������ӽ���
		Process p=Runtime.getRuntime().exec("javac");
		try(
			//��p���̵Ĵ���������BufferReader����
			//����������Ա��������������,��p���̾��������
			BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()))
			){
			String buff=null;
			//��ȡѭ����ʽ��ȡp���̵Ĵ������
			while((buff=br.readLine())!=null) {
				System.out.println(buff);
			}
		}
	}
}