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
			//����һ��RandomAccessFile����
			RandomAccessFile raf=new RandomAccessFile(f, "rw");
			//��ȡRandomAccessFile��Ӧ��Channel
				FileChannel randomChannel=raf.getChannel();
			){
			//��Channel�е���������ӳ���ByteBuffer
			ByteBuffer buffer=randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, f.length());
			//��Channel�ļ�¼ָ���ƶ������
			randomChannel.position(f.length());
			//��buffer�е������������
			long temp=randomChannel.write(buffer);
			System.out.println(temp);
		}
	}
}
