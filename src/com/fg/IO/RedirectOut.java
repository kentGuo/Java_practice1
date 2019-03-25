package com.fg.IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {
	public static void main(String[] args) {
		try (
			//一次性创建PrintStream输出流
		PrintStream ps=new PrintStream(new FileOutputStream("out.txt"));
			){
			//将标准输出重定向到ps输出流
			System.setOut(ps);
			//向标准输出输出一个字符串
			System.out.println("普通字符串");
			//向标准输出一个对象
			System.out.println(new RedirectOut());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
