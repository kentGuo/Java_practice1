package com.fg.IO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		try(
			//以读写方式打开一个RandomAccessFile对象
				RandomAccessFile raf=new RandomAccessFile("out.txt", "rw");
			){
			//将记录指针移动到out.txt文件的最后
			raf.seek(raf.length());
			raf.write("追加的内容!\r\n".getBytes());
		}
	}
}
