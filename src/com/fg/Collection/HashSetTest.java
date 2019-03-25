package com.fg.Collection;

import java.util.HashSet;

public class HashSetTest{
		public static void main(String[] args) {
			HashSet<Object> books=new HashSet<>();
			//分别向books集合中添加两个A对象，两个B对象，两个C对象
			books.add(new A());
			books.add(new A());
			books.add(new B());
			books.add(new B());
			books.add(new C());
			books.add(new C());
			System.out.println(books);
			
		}
}
//类A的equals()方法总是返回true，但没有重写器hashCode()方法
class A {
	public boolean equals(Object obj)
	{
		return true;
	}
}
//类B的hashCode()方法总是返回2，且重写 了其equals()方法
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
