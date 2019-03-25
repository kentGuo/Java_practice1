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
			System.out.println("您输入的两个数相除的结果是:"+c);
		} catch (IndexOutOfBoundsException|NumberFormatException|ArithmeticException ie) {
			// TODO: handle exception
			System.out.println("程序发生了数组越界，数字格式异常，算术异常之一:"+ie);
			//捕获多异常时，异常变量默认有final修饰
			//所以下面代码有错
			//ie=new ArithmeticException("test");
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("未知异常"+e);
			//捕获一只类型 的异常时，异常变量没有final修饰
			//所以下面代码完全正确
			e=new RuntimeException("test");
		}
	}
}
