package com.fg.Collection;

import java.util.Collection;
import java.util.HashSet;

public class ForeachTest {
	public static void main(String[] args) {
		//����һ������
		Collection<Object> books=new HashSet<>();
		books.add("ѩ�к�����");
		books.add("���");
		books.add("���������");
		for(Object obj:books) {
			//�˴���book����Ҳ���Ǽ���Ԫ�ر���
			String book=(String)obj;
			System.out.println(book);
			if(book.equals("ѩ�к�����")) {
				//������뽫����ConcurrentModificationException�쳣
				books.remove(book);
			}
		}
		System.out.println(books);
	}
}
