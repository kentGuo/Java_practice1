package com.fg.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFormProcess {
	public static void main(String[] args) throws IOException {
		//运行javac命令，返回运行该命令的子进程
		Process p=Runtime.getRuntime().exec("javac");
		try(
			//以p进程的错误流创建BufferReader对象
			//这个错误流对本程序就是输入流,对p进程就是输出流
			BufferedReader br=new BufferedReader(new InputStreamReader(p.getErrorStream()))
			){
			String buff=null;
			//采取循环方式读取p进程的错误输出
			while((buff=br.readLine())!=null) {
				System.out.println(buff);
			}
		}
	}
}
