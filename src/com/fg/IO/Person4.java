package com.fg.IO;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person4 implements Externalizable{
	private String name;
	private int age;
	public Person4(String name,int age) {
		this.name=name;
		this.age=age;
		System.out.println("有参数的构造器");
		// TODO 自动生成的构造函数存根
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

	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException {
		// 将读取的字符串反转后赋给name Field
		this.name=((StringBuffer)arg0.readObject()).reverse().toString();
		this.age=arg0.readInt();
		
	}

	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// 将name Field值反转后写入二进制流
		arg0.writeObject(new StringBuffer(name).reverse());
		arg0.writeInt(age);
	}

}
