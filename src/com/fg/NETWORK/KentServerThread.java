package com.fg.NETWORK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class KentServerThread extends Thread{
	private Socket s;
	BufferedReader br=null;
	PrintStream ps=null;
	// 定义一个构造器，用于接受一个Socket来创建ServerThread线程
	public KentServerThread(Socket s) {
		super();
		this.s = s;
	}
	//将读到的内容去掉前后的协议字符，恢复成真是数据
	private String getRealMsg(String line) {
		return line.substring(KentProtocol.PROROCOL_LEN, line.length()-KentProtocol.PROROCOL_LEN);
	}
	@Override
	public void run() {
		try {
			//获取该Socket对应的输入流
			br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			//获取该Socket对应 的输出流
			ps=new PrintStream(s.getOutputStream());
			String line=null;
			while((line=br.readLine())!=null) {
				//如果读到的行以KentProrocol.USER_ROUND开始，并以其结束
				//则可以确定读到的是用户登录的用户名
				if(line.startsWith(KentProtocol.USER_ROUND)&&line.endsWith(KentProtocol.USER_ROUND)) {
					//得到真实消息
					String userName=getRealMsg(line);
					//如果用户名重复
					if(KentServer.clients.map.containsKey(userName)) {
						System.out.println("重复");
						ps.println(KentProtocol.NAME_REP);
					}else {
						System.out.println("成功");
						ps.println(KentProtocol.LOGIN_SUCESS);
						KentServer.clients.put(userName, ps);
					}
				}
				//如果读到的行以KentProrocol.PRIVATE_ROUND开始，并以其结束
				//则可以确定是私聊信息，私聊信息只向特定的输出流发送
				else if(line.startsWith(KentProtocol.PRIVATE_ROUND)&&line.endsWith(KentProtocol.PRIVATE_ROUND)){
					//得到真实消息
					String userAndMsg=getRealMsg(line);
					//以SPLIT_SIGN分割字符串，前半是私聊用户，后半是私聊信息
					String user=userAndMsg.split(KentProtocol.SPLIT_SIGN)[0];
					String msg=userAndMsg.split(KentProtocol.SPLIT_SIGN)[1];
					//获取私聊用户对应的输出流 ，并发送私聊信息
					KentServer.clients.map.get(user).println(KentServer.clients.getKeyByValue(ps)+"悄悄对你说:"+msg);
				}
				//公聊向每个Socket发送
				else {
					//得到真实消息
					String msg=getRealMsg(line);
					//遍历clients中的输出流
					for(PrintStream clientsPS:KentServer.clients.valueSet()) {
						clientsPS.println(KentServer.clients.getKeyByValue(ps)+"说"+msg);
					}
				}
			}
			//捕获到异常后，表明该Socket对应的客户端已经出现了问题
			//所以程序将其对应的输出流Map中删除
		} catch (Exception e) {
			KentServer.clients.removeByValue(ps);
			System.out.println(KentServer.clients.map.size());
			//关闭网络IO资源
			try {
				if(br!=null)br.close();
				if(ps!=null)ps.close();
				if(s!=null)s.close();
			} catch (IOException e2) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
