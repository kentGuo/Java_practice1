package com.fg.Generic;

public class Apple<T> {
	//ʹ��T�����βζ���ʵ������
	private T info;
	
	public T getInfo() {
		return info;
	}
	public void setInfo(T info) {
		this.info = info;
	}
	public Apple() {}
	//���淽����ʹ��T���β������幹����
	public Apple(T info) {
		this.info=info;
	}
	public static void main(String[] args) {
		//��Ϊ����T�βε���Stringʵ������
		//���Թ������Ĳ���ֻ����String
		Apple<String> a1=new Apple<>("ƻ��");
		System.out.println(a1.getInfo());
		//��Ϊ����T�βε���Doubleʵ������
		//���Թ������Ĳ���ֻ����Double����double
		Apple<Double> a2=new Apple<>(5.67);
		System.out.println(a2.getInfo());
	}
	
}
