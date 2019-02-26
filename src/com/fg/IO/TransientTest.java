package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest {
	public static void main(String[] args) {
		try (
			//����һ��ObjectOutputStream�����
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("transient.txt"));
			//����һ��ObjectInputStream������
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("transient.txt"))
			){
			Person1 per=new Person1("�����", 500);
			//ϵͳ��per����ת�����ֽ������
			oos.writeObject(per);
			Person1 p=(Person1)ois.readObject();
			System.out.println(p.getAge());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
