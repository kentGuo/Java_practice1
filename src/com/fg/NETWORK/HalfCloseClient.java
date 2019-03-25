package com.fg.NETWORK;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HalfCloseClient {
	public static void main(String[] args) throws Exception{
		Socket s=new Socket("localhost", 30000);
		Scanner scan=new Scanner(s.getInputStream());
		PrintStream ps=new PrintStream(s.getOutputStream());
		ps.println("客户端的第一行数据");
		ps.println("客户端的第二行数据");
		while(scan.hasNextLine()) {
			ps.println(scan.nextLine());
		}
		
		s.close();
		ps.close();
		scan.close();
	}
}
