package com.fg.Collection;

import java.util.LinkedHashSet;

public class LinkedHashSetTest {
	public static void main(String[] args) {
		LinkedHashSet<Object> books=new LinkedHashSet<>();
		books.add("ѩ�к�����");
		books.add("���");
		//books.add("���������");
		System.out.println(books);
		//ɾ�� ѩ�к�����
		books.remove("ѩ�к�����");
		//������� ѩ�к�����
		books.add("ѩ�к�����");
		System.out.println(books);
	}
}
