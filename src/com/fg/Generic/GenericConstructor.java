package com.fg.Generic;

public class GenericConstructor {
	public static void main(String[] args) {
		//���͹������е�TΪString����
		new Foo("�����");
		//���͹������е�TΪInteger����
		new Foo(200);
		//��ʽָ�����͹������е�TΪString����
		//����Foo��������ʵ��Ҳ��String���ͣ���ȫ��ȷ
		new <String> Foo("��");
		//��ʽָ�����͹������е�TΪString���͡�
		//����Foo��������ʵ����Double���ͣ����Դ������
		new <String> Foo(1.2+"1");
		System.out.println(1.2+"2");
	}
}
class Foo{
	public <T> Foo(T c){
		System.out.println(c);
	}
}
