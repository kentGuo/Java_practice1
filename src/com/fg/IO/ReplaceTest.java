package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ReplaceTest {
	public static void main(String[] args) {
		try (
			//����һ��ObjectOutputStream����
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("replace.txt"));
			//����һ��ObjectInputStream����
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("replace.txt"))
			){
			Person3 per=new Person3("�����", 500);
			//ϵͳ��per����ת�����ֽ�ϵ�в����
			oos.writeObject(per);
			//�����ж�ȡ�õ�����ArrayList
			ArrayList list=(ArrayList)ois.readObject();
			System.out.println(list);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
