package com.fg.Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorTest {
	public static void main(String[] args) {
		//����һ������
		Collection<Object> books=new HashSet<>();
		books.add("ѩ�к�����");
		books.add("���");
		books.add("���������");
		//��ȡbooks���϶�Ӧ�ĵ�����
		Iterator<Object> it=books.iterator();
		while(it.hasNext()) {
			//it.next()�������ص�����������Object����
			//��Ҫǿ��ת������
			String book=(String)it.next();
			System.out.println(book);
			if(book.equals("ѩ�к�����"))
			{
				//�Ӽ�����ɾ����һ��next�������ص�Ԫ��
				it.remove();
			}
			//��book������ֵ������ı伯��Ԫ�ر���
			book="�����ַ���";
		}
		System.out.println(books);
	}
}
