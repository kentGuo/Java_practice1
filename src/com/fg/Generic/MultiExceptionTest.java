package com.fg.Generic;

import java.util.Scanner;

public class MultiExceptionTest {
	public static void main(String[] args) {
		try {
			Scanner sc1=new Scanner(System.in);
			//Scanner sc2=new Scanner(System.in);
			int a=Integer.parseInt(sc1.nextLine());
			int b=Integer.parseInt(sc1.nextLine());
			int c=a/b;
			System.out.println("�����������������Ľ����:"+c);
		} catch (IndexOutOfBoundsException|NumberFormatException|ArithmeticException ie) {
			// TODO: handle exception
			System.out.println("������������Խ�磬���ָ�ʽ�쳣�������쳣֮һ:"+ie);
			//������쳣ʱ���쳣����Ĭ����final����
			//������������д�
			//ie=new ArithmeticException("test");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("δ֪�쳣"+e);
			//����һֻ���� ���쳣ʱ���쳣����û��final����
			//�������������ȫ��ȷ
			e=new RuntimeException("test");
		}
	}
}
