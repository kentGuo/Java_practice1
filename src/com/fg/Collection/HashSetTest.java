package com.fg.Collection;

import java.util.HashSet;

public class HashSetTest{
		public static void main(String[] args) {
			HashSet<Object> books=new HashSet<>();
			//�ֱ���books�������������A��������B��������C����
			books.add(new A());
			books.add(new A());
			books.add(new B());
			books.add(new B());
			books.add(new C());
			books.add(new C());
			System.out.println(books);
			
		}
}
//��A��equals()�������Ƿ���true����û����д��hashCode()����
class A {
	public boolean equals(Object obj)
	{
		return true;
	}
}
//��B��hashCode()�������Ƿ���2������д ����equals()����
class B{
	@Override
	public int hashCode() {
		return 1;
	}
}
class C{
	@Override
	public int hashCode() {
		return 2;
	}
	public boolean equals(Object obj)
	{
		return true;
	}
}
