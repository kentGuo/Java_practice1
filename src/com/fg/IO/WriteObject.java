package com.fg.IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args) {
		try(
			//创建一个ObjectOutputStream输出流
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object.txt"))
			)
		{
			Person per=new Person("Kent", 11);
			//将per对象写入输出流
			oos.writeObject(per);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
