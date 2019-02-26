package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
	public static void main(String[] args) {
		try (
			//创建一个ObjectOutputStream输出流
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("transient.txt"));
			//创建一个ObjectInputStream输入流
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("transient.txt"))
			){
			Person1 per=new Person1("孙悟空", 500);
			//系统将per对象转换成字节流输出
			oos.writeObject(per);
			Person1 p=(Person1)ois.readObject();
			System.out.println(p.getAge());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
