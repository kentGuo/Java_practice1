package com.fg.IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadObject {
	public static void main(String[] args) {
		try (
			//����һ��ObjectInputStream������
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream("object.txt"))
			){
			//���������ж�ȡһ��Java����,������ǿ������ת��ΪPerson��
			Person p=(Person)ois.readObject();
			System.out.println("����Ϊ:"+p.getName()+"����Ϊ:"+p.getAge());
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
