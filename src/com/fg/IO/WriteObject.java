package com.fg.IO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class WriteObject {
	public static void main(String[] args) {
		try(
			//����һ��ObjectOutputStream�����
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("object.txt"))
			)
		{
			Person per=new Person("Kent", 11);
			//��per����д�������
			oos.writeObject(per);
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
