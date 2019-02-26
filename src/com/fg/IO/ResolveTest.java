package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ResolveTest {
	public static void main(String[] args) {
		try (
			//创建一个ObjectOutputStream输出流
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("transient1.txt"));
		//创建一个ObjectInputStream输入流
		ObjectInputStream ois=new ObjectInputStream(new FileInputStream("transient1.txt"))
			){
			oos.writeObject(Orientation.HORIZONTAL);
			Orientation ori=(Orientation)ois.readObject();
			System.out.println(ori==Orientation.HORIZONTAL);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
