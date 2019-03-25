package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMutable {
	public static void main(String[] args) {
		try (
			//创建一个ObjectOutStream输出流
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("mutable.txt"));
				//创建一个ObjectInputStream输入流
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream("mutable.txt"));
				
			){
			Person per=new Person("孙悟空", 500);
			//系统将per对象转换成字节列并输出
			oos.writeObject(per);
			//改变per对象的name Field值
			per.setName("猪八戒");
			//系统知识输出序列化编号,所以改变后的name不会被序列化
			oos.writeObject(per);
			Person p1=(Person)ois.readObject();
			Person p2=(Person)ois.readObject();
			//下面输出true,即反序列化后p1等于p2
			System.out.println(p1==p2);
			//下面依然看到输出"孙悟空",即改变后的Field没有被序列化
			System.out.println(p2.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
