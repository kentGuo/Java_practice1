package com.fg.IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteTeacher {
	public static void main(String[] args) {
		try (
			//����һ��ObjectOutputStream���������
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("teacher.txt"))
			){
			Person per=new Person("����", 16);
			Teacher t1=new Teacher("������", per);
			Teacher t2=new Teacher("���Ķ��", per);
			//���ν�4������д�������
			oos.writeObject(t1);
			oos.writeObject(t2);
			oos.writeObject(per);
			oos.writeObject(t2);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
