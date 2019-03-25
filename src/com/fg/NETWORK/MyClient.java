package com.fg.NETWORK;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class MyClient {
	public static void main(String[] args) throws Exception{
		FileWriter fw=new FileWriter("b.txt");
		Socket s=new Socket("127.0.0.1", 3001);
		//客户端启动ClientThread线程不断地读取来自服务器的数据
		new Thread(new ClientThread(s)).start();
		//获取该Socket对应的输出流
		PrintStream ps=new PrintStream(s.getOutputStream());
		String line=null;
		//不断的读取键盘输入
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		while((line=br.readLine())!=null) {
			//将用户的键盘输入内容写入Socket对应的输出流
			ps.println(line);
			fw.write(line);
		}
	}
}
