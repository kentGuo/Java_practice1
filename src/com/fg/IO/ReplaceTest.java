package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReplaceTest {
	public static void main(String[] args) {
		try (
			//创建一个ObjectOutputStream对象
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("replace.txt"));
			//创建一个ObjectInputStream对象
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("replace.txt"))
			){
			Person3 per=new Person3("孙悟空", 500);
			//系统将per对象转换成字节系列并输出
			oos.writeObject(per);
			//反序列读取得到的是ArrayList
			ArrayList list=(ArrayList)ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
