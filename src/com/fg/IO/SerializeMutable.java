package com.fg.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeMutable {
	public static void main(String[] args) {
		try (
			//����һ��ObjectOutStream�����
				ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("mutable.txt"));
				//����һ��ObjectInputStream������
				ObjectInputStream ois=new ObjectInputStream(new FileInputStream("mutable.txt"));
				
			){
			Person per=new Person("�����", 500);
			//ϵͳ��per����ת�����ֽ��в����
			oos.writeObject(per);
			//�ı�per�����name Fieldֵ
			per.setName("��˽�");
			//ϵͳ֪ʶ������л����,���Ըı���name���ᱻ���л�
			oos.writeObject(per);
			Person p1=(Person)ois.readObject();
			Person p2=(Person)ois.readObject();
			//�������true,�������л���p1����p2
			System.out.println(p1==p2);
			//������Ȼ�������"�����",���ı���Fieldû�б����л�
			System.out.println(p2.getName());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
