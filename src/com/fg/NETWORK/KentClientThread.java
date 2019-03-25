package com.fg.NETWORK;

import java.io.BufferedReader;

public class KentClientThread extends Thread{
	//该客户端线程负责处理的输入流
	BufferedReader br=null;
	//使用一个网络输入流来创建客户端线程

	public KentClientThread(BufferedReader br) {
		super();
		this.br = br;
	}
	@Override
	public void run() {
		try {
			String line=null;
			//不断地输入流中读取数据，并将这些数据打印输出
			while((line=br.readLine())!=null) {
				System.out.println(line);
				/**
				 * 本例仅打印了从服务器端读到的内容。实际上，此处的情况可以更复杂:如果希望客户端
				 * 能看到聊天室的用户列表，则可以让服务器在每次有用户登录，用户退出时，将所有的用户列表信息都向
				 * 客户端发送一遍。卫兰区分服务器端发送的是聊天信息，还是用户列表，服务器端也应该在要发送的信息
				 * 前，后都添加一定的协议字符串，客户端则根据协议字符串的不同而进行不同的处理！
				 * 更复杂的情况:
				 * 如果两端进行游戏，则还有可能发送游戏信息，例如两端进行五子棋游戏，则需要发送下棋坐标信息
				 * 等，服务器端同样在这些下棋坐标信息前，后添加协议字符串后再发送，客户端就可以根据该信息知道
				 * 对手的下棋坐标
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//使用finally块来关闭该线程对应的输入流
		finally {
			try {
				if(br!=null)br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
