package com.fg.Collection;

import java.util.LinkedList;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Object> books=new LinkedList<>();
		//���ַ���Ԫ�ؼ�����е�β��
		books.offer("ѩ�к�����");
		//��һ���ַ���Ԫ�ؼ���ջ�Ķ���
		books.push("������");
		//���ַ���Ԫ����ӵ����е�ͷ��(�൱��ջ�Ķ���)
		books.offerFirst("���");
		for(int i=0;i<books.size();i++) {
			System.out.println(books.get(i));
		}
		//���ʵ���ɾ��ջ����Ԫ��
		System.out.println(books.peekFirst());
		//���ʵ���ɾ�����е����һ��Ԫ��
		System.out.println(books.peekLast());
		//��ջ����Ԫ�ص���ջ
		System.out.println(books.pop());
		//������������������е�һ��Ԫ�ر�ɾ��
		System.out.println(books);
		//���ʲ�ɾ�����е����һ��Ԫ��
		System.out.println(books.pollLast());
		//������������������и�ֻʣ���м�һ��Ԫ��
		//[������]
		System.out.println(books);
	}
}
