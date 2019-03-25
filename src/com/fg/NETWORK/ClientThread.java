package com.fg.NETWORK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable{
	//该线程负责处理的Socket
	private Socket s;
	//该线程所处理的Socket对应的输入流
	BufferedReader br=null;
	
	public ClientThread(Socket s) throws IOException {
		super();
		this.s = s;
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			String conten=null;
			//不断的读取Socket输入流 中的内容，并将这些内容打印输出
			while((conten=br.readLine())!=null) {
				System.out.println(conten);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
