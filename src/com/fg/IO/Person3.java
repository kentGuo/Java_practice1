package com.fg.IO;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;

public class Person3 implements Serializable{
	private String name;
	private int age;
	public Person3(String name,int age) {
		this.age=age;
		this.name=name;
		System.out.println("�в����Ĺ�����");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//��дwriteReplace����,���������л��ö���֮ǰ,�ȵ��ø÷���
	private Object writeReplace() throws ObjectStreamException{
		ArrayList<Object> list=new ArrayList<Object>();
		list.add(name);
		list.add(age);
		return list;
	}
	
}
