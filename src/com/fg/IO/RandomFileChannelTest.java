package com.fg.IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
/**
 * 
 * @author Administrator
 *
 */
public class RandomFileChannelTest {
	public static void main(String[] args) throws IOException {
		File f=new File("a.txt");
		try(
			//创建一个RandomAccessFile对象
			RandomAccessFile raf=new RandomAccessFile(f, "rw");
			//获取RandomAccessFile对应的Channel
				FileChannel randomChannel=raf.getChannel();
			){
			//将Channel中的所有数据映射成ByteBuffer
			ByteBuffer buffer=randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			//将Channel的记录指针移动到最后
			randomChannel.position(f.length());
			//将buffer中的所有数据输出
			long temp=randomChannel.write(buffer);
			System.out.println(temp);
		}
	}
}
