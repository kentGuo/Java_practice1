package com.fg.NETWORK;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class KentServer {
	private static final int SERVER_PORT=30000;
	//使用KentMap对象来保存每个客户名字和对应输出流之间的对应关系
	public static KentMap<String, PrintStream> clients=new KentMap<>();
	public void init() {
		try (//建立监听的ServerSocket
				ServerSocket ss=new ServerSocket(SERVER_PORT);){
			//采用死循环来不断的接收来自客户端的请求
			while(true) {
				Socket s=ss.accept();
				new KentServerThread(s).start();
			}
			
		} catch (Exception e) {
			System.out.println("服务器启动失败，是否端口"+SERVER_PORT+"已被占用？");
		}
	}
	public static void main(String[] args) {
		KentServer server=new KentServer();
		server.init();
	}
}
