package com.fg.IO;

import java.io.FileInputStream;
import java.util.Scanner;


public class RedirectIn {
	public static void main(String[] args) {
		try(
			FileInputStream fis=new FileInputStream(".\\\\src\\\\com\\\\fg\\\\IO\\\\RedirectIn.java");	
			) {
			//将标准输入重定向到fis输入流
			System.setIn(fis);
			//使用System.in创建Scanner对象，用于获取标准输入
			Scanner sc=new Scanner(System.in);
			//增加下面一行只把回车作为分隔符
			sc.useDelimiter("\n");
			//判断是否还有下一个输入项
			while(sc.hasNext()) {
				//输入输出项
				System.out.println("键盘输入的内容是:"+sc.next());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
