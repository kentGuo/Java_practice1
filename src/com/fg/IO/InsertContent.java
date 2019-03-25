package com.fg.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class InsertContent {
	public static void insert(String fileName,long pos,String content) throws IOException{
		File tmp=File.createTempFile("tmp", null);
		tmp.deleteOnExit();
		try(
			RandomAccessFile raf=new RandomAccessFile(fileName, "rw");
			//创建一个临时文件来保存插入点后的数据
			FileOutputStream tmpOut=new FileOutputStream(tmp);
			FileInputStream tmpIn=new FileInputStream(tmp);
			){
			raf.seek(pos);
			//下面代码将插入点后的内容读入临时文件保存
			byte[] bbuf=new byte[64];
			//用于保存实际 读取的字节数
			int hasRead=0;
			//循环读取插入点后的数据
			while((hasRead=raf.read(bbuf))>0) {
				//将读取的数据写入临时文件
				tmpOut.write(bbuf, 0, hasRead);
			}
			//下面代码用于插入内容
			//把文件记录指针重新定位到pos位置
			raf.seek(pos);
			//追加需要插入的内容
			raf.write(content.getBytes());
			//追加临时文件的内容
			while((hasRead=tmpIn.read(bbuf))>0) {
				raf.write(bbuf, 0, hasRead);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		insert(".\\poem.txt", 45, "插入的内容!\r\n");
	}
}
