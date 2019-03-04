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
			System.out.println("您输入的两个数相处的结果是:"+c);
		} catch (IndexOutOfBoundsException ie) {
			// TODO: handle exception
			System.out.println("数组越界:运行程序时输入的参数个数不够");
		}catch (NumberFormatException ne) {
			// TODO: handle exception
			System.out.println("数字格式异常:程序只能接收整数");
		}catch (ArithmeticException ae) {
			// TODO: handle exception
			System.out.println("算术异常"+ae);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("未知异常"+e);
		}
	}
}
