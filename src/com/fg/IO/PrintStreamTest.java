package com.fg.IO;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamTest {
	public static void main(String[] args) {
		try(
			FileOutputStream fos=new FileOutputStream("test.txt");
			PrintStream ps=new PrintStream(fos);
			){
			//使用PrintStream执行输出
			ps.println("普通字符串");
			//直接使用PrintSteam输出对象
			ps.print(new PrintStreamTest());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
