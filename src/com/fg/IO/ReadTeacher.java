package com.fg.IO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ReadTeacher {
	public static void main(String[] args) {
		try(
			//����һ��ObjectInputStream������
			ObjectInputStream ois=new ObjectInputStream(new FileInputStream("teacher.txt"))
			) {
			//���ζ�ȡObjectInputStream��������4������
			Teacher t1=(Teacher)ois.readObject();
			Teacher t2=(Teacher)ois.readObject();
			Person p=(Person)ois.readObject();
			Teacher t3=(Teacher)ois.readObject();
			//���true
			System.out.println("t1��student���ú�p�Ƿ���ͬ:"+(t1.getStudent()==p));
			System.out.println("t1��student���ú�p�Ƿ���ͬ:"+(t2.getStudent()==p));
			System.out.println("t2��t3�ǲ���ͬһ������:"+(t2==t3));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
