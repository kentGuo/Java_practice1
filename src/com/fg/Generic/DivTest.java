package com.fg.Generic;

import java.util.Scanner;

public class DivTest {
	public static void main(String[] args) {
		try {
			Scanner sc1=new Scanner(System.in);
			//Scanner sc2=new Scanner(System.in);
			int a=Integer.parseInt(sc1.nextLine());
			int b=Integer.parseInt(sc1.nextLine());
			int c=a/b;
			System.out.println("��������������ദ�Ľ����:"+c);
		} catch (IndexOutOfBoundsException ie) {
			// TODO: handle exception
			System.out.println("����Խ��:���г���ʱ����Ĳ�����������");
		}catch (NumberFormatException ne) {
			// TODO: handle exception
			System.out.println("���ָ�ʽ�쳣:����ֻ�ܽ�������");
		}catch (ArithmeticException ae) {
			// TODO: handle exception
			System.out.println("�����쳣"+ae);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("δ֪�쳣"+e);
		}
	}
}
