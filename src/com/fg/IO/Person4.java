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
		System.out.println("�в����Ĺ�����");
		// TODO �Զ����ɵĹ��캯�����
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
		// ����ȡ���ַ�����ת�󸳸�name Field
		this.name=((StringBuffer)arg0.readObject()).reverse().toString();
		this.age=arg0.readInt();
		
	}

	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException {
		// ��name Fieldֵ��ת��д���������
		arg0.writeObject(new StringBuffer(name).reverse());
		arg0.writeInt(age);
	}

}
