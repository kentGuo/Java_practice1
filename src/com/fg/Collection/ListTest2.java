package com.fg.Collection;

import java.util.ArrayList;
import java.util.List;

class A2{
	@Override
	public boolean equals(Object obj) {
		return true;
	}
}
public class ListTest2 {
	public static void main(String[] args) {
		List<String> books=new ArrayList<String>();
		//��books�������������Ԫ��
		books.add(new String("Java"));
		books.add(new String("C"));
		books.add(new String("C++"));
		books.add(new String("C#"));
		System.out.println(books);
		//ɾ�������е�A2���󣬽����µ�һ��Ԫ�ر�ɾ��
		books.remove(new A2());
		//ɾ�������е�A2�����ٴ�ɾ�������еĵ�һ��Ԫ��
		books.remove(new A2());
		System.out.println(books);
	}
}
