package com.fg.NETWORK;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyServer {
	//定义保存所有的Socket的ArrayList,并将其包装为线程安全的
	public static List<Socket> socketList=Collections.synchronizedList(new ArrayList<>());
	public static void main(String[] args) throws Exception {
		ServerSocket ss=new ServerSocket(3001);
		//ss.setSoTimeout(5000);
		while(true) {
			//此处代码会阻塞，将一直等待别人的连接
			Socket s=ss.accept();
			socketList.add(s);
			//每当客户端连接后启动一个ServerThread线程为该客户端服务
			new Thread(new ServerThread(s)).start();
		}
	}
	
}
