package com.fg.NETWORK;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class SimpleAIOServer {
	static final int PORT=30000;
	public static void main(String[] args) throws Exception {
		try(
			//创建AsynchronousServerSocketChannel对象
				AsynchronousServerSocketChannel serverChannel=AsynchronousServerSocketChannel.open()
			){
			//指定在指定地址，端口监听
			serverChannel.bind(new InetSocketAddress(PORT));
			while(true) {
				//采用循环接受来自客户端的连接
				Future<AsynchronousSocketChannel> future=serverChannel.accept();
				//获取连接完成后返回的AsynchronousServerSocketChannel
				AsynchronousSocketChannel socketChannel=future.get();
				//执行输出
				socketChannel.write(ByteBuffer.wrap("欢迎来到AIO的世界!".getBytes("utf-8"))).get();
			}
		}
	}
}
