package com.fg.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Collection<Comparable> c=new ArrayList<Comparable>();
		//���Ԫ��
		c.add("�����");
		c.add(6);
		System.out.println("c���ϵ�Ԫ�ظ���Ϊ:"+c.size());
		//ɾ��ָ��Ԫ��
		c.remove(6);
		System.out.println("c���ϵ�Ԫ�ظ���Ϊ:"+c.size());
		//�ж��Ƿ����ָ���ַ���
		System.out.println("c�����Ƿ����\"�����\"�ַ���:"+c.contains("�����"));
		c.add("������Java EE��ҵӦ��ʵս");
		System.out.println("c���ϵ�Ԫ��:"+c);
		Collection<String> books=new HashSet<String>();
		books.add("������Java EE��ҵӦ��ʵս");
		books.add("���Java����");
		System.out.println("c�����Ƿ���ȫ����books���ϣ�"+c.containsAll(books));
		System.out.println("c���ϵ�Ԫ��:"+c);
		//ɾ��c�����������Ԫ��
		c.clear();
		System.out.println("c���ϵ�Ԫ��:"+c);
		//books������c���ϵĽ���
		books.retainAll(c);
		System.out.println("books���ϵ�Ԫ��:"+books);
		
	}
}
