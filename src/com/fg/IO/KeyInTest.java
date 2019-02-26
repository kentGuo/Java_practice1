package com.fg.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyInTest {
	public static void main(String[] args) {
		try(
			//将System.in对象转换成Reader对象
			InputStreamReader reader=new InputStreamReader(System.in);
			//将普通的Reader包装秤BufferedReader
				BufferedReader br=new BufferedReader(reader);
			){
			String buffer=null;
			//采用循环方式来逐行读取
			while((buffer=br.readLine())!=null) {
				//如果读取的字符串为'exit',则程序退出
				if(buffer.equals("exit")) {
					System.exit(1);
				}
			//打印读取的内容
				System.out.println("输入的内容为:"+buffer);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
