package com.fg.NETWORK;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;

public class SimpleAIOClient {
	static final int PORT=30000;
	public static void main(String[] args) {
		//用于读取数据的ByteBuffer
		ByteBuffer buff=ByteBuffer.allocate(2014);
		Charset utf=Charset.forName("utf-8");
		try (
			//创建AsynchronousSocketChannel对象
				AsynchronousSocketChannel clientChannel=AsynchronousSocketChannel.open();
			){
			//连接远程服务器
			clientChannel.connect(new InetSocketAddress("127.0.0.1", PORT)).get();
			buff.clear();
			//从clientChannel中读取数据
			clientChannel.read(buff).get();
			buff.flip();
			//将buff中的内容转换成字符串
			String content=utf.decode(buff).toString();
			System.out.println("服务信息:"+content);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
