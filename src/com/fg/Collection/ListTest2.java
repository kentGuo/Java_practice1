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
		//向books集合中添加三个元素
		books.add(new String("Java"));
		books.add(new String("C"));
		books.add(new String("C++"));
		books.add(new String("C#"));
		System.out.println(books);
		//删除集合中的A2对象，将导致第一个元素被删除
		books.remove(new A2());
		//删除集合中的A2对象，再次删除集合中的第一个元素
		books.remove(new A2());
		System.out.println(books);
	}
}
