package com.fg.Collection;

import java.util.List;
import java.util.ArrayList;

public class ListTest {
	public static void main(String[] args) {
		List<String> books=new ArrayList<String>();
		//��books�������������Ԫ��
		books.add(new String("Java"));
		books.add(new String("C"));
		books.add(new String("C++"));
		books.add(new String("C#"));
		System.out.println(books);
		//�����ַ�����������ڵڶ���λ��
		books.add(1,new String("Object C"));
		for(int i=0;i<4;i++) {
			System.out.println(books.get(i));
		}
		//ɾ��������Ԫ��
		books.remove(2);
		System.out.println(books);
		//�ж�ָ��Ԫ����List�����е�λ�ã����1������λ�ڵڶ�λ
		System.out.println(books.indexOf(new String("Object C")));
		//���ڶ���Ԫ���滻���µ��ַ�������
		books.set(1, new String("C"));
		System.out.println(books);
		//��books���ϵĵڶ���Ԫ��(����)
		//��������Ԫ��(������)��ȡ���Ӽ���
		System.out.println(books.subList(1, 2));
	}
}
