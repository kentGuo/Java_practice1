package com.fg.Generic;

public class GenericDiamondTest {
	public static void main(String[] args) {
		//MyClass�������е�E�β���String����
		//���͹�������������T�β���Integer����
		MyClass<String> m1=new MyClass<>(5);
		//��ʽָ�����͹�������������T�β���Integer����
		//
		MyClass<String> m2=new <Integer> MyClass<String>(5);
		
		//MyClass�������е�E�β���String����
		//�����ʽָ�����͹�������������T�β���Integer����
		//��ʱ�Ͳ���ʹ��"����"�﷨����������Ǵ����
		//MyClass<String> m3=new <Integer> MyClass<>(5);
	}
}
class MyClass<E>{
	public <T> MyClass(T t){
		System.out.println("t�Ĳ�����ֵΪ:"+t);
	}
}
