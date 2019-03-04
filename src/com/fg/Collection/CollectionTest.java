package com.fg.Collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class CollectionTest {
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Collection<Comparable> c=new ArrayList<Comparable>();
		//添加元素
		c.add("孙悟空");
		c.add(6);
		System.out.println("c集合的元素个数为:"+c.size());
		//删除指定元素
		c.remove(6);
		System.out.println("c集合的元素个数为:"+c.size());
		//判断是否包含指定字符串
		System.out.println("c集合是否包含\"孙悟空\"字符串:"+c.contains("孙悟空"));
		c.add("轻量级Java EE企业应用实战");
		System.out.println("c集合的元素:"+c);
		Collection<String> books=new HashSet<String>();
		books.add("轻量级Java EE企业应用实战");
		books.add("疯狂Java讲义");
		System.out.println("c集合是否完全包含books集合？"+c.containsAll(books));
		System.out.println("c集合的元素:"+c);
		//删除c集合里的所有元素
		c.clear();
		System.out.println("c集合的元素:"+c);
		//books集合与c集合的交集
		books.retainAll(c);
		System.out.println("books集合的元素:"+books);
		
	}
}
