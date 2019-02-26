package com.fg.IO;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Person2 implements Serializable{
	private String name;
	private int age;
	public Person2(String name,int age) {
		this.age=age;
		this.name=name;
		System.out.println("有参数的构造器");
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
	private void writeObject(ObjectOutputStream out) throws IOException{
		//将name Field值反转后写入二进制流
		out.writeObject(new StringBuffer(name).reverse());
		out.writeInt(age);
	}
	private void readObject(ObjectInputStream in) throws IOException,ClassNotFoundException{
		//将读取的字符串反转后赋给name Field
		this.name=((StringBuffer)in.readObject()).reverse().toString();
		this.age=in.readInt();
		
	}
}
