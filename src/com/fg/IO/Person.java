package com.fg.IO;

import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private int age;
	public Person(String name,int age) {
		this.age=age;
		this.name=name;
		System.out.println("�й���Ĳ���");
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
	
}
