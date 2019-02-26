package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ResolveTest {
	public static void main(String[] args) {
		try (
			//����һ��ObjectOutputStream�����
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("transient1.txt"));
		//����һ��ObjectInputStream������
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
