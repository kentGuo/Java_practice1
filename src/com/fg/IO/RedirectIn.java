package com.fg.IO;

import java.io.FileInputStream;
import java.util.Scanner;


public class RedirectIn {
	public static void main(String[] args) {
		try(
			FileInputStream fis=new FileInputStream(".\\\\src\\\\com\\\\fg\\\\IO\\\\RedirectIn.java");	
			) {
			//����׼�����ض���fis������
			System.setIn(fis);
			//ʹ��System.in����Scanner�������ڻ�ȡ��׼����
			Scanner sc=new Scanner(System.in);
			//��������һ��ֻ�ѻس���Ϊ�ָ���
			sc.useDelimiter("\n");
			//�ж��Ƿ�����һ��������
			while(sc.hasNext()) {
				//���������
				System.out.println("���������������:"+sc.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
