package com.fg.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(
			RandomAccessFile raf=new RandomAccessFile(".\\\\src\\\\com\\\\fg\\\\IO\\\\RandomAccessFileTest.java", "r");	
			){
			//获取RandomAccessFile对象文件指针的位置,初始位置为0
			System.out.println("RandomAccessFile的文件指针的初始位置为:"+raf.getFilePointer());
			//移动raf的文件记录指针的位置
			raf.seek(100);
			byte[] bbuf=new byte[1024];
			//用于保存实际读取的字节数
			int hasRead=0;
			//使用循环方式读取流
			while((hasRead=raf.read(bbuf))>0) {
				//取出字节流，将字节数组转换成字符串输入
				System.out.println(new String(bbuf,0,hasRead));
			}
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
