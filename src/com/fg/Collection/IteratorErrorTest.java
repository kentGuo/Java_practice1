package com.fg.Collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorErrorTest {
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
						//ʹ��Iterator�����������У������޸ļ���Ԫ�أ�������������쳣
						books.remove(book);
					}
				}
	}
}
